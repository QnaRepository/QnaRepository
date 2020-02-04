package chris.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chris.spring.web.board.impl.BoardDAO;

//xml의 <context>태그를 통하여 @Controller를 사용한 모든 클래스들을 자동으로 찾는다.
//Controller어노테이션을 사용하므로서 Spring Container내부의 Controller를 구현할 필요가 없어진다.
//하지만 xml파일에서 <bean>태그가 아닌<context>를 사용하여 component를 설정하였기 때문에
//어떠한 요청 정보가 들어왔을때 해당 컴포넌트 클래스를 사용해야 할지 지정이 되어있지 않다.
//따라서 @RequestMapping어노테이션을 통해서 요청정보를 지정한다.

@Controller
public class DeleteBoardController {

	//Spring Container내의 Controller를 상속받지 않게되어 메서드의 형식을 자유롭게 바꿀 수 있다.
	
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDao) {
		System.out.println("글 삭제 처리");

		boardDao.deleteBoard(vo);

		//삭제 처리후 페이지 이동을 해야하는데 삭제하고 남은 글들을 받아서 
		//목록을 보여주어야 하기 때문에 String으로 do요청을 보낸다.
		return "getBoardList.do";
	}

}
