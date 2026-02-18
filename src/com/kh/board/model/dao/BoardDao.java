package com.kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.board.model.vo.Board;

import static com.kh.board.model.template.JDBCTemplate.*;
/** 
 * Service의 요청에 맞는 sql문을 실행할 클래스.
 * 단, sql문은 resources/query.xml에 보관/관리한다.
 * */
public class BoardDao {

	private Properties prop = new Properties();
	public int login(Connection conn, String memberId, String memberPwd) {
		int result =0;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		
		String sql =prop.getProperty("login");
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public List<Board> selectBoardList(Connection conn) {
		 List<Board> list = new ArrayList<Board>();
			PreparedStatement pstmt=null;
			ResultSet rset = null;
			
			String sql= prop.getProperty("selectBoardList");
			
			try {
				pstmt =conn.prepareStatement(sql);
				rset =pstmt.executeQuery();
				
				while(rset.next()) {
					Board b = new Board(
					 rset.getInt("BOARD_NO"),
					 rset.getString("BOARD_TITLE"),
					 rset.getString("MEMBER_ID"),
					 rset.getDate("CREATE_DATE")
					 );
					list.add(b);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
	}

	public Board selectBoard(Connection conn, int boardNo) {
		Board result = null;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		
		String sql= prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result = new Board();//여기서 이거 생성하는 거 잊지 말기 
				rset.getString("BOARD_CONTENT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int insertBoard(Connection conn, Board b) {

		int result= 0;
		PreparedStatement pstmt= null;
		
		String sql = "INSERT INTO BOARD (BOARD_TITLE,BOARD_CONTENT) VALUES(?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection conn, int boardNo, Board b) {
		int result =0;
		PreparedStatement pstmt= null;
		
		String sql= "UPDATE BOARD SET BOARD_CONTENT = ? WHERE BOARD_NO = ? ";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardContent());
			pstmt.setInt(2, boardNo);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		int result =0;
		PreparedStatement pstmt= null;
		String sql= prop.getProperty("deleteBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

}
