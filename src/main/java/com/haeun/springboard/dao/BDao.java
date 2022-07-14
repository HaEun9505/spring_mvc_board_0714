package com.haeun.springboard.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.haeun.springboard.dto.BDto;

//DB랑 연동해주는 클래스(데이터 접속 객체)

public class BDao {
	
	DataSource dataSource;	// Server의 context.xml 불러서 사용

	public BDao() {	
		super();
		// TODO Auto-generated constructor stub
		try {	// 강제적 예외처리
			Context context = new InitialContext();
			// java DateSource 초기화
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void write(String bname, String btitle, String bcontent) {	 // 사용자가 입력한 3개의 값을 받음
		Connection conn = null;
		PreparedStatement pstmt = null;
		//PreparedStatement - SQL구문을 실행시키는 기능
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO mvc_board(bid,bname,btitle,bcontent,bhit,bgroup,bstep,bindent) "
					+ "VALUES(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
			//물음표의 n번째 값 지정(1부터 시작)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.executeUpdate();	// integer 반환 가능
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}
	}
	
	//배열 - BDto로 만든 데이터 객체(자료구조)
	public ArrayList<BDto> list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//빈 리스트(배열)
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM mvc_board ORDER BY bid DESC";
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();	//sql 실행문
			
			while(rs.next()) {//글의 개수만큼 반복
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				//필드값을 가지고 초기화
				BDto dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				dtos.add(dto);				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}
		return dtos;	// 리스트 반환
	}
	
	//한개만 반환하므로 배열 x, 반환값 o
	public BDto contentView(String strbid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BDto dto = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM mvc_board WHERE bid=?";
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, Integer.parseInt(strbid));
			//문자열로 들어온 strbid를 int형으로 형변환
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	//글의 개수만큼 반복
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
							
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}
		return dto;
	}
	
}