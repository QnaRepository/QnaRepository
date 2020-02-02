<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bum.spring.web.board.impl.BoardDAO" %>
<%@ page import="bum.spring.web.board.BoardVO" %>
<%@ page import="java.util.List" %>  
<%
	// 1. 사용자 입력 정보 추출 : 검색 기능은 나중에 구현
	
	// 2. 데이터베이스 연동 처리
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
	// 3. 응답 화면 구성
%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Board List</title>
	</head>
	<body>
		<h1>글 목록</h1>
		<h3>테스트 회원님 환영합니다.<a href="logoutProc.jsp">Log-Out</a></h3>
		<!-- 검색 시작 -->
		<form action="getBoardList.jsp" method="post">
			<table border="1">
				<tr>
					<td>
						<select name="searchCondition">
							<option value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
						</select>
						<input type="text" name="searchKeyword" />
						<input type="submit" value="검색" />
					</td>
				</tr>
			
			</table>
		</form>
		<br>
		<!-- 검색 종료 -->
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
			<%for(BoardVO board: boardList){ %>
			<tr>
				<td><%=board.getSeq()%></td>
				<td><a href="getBoard.jsp?seq=<%=board.getSeq() %>"><%=board.getTitle() %></a></td>
				<td><%=board.getWriter() %></td>
				<td><%=board.getRegDate() %></td>
				<td><%=board.getCnt() %></td>
			</tr>
			<%} %>
		</table>
		<br>
		<a href="insertBoard.jsp">새글 작성</a>
	</body>
</html>



















