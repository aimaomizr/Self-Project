package com.zr.HealthRisk.servlets;




import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.HealthRisk.database_op.Connect;
import com.zr.HealthRisk.database_op.User;
import com.zr.HealthRisk.database_op.UserDao;
import com.zr.HealthRisk.database_op.UserDaoImpl;


public class AjaxLoginVerify extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
//		        ServletContext  application= this.getServletContext();
//        HttpSession session = request.getSession();
		System.out.println("AjaxLoginVerify");
		String usernameid = request.getParameter("UserNameId");
	String  userpasswordid = request.getParameter("UserPasswordId");
	
		System.out.println("����õ���"+userpasswordid);	
// ����
		System.out.println("�û�Ϊ��" + usernameid);
		
//�����û������¼

		// �������ݿ�
		Connect c = new Connect();
		Connection conn = null;
		
		Statement st = null;
		ResultSet rs = null;
		
		String  sql="select * from user where UserName like '%"+usernameid+"%'";
		System.out.println(sql);
		
		//int dbs_password ;
		int flag=0;
		
	try{int count=0;
			conn = c.getConn();
			System.out.println(conn);
			st = conn.createStatement();
			System.out.println(st);
			rs = st.executeQuery(sql);
//			rs.last();//ָ���Ƶ����һ������
//			int rows=rs.getRow();
//			System.out.println(rs.getRowId(flag));
//			if(rs.getRow()!=0){
			System.out.println(rs);
			while (rs.next()) {
				 count = count + 1;
			System.out.println("count");
//			emname = rs.getString("employeename");
			//dbs_password = rs.getInt("UserPassword");
			//String pwd=new Integer(emwd).toString();
			
		//	System.out.println("���ݿ�������"+pwd);
			
				if (rs.getString("UserPassword").equals(userpasswordid)) {
                     //ҳ���ֵ�������ݿ��ֵ
					out.println("welcome");
					
				
						flag=1;
						
					}else{
						out.println("wrong password");
					
						flag=2;
					}
					
				

		
				
				rs.close();
				st.close();
			}
			System.out.println("count"+count);
			if(count==0){out.println("user unexist");}
//			}else{}
			
	}catch (Exception e) {
					// TODO: handle exception
				}
//	 if(flag!=3){if(flag==1){
//		 out.print("�û���������ȷ");
//		 
//		 } 
//	  if(flag==2)
//		 {
//			 out.print("�������");
//		 }
//	 }else { out.print("�û�������");}
	 
	  
		  
		  
	  
	
		}
	
}

