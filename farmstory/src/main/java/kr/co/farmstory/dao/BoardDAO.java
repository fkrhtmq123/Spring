package kr.co.farmstory.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.farmstory.vo.BoardVO;

@Repository
public class BoardDAO {
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public void selectBoard() {}
	
	public List<BoardVO> selectBoards(int start, String cate) {
		
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("start", start);
		values.put("cate", cate);
		
		return mybatis.selectList("mapper.board.SELECT_BOARDS", values);
	}
	
	public int selectCountBoard(String cate) {
		return mybatis.selectOne("mapper.board.SELECT_COUNT_BOARD", cate);
	}
	
	public void insertBoard() {}
	
	public void updateBoard() {}
	
	public void deleteBoard() {}
	
	public List<BoardVO> selectLatest(String cate) {
		return mybatis.selectList("mapper.board.SELECT_LATEST", cate);
	}
}
