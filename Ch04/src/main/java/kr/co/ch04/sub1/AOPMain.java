package kr.co.ch04.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.co.ch04.sub2.BoardService;

/*
 * 날짜 : 2020/09/01
 * 이름 : 김동욱
 * 내용 : AOP 실습하기
 * 
 *  스프링 AOP
 *   - 핵심 관심과 공통 관심(횡단 관심)을 분리해서 프로그래밍 하는 방식
 *   
 *  주요 용어
 *   1) JoinPoint
 *    - 실행하는 모든 핵심 관심 메서드(모든 Pointcut)
 *    
 *   2) Pointcut
 *    - JoinPoint 가운데 AOP가 설정된 핵심 관심 메서드
 *    
 *   3) Advice
 *    - 횡단 관심에 해당하는 공통의 부가기능 메서드
 *   
 *   4) Aspect
 *    - Pointcut과 Advice의 결합된 모듈형태
 *   
 *   5) Weaving
 *    - Pointcut(핵심 관심)이 실행될 때 Advice가 Pointcut에 결합되는 과정
 */

public class AOPMain {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		BoardService bs = (BoardService) ctx.getBean("boardService");
		
		bs.insert();
		bs.select();
		bs.update(1);
		bs.delete(1, "abcd");
		
	}

}
