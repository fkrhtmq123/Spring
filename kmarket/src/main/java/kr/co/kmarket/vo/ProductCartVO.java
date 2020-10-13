package kr.co.kmarket.vo;

import lombok.*;

@Getter
@Setter
public class ProductCartVO {
	
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
	private String cate1;
	private String cate2;
	private String thumb1;

}
