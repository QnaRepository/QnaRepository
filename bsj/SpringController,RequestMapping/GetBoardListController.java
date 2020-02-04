package chris.spring.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chris.spring.web.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	//Controller어노테이션을 사용하면 SpringContainer는 xml파일에 설정한 
	//<context>태그에 의해서 자동으로 Controller를 찾게된다.
	//하지만 이렇게 되면 어떤 요청이 들어올때 해당 컨트롤러를 사용할지 알지 못하게 된다.
	//따라서 @RequestMapping어노테이션을 사용하여 설정을 해둔다.
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDao, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
		//SpringContainer가 지원하는 Command객체를 사용하여 불필요한 코드를 줄인다.
		//(BoardVO, BoardDAO, ModelAndView가 해당)
		List<BoardVO> boardList = boardDao.getBoardList(vo);
		
		//페이지를 보여주기 위해서는 ViewResolver를 사용해 보낼수 있도록
		//ModelAndView객체를 사용한다.
		mav.addObject("boardList",boardList);
		mav.setViewName("getBoardList.jsp");

		return mav;
	}

}
