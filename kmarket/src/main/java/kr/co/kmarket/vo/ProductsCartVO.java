package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name="km_products_cart")
public class ProductsCartVO {
	
	@Id
	private int seq;
	private String uid;
	private int code;
	private String name;
	private String option;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int delivery;
	private int total;
	private String rdate;
	
	// 추가필드
	@Transient
	private int cate1;
	@Transient
	private int cate2;
	@Transient
	private String thumb1;

}
