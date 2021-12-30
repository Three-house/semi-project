package com.tr.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.tr.log.DBManager;

public class CommentDAO {
	
	//db에 접근하는 객체
	private Connection con;
	private ResultSet rs;
	
	public CommentDAO() {
		
		try {
			
			con = DBManager.connect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getDate() {
		
		String sql = "select now()";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
				
			if (rs.next()) {
				return rs.getString(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public int getNext() {
		
		String sql = "select commentID from comments order by commentID desc";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 첫번째 댓글 인 경우
		return 1;  
	}
	
	
	public int write(int boardID, int bbsID, String userID, String commentText) {
		
		try {
			
		//	request.setCharacterEncoding("utf-8");
			
			String sql = "insert into comments values (?, ?, ? ,? ,?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, boardID);
			pstmt.setInt(2, getNext());
			pstmt.setInt(3, bbsID);
			pstmt.setString(4, userID);
			pstmt.setString(5, getDate());
			pstmt.setString(6, commentText);
			pstmt.setInt(7, 1);
			
			pstmt.executeUpdate();
			
			return getNext();

			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		// 데이터 베이스 오류
		return -1; 
		
	}
	
	public String getUpdateComment(int commentID) {
		
		String sql = "select commentText from comments where commentID = ?";
		
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, commentID);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ""; // 오류
	}

	public ArrayList<Comment> getList(int boardID, int bbsID){
		
		String sql = "select * from comments where boardID = ? and bbsID = ? and commentAvailable = 1 order by bbsID desc";
		
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, boardID);
			pstmt.setInt(2, bbsID);
	
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Comment cmt = new Comment();
				
				cmt.setBoardID(rs.getInt(1));
				cmt.setCommentID(rs.getInt(2));
				cmt.setBbsID(rs.getInt(3));
				cmt.setUserID(rs.getString(4));
				cmt.setCommentDate(rs.getString(5));
				cmt.setCommentText(rs.getString(6));
				cmt.setCommentAvailable(rs.getInt(7));
				list.add(cmt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 수정
	public int update(int commentID, String commentText) {
		
		String sql = "update comments set commentText = ? where commentID Like ?";
	
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, commentText);
			pstmt.setInt(2, commentID);
			
			return pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return -1; // 데이터베이스 오류
	
	}
	
	public Comment getComment(int commentID) {
		
		String sql = "select * from comments where commentID = ? order by commentID desc";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, commentID);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Comment cmt = new Comment();
				
				cmt.setBoardID(rs.getInt(1));
				cmt.setCommentID(rs.getInt(2));
				cmt.setBbsID(rs.getInt(3));
				cmt.setUserID(rs.getString(4));
				cmt.setCommentDate(rs.getString(5));
				cmt.setCommentText(rs.getString(6));
				cmt.setCommentAvailable(rs.getInt(7));
				return cmt;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 삭제
	public int delete(int commentID) {
		
		String sql = "delete from comments where commentID = ?";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, commentID);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1; // 데이터베이스 오류
	}

}
