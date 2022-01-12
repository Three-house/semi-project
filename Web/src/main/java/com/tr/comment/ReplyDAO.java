package com.tr.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.tr.log.DBManager;

public class ReplyDAO {

	public static void getAllReplies(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from replies order by re_date desc";
		
		try {
			
			con = DBManager.connect();
			System.out.println("연결 성공");
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Replies> repls = new ArrayList<Replies>();
			
			Replies r = null;
			
			while (rs.next()) {
				
				r = new Replies();
				
				r.setRe_no(rs.getInt("re_no"));
				r.setRe_name(rs.getString("re_name"));
				r.setRe_content(rs.getString("re_content"));
				r.setRe_date(rs.getDate("re_date"));
				
				repls.add(r);
			}
			
			request.setAttribute("repls", repls);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public static void regReplies(HttpServletRequest request) {
		 
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			request.setCharacterEncoding("utf-8");
			
			con = DBManager.connect();
			System.out.println("연결 성공");
			
			String sql = "insert into replies values (replies_seq.nextval, ? , ? , sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("content"));
			
			if (pstmt.executeUpdate() == 1) {
				
				System.out.println("등록 성공");
				request.setAttribute("r", "등록 성공");
				
			} else {
				System.out.println("등록 실패");
				request.setAttribute("r", "등록 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 문제");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public static void getReplies(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from replies where re_no = ?";
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(request.getParameter("num")));
			
			rs = pstmt.executeQuery();
			
			Replies r = null;
			
			if (rs.next()) {
				
				r = new Replies();
				
				r.setRe_no(rs.getInt("re_no"));
				r.setRe_name(rs.getString("re_name"));
				r.setRe_content(rs.getString("re_content"));
				r.setRe_date(rs.getDate("re_date"));
				
				request.setAttribute("reply", r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public static void updateReplies(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update replies set re_name = ?, re_content =? where re_no = ?";
		
		try {
			
			request.setCharacterEncoding("utf-8");
			
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("content"));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("no")));
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정 성공");
			} else {
				request.setAttribute("r", "수정 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 문제");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
	
	public static void deleteReplies(HttpServletRequest  request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "delete replies where re_no = ?";
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제 완료");
			} else {
				request.setAttribute("r", "삭제 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 문제");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
}
