package kr.co.kmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ResultVO;

@Repository
public interface MemberDAO {
	
	public ResultVO selectCountUid(String uid);

}
