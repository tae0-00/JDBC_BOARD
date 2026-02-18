package com.kh.board.controller;

import java.util.List;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.service.BoardServiceImpl;
import com.kh.board.model.vo.Board;
import com.kh.board.view.BoardView;

/* 
 * View요청에 맞는 Service를 선택하여 메서드를 실행 한 후 결과값을 돌려주는 클래스.
 * */
public class BoardController {

	
	
	// service 변수 선언 및 초기화
	private BoardService bs = new BoardServiceImpl();
	// view의 login요청을 담당할 메서드
	public int login(String id, String pwd) {
		return bs.login(id,pwd);
	}
	// view의 selectBoardList요청을 담당할 메서드
	public List<Board> selectBoardList() {
		return bs.selectBoardList();
		
	}
	
	// view의 selectBoard요청을 담당할 메서드
	public Board selectBoard(int boardNo) {
	   return bs.selectBoard(boardNo);
		
	}
	
	// view의 insertBoard요청을 담당할 메서드
	public void insertBoard(String boardTitle, String boardContent) {
		Board b = new Board();
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		int result=bs.insertBoard(b);
		
		if(result>0) {
			new BoardView().displaySuccess("등록성공");
		}else {
			new BoardView().displayFail("등록 실패");
		}
		
	}
	
	
	
	
	// view의 updateBoard요청을 담당할 메서드
	public void updateBoard(int boardNo, String boardContent) {
		Board b = new Board();
		
		b.setBoardNo(boardNo);
		b.setBoardContent(boardContent);
		
		int result = bs.updateBoard(boardNo,b);
		if(result>0) {
			new BoardView().displaySuccess("내용변경 성공");
		}else {
			new BoardView().displayFail("변경 실패");
		}
		
	}
	// view의 deleteBoard요청을 담당할 메서드
	public void deleteBoard(int boardNo) {
		int result = bs.deleteBoard(boardNo);
		
		if(result>0) {
			new BoardView().displaySuccess("삭제 성공");
			
		}else {
			new BoardView().displayFail("삭제못함");
		}
		
	}
	
	
	
			
}
