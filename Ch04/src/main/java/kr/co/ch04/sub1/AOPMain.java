package kr.co.ch04.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.co.ch04.sub2.BoardService;

/*
 * ��¥ : 2020/09/01
 * �̸� : �赿��
 * ���� : AOP �ǽ��ϱ�
 * 
 *  ������ AOP
 *   - �ٽ� ���ɰ� ���� ����(Ⱦ�� ����)�� �и��ؼ� ���α׷��� �ϴ� ���
 *   
 *  �ֿ� ���
 *   1) JoinPoint
 *    - �����ϴ� ��� �ٽ� ���� �޼���(��� Pointcut)
 *    
 *   2) Pointcut
 *    - JoinPoint ��� AOP�� ������ �ٽ� ���� �޼���
 *    
 *   3) Advice
 *    - Ⱦ�� ���ɿ� �ش��ϴ� ������ �ΰ���� �޼���
 *   
 *   4) Aspect
 *    - Pointcut�� Advice�� ���յ� �������
 *   
 *   5) Weaving
 *    - Pointcut(�ٽ� ����)�� ����� �� Advice�� Pointcut�� ���յǴ� ����
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
