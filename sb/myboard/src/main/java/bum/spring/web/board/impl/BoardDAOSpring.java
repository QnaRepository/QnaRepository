package bum.spring.web.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bum.spring.web.board.BoardVO;
import bum.spring.web.common.JDBCUtil;

@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT = "insert into myboard1(seq, title, writer, content) values((select nvl(max(seq), 0) +1 from myboard1), ?, ?, ?)";
	private final String BOARD_UPDATE = "update myboard1 set title = ?, content = ?, where seq = ?";
	private final String BOARD_DELETE = "delete myboard1 where seq = ? ";
	private final String BOARD_GET = "select * from myboard1 where seq = ?";
	private final String BOARD_LIST = "select * from myboard1 order by seq desc";
	
	
	public void insertBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 updateBoard() 기능처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());

	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 deleteBoard() 기능처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("Spring JDBC로 getBoardList() 기능 처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}

	
}





















