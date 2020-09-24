package kr.co.kmarket.admin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsVO;

@Repository
public interface AdminProductsRepo extends JpaRepository<ProductsVO, Integer> {

}
