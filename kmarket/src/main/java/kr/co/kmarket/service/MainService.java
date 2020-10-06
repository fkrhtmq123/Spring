package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MainDAO;
import kr.co.kmarket.vo.CategoriesVO;
import kr.co.kmarket.vo.ProductsVO;

@Service
public class MainService {
	
	@Autowired
	private MainDAO dao;
	
	public List<CategoriesVO> selectCategories() {
		return dao.selectCategories();
	}
	
	public List<ProductsVO> selectHitProduct() {
		return dao.selectHitProduct();
	}
	
	public List<ProductsVO> selectBestProduct() {
		return dao.selectBestProduct();
	}
	
	public List<ProductsVO> selectRecProduct() {
		return dao.selectRecProduct();
	}
	
	public List<ProductsVO> selectNewProduct() {
		return dao.selectNewProduct();
	}
	
	public List<ProductsVO> selectDiscProduct() {
		return dao.selectDiscProduct();
	}

}
