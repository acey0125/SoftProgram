package com.bjsxt.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends  HttpServlet {
	
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   //�����������Ĳ���
		   //req.setCharacterEncoding("utf-8");
		   //��Ҫִ�еķ���������
		   String method = req.getParameter("method");
		   
		   //���ݹ����Ķ���
		   Class  clazz= this.getClass();
		  
		   try {
			   //ʹ�÷���ķ�ʽ���ö���
			   Method method2 = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
		        
			   method2.setAccessible(true);
			   
			   method2.invoke(this, req,resp);
		   
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
	}
	

}
