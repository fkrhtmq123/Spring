package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="km_products")
public class ProductsVO {
	
	@Id
	private int code;
	private int cate1;
	private int cate2;
	private String name;
	private String descipt;
	private String company;
	private String seller;
	private int price;
	private int discount;
	private int point;
	private int stock;
	private int sold;
	private int delivery;
	private int hit;
	private int score;
	private String thumb1;
	private String thumb2;
	private String thumb3;
	private String detail;
	private String status;
	private String dutyfree;
	private String receipt;
	private String bizClass;
	private String origin;
	private String ip;
	private String rdate;
	private int etc1;
	private int etc2;
	private String etc3;
	private String etc4;
	private String etc5;
	
	// 추가필드
	@Transient
	private int salePrice;
	@Transient // 데이터 베이스 영속필드에서 제거(컬럼으로 인식 안되게 함)
	private MultipartFile file1;
	@Transient
	private MultipartFile file2;
	@Transient
	private MultipartFile file3;
	@Transient
	private MultipartFile file4;

}
