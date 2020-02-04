package chris.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chris.spring.web.board.impl.BoardDAO;

//@Controller어노테이션을 사용하는 경우,<context:component-scan>태그를 사용하므로
//자동으로 Controller를 찾게 된다. 하지만 어떤 요청이 들어와야 해당 클래스를 실행할지 모르게 되므로
//@RequestMapping어노테이션을 사용하여 받아들일 요청을 지정해준다.

@Controller
public class GetBoardController{

	@RequestMapping("/getBoard.do")
	//해당 메서드의 결과는 글의 상세페이지를 보여주어야 하기 때문에 ModelAndView를 리턴타입으로 지정한다.
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDao, ModelAndView mav) {
		System.out.println("글 상세 보기 처리");
		
		//BoardVO, BoardDAO, ModelAndView객체는 Command객체로서 
		//그 값들이 자동으로 저장이 된다.
		
		BoardVO board = boardDao.getBoard(vo);
		
		mav.addObject("board",board);
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}

}
