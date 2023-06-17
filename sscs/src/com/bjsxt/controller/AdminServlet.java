package com.bjsxt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Admin;
import com.bjsxt.entity.Clazz;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;
import com.bjsxt.entity.Teacher;
import com.bjsxt.service.AdminService;
import com.bjsxt.service.impl.AdminServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/servlet/AdminServlet")
public class AdminServlet  extends  BaseServlet{
	
	private static final String NULL = null;
	AdminService  admins=new  AdminServiceImpl();
	
	
	/**********����Աɾ����ʦ��Ӧ�Ŀγ�*******************/
	protected void tcRemove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
        int  cno=Integer.parseInt(req.getParameter("cno"));
		
		int tno =Integer.parseInt(req.getParameter("tno"));
		 
		int  update= admins.tcRemove(cno, tno);
		
		resp.getWriter().print(update);
		
	}
	
	/**********����Ա����ʦ����γ�*******************/
	protected void tcRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		int  cno=Integer.parseInt(req.getParameter("cno"));
		
		int tno =Integer.parseInt(req.getParameter("tno"));

		int  update=  admins.tcRegister(cno, tno);
		
		
		resp.getWriter().print(update);
		
	}
	
	/**********����Ա��ѯ��ʦ��Ϣ*******************/
	protected void teaFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  
		   resp.setContentType("text/html;charset=utf-8");
		   
		   List<Teacher> teaList = admins.teaFindAll();
		   
		   Gson  gson=new Gson();
		   
		   String json = gson.toJson(teaList);
		   
		   resp.getWriter().print(json);
	}
	
	/**********����Ա��ѯ�γ�*******************/
	protected void couFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		List<Course> coulist = admins.couFindAll();
		
          Gson   gson=new Gson();
          
          String json = gson.toJson(coulist);
          
          resp.getWriter().print(json);
		
	}
	
	/**********����Ա��ѯ�γ̺���ʦ��Ϣ*******************/
	protected void tcFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   resp.setContentType("text/html;charset=utf-8");
		
		   List<Course> tclist = admins.tcFindAll();
		
		   Gson  gson =new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		   
		   String json = gson.toJson(tclist);
		   
		  resp.getWriter().print(json);
		
	}
	
	/**********����Ա�༶��Ϣ�Ĳ���*******************/
	protected void claFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Clazz> claList = admins.claFindAll();
		
		req.setAttribute("claList", claList);
		
		req.getRequestDispatcher("/files/studentRegister.jsp").forward(req, resp);
	}
	
	/**********����Ա��������ѯѧ������*******************/
	protected void stuFindLike(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		//��1������ǰ̨������
		 int  clazzno =Integer.parseInt(req.getParameter("clazzno"));
		 
		 String  sname =req.getParameter("sname");
		
		//��2�����ݵĴ���
		 
		 //��ѯѧ������Ϣ
		 List<Student> list = admins.stuFindLike(clazzno, sname);
		 
		 //��ѯ�༶����Ϣ
		 List<Clazz> claList = admins.claFindAll();
		
		//��3��������Ӧ
		 req.setAttribute("clazzno", clazzno);
		 req.setAttribute("sname", sname);
		 req.setAttribute("list", list); 
		 req.setAttribute("claList", claList);
		 req.getRequestDispatcher("/files/studentList.jsp").forward(req, resp);
		
		
		
	}
	
	/**********管理员查询老师信息*******************/
	protected void teaFindAll1(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  
		   AdminService  admins=new  AdminServiceImpl();
		   
		   List<Teacher> list1 = admins.teaFindAll();
		   List<Teacher> list = admins.teaFindAll();
		   req.setAttribute("list", list);
		   req.setAttribute("list1", list1);
			req.getRequestDispatcher("/files/teacherList.jsp").forward(req, resp);
	}
	
	/*******管理员查询单个学生***********/
	protected void teaFindOne(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //【1】解决中文的乱码
		
		    //【2】接受前台的数据
		    int  tno=Integer.parseInt(req.getParameter("tno"));
		    
		    //【3】处理数据
		    AdminService  admins=new  AdminServiceImpl();
		    
		    //制定的学生的信息
		    Teacher tea = admins.teaFindOne(tno);
		    
		    
		    
		    
		    //【4】做出响应
		    if(tea!=null){
		    	req.setAttribute("tea", tea);
		    	req.getRequestDispatcher("/files/teacherUpdate.jsp").forward(req, resp);
		    	
		    }
	}
	

	/**********管理员修改教师操作*******************/
	protected void teaChange(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //【1】解决中文乱码
		     req.setCharacterEncoding("utf-8");
		     
		     boolean legalflag = true;
		    //【2】接受前台的数据
		     int  tno=Integer.parseInt(req.getParameter("tno"));
		     
		     
		     String   pwd=req.getParameter("pwd");
			   if(pwd == "") legalflag = false;
			   
			   String  tname=req.getParameter("tname");
			   if(tname == "") legalflag = false;
			   
			   String phone=req.getParameter("phone");
			   if(phone == "") legalflag = false;
			   
			   Date hiredate = null;
			   if(req.getParameter("hiredate") == "") legalflag = false;
			   else hiredate = Date.valueOf(req.getParameter("hiredate"));
		     
			   
			   String  remark=req.getParameter("remark");
					   
			  
			  
			  
			   AdminService  admins=new  AdminServiceImpl();
		    //【3】处理数据
			   int update = 0;
			     
			     if(legalflag == true) {
			    	 Teacher teacher =new Teacher(tno,tname,pwd,phone,hiredate,remark);
			    //【3】处理数据
			    	 update = admins.teaChange(teacher);}
			
			    //【4】做出响应
			        
			     if(update>0){
			    	 resp.setCharacterEncoding("utf-8");
			    	 PrintWriter out = resp.getWriter();
			    	 out.print("<script>alert('修改成功');window.location = 'AdminServlet?method=teaFindAll1'</script>");
			    	 out.flush();
			    	 out.close();
			     }else {
			    	 resp.setCharacterEncoding("utf-8");
			    	 PrintWriter out = resp.getWriter();
			    	 out.print("<script>alert('修改失败');window.location = 'AdminServlet?method=teaFindAll1'</script>");
			    	 out.flush();
			    	 out.close();
			     }
		     
		}
	
	/**********管理员删除老师*******************/
	protected void teaRemove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//【1】解决中文的乱码
	    
	    //[2]接受前台的数据
	      int  tno=Integer.parseInt(req.getParameter("tno"));
	
	   //[3]处理数据
	      AdminService  admins=new  AdminServiceImpl();
	      
	      int update = admins.teaRemove(tno);
	
	   //【4】做出响应
	      
	      resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=teaFindAll1");
		
	}
	
	/**********管理员按条件查询教师操作*******************/
	protected void teaFindLike(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		//【1】接受前台的数据
		 int  teano =Integer.parseInt(req.getParameter("teano"));
		 
		 String  tname =req.getParameter("tname");
		
		//【2】数据的处理
		 
		 //查询学生的信息
		 List<Teacher> list1 = admins.teaFindLike(0,NULL);
		 List<Teacher> list = admins.teaFindLike(teano, tname);

		//【3】做出响应
		 req.setAttribute("teano", teano);
		 req.setAttribute("tname", tname);
		 req.setAttribute("list", list);
		 req.setAttribute("list1", list1); 
		 req.getRequestDispatcher("/files/teacherList.jsp").forward(req, resp);		
	}
	
	/**********����Ա�޸�ѧ������*******************/
	protected void stuChange(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //��1�������������
		     req.setCharacterEncoding("utf-8");
		    //��2������ǰ̨������
		    
		     int  sno=Integer.parseInt(req.getParameter("sno"));
		     
		     String pwd=req.getParameter("pwd");
		     
		     String sname=req.getParameter("sname");
		     
		     String phone=req.getParameter("phone");
		     
		     String gender=req.getParameter("gender");
		     
		     Date  birth=Date.valueOf(req.getParameter("birth"));
		     
		     int  clazzno=Integer.parseInt(req.getParameter("clazzno"));
		     
		     String remark=req.getParameter("remark");
		     
		     Student  stu=new  Student(sno, pwd, sname, phone, gender, birth, clazzno, remark);
		    //��3����������
		     
		     
		     
		     int update = admins.stuChange(stu);
		
		    //��4��������Ӧ
		        
		     if(update>0){
		    	 
		    	 resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=stuFindAll");
		     }
		}
	/*******����Ա��ѯ����ѧ��***********/
	protected void stuFindOne(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //��1��������ĵ�����
		
		    //��2������ǰ̨������
		    int  sno=Integer.parseInt(req.getParameter("sno"));
		    
		    //��3����������
		    AdminService  admins=new  AdminServiceImpl();
		    
		    //�ƶ���ѧ������Ϣ
		    Student stu = admins.stuFindOne(sno);
		    
		    //�༶����Ϣ
		    List<Clazz> claList = admins.claFindAll();
		    
		    
		    //��4��������Ӧ
		    if(stu!=null){
		    	
		    	req.setAttribute("claList", claList);
		    	req.setAttribute("stu", stu);
		    	req.getRequestDispatcher("/files/studentUpdate.jsp").forward(req, resp);
		    	
		    }
	}
	/*****����Աɾ��ָ����ѧ������*******/
	protected void stuRemove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    
		    //��1��������ĵ�����
		    
		    //[2]����ǰ̨������
		      int  sno=Integer.parseInt(req.getParameter("sno"));
		
		   //[3]��������
		      AdminService  admins=new  AdminServiceImpl();
		      
		      int update = admins.stuRemove(sno);
		
		   //��4��������Ӧ
		      
		      resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=stuFindAll");
		}
	/**********����Ա��ѯ����ѧ���Ĳ���*********/
	protected void stuFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 //��1������Ľ��
		   
		 //��2������ǰ̨������
		
		
		 //��3����������
		AdminService  admins=new  AdminServiceImpl();
		//��ѯ����ѧ����Ϣ
		List<Student> list = admins.stuFindAll();
		
		//��ѯ�༶����Ϣ
         List<Clazz> claList = admins.claFindAll();
         
         
		//��4��������Ӧ
		req.setAttribute("list", list);
		req.setAttribute("claList", claList);
		req.getRequestDispatcher("/files/studentList.jsp").forward(req, resp);
		
	}
	
	
	
