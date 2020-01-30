package bum.spring.web.user.impl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import bum.spring.web.user.UserService;
import bum.spring.web.user.UserVO;

public class UserServiceClient {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("bummit");
		vo.setPassword("123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		}else {
			System.out.println("로그인 실패");
		}
		container.close();
		
		
	}


}
