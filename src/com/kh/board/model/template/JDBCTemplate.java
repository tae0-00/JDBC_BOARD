package com.kh.board.model.template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

// JDBC의 주요 메서드들을 정의한 클래스
// getConnection, close, commit, rollback 메서드를 정의
// 단, db와의 연결정보는 resources/driver.properties에서 관리한다.
public class JDBCTemplate {

	public static Connection getConnectin() {
		Connection conn=null;
		
		Properties prop =new Properties();
		
		
		BasicDataSource dataSource = new BasicDataSource();
		
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
			
			dataSource.setDriverClassName(prop.getProperty("driver"));
			dataSource.setUrl(prop.getProperty("url"));
			dataSource.setUsername(prop.getProperty("username"));
			dataSource.setPassword(prop.getProperty("password"));
			dataSource.setInitialSize(10); // 초키 커넥션풀 사이즈(기본값0)
			dataSource.setMaxTotal(50);// 커넥션풀이 가질 수 있는 최대커넥션 수. (기본 8)
			dataSource.setDefaultAutoCommit(false);
			dataSource.setMaxWaitMillis(10000);// 최대 대기 시간설정. 10초가 지나면 에러발생.
			dataSource.setRemoveAbandonedTimeout(300);// 사용하고 있지 않은 커넥션 삭제
			
			conn = dataSource.getConnection();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 트랜잭션처리 메서드
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
