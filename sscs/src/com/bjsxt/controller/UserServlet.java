package com.bjsxt.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.CharChunk.CharOutputChannel;

import com.bjsxt.service.AdminService;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.TeacherService;
import com.bjsxt.service.impl.AdminServiceImpl;
import com.bjsxt.service.impl.StudentServiceImpl;
import com.bjsxt.service.impl.TeacherServiceImpl;

@WebServlet("/servlet/UserServlet")
public class UserServlet  extends  BaseServlet{

	
	/********�˳�����**********/
	protected void loginOut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //[1]��session����ע��
		     
		    req.getSession().invalidate();
		    
		    //req.getSession().removeAttribute("admin");
		 
		    //[2]��ת����½��ҳ��
		    
		    resp.sendRedirect(req.getContextPath()+"/login.jsp");
		 
	}
	
	
	
	/********��¼�Ĳ���*************/
	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //[1]����������루post��
		    req.setCharacterEncoding("utf-8");
		    
		    
		    
		    
		    //[2]����ǰ̨������
		    String uid = req.getParameter("uid");
		    //System.out.println(uid);
		    String pwd =req.getParameter("pwd");
		    //System.out.println(pwd);
		    //����û��Ľ�ɫ
		    String role = req.getParameter("role");
		    
		    //��Ȩ�ޱ��浽session��
		    
		    req.getSession().setAttribute("role", role);
		    
		    
		    /******��֤�� ��У��************************/
		    
		    //���ϵͳ��������֤��
		     String  randStr= (String) req.getSession().getAttribute("randStr");
		    
		     //����û��������֤��
		     String yzm = req.getParameter("yzm");
		    
		     if(yzm==null ||"".equals(yzm)||!yzm.equals(randStr)){
		    	 
		    	 req.setAttribute("msg2", "验证码错误");
		    	 req.getRequestDispatcher("/login.jsp").forward(req, resp);
		         return;
		     }
		    
		    
		    
		    //[3]��������
		    
		    Object   user=null;
		    
		    if("admin".equals(role)){
		    	
		    	 AdminService  admins=new  AdminServiceImpl();
				    
		    	 user = admins.adminLogin(uid, pwd);
		    }else  if("teacher".equals(role)){
		    	
		    	TeacherService  teas=new  TeacherServiceImpl();
		    	
		    	user=teas.login(uid, pwd);
		    	
		    	
		    }else  if("student".equals(role)){
		    	
		    	StudentService  stus=new StudentServiceImpl();
		    	
		    	user = stus.login(uid, pwd);
		    	 
		    }
		    
		   
		    
		    
		    
		    //[4]������Ӧ
		    
		    if(user!=null){
		    	
		    	/*****ʹ��session��ӭxx��½******/
		    	
		    	//���session����
		    	HttpSession session = req.getSession();
		    	//���ƶ������ݴ��뵽session
		    	session.setAttribute("admin", user);
		    	
		    	/******ͳ����վ�ķ�������************/
		    	
		    	 //���ȫ�ֵĶ���
		    	 ServletContext context = req.getServletContext();
		    	 
		    	 //���֮ǰ�Ѿ���½��������
		    	 
		    	 Integer   count= (Integer) context.getAttribute("count");
		    	
		    	  if(count==null){
		    		  
		    		  count=1;
		    	  }else {
		    		  
		    		  count++;
		    	  }
		    	 
		    	  context.setAttribute("count", count);
		    	 
		    	//�ض���
		    	resp.sendRedirect(req.getContextPath()+"/index.html");
		    }else{
		    	
		    	req.setAttribute("msg", "账号或密码错误");
		    	req.getRequestDispatcher("/login.jsp").forward(req, resp);;
		    }
		  
		  
	}

}
