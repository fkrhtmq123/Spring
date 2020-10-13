package kr.co.kmarket.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class CartTotalInfoVO {
	
	int count;
	int price;
	int sale;
	int delivery;
	int point;
	int total;

}
