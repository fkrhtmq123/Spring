package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CategoriesVO;
import kr.co.kmarket.vo.ProductsVO;

@Repository
public interface MainDAO {
	
	public List<CategoriesVO> selectCategories();
	public List<ProductsVO> selectHitProduct();
	public List<ProductsVO> selectBestProduct();
	public List<ProductsVO> selectRecProduct();
	public List<ProductsVO> selectNewProduct();
	public List<ProductsVO> selectDiscProduct();

}
