package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.CommandAction;
import mvc.CommandProcess;

public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//명령어와 명령어 처리 클래스를 쌍으로 저장 -->최종목적은 command url에 저장된 String을 key값으로 하는
	//value Object를 받아와서 Action객체를 사용하려는 것이  목적이다.
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	//명령어(String)와 처리클래스(Object)가 매핑되어 있는 properties 파일을 읽어서 Map객체인 commandMap에 저장
	//명령어와 처리클래스가 매핑되어 있는 properties 파일은 Command.properties파일
    public ControllerAction() {
        super();
    }
    @SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
    	//web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
    	String props = config.getInitParameter("propertyConfig");
//    	System.out.println(props);
    	Properties pr = new Properties();
    	//WEB-INF의 경로를 얻어오기 위함
    	String path = config.getServletContext().getRealPath("/WEB-INF");
    	FileInputStream f = null;
    	try {
    		//Command.properties파일의 내용을 읽어옴
    		f = new FileInputStream(new File(path, props));
    		//Command.properties파일의 정보를 Properties객체에 저장
    		pr.load(f);
    		//바이트 단위로 Properties의 내용을 모두 읽어온다.
    	}catch(IOException e) {
    		throw new ServletException(e);
    	}finally {
    		if(f != null) try {f.close();} catch(IOException ex) {}
    	}
    	//Iterator객체는 Enumeration객체를 확장시킨 개념의 객체이다.
    	//pr에 있는 모든 key값들을 가지고 온 후에, 그것들을 순차적으로 나열한다.
    	Iterator<Object> keyIter = pr.keySet().iterator();
    	while(keyIter.hasNext()) {
    		String command = (String)keyIter.next();
    		//key값을 command에서 받아와서 그값을 이용해 value값을 얻어온다.
    		String className = pr.getProperty(command);
    		try{
    			//클래스 이름을 통해서 클래스를 얻어온다.
    			Class commandClass = Class.forName(className);
    			//받아온 클래스들을 newInstance메서드를 통해 인스턴스를 생성한다.
    			Object commandInstance = commandClass.newInstance();
    			//맨 윗줄에 선언한 전역변수 개념의 Map commandMap에 String인 command와
    			//Object인 commandInstance를 입력한다.
    			commandMap.put(command, commandInstance);
    		}catch(ClassNotFoundException e) {
    			throw new ServletException(e);
    		}catch(InstantiationException e) {
    			throw new ServletException(e);
    		}catch(IllegalAccessException e) {
    			throw new ServletException(e);
    		}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		try {
			//요청 정보중 요청 uri를 받아온다. ex) /myWeb/mvc/message.do
			String command = request.getRequestURI();
			//command에서 getContextPath의 리턴값(위의 경우 /myWeb)으로 시작하는 부분이 0번째 라면
			if(command.indexOf(request.getContextPath())==0) {
				//command에 getContextPath의 리턴값을 자르고 난 나머지를 저장해라
				command = command.substring(request.getContextPath().length());
			}
			//init에서 만든 commandMap에 key값으로 위의 command(경로)를 넣게 되면
			//그에 해당하는 Object(=실행해야할 Action객체)가 나오게된다.
			com = (CommandAction)commandMap.get(command);
			//그 객체 안에 requestPro메서드를 이동할 페이지의 경로를 받아온다.
			//이동할 페이지의 경로를 view변수에 저장한다.
			view = com.requestPro(request,  response);
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		//페이지 이동방식중 하나인 forward방식을 사용하기 위해서  requestDispatcher를 사용했고
		//dispatcher.forward를 사용해서 페이지를 이동한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
}
