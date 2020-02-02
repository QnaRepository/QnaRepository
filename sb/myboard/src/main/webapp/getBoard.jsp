<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bum.spring.web.board.impl.BoardDAO" %>
<%@ page import="bum.spring.web.board.BoardVO" %>
<%
	// 1. 검색할 게시글 번호 추출
	String seq = request.getParameter("seq");
	// 2. 데이터베이스 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoard(vo);
	
	// 3. 응답 화면 구현
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Board Article Content</title>
	</head>
	<body>
		<h1>글 상세</h1>
		<a href="logoutProc.jsp">Log Out</a>
		<hr>
		<form action="updateBoardProc.jsp" method="post">
			<table border="1">
				<tr>
					<td>제목</td>
					<td><input name="title" type="text" value="<%=board.getTitle() %>" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><%=board.getWriter() %></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><%=board.getContent()%></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><%=board.getRegDate() %></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td><%=board.getCnt() %></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="글수정"></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoardProc.jsp">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.jsp">글목록</a>&nbsp;&nbsp;&nbsp;
	</body>
</html>














