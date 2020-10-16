package kr.co.kmarket.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class OrderTotalInfoVO {
	
	int count;
	int price;
	int sale;
	int delivery;
	int point;
	int total;

}
