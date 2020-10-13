package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.ResultVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public ResultVO selectCountUid(String uid) {
		return dao.selectCountUid(uid); 
	}
	
	public MemberVO selectMember(MemberVO vo) {
		return dao.selectMember(vo);
	}
	
}
