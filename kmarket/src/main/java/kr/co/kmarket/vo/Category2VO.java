package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name="km_category2")
public class Category2VO {
	
	@Id
	private int seq;
	private int code1;
	private int code2;
	private String title;

}
