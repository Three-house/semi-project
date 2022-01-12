package com.tr.community;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tr.log.DBManager;

public class ComDAO {
	
	private ArrayList<Community> communities;
	
	private static final ComDAO CDAO = new ComDAO();
	
	private ComDAO() {
		
	}
	
	public static ComDAO getCdao() {
		return CDAO;
	}
	
	public void regCom(HttpServletRequest request) {
		//커뮤 글 등록
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into community values (community_seq.nextval,?,?,?,?,sysdate)";
		
		try {
			request.setCharacterEncoding("utf-8");
			
			con = DBManager.connect();
			System.out.println("연결 성공");
			
			pstmt = con.prepareStatement(sql);
			
			String saveDirectory = request.getServletContext().getRealPath("com_img");
			System.out.println(saveDirectory);
			
			MultipartRequest mr = new MultipartRequest(request, saveDirectory,
							31457280, "utf-8", new DefaultFileRenamePolicy());
			
			String userId = mr.getParameter("userId");
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
			String fName = mr.getFilesystemName("file");
			
			System.out.println(userId);
			System.out.println(title);
			System.out.println(content);
			System.out.println(fName);
			
			pstmt.setString(1,userId);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, fName);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록되었습니다.");
			} else {
				request.setAttribute("r", "등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버에러");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}


	public void getAllCom(HttpServletRequest request) {
		// 커뮤니티 글 다 보기
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from community order by c_date";
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			communities = new ArrayList<Community>();
			
			Community c = null;
			
			while (rs.next()) {
				
				c = new Community();
				
				c.setNo(rs.getInt("c_no"));
				c.setUserId(rs.getString("c_userId"));
				c.setTitle(rs.getString("c_title"));
				c.setContent(rs.getString("c_content"));
				c.setImg(rs.getString("c_img"));
				c.setDate(rs.getDate("c_date"));
				communities.add(c);
			}
				
				request.setAttribute("communities", communities);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void getCom(HttpServletRequest request) {
		// 선택한 글 정보

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from community where c_no = ?";
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(request.getParameter("num")));
			
			rs = pstmt.executeQuery();
			
			Community c = null;
			
			if (rs.next()) {
				 
				c = new Community();
				
				c.setNo(rs.getInt("c_no"));
				c.setUserId(rs.getString("c_userId"));
				c.setTitle(rs.getString("c_title"));
				c.setContent(rs.getString("c_content"));
				c.setImg(rs.getString("c_img"));
				c.setDate(rs.getDate("c_date"));
				
				request.setAttribute("community", c);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void searchCom(HttpServletRequest request) {
		// 검색하기

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 강의 다시보기
		String sql = "select * from community where c_title like  '%'||?||'%'";
		
		try {
			
			request.setCharacterEncoding("utf-8");
			
			con = DBManager.connect();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("search"));
			
			rs = pstmt.executeQuery();
			
			communities = new ArrayList<Community>();
			Community c = null;
			
			while (rs.next()) {
				c = new Community();
				c.setNo(rs.getInt("c_no"));
				c.setUserId(rs.getString("c_userId"));
				c.setTitle(rs.getString("c_title"));
				c.setContent(rs.getString("c_content"));
				c.setImg(rs.getString("c_img"));
				c.setDate(rs.getDate("c_date"));
				
				communities.add(c);
			}
			
			request.setAttribute("communities", communities);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public void deleteCom(HttpServletRequest request) {
		// 삭제하기
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "delete community where c_no = ?";
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String no= request.getParameter("no");
			pstmt.setString(1, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제되었습니다.");
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

	public void updateCom(HttpServletRequest request) {
		// 수정하기
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update community set c_title = ?, c_content = ? where c_no = ?";
		
		try {
			request.setCharacterEncoding("utf-8");
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String no = request.getParameter("no");
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정되었습니다.");
			} else {
				request.setAttribute("r", "수정 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
	
	public void paging(int page, HttpServletRequest request) {
			
			// 현재 페이지 
			request.setAttribute("curPageNo", page); // view에서 쓰기 위해
			
			// 전체 페이지 수 계산
			int cnt = 10; // 한 페이지당 보여줄 개수
			
			int total = communities.size(); // 총 데이터 개수
						// size() : 길이
			
			//	총페이지수
			int pageCount = (int) Math.ceil((double) total / cnt);
			request.setAttribute("pageCount", pageCount);
			 
			int start = total - (cnt * (page - 1));
			
			int end = (page == pageCount) ? -1 : start - (cnt + 1);
			
			ArrayList<Community> items = new ArrayList<Community>(); 
					
											// 역순
			for (int i = start - 1; i > end; i--) {
							// 0 > -1 
						// 배열 -> 0부터 시작 
				
				items.add(communities.get(i));
			}
			
			request.setAttribute("communities", items);
			
	
		}
}
