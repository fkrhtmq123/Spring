package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsCartVO;
import kr.co.kmarket.vo.ProductsVO;

@Repository
public interface ShopDAO {
	
	public List<ProductsVO> selectProducts(int cate1, int cate2, int sort);
	
	public ProductsVO selectProduct(int code);
	
	public int insertCart(ProductsCartVO vo);
	
	public List<ProductsCartVO> selectCart(String uid);
	
	public int deleteCart(int[] seqs);
	
	public List<ProductsCartVO> selectOrder(int[] seqs);

}
