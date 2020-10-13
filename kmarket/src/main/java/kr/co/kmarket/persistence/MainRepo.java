package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.Category1VO;

@Repository
public interface MainRepo extends JpaRepository<Category1VO, Integer> {

}
