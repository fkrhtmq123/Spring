package kr.co.kmarket.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ShopDAO;
import kr.co.kmarket.vo.CategoriesVO;
import kr.co.kmarket.vo.ProductCartVO;
import kr.co.kmarket.vo.ProductsVO;

@Service
public class ShopService {
	
	@Autowired
	private ShopDAO dao;
	
	public List<ProductsVO> selectProducts(int cate1, int cate2, int sort) {
		return dao.selectProducts(cate1, cate2, sort);
	}
	
	public ProductsVO selectProduct(int code) {
		return dao.selectProduct(code);
	}
	
	public int insertCart(ProductCartVO vo) {
		return dao.insertCart(vo);
	}
	
	public String[] getTitles(HttpSession sess, int cate1, int cate2) {
		List<CategoriesVO> categories = (List<CategoriesVO>) sess.getAttribute("cate1List");
		String tit1 = categories.get(cate1-1).getTitle();
		String tit2 = categories.get(cate1-1).getCate2List().get(cate2-1).getTitle();
		
		String[] tits = {tit1, tit2};
		return tits;
	}

}
