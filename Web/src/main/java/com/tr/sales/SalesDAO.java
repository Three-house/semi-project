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
	
	private ArrayList<sales> sales;
	
	private static final SalesDAO SDAO = new SalesDAO();
	
	public SalesDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static SalesDAO getSdao() {
		return SDAO;
	}
	
	// 매물 전체 조회
	public static void sales_select_all(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sales order by s_date desc";
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
				String address = rs.getString("s_address");
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
//				System.out.println(num);
//				System.out.println(name);
//				System.out.println(salesort);
//				System.out.println(location);
//				System.out.println(address);
//				System.out.println(size);
//				System.out.println(condition);
//				System.out.println(price);
//				System.out.println(date);
//				System.out.println(img1);
//				System.out.println(img2);
//				System.out.println(img3);
//				System.out.println(contact);
				
				s = new sales(num, name, salesort, location, address, size, condition, price, date, etc, img1, img2, img3, contact);
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
				String address = rs.getString("s_address");
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
				System.out.println(address);				
				System.out.println(size);
				System.out.println(condition);
				System.out.println(price);
				System.out.println(date);
				System.out.println(etc);
				System.out.println(img1);
				System.out.println(img2);
				System.out.println(img3);
				System.out.println(contact);
				
				s = new sales(num, name, salesort,location,address, size, condition, price, date, etc, img1, img2, img3, contact);
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
		String sql = "update sales set s_name=?,s_salesort=?,s_size=?,s_condition=?,s_location=?,s_address=?,s_price=?,"
				+ "s_etc=?,s_img1=?,s_img2=?,s_img3=?,s_contact=? where s_no=?";
		
		try {
			
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			String path = request.getSession().getServletContext().getRealPath("sales_img");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(request,path,5*1024*1024,"utf-8",policy);
			
			String file1 = mr.getFilesystemName("img1");
			String file2 = mr.getFilesystemName("img2");
			String file3 = mr.getFilesystemName("img3");
			
			con = DBManager.connect();		
			pstmt = con.prepareStatement(sql);
			
			System.out.println("--------매물 업뎃 값 확인---------");
			System.out.println(mr.getParameter("no"));
			System.out.println(mr.getParameter("buildingName"));
			System.out.println(mr.getParameter("condition"));
			System.out.println(mr.getParameter("salesort"));
			System.out.println(mr.getParameter("location"));
			System.out.println(mr.getParameter("address"));
			System.out.println(mr.getParameter("price"));
			System.out.println(mr.getParameter("size"));
			System.out.println(mr.getParameter("etc"));
			System.out.println(file1);
			System.out.println(file2);
			System.out.println(file3);
			System.out.println(mr.getParameter("contact"));
			
			pstmt.setString(1, mr.getParameter("buildingName"));
			pstmt.setString(2, mr.getParameter("condition"));
			pstmt.setString(3, mr.getParameter("salesort"));
			pstmt.setString(4, mr.getParameter("location"));
			pstmt.setString(5, mr.getParameter("address"));
			pstmt.setString(6, mr.getParameter("price"));
			pstmt.setString(7, mr.getParameter("size"));
			pstmt.setString(8, mr.getParameter("etc"));
			pstmt.setString(9, file1);
			pstmt.setString(10, file2);
			pstmt.setString(11, file3);
			pstmt.setString(12, mr.getParameter("contact"));
			pstmt.setString(13, mr.getParameter("no"));
			
			
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
			String sql = "insert into sales values (sales_seq.nextval,?,?,?,?,?,?,?,sysdate,?,?,?,?,?)";
			
		try {
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			String path = request.getSession().getServletContext().getRealPath("sales_img");
			System.out.println(path);
			
			MultipartRequest mr = new MultipartRequest(request,path,5*1024*1024,"utf-8",policy);
			
			String file1 = mr.getFilesystemName("img1");
			String file2 = mr.getFilesystemName("img2");
			String file3 = mr.getFilesystemName("img3");
			System.out.println("--------매물내놓기 값");
			System.out.println(mr.getParameter("buildingName"));
			System.out.println(mr.getParameter("salesort"));
			System.out.println(mr.getParameter("location"));
			System.out.println(mr.getParameter("address"));
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
			pstmt.setString(4, mr.getParameter("address"));
			pstmt.setString(5,mr.getParameter("size"));
			pstmt.setString(6,mr.getParameter("condition"));
			pstmt.setString(7,mr.getParameter("price"));
			pstmt.setString(8,mr.getParameter("etc"));
			pstmt.setString(9,file1);
			pstmt.setString(10,file2);
			pstmt.setString(11,file3);
			pstmt.setString(12,mr.getParameter("contact"));
			
			
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
		// s_date가 최신순으로 해서 상위 4개까지만 보기
		String sql = "select * from (select * from sales order by s_date desc) where rownum < 5";
		
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
				String address = rs.getString("s_address");
				String size = rs.getString("s_size");
				String condition = rs.getString("s_condition");
				String price = rs.getString("s_price");
				Date date = rs.getDate("s_date");
				String etc = rs.getString("s_etc");
				String img1 = rs.getString("s_img1");
				String img2 = rs.getString("s_img2");
				String img3 = rs.getString("s_img3");
				String contact = rs.getString("s_contact");
				
				s = new sales(num, name, salesort, location, address, size, condition, price, date, etc, img1, img2, img3, contact);
				sales.add(s);
				
				
			}
			request.setAttribute("salesfour", sales);
						

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	
	public void paging (int page, HttpServletRequest request) {
		
		
		request.setAttribute("curPageNo", page);
		
		// 전체 페이지 수 계산
		int cnt = 3; // 한 페이지당 보여줄 개수
		int total = sales.size(); // 총 데이터 개수
		
		int pageCount = (int) Math.ceil((double) total / cnt);
		request.setAttribute("pageCount", pageCount);
		
		int start = total - (cnt * (page - 1));
		
		int end = (page == pageCount) ? -1 : start - (3 + 1);
		
		
		
		
		ArrayList<sales> items = new ArrayList<sales>();
		
		for (int i = start-1; i > end ; i--) {
			items.add(sales.get(i));
		}
		request.setAttribute("sales", items);
		
	}
	
	//매물 상세 검색
	public void sales_search(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sales where s_location like ? and s_price >= ? and s_price < ? and s_condition = ? and s_name like ?";
		try {
			String region = request.getParameter("region");
			String searchRegion = null;
			if (region.equals("seoul")) {
				searchRegion = "서울";
			}else if (region.equals("gyeonggido")) {
				searchRegion = "경기도";
			}else if (region.equals("chungcheongdo")) {
				searchRegion = "충청도";
			}else if (region.equals("gyeongsangdo")) {
				searchRegion = "경상도";
			}else if (region.equals("jeollado")) {
				searchRegion = "전라도";
			}else if (region.equals("jejudo")) {
				searchRegion = "제주도";
			}
			String priceHouse = request.getParameter("priceHouse");
			int min = 0;
			int max = 0;
			if (priceHouse.equals("zero")) {
				max = 1000000;
			}else if (priceHouse.equals("hundred")) {
				min = 1000000;
				max = 3000000;
			}else if (priceHouse.equals("threehun")) {
				min = 3000000;
				max = 6000000;
			}else if (priceHouse.equals("sixhun")) {
				min = 6000000;
				max = 10000000;
			}else if (priceHouse.equals("tenmillion")) {
				min = 10000000;
				max = 100000000;
			}else if (priceHouse.equals("hundredmillion")) {
				min = 100000000;
				max = 2147483647;
			}
			String TypeofSale = request.getParameter("TypeofSale");
			String searchType = null;
			if (TypeofSale.equals("lease")) {
				searchType = "전세";
			}else if (TypeofSale.equals("monthlyRent")) {
				searchType = "월세";
			}else if (TypeofSale.equals("sale")) {
				searchType = "매매";
			}
			String searchRoom = request.getParameter("searchRoom");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+ searchRegion +"%");
			pstmt.setInt(2, min);
			pstmt.setInt(3, max);
			pstmt.setString(4, searchType);
			pstmt.setString(5, "%"+ searchRoom +"%");
			rs = pstmt.executeQuery();
			
			
			sales s = null;
			ArrayList<sales> sales = new ArrayList<sales>();
			
			while (rs.next()) {
				
				String num = rs.getString("s_no");
				String name = rs.getString("s_name");
				String salesort = rs.getString("s_salesort");
				String location = rs.getString("s_location");
				String address = rs.getString("s_address");
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
				System.out.println(address);
				System.out.println(size);
				System.out.println(condition);
				System.out.println(price);
				System.out.println(date);
				System.out.println(img1);
				System.out.println(img2);
				System.out.println(img3);
				System.out.println(contact);
				
				s = new sales(num, name, salesort,location,address, size, condition, price, date, etc, img1, img2, img3, contact);
				sales.add(s);
			}
			request.setAttribute("sales", sales);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	
}
