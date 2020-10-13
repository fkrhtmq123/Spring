package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVO;
import kr.co.kmarket.vo.ProductsVO;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@GetMapping(value={"/", "/index"})
	public String index(Model model, HttpSession sess) {
		
		List<CategoriesVO> cate1List = service.selectCategories();
		List<ProductsVO> hitProducts = service.selectHitProduct();
		List<ProductsVO> bestProducts = service.selectBestProduct();
		
		sess.setAttribute("cate1List", cate1List);
		//System.out.println("길이1 : "+cateList.size()); // 전체 카테고리 길이
		//System.out.println("길이2 : "+cateList.get(0).getCate2List().size()); // 각 카테고리 길이
		model.addAttribute("hitProducts", hitProducts);
		model.addAttribute("bestProducts", bestProducts);
		
		return "/index";
	}
	
	@ResponseBody
	@GetMapping("/main/recommend")
	public List<ProductsVO> recommend() {
		
		return service.selectRecProduct();
	}
	
	@ResponseBody
	@GetMapping("/main/newItems")
	public List<ProductsVO> newItems() {
		
		return service.selectNewProduct();
	}
	
	@ResponseBody
	@GetMapping("/main/discountItems")
	public List<ProductsVO> discount() {
		
		return service.selectDiscProduct();
	}

}