/***********管理员添加其他学生的操作**********/
	protected void stuRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
		  //【2】接受前台的数据
			
			boolean legalflag = true;
			
			int sno = 0;
			  if(req.getParameter("sno") == "") legalflag = false;
			   else sno=Integer.parseInt(req.getParameter("sno"));
			  
		   String   pwd=req.getParameter("pwd");
		   if(pwd == "") legalflag = false;
		   
		   String  sname=req.getParameter("sname");
		   if(sname == "") legalflag = false;
		   
		   String phone=req.getParameter("phone");
		   if(phone == "") legalflag = false;
		   
		   String gender = req.getParameter("gender");
		   if(gender == "") legalflag = false;
		   
		   Date birth = null;
		   if(req.getParameter("birth") == "") legalflag = false;
		   else birth=Date.valueOf(req.getParameter("birth"));
		   
		   int clazzno = 0;
		   if(req.getParameter("clazzno") == "") legalflag = false;
		   else clazzno=Integer.parseInt(req.getParameter("clazzno"));
		   
		   String  remark=req.getParameter("remark");
				   
		   Student   stu=new  Student(sno, pwd, sname, phone, gender, birth, clazzno, remark);
		  //【3】处理数据
		   AdminService  admins=new  AdminServiceImpl();
		   
		   int update = 0; 
		   if(legalflag) update = admins.stuRegister(stu);
		 //【4】做出响应
		  
		  if(update>0){
	    	  req.setAttribute("msg", "   <注册成功>");
	    	  req.getRequestDispatcher("AdminServlet?method=claFindAll").forward(req, resp);
	    	}else if(!legalflag){
	    	  req.setAttribute("msg", "   <信息不完整>");
	    	  req.getRequestDispatcher("AdminServlet?method=claFindAll").forward(req, resp);
	      }
		  
	}	
	
	/********管理员添加其他管理员操作*********/
	protected void adminRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   //【1】解决中文乱码
		    req.setCharacterEncoding("utf-8");
		
		  //【2】接受前台的数据
		 boolean legalflag = true;
		    
		 String userid = req.getParameter("uid");
		 if(userid == "") legalflag = false;
		 
		 String  username=req.getParameter("uname");
		 if(username == "") legalflag = false;
		      
		 String password=req.getParameter("pwd");
		 if(password == "") legalflag = false;
		 
		 int age = 0;
		 if(req.getParameter("age") == "") legalflag = false;
		 else age=Integer.parseInt(req.getParameter("age"));
		 
		 
		 float  score = 0;
		 
		 
		 Date  enterdate = null;
		 if(req.getParameter("enterdate") == "") legalflag = false;
		 else enterdate=Date.valueOf(req.getParameter("enterdate"));
		 
		 String hobby = req.getParameter("remark");
		      //把数组转换成字符
		 
		 System.out.println("adminregister");
		 System.out.println(userid);
		 System.out.println(username);
		 System.out.println(password);
		 System.out.println(age);
		 System.out.println(enterdate);
		 System.out.println(hobby);
		 System.out.println("adminregister");
		 
		 Admin   admin;
		 int update = 0;
		 if(legalflag) { admin =new Admin(userid, username, password, age, score, enterdate, hobby);
		  //【3】处理数据
		      AdminService  admins=new  AdminServiceImpl();
		      
		      update = admins.adminRegister(admin);}
		
		  //【4】做出响应
		      
		      if(update>0){
		    	  req.setAttribute("msg", "   <注册成功>");
		    	  req.getRequestDispatcher("/files/adminRegister.jsp").forward(req, resp);
		    	}else if(!legalflag){
		    	  req.setAttribute("msg", "   <信息不完整>");
		    	  req.getRequestDispatcher("/files/adminRegister.jsp").forward(req, resp);
		      }else{
		    	  req.setAttribute("msg", "   <注册失败,该账号已存在>");
		    	  req.getRequestDispatcher("/files/adminRegister.jsp").forward(req, resp);
		      }
		
		
		
	}
	
	/***********管理员添加其他教师的操作**********/
	protected void teaRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
			boolean legalflag = true;
			
			int tno = 0;
			  if(req.getParameter("tno") == "") legalflag = false;
			   else tno=Integer.parseInt(req.getParameter("tno"));
		  //【2】接受前台的数据
		   String   pwd=req.getParameter("pwd");
		   if(pwd == "") legalflag = false;
		   
		   String  tname=req.getParameter("tname");
		   if(tname == "") legalflag = false;
		   
		   String phone=req.getParameter("phone");
		   if(phone == "") legalflag = false;
		   
		   Date hiredate = null;
		   if(req.getParameter("hiredate") == "") legalflag = false;
		   else hiredate = Date.valueOf(req.getParameter("hiredate"));
		   
		   String  remark=req.getParameter("remark");
				   
		  Teacher teacher =new Teacher(tno,tname,pwd,phone,hiredate,remark);
		  
		  //【3】处理数据
		   AdminService  admins=new  AdminServiceImpl();
		   
		   
		   
		   int update = 0;
		   if(legalflag) update = admins.teaRegister(teacher);
		 //【4】做出响应
		  
		  if(update>0){
	    	  req.setAttribute("msg", "   <添加成功>");
	    	  req.getRequestDispatcher("/files/teacherRegister.jsp").forward(req, resp);
	    	}else if(!legalflag){
	    	  req.setAttribute("msg", "   <添加失败>");
	    	  req.getRequestDispatcher("/files/teacherRegister.jsp").forward(req, resp);
	      }
	}

	/***********����Ա���ӿγ̵Ĳ���**********/
	protected void couRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
		  //��2������ǰ̨������
			boolean legalflag = true;
			   int cno = 0;
			   if(req.getParameter("cno") == "") legalflag = false;
			   else	 cno = Integer.parseInt(req.getParameter("cno"));
			
		   String  cname=req.getParameter("name");
		   if(cname == "") legalflag = false;
		   
		   int credit = 0;
		   if(req.getParameter("credit") == "") legalflag = false;
		   else	 credit = Integer.parseInt(req.getParameter("credit"));
		   
		   Date  periodstart = null;
		   if(req.getParameter("periodstart") == "") legalflag = false;
		   else periodstart = Date.valueOf(req.getParameter("periodstart"));
		   
		   Date  periodend = null;
		   if(req.getParameter("periodend") == "") legalflag = false;
		   else periodend = Date.valueOf(req.getParameter("periodend"));
		   
		   if(legalflag && periodstart.compareTo(periodend) > 0 ) {
			   legalflag = false;
		   }
		   
		   
		   Course cou = new Course(cno,cname,credit,periodstart,periodend);
				   
		   //��3����������
		   AdminService  admins=new  AdminServiceImpl();
		   
		   int update = 0; 
		   if(legalflag) update = admins.couRegister(cou);
		 //��4��������Ӧ
			  if(update>0){
				  req.setAttribute("msg", "<添加成功>");
				  req.getRequestDispatcher("/files/courseRegister.jsp").forward(req, resp);
			  }else {
				  req.setAttribute("msg", "<信息不完整>");
				  req.getRequestDispatcher("/files/courseRegister.jsp").forward(req, resp);
			  }
	}
	
	

}
