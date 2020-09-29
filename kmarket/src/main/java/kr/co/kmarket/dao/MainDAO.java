package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CategoryVO;
import kr.co.kmarket.vo.ProductsVO;

@Repository
public interface MainDAO {
	
	public List<CategoryVO> selectCate();
	public List<ProductsVO> selectHitProduct();
	public List<ProductsVO> selectBestProduct();
	public List<ProductsVO> selectRdateProduct();
	public List<ProductsVO> selectRecProduct();

}
