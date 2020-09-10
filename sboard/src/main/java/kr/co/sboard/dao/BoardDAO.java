package kr.co.sboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public BoardVO selectBoard(int seq) {
		return mybatis.selectOne("mapper.board.SELECT_BOARD", seq);
	}
	
	public List<BoardVO> selectBoards(int start) {
		
		List<BoardVO> articles = mybatis.selectList("mapper.board.SELECT_BOARDS", start);
		
		return articles;
	}
	
	public int insertBoard(BoardVO vo) {
		// 글을 insert 한 후 해당 record의 seq를 vo객체 seq멤버에 저장
		mybatis.insert("mapper.board.INSERT_BOARD", vo); 
		
		return vo.getSeq();
	}
	
	public void insertFile(FileVO fvo) {
		mybatis.insert("mapper.board.INSERT_FILE", fvo);
	}
	
	public int updateBoard(BoardVO vo) {
		mybatis.update("mapper.board.UPDATE_BOARD", vo);
		
		return vo.getSeq();
	}
	
	public void deleteBoard(int seq) {
		mybatis.delete("mapper.board.DELETE_BOARD", seq);
	}
	
	public int selectCountBoard() {
		return mybatis.selectOne("mapper.board.SELECT_COUNT_BOARD");
	}

}
