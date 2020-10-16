package kr.co.kmarket.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.persistence.ProductsOrderRepo;
import kr.co.kmarket.service.ShopService;
import kr.co.kmarket.vo.OrderTotalInfoVO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.ProductsCartVO;
import kr.co.kmarket.vo.ProductsOrderVO;
import kr.co.kmarket.vo.ProductsVO;
import kr.co.kmarket.vo.ResultVO;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService service;
	
	@Autowired
	private ProductsOrderRepo productsOrderRepo;
	
	@GetMapping("/shop/search")
	public String searach() {
		return "/shop/search";
	}
	
	@GetMapping("/shop/list")
	public String list(int cate1, int cate2, int sort, Model model, HttpSession sess) {
		List<ProductsVO> items = service.selectProducts(cate1, cate2, sort);
		service.setTitles(sess, cate1, cate2);
		String[] tits = service.getTitles(sess);
		
		model.addAttribute("tit1", tits[0]);
		model.addAttribute("tit2", tits[1]);
		model.addAttribute("cate1", cate1);
		model.addAttribute("cate2", cate2);
		model.addAttribute("items", items);
		return "/shop/list";
	}
	
	@GetMapping("/shop/view")
	public String view(int code, Model model, HttpSession sess) {
		MemberVO member = (MemberVO) sess.getAttribute("member");
		
		ProductsVO vo = service.selectProduct(code);
		String[] tits = service.getTitles(sess);
		
		model.addAttribute("tit1", tits[0]);
		model.addAttribute("tit2", tits[1]);
		model.addAttribute(vo);
		model.addAttribute("member", member);
		
		return "/shop/view";
	}
	
	@GetMapping("/shop/cart")
	public String cart(Model model, HttpSession sess) {
		MemberVO member = (MemberVO) sess.getAttribute("member");
		
		if(member != null) {
			List<ProductsCartVO> items = service.selectCart(member.getUid());
			
			model.addAttribute("items", items);
			// 전체 합계에 출력할 데이터
			//OrderTotalInfoVO totalInfo = service.orderTotalInfo(items);
			
			//model.addAttribute("totalInfo", totalInfo);
			
			return "/shop/cart";
		} else {
			return "redirect:/member/login?success=cart";
		}
		
	}
	
	@ResponseBody
	@PostMapping("/shop/cart")
	public ResultVO cart(ProductsCartVO vo) {
		int result = service.insertCart(vo);
		return new ResultVO(result);
	}
	
	@ResponseBody
	@PostMapping("/shop/cartDel")
	public int cartDel(int[] seqs) {
		return service.deleteCart(seqs);		
	}
	
	@GetMapping("/shop/order")
	public String order(int[] seqs, Model model) {
		
		List<ProductsCartVO> items = service.selectOrder(seqs);
		model.addAttribute("items", items);
		
		OrderTotalInfoVO totalInfo = service.orderTotalInfo(items);
		model.addAttribute("totalInfo", totalInfo);
		
		return "/shop/order";
	}
	
	@PostMapping("/shop/order")
	public String order(ProductsOrderVO vo, int[] cartSeqs) {
		vo.setRdate(LocalDateTime.now().toString());
		
		// 주문 테이블에 주문 상품 입력
		ProductsOrderVO ordered = productsOrderRepo.save(vo);
		
		System.out.println("주문 번호 : "+ordered.getSeq());
		System.out.println("주문 아이디 : "+ordered.getUid());
		
		// 주문 상품은 장바구니에서 삭제
		//service.deleteCart(cartSeqs);
		
		return "redirect:/shop/order-complete?seq="+ordered.getSeq();
	}
	
	@GetMapping("/shop/order-complete")
	public String orderComplete(int seq, Model model) {
		ProductsOrderVO vo = productsOrderRepo.findById(seq).get();
		
		String products = vo.getProducts();
		
		model.addAttribute(vo);
		
		return "/shop/order-complete";
	}

}
