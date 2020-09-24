package kr.co.kmarket.admin.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.Category2VO;

@Repository
public interface AdminCategory2Repo extends JpaRepository<Category2VO, Integer> {
	
	public List<Category2VO> findByCode1OrderBySeq(int code1);

}
