package kr.co.kmarket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import kr.co.kmarket.persistence.ProductsOrderRepo;
import kr.co.kmarket.vo.ProductsOrderVO;

@SpringBootTest
public class KmarketApplicationTests {
	
	@Autowired
	private ProductsOrderRepo productsOrderRepo;

	@Test
	public String orderComplete(int seq, Model model) {
		ProductsOrderVO vo = productsOrderRepo.findById(seq).get();
		
		String products = vo.getProducts();
		
		model.addAttribute(vo);
		
		return "/shop/order-complete";
	}

}
