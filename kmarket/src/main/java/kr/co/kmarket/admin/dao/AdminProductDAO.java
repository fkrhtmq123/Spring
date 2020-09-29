package kr.co.kmarket.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsVO;

@Repository
public interface AdminProductDAO {
	
	public void insertProduct(ProductsVO vo);
	public ProductsVO selectProduct();
	public List<ProductsVO> selectProducts(int start);
	public void updateProduct();
	public int deleteProduct(String[] codes);
	public int selectCountProduct();
	public int selectCountProductBySearch();
	
	public List<ProductsVO> selectProductsBySearch(int start, String opt, String keyword);

}
