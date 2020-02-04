package chris.spring.web.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import chris.spring.web.board.impl.BoardDAO;

@Controller
public class InsertBoardController {

	
	//어노테이션 문법을 사용하면 @Controller를 사용하므로서 interface의 상속을 받지 않게된다.
	//따라서 Override된 메서드의 이름을 변경할 수 있다.
	//메서드의 매개변수도 변경이 가능하다.(response를 굳이 사용하지 않으니 지운다.)
	//이렇게 되면 어떤 요청이 들어왔을때 InsertBoardController를 사용할지 모르니
	//@RequestMapping 어노테이션을 사용하여 그 설정을 해준다.
	
	//대부분의 Controller는 사용자의 입력 정보를 추출하여 VO객체에 저장한다.
	//그 값들은 VO의 객체로 전달된다.-->전달갯수가 많아지면 코드의 양이 많아지게된다.
	//이러한 문제는 Command객체를 이용하면 쉽게 해결이 가능하다.
	//<form>으로 들어오는 값들을 자동으로 입력해준다.
	//단 해당 Command객체의 setter메서드를 통하여 값을 넣어주게 되므로
	//setter메서드가 객체에 없다면 에러가 발생한다.
	
	//현재 @Repository로 적용된 BoardDAO가 2개 이므로 아래의 메서드는 어떤 클래스를
	//주입시켜야할지 모른다. 따라서 하나를 전체 주석을 시켜서 주입시킬 DAO를 지정해준다.
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDao) {
		System.out.println("글 등록 처리");
		//1. 사용자 입력 정보 추출 : 커맨드 객체가 자동으로 처리해 줌.
		//2. 데이터베이스 연동처리
		//boardDAO객체도 VO와 동일하게 커맨드 객체를 사용해서 자동으로 매핑한다.
		boardDao.insertBoard(vo);
		return "getBoardList.do";//비즈니스 로직 종료후에 View경로를 리턴한다.
	}

}
