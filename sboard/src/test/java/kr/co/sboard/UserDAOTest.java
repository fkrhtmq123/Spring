package kr.co.sboard;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class UserDAOTest {
	
	@Inject
	private UserDAO dao;
	
	public void selecTerms() {
		dao.selectTerms();
	}
	
	public void selecUserCount() {
		int result = dao.selectUserCount("abcd");
		
		System.out.println("result : "+result);
	}

	@Test
	public void insertuser() {
		
		UserVO vo = new UserVO();
		vo.setUid("dasdasd");
		vo.setPass1("1234");
		vo.setName("¿”≤©¡§");
		vo.setNick("≤©¡§");
		vo.setEmail("dasdasd@gmail.com");
		vo.setHp("010-1237-4456");
		vo.setRegip("192.123.120.1");
		
		dao.insertUser(vo);
	}

}
