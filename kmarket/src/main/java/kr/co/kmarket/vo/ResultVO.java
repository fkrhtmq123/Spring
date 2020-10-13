package kr.co.kmarket.vo;

import lombok.*;

@Getter
@Setter
public class ResultVO {
	
	private int result;
	
	public ResultVO(int result) {
		this.result = result;
	}

}
