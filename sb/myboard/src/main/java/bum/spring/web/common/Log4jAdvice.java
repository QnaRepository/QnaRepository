package bum.spring.web.common;

public class Log4jAdvice {
	public void printLogging() {
		System.out.println("[로그-Log4jAdvice] : 비즈니스 로직 수행 전 동작");
	}
	public void printLogging2() {
		System.out.println("[로그-Log4jAdvice] : 비즈니스 로직 수행 후 동작");
	}
}
