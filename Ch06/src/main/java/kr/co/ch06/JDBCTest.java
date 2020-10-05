package kr.co.ch06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2020/09/02
 * 이름 : 김동욱
 * 내용 : Spring JDBC 실습하기
 */

public class JDBCTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		UserDAO dao = (UserDAO) ctx.getBean("userDAO");
		
		dao.updateUser();
		dao.deleteUser();
		
		System.out.println("프로그램 종료...");
		
	}
	
}
