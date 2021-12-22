package com.tr.log;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tr.log.DBManager;

public class AccountDAO {

	public static void logincheck(HttpServletRequest request) {
		
		HttpSession hs = request.getSession();
		Account a = (Account) hs.getAttribute("accountInfo");

		if (a == null) {	
			// 로그인 실패
			request.setAttribute("loginPage", "jsp/loginInfo.jsp");
		} else {
			// 로그인 성공
			request.setAttribute("loginPage", "jsp/loginOK.jsp");
		}
		
	}

	public static void login(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from account where a_id = ?";
		
		try {
			request.setCharacterEncoding("utf-8");
			String userid = request.getParameter("id");
			String userpw = request.getParameter("pw");
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// 입력받은 아이디 확인 후 비밀번호  검사하기
				String dbPW = rs.getString("a_pw");
				
				if (userpw.equals(dbPW)) {
					// 비번 비교해서  맞으면 db에 있는 정보들 a 객체에 셋팅
					Account a = new Account();
					a.setName(rs.getString("a_name"));
					a.setId(rs.getString("a_id"));
					a.setPw(rs.getString("a_pw"));
					a.setSex(rs.getString("a_sex"));
					a.setContact(rs.getString("a_contact"));
					a.setAddr(rs.getString("a_addr"));
					
					// 전화번호 잘라서 넣기
					String contact = rs.getString("a_contact");
					String num1 = contact.split("-")[0];
					String num2 = contact.split("-")[1];
					String num3 = contact.split("-")[2];
						//자른 전화번호 확인하기
					System.out.println(num1);
					System.out.println(num2);
					System.out.println(num3);
					   //자른 전화번호 객체 필드에 세팅하기
					a.setNum1(num1);
					a.setNum2(num2);
					a.setNum3(num3);
					// 주소 잘라서 넣기
					String addr = rs.getString("a_addr");
					String postAddr1 = addr.split("_")[0];
					String postAddr2 = addr.split("_")[1];
					String postAddr3 = addr.split("_")[2];
						// 자른 주소 확인하기
					System.out.println(postAddr1);
					System.out.println(postAddr2);
					System.out.println(postAddr3);
						// 자른 주소 객체 필드에 세팅하기
					a.setPostAddr1(postAddr1);
					a.setPostAddr2(postAddr2);
					a.setPostAddr3(postAddr3);
					// 세션, 셋어트리뷰트로 포장
					HttpSession hs = request.getSession();
					hs.setAttribute("accountInfo", a);
					hs.setMaxInactiveInterval(180);
					
					request.setAttribute("r", "로그인 성공!");
				} else {
					request.setAttribute("r", "비밀번호 오류!");
				}
			} else {
				request.setAttribute("r", "존재하지 않는 회원 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void loginOut(HttpServletRequest request) {
		
		HttpSession hs = request.getSession();
		hs.setAttribute("accountInfo", null);
		
	}

	public static void reg(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into account values (?,?,?,?,?,?)";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			// 값들 받아오기
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String sex = request.getParameter("gender");
				// 연락처 값3개 받아서 하나로 만들기
			String num1 = request.getParameter("num1");
			String num2 = request.getParameter("num2");
			String num3 = request.getParameter("num3");
			String contact = num1 + "-" + num2 + "-" + num3;
				// 주소 값3개 받아서 하나로 만들기
			String  postAddr1= request.getParameter("postAddr1");
			String  postAddr2= request.getParameter("postAddr2");
			String  postAddr3= request.getParameter("postAddr3");
			String addr = postAddr1+"_"+postAddr2+"_"+postAddr3;
			// 값 확인해보기
			System.out.println(name);
			System.out.println(id);
			System.out.println(pw);
			System.out.println(sex);
			System.out.println(contact);
			System.out.println(addr);
			//값 세팅해주기
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, sex);
			pstmt.setString(5, contact);
			pstmt.setString(6, addr);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공!");
			} else {
				System.out.println("등록 실패...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결 문제 ...");
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void deleteAccount(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "delete account where a_id = ?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String id = request.getParameter("id");
			pstmt.setString(1, id);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("탈퇴 성공!");
			} 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 서버 문제...");
		} finally {
			DBManager.close(con, pstmt, null);
		}
				
	}

public static void updateAccount(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update account set a_pw=?, a_contact=?, a_addr=? where a_id=?";
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			// 수정가능한 파라미터만 받아오기
			String id =request.getParameter("id");
			String pw = request.getParameter("pw");
			String pw2 = request.getParameter("pw2");
			System.out.println("--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println(id);
			System.out.println(pw);
			System.out.println(pw2);
				// 연락처 값3개 받아서 하나로 만들기(기존 값)
			String num1 = request.getParameter("num1");
			String num2 = request.getParameter("num2");
			String num3 = request.getParameter("num3");
			String contact = num1 + "-" + num2 + "-" + num3;
			System.out.println(contact);
				// 연락처 값3개 받아서 하나로 만들기(업데이트 값)
			String num11 = request.getParameter("num11");
			String num22 = request.getParameter("num22");
			String num33 = request.getParameter("num33");
			String contact2 = num11 + "-" + num22 + "-" + num33;
			System.out.println(contact2);
				// 주소 값3개 받아서 하나로 만들기(기존 값)
			String  postAddr1= request.getParameter("postAddr1");
			String  postAddr2= request.getParameter("postAddr2");
			String  postAddr3= request.getParameter("postAddr3");
			String addr = postAddr1+"_"+postAddr2+"_"+postAddr3;
			System.out.println(addr);
			// 주소 값3개 받아서 하나로 만들기(업데이트 값)
			String  postAddr11= request.getParameter("postAddr1");
			String  postAddr22= request.getParameter("postAddr2");
			String  postAddr33= request.getParameter("postAddr3");
			String addr2 = postAddr11+"_"+postAddr22+"_"+postAddr33;
			System.out.println(addr2);
			// 기존값과 업데이트값 중 넣기
				// 패스워드
			String pw3 = "";
			if(pw2.length() == 0) {
				pw3 = pw;
			}else {
				pw3 = pw2;
			}
				// 전화번호
			String contact3 = "";
			if(contact2.length() == 2) {
				contact3 = contact;
			}else {
				contact3 = contact2;
			}
				// 주소
			String addr3 = "";
			if(addr2.length() == 0) {
				addr3 = addr;
			}else {
				addr3 = addr2;
			}
			
			// sql문 자리에 각 값 배치
			pstmt.setString(1, pw3);
			pstmt.setString(2, contact3);
			pstmt.setString(3, addr3);
			pstmt.setString(4, id);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정 성공!");
			} else {
				request.setAttribute("r", "수정 실패 ...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 서버 문제...");
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
		
	

}
