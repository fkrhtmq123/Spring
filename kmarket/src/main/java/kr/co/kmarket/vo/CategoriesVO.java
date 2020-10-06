package kr.co.kmarket.vo;

import java.util.List;

import lombok.*;

@Getter
@Setter
public class CategoriesVO {

	private int code1;
	private String title;
	
	private List<Category2VO> cate2List;

}
