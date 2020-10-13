package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberVO;

@Repository
public interface MemberRepo extends JpaRepository<MemberVO, String> {
	
}
