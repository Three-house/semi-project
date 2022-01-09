package com.tr.sales;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tr.log.DBManager;


public class SalesDAO {
	
	// 매물 전체 조회
	public static void sales_select_all(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sales";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			sales s = null;
			ArrayList<sales> sales = new ArrayList<sales>();
			
			while (rs.next()) {
				
				String num = rs.getString("s_no");
				String name = rs.getString("s_name");
				String salesort = rs.getString("s_salesort");
				String location = rs.getString("s_location");
				String size = rs.getString("s_size");
				String condition = rs.getString("s_condition");
				String price = rs.getString("s_price");
				Date date = rs.getDate("s_date");
				String etc = rs.getString("s_etc");
				String img1 = rs.getString("s_img1");
				String img2 = rs.getString("s_img2");
				String img3 = rs.getString("s_img3");
				String contact = rs.getString("s_contact");
				// db값 잘 넘어 오는지 확인 ok
				System.out.println(num);
				System.out.println(name);
				System.out.println(salesort);
				System.out.println(location);
				System.out.println(size);
				System.out.println(condition);
				System.out.println(price);
				System.out.println(date);
				System.out.println(img1);
				System.out.println(img2);
				System.out.println(img3);
				System.out.println(contact);
				
				s = new sales(num, name, salesort,location, size, condition, price, date, etc, img1, img2, img3, contact);
				sales.add(s);
			}
			request.setAttribute("sales", sales);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public static void sales_select_one(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sales where s_no=?";
		String num = request.getParameter("num");
		System.out.println(num);
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			sales s = null;
			while (rs.next()) {
				
				String name = rs.getString("s_name");
				String salesort = rs.getString("s_salesort");
				String location = rs.getString("s_location");
				String size = rs.getString("s_size");
				String condition = rs.getString("s_condition");
				String price = rs.getString("s_price");
				Date date = rs.getDate("s_date");
				String etc = rs.getString("s_etc");
				String img1 = rs.getString("s_img1");
				String img2 = rs.getString("s_img2");
				String img3 = rs.getString("s_img3");
				String contact = rs.getString("s_contact");
				// 매물 상세보기페이지 값넘어오는지 화인ok
				System.out.println("----------------디테일부문-------------");
				System.out.println(name);
				System.out.println(salesort);
				System.out.println(location);				
				System.out.println(size);
				System.out.println(condition);
				System.out.println(price);
				System.out.println(date);
				System.out.println(etc);
				System.out.println(img1);
				System.out.println(img2);
				System.out.println(img3);
				System.out.println(contact);
				
				s = new sales(num, name, salesort,location, size, condition, price, date, etc, img1, img2, img3, contact);
			}
			request.setAttribute("sales", s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public static void sales_update(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update sales set s_name=?,s_salesort=?,s_size=?,s_condition=?,s_price=?,"
				+ "s_etc=?,s_img1=?,s_img2=?,s_img3=?,s_contact=? where s_no=?";
		
		try {
			
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			String path = request.getSession().getServletContext().getRealPath("salesimg");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(request,path,5*1024*1024,"utf-8",policy);
			
			String file1 = mr.getFilesystemName("img1");
			String file2 = mr.getFilesystemName("img2");
			String file3 = mr.getFilesystemName("img3");
			
			con = DBManager.connect();		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mr.getParameter("name"));
			pstmt.setString(2, mr.getParameter(""));
			pstmt.setString(3, mr.getParameter(""));
			pstmt.setString(4, mr.getParameter(""));
			pstmt.setString(5, mr.getParameter(""));
			pstmt.setString(6, mr.getParameter(""));
			pstmt.setString(7, file1);
			pstmt.setString(8, file2);
			pstmt.setString(9, file3);
			pstmt.setString(10, mr.getParameter(""));
			pstmt.setString(11, mr.getParameter(""));
			
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정 성공!");
				}else {		
					request.setAttribute("r", "수정 실패!");
				}
			
		} catch (Exception e) {
			request.setAttribute("r", "DB서버 오류!");
			e.printStackTrace();
			
		}finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public void sales_delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete sales where s_no=?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1,no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제 성공!");
				}else {		
					request.setAttribute("r", "삭제 실패!");
				}
			
		} catch (Exception e) {
			request.setAttribute("r", "DB서버 오류!");
			e.printStackTrace();
			
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
	}
	
	public static void sales_insert(HttpServletRequest request) {
		
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "insert into sales values (sales_seq.nextval,?,?,?,?,?,?,sysdate,?,?,?,?,?)";
			
		try {
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			String path = request.getSession().getServletContext().getRealPath("salesimg");
			System.out.println(path);
			
			MultipartRequest mr = new MultipartRequest(request,path,5*1024*1024,"utf-8",policy);
			
			String file1 = mr.getFilesystemName("img1");
			String file2 = mr.getFilesystemName("img2");
			String file3 = mr.getFilesystemName("img3");
			System.out.println("--------매물내놓기 값");
			System.out.println(mr.getParameter("buildingName"));
			System.out.println(mr.getParameter("salesort"));
			System.out.println(mr.getParameter("location"));
			System.out.println(mr.getParameter("size"));
			System.out.println(mr.getParameter("condition"));
			System.out.println(mr.getParameter("price"));
			System.out.println(mr.getParameter("etc"));
			System.out.println(file1);
			System.out.println(file2);
			System.out.println(file3);
			System.out.println(mr.getParameter("contact"));
		
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,mr.getParameter("buildingName"));
			pstmt.setString(2,mr.getParameter("salesort"));
			pstmt.setString(3, mr.getParameter("location"));
			pstmt.setString(4,mr.getParameter("size"));
			pstmt.setString(5,mr.getParameter("condition"));
			pstmt.setString(6,mr.getParameter("price"));
			pstmt.setString(7,mr.getParameter("etc"));
			pstmt.setString(8,file1);
			pstmt.setString(9,file2);
			pstmt.setString(10,file3);
			pstmt.setString(11,mr.getParameter("contact"));
			
			
			if (pstmt.executeUpdate() == 1) {
					System.out.println("등록 성공");
				}else {
					System.out.println("등록 실패 ...");
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결문제 ...");		
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}
	
	public static void sales_topfour(HttpServletRequest request) {
				
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from sales where rownum < 5";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			sales s = null;
			ArrayList<sales> sales = new ArrayList<sales>();
			
			while (rs.next()) {
				
				String num = rs.getString("s_no");
				String name = rs.getString("s_name");
				String salesort = rs.getString("s_salesort");
				String location = rs.getString("s_location");
				String size = rs.getString("s_size");
				String condition = rs.getString("s_condition");
				String price = rs.getString("s_price");
				Date date = rs.getDate("s_date");
				String etc = rs.getString("s_etc");
				String img1 = rs.getString("s_img1");
				String img2 = rs.getString("s_img2");
				String img3 = rs.getString("s_img3");
				String contact = rs.getString("s_contact");
				
				s = new sales(num, name, salesort,location, size, condition, price, date, etc, img1, img2, img3, contact);
				sales.add(s);
				
				
			}
			request.setAttribute("salesfour", sales);
						

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
}
