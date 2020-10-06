package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket.vo.MemberVO;

public interface MemberRepo extends JpaRepository<MemberVO, String> {
	
}
