package chris.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogoutController{

	@RequestMapping("/logout.do")
	public String handleRequest(HttpSession session) {
		System.out.println("로그아웃 처리");
		//HttpSession session = request.getSession(false);
		//만일 세션이 있다면 새로운 세션 객체를 생성하지 않고, null을 반환한다.
		session.invalidate();
		
		return "login.jsp";
	}

}
