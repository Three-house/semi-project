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
			// �α��� ����
			request.setAttribute("loginPage", "jsp/loginInfo.jsp");
		} else {
			// �α��� ����
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
				// �Է¹��� ���̵� Ȯ�� �� ��й�ȣ  �˻��ϱ�
				String dbPW = rs.getString("a_pw");
				
				if (userpw.equals(dbPW)) {
					// ��� ���ؼ�  ������ db�� �ִ� ������ a ��ü�� ����
					Account a = new Account();
					a.setName(rs.getString("a_name"));
					a.setId(rs.getString("a_id"));
					a.setPw(rs.getString("a_pw"));
					a.setSex(rs.getString("a_sex"));
					a.setContact(rs.getString("a_contact"));
					a.setAddr(rs.getString("a_addr"));
					
					// ��ȭ��ȣ �߶� �ֱ�
					String contact = rs.getString("a_contact");
					String num1 = contact.split("-")[0];
					String num2 = contact.split("-")[1];
					String num3 = contact.split("-")[2];
						//�ڸ� ��ȭ��ȣ Ȯ���ϱ�
					System.out.println(num1);
					System.out.println(num2);
					System.out.println(num3);
					   //�ڸ� ��ȭ��ȣ ��ü �ʵ忡 �����ϱ�
					a.setNum1(num1);
					a.setNum2(num2);
					a.setNum3(num3);
					// �ּ� �߶� �ֱ�
					String addr = rs.getString("a_addr");
					String postAddr1 = addr.split("_")[0];
					String postAddr2 = addr.split("_")[1];
					String postAddr3 = addr.split("_")[2];
						// �ڸ� �ּ� Ȯ���ϱ�
					System.out.println(postAddr1);
					System.out.println(postAddr2);
					System.out.println(postAddr3);
						// �ڸ� �ּ� ��ü �ʵ忡 �����ϱ�
					a.setPostAddr1(postAddr1);
					a.setPostAddr2(postAddr2);
					a.setPostAddr3(postAddr3);
					// ����, �¾�Ʈ����Ʈ�� ����
					HttpSession hs = request.getSession();
					hs.setAttribute("accountInfo", a);
					hs.setMaxInactiveInterval(180);
					
					request.setAttribute("r", "�α��� ����!");
				} else {
					request.setAttribute("r", "��й�ȣ ����!");
				}
			} else {
				request.setAttribute("r", "�������� �ʴ� ȸ�� �Դϴ�.");
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
			// ���� �޾ƿ���
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String sex = request.getParameter("gender");
				// ����ó ��3�� �޾Ƽ� �ϳ��� �����
			String num1 = request.getParameter("num1");
			String num2 = request.getParameter("num2");
			String num3 = request.getParameter("num3");
			String contact = num1 + "-" + num2 + "-" + num3;
				// �ּ� ��3�� �޾Ƽ� �ϳ��� �����
			String  postAddr1= request.getParameter("postAddr1");
			String  postAddr2= request.getParameter("postAddr2");
			String  postAddr3= request.getParameter("postAddr3");
			String addr = postAddr1+"_"+postAddr2+"_"+postAddr3;
			// �� Ȯ���غ���
			System.out.println(name);
			System.out.println(id);
			System.out.println(pw);
			System.out.println(sex);
			System.out.println(contact);
			System.out.println(addr);
			//�� �������ֱ�
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, sex);
			pstmt.setString(5, contact);
			pstmt.setString(6, addr);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("��� ����!");
			} else {
				System.out.println("��� ����...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB ���� ���� ...");
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
				System.out.println("Ż�� ����!");
			} 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB ���� ����...");
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
			
			// ���������� �Ķ���͸� �޾ƿ���
			String id =request.getParameter("id");
			String pw = request.getParameter("pw");
			String pw2 = request.getParameter("pw2");
			System.out.println("--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println(id);
			System.out.println(pw);
			System.out.println(pw2);
				// ����ó ��3�� �޾Ƽ� �ϳ��� �����(���� ��)
			String num1 = request.getParameter("num1");
			String num2 = request.getParameter("num2");
			String num3 = request.getParameter("num3");
			String contact = num1 + "-" + num2 + "-" + num3;
			System.out.println(contact);
				// ����ó ��3�� �޾Ƽ� �ϳ��� �����(������Ʈ ��)
			String num11 = request.getParameter("num11");
			String num22 = request.getParameter("num22");
			String num33 = request.getParameter("num33");
			String contact2 = num11 + "-" + num22 + "-" + num33;
			System.out.println(contact2);
				// �ּ� ��3�� �޾Ƽ� �ϳ��� �����(���� ��)
			String  postAddr1= request.getParameter("postAddr1");
			String  postAddr2= request.getParameter("postAddr2");
			String  postAddr3= request.getParameter("postAddr3");
			String addr = postAddr1+"_"+postAddr2+"_"+postAddr3;
			System.out.println(addr);
			// �ּ� ��3�� �޾Ƽ� �ϳ��� �����(������Ʈ ��)
			String  postAddr11= request.getParameter("postAddr1");
			String  postAddr22= request.getParameter("postAddr2");
			String  postAddr33= request.getParameter("postAddr3");
			String addr2 = postAddr11+"_"+postAddr22+"_"+postAddr33;
			System.out.println(addr2);
			// �������� ������Ʈ�� �� �ֱ�
				// �н�����
			String pw3 = "";
			if(pw2.length() == 0) {
				pw3 = pw;
			}else {
				pw3 = pw2;
			}
				// ��ȭ��ȣ
			String contact3 = "";
			if(contact2.length() == 2) {
				contact3 = contact;
			}else {
				contact3 = contact2;
			}
				// �ּ�
			String addr3 = "";
			if(addr2.length() == 0) {
				addr3 = addr;
			}else {
				addr3 = addr2;
			}
			
			// sql�� �ڸ��� �� �� ��ġ
			pstmt.setString(1, pw3);
			pstmt.setString(2, contact3);
			pstmt.setString(3, addr3);
			pstmt.setString(4, id);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "���� ����!");
			} else {
				request.setAttribute("r", "���� ���� ...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB ���� ����...");
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
		
	

}
