package kr.co.ch05.sub2;

import org.springframework.stereotype.Component;

@Component("bs2")
public class BoardService {
	
	public void insert() {
		System.out.println("�ٽ� ����  - insert...");
		
		return;
	}
	
	public void select() {
		System.out.println("�ٽ� ����  - select...");
	}
	
	public void update(int seq) {
		System.out.println("�ٽ� ����  - update...");
	}
	
	public void delete(int seq, String uid) {
		System.out.println("�ٽ� ����  - delete...");
		
		char ch = uid.charAt(5);
	}

}
