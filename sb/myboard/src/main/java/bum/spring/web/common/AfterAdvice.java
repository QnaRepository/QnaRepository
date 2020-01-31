package bum.spring.web.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	@After("PointcutCommon.allPointcut()")
	public void finallyLog() {
		System.err.println("[사후처리] : 비즈니스 로직 수행 후 무조건 동작");
	}
}
