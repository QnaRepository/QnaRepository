package bum.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Before("PointcutCommon.allPointcut()")
	public void printLog() {
		System.out.println("[공통로그] : 비즈니스 로직 수행 전 동작");
	}
}
