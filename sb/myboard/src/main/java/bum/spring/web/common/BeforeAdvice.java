package bum.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("[사전처리] : " + method + "() 메서드의 ARGS 정보 : " + args.toString());
	}
}
