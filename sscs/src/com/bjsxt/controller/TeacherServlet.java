package com.bjsxt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Course;
import com.bjsxt.entity.SCC;
import com.bjsxt.entity.Teacher;
import com.bjsxt.service.TeacherService;
import com.bjsxt.service.impl.TeacherServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/servlet/TeacherServlet")
public class TeacherServlet  extends  BaseServlet{
	
	
	/******��ʦ��ѯ�γ̵Ĳ���************/
	protected void sccFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   resp.setContentType("text/html;charset=utf-8");
		
		  Teacher   tea=  (Teacher) req.getSession().getAttribute("admin");
		
		  int tno = tea.getTno();
		  
		  TeacherService  teas=new TeacherServiceImpl();
		  
		  List<SCC> list = teas.sccFindAll(tno);
		  
		  
		  Gson  gson=new  Gson();
		  
		  String json = gson.toJson(list);
		  
		  resp.getWriter().print(json);
		  
	}
	
	/******��ʦ����******/
	protected void sccUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  resp.setContentType("text/html;charset=utf-8");
		
		  Teacher   tea=  (Teacher) req.getSession().getAttribute("admin");
		
		  int tno = tea.getTno();
		  
		  TeacherService  teas=new TeacherServiceImpl();
		  
		  int cno = Integer.parseInt(req.getParameter("cno"));

		  int sno = Integer.parseInt(req.getParameter("sno"));
		  
		  int score = Integer.parseInt(req.getParameter("score"));
		  
		  int  update=0;
		    
		  update=  teas.sccUpdate(sno, cno, tno, score);
		  
		  resp.getWriter().print(update);
	}
	
	/******�鿴��ʦ�Ŀγ�******/
	protected void tcFindOne(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   resp.setContentType("text/html;charset=utf-8");
		
		  Teacher   tea=  (Teacher) req.getSession().getAttribute("admin");
		
		  int tno = tea.getTno();
		  
		  TeacherService  teas=new TeacherServiceImpl();
		  
		  List<Course> list = teas.tcFindOne(tno);
		  
		  System.out.print("tcFindOne");
		  System.out.print(list.get(0).getName());
		  
		  Gson  gson =new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		  
		  String json = gson.toJson(list);
		  
		  resp.getWriter().print(json);
		  
	}
}
