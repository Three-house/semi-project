package com.tr.salesReply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.tr.log.DBManager;

public class SaleReplyDAO {
	
	public static void regSaleReply(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into saleReply values (saleReply_seq.nextval, ?, ? , sysdate)";
		
		try {
			
			request.setCharacterEncoding("utf-8");
			
			con = DBManager.connect();
			System.out.println("연결 성공");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("content"));
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
				request.setAttribute("r", "등록 성공");
			} else {
				request.setAttribute("r", "등록 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 문제");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public static void getAllSaleReply(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from saleReply order by s_date";
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<SaleReply> saleReplies = new ArrayList<SaleReply>();
			
			SaleReply sr = null;
			
			while (rs.next()) {
				sr = new SaleReply();
				
				sr.setS_no(rs.getInt("s_no"));
				sr.setS_name(rs.getString("s_name"));
				sr.setS_content(rs.getString("s_content"));
				sr.setS_date(rs.getDate("s_date"));
				
//				System.out.println("-----댓글 값 넘어오는지 확인-----");
//				System.out.println(rs.getInt("s_no"));
//				System.out.println(rs.getString("s_name"));
//				System.out.println(rs.getString("s_content"));
//				System.out.println(rs.getDate("s_date"));
				
				saleReplies.add(sr);
			}
			
			request.setAttribute("saleReplies", saleReplies);

			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB에러 ...");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public static void getSaleReply(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from saleReply where s_no = ?";
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(request.getParameter("num")));
			
			rs = pstmt.executeQuery();
			
			SaleReply sr = null;
			
			if (rs.next()) {
				sr = new SaleReply();
				
				sr.setS_no(rs.getInt("s_no"));
				sr.setS_name(rs.getString("s_name"));
				sr.setS_content(rs.getString("s_content"));
				sr.setS_date(rs.getDate("s_date"));
				
				request.setAttribute("saleReply", sr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void updateSaleReply(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update saleReply set s_name = ?, s_content = ? where s_no = ?";
		
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
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void deleteSaleReply(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "delete saleReply where s_no = ?";
			
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
