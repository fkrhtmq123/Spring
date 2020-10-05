package kr.co.ch05.sub1;

import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	private LogAdvice log;
	
	public void insert() {
		System.out.println("�ٽ� ����  - insert...");
	}
	
	public void select() {
		System.out.println("�ٽ� ����  - select...");
	}
	
	public void update(int seq) {
		System.out.println("�ٽ� ����  - update...");
	}
	
	public void delete(int seq, String uid) {
		System.out.println("�ٽ� ����  - delete...");
	}

}
