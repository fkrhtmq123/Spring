package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name="km_category1")
public class Category1VO {
	
	@Id
	private int code1;
	private String title;

}
