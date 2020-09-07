package kr.co.ch08.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Inject
	private JdbcTemplate jdbc;
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertMember(MemberVO vo) {
		
		// Spring jdbc 방식
		//String sql = "INSERT INTO `USER3` VALUES(?, ?, ?, ?)";
		//Object[] values = {vo.getUid(), vo.getName(), vo.getHp(), vo.getAge()};
		//jdbc.update(sql, values);
		
		// Mybatis 방식
		mybatis.insert("mapper.member.INSERT_MEMBER", vo);
	}
	
	public MemberVO selectMember(String uid) {
		return mybatis.selectOne("mapper.member.SELECT_MEMBER", uid);
	}
	
	public List<MemberVO> selectMembers() {
		
		// Spring jdbc 방식
		//String sql = "SELECT * FROM `USER3`";
		//List<UserVO> users = jdbc.query(sql, new UserRowMapper());
		
		// Mybatis 방식
		List<MemberVO> members = mybatis.selectList("mapper.member.SELECT_MEMBERS");
		
		return members;
	}	
	
	public void updateMember(MemberVO vo) {
		mybatis.update("mapper.member.UPDATE_MEMBER", vo);
	}
	public void deleteMember(String uid) {
		mybatis.delete("mapper.member.DELETE_MEMBER", uid);
	}

}
