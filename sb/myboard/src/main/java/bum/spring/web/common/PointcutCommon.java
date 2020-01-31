package bum.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	
	@Pointcut("execution(* bum.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Pointcut("execution(* bum.spring.web..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	
}
