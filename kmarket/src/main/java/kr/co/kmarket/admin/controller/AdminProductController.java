package kr.co.kmarket.admin.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.admin.persistence.AdminCategory1Repo;
import kr.co.kmarket.admin.persistence.AdminCategory2Repo;
import kr.co.kmarket.admin.service.AdminProductService;
import kr.co.kmarket.vo.Category1VO;
import kr.co.kmarket.vo.Category2VO;
import kr.co.kmarket.vo.ProductsVO;

@Controller
public class AdminProductController {
	
	@Autowired
	private AdminProductService service;
	@Autowired
	private AdminCategory1Repo cate1Repo;
	@Autowired
	private AdminCategory2Repo cate2Repo;
	
	@GetMapping("/admin/product/search")
	public String search(String pg, String opt, String keyword, Model model) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountProductBySearch();
		int pageEnd = service.getPageEnd(total);
		int count = service.getListCount(total, start);
		int currentPg = service.getCurrentPg(pg);
		
		int groupCurrent = (int)Math.ceil(currentPg/10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > pageEnd) {
			groupEnd = pageEnd;
		}
		
		List<ProductsVO> products = service.selectProductsBySearch(start, opt, keyword);
		model.addAttribute("products", products);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		model.addAttribute("count", count);
		model.addAttribute("groupStart", groupStart);
		model.addAttribute("groupEnd", groupEnd);
		
		return "/admin/product/list";
	}
	
	@GetMapping("/admin/product/list")
	public String list(Model model, String pg) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountProduct();
		int pageEnd = service.getPageEnd(total);
		int count = service.getListCount(total, start);
		int currentPg = service.getCurrentPg(pg);
		
		int groupCurrent = (int)Math.ceil(currentPg/10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > pageEnd) {
			groupEnd = pageEnd;
		}
		
		List<ProductsVO> products = service.selectProducts(start);
		
		model.addAttribute("products", products);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		model.addAttribute("count", count);
		model.addAttribute("groupStart", groupStart);
		model.addAttribute("groupEnd", groupEnd);
		
		return "/admin/product/list";
	}
	
	@GetMapping("/admin/product/register")
	public String register() {
		return "/admin/product/register";
	}
	
	@PostMapping("/admin/product/register")
	public String register(ProductsVO vo, HttpServletRequest req) throws Exception {
		/*
		vo.setThumb1("/thumb/"+vo.getFile1().getOriginalFilename());
		vo.setThumb2("/thumb/"+vo.getFile2().getOriginalFilename());
		
		vo.setIp(req.getRemoteAddr());
		vo.setRdate(LocalDateTime.now().toString());
		
		service.insertProduct(vo);
		
		// 파일 업로드
		MultipartFile f1 = vo.getFile1();
		MultipartFile f2 = vo.getFile2();
		MultipartFile f3 = vo.getFile3();
		MultipartFile f4 = vo.getFile4();
		
		String realName1 = vo.getFile1().getOriginalFilename();
		String realName2 = vo.getFile2().getOriginalFilename();
		String realName3 = vo.getFile3().getOriginalFilename();
		String realName4 = vo.getFile4().getOriginalFilename();
		
		
		//File file = new File("src/main/resources/static/thumb");
		//String path = file.getAbsolutePath();
		//=> String path = new File("src/main/resources/static/thumb").getAbsolutePath();
		// 또는
		File file = new File("src/main/resources/static/thumb");
		String path = file.getCanonicalPath();
		
		// 파일 저장
		f1.transferTo(new File(path+"/"+realName1));
		f2.transferTo(new File(path+"/"+realName2));
		f3.transferTo(new File("/thumb/file3.jpg"));
		f4.transferTo(new File("/thumb/file4.jpg"));
		*/

		vo.setIp(req.getRemoteAddr());
		vo.setRdate(LocalDateTime.now().toString());
		
		vo = service.uploadThunmb(vo);
		service.insertProduct(vo);
		
		return "redirect:/admin/product/register";
	}
	
	@ResponseBody //json으로 불러오기 위한 어노테이션 
	@GetMapping("/admin/product/cate1")
	public List<Category1VO> getCate1() {
		return cate1Repo.findAll();
	}
	
	@ResponseBody //json으로 불러오기 위한 어노테이션 
	@GetMapping("/admin/product/cate2")
	public List<Category2VO> getCate2(int code1) {
		return cate2Repo.findByCode1OrderBySeq(code1);
	}

}
