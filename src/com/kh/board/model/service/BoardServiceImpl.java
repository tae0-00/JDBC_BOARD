package com.kh.board.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import static com.kh.board.model.template.JDBCTemplate.*;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;

// BoardService 인터페이스를 구현하는 클래스.
// 각 메서드의 설명에 맞게 기능을 작성.
public class BoardServiceImpl implements BoardService {

	private BoardDao bdao = new BoardDao();
	@Override
	public int login(String memberId, String MemberPwd) {

		Connection conn = getConnectin();
		int result= bdao.login(conn,memberId,MemberPwd);
		close(conn);
	return result;
	}

	@Override
	public int insertBoard(Board b) {
		Connection conn = getConnectin();
		int result = bdao.insertBoard(conn, b);
		close(conn);
		return result;
	}

	@Override
	public List<Board> selectBoardList() {
		Connection conn = getConnectin();
		List<Board> result = bdao.selectBoardList(conn);
		close(conn);
		
		return result;
	}

	@Override
	public Board selectBoard(int boardNo) {
		Connection conn = getConnectin();
		Board result = bdao.selectBoard(conn,boardNo);
		close(conn);
		return result;
	}

	@Override
	public int updateBoard(int boardNo, Board b) {
		Connection conn = getConnectin();
		int result = bdao.updateBoard(conn, boardNo, b);
		close(conn);
		return result;
	}

	@Override
	public int deleteBoard(int boardNo) {
		Connection conn= getConnectin();
		int result = bdao.deleteBoard(conn, boardNo);
		return 0;
	}

}
