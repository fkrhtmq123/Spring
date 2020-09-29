package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MainDAO;
import kr.co.kmarket.vo.CategoryVO;
import kr.co.kmarket.vo.ProductsVO;

@Service
public class MainService {
	
	@Autowired
	private MainDAO dao;
	
	public List<CategoryVO> selectCate() {
		return dao.selectCate();
	}
	
	public List<ProductsVO> selectHitProduct() {
		return dao.selectHitProduct();
	}
	
	public List<ProductsVO> selectBestProduct() {
		return dao.selectBestProduct();
	}
	
	public List<ProductsVO> selectRdateProduct() {
		return dao.selectRdateProduct();
	}
	
	public List<ProductsVO> selectRecProduct() {
		return dao.selectRecProduct();
	}
	
	

}
