package chris.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import chris.spring.web.board.impl.BoardDAO;

//Controller로서 사용하기 위해 어노테이션을 설정한다.<context>태그에 의해서
//자동으로 찾을 수 있다. 하지만 어떤 요청이 들어왔을때 해당 component를 사용할지 
//지정이 되지 않았기 때문에, @RequestMapping을 사용하여 지정한다.

@Controller
public class UpdateBoardController{

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDao) {
		System.out.println("글 수정 처리");
		// 1. 사용자 입력 정보 추출
		// 2. 데이터베이스 연동 처리
		// 1번과 2번은 Command객체의 성질을 이용하여 해당 객체 안의 setter,메서드들의
		// 기능을 사용해서 자동으로 처리가 된다.
		boardDao.updateBoard(vo);
		
		//proc와 view가 같이 있는경우 do요청을 보내어 이동한다.
		return "getBoardList.do";
	}

}
