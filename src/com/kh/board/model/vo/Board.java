package com.kh.board.model.vo;

import java.sql.Date;

/**
 * Board 테이블의 한행의 정보를 보관할 클래스
 *  */
/** 
 * 게시글 목록 조회 메서드
 * 게시판에 존재하는 게시글 정보를 모두 출력하는 메서드.
 * 게시글의 번호, 제목, 작성자, 작성시간 출력
 * */
public class Board {

	private int boardNo;
	private String boardTitle;
	private String memberId;
	private Date createDate;
	private String boardContent;  
	public Board() {}

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Board(int boardNo, String boardTitle, String memberId, Date createDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.memberId = memberId;
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", memberId=" + memberId + ", createDate="
				+ createDate + "]";
	}
	
	
}
