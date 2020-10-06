package kr.co.kmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kmarket.persistence.MemberRepo;
import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.ResultVO;

@RestController
public class MemberRestController {
	/*(JPA 방법 구상)
	@Autowired
	private MemberRepo repo;
	
	@GetMapping("/member/checkUid")
	public int checkUid(String uid) {
		MemberVO vo = repo.findById(uid).get();
		
		int result = 0;
		
		if(vo != null ) {
			result = 1;
		}
		
		return result;
	}*/
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/checkUid")
	public ResultVO checkUid(String uid) {
		return service.selectCountUid(uid);
	}
}
