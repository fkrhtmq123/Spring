package kr.co.kmarket.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ShopDAO;
import kr.co.kmarket.vo.CartTotalInfoVO;
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
	
	public List<ProductCartVO> selectCart(String uid) {
		return dao.selectCart(uid);
	}
	
	public void setTitles(HttpSession sess, int cate1, int cate2) {
		List<CategoriesVO> categories = (List<CategoriesVO>) sess.getAttribute("cate1List");
		String tit1 = categories.get(cate1-1).getTitle();
		String tit2 = categories.get(cate1-1).getCate2List().get(cate2-1).getTitle();
		
		sess.setAttribute("tit1", tit1);
		sess.setAttribute("tit2", tit2);
	}
	
	public String[] getTitles(HttpSession sess) {
		String tit1 = (String) sess.getAttribute("tit1");
		String tit2 = (String) sess.getAttribute("tit2");
		
		String tits[] = {tit1, tit2};
		return tits;
	}
	
	public CartTotalInfoVO cateTotalInfo(List<ProductCartVO> items) {
		
		int count = items.size();
		int price = 0;
		int sale = 0;
		int delivery = 0;
		int point = 0;
		int total = 0;
		
		for(ProductCartVO item : items) {
			price    += item.getPrice() * item.getCount();
			sale     += (item.getPrice() * item.getDiscount()/100) * item.getCount();
			delivery += item.getDelivery();
			point    += item.getPoint();
			total    += item.getTotal();
		}
		
		return new CartTotalInfoVO(count, price, sale, delivery, point, total);
		
	}

}
