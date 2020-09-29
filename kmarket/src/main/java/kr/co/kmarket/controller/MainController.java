package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoryVO;
import kr.co.kmarket.vo.ProductsVO;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@GetMapping(value={"/", "/index"})
	public String index(Model model) {
		
		List<CategoryVO> cateList = service.selectCate();
		List<ProductsVO> hitProducts = service.selectHitProduct();
		List<ProductsVO> bestProducts = service.selectBestProduct();
		List<ProductsVO> rdateProducts = service.selectRdateProduct();
		
		model.addAttribute("cateList", cateList);
		model.addAttribute("hitProducts", hitProducts);
		model.addAttribute("bestProducts", bestProducts);
		model.addAttribute("rdateProducts", rdateProducts);
		
		return "/index";
	}
	
	@ResponseBody
	@GetMapping("/main/recommend")
	public List<ProductsVO> recommend() {
		
		return service.selectRecProduct();
	}

}
