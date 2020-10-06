package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket.vo.TermsVO;

public interface TermsRepo extends JpaRepository<TermsVO, Integer> {

}
