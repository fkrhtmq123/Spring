package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsOrderVO;

@Repository
public interface ProductsOrderRepo extends JpaRepository<ProductsOrderVO, Integer> {

}
