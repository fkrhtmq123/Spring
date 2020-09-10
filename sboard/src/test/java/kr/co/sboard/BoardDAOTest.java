package kr.co.sboard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sboard.dao.BoardDAO;
import kr.co.sboard.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class BoardDAOTest {
	
	private BoardDAO dao;
	
	@Test
	public void insertBoard() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트2");
		vo.setContent("테스트2");
		vo.setUid("abcd");
		vo.setRegip("192.123.120.1");
		
		dao.insertBoard(vo);
	}

}
