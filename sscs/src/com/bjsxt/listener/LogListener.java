package com.bjsxt.listener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class LogListener  implements ServletRequestListener,ServletRequestAttributeListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		
	   HttpServletRequest   req=(HttpServletRequest) arg0.getServletRequest();
		
		//�����û���IP��ַ
		String host = req.getRemoteHost();
		
		//��÷��ʵ�ʱ��
		String time = new  Date().toLocaleString();
		
		//���ʵĲ���  http://127.0.0.1:8888/sscs/servlet/adminservlet?method=delete
		String uri = req.getRequestURI();
		
		//��÷��ʵĲ���
		String method = req.getQueryString();
		
		
		try {
			PrintWriter out = new  PrintWriter(new FileWriter("d:/log.txt", true));
			
			out.println("IP��ַ�ǣ�"+host+"==���ʵ�ʱ����:"+time+"==���ʵĵ�ַ��"+uri+"?"+method);
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		// req.setAttribute("claList", claList);
		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// req.removeAttribute("claList");
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		// �ڶ���ִ�д˲���ʱ��  req.setAttribute("claList", claList);
		
	}

}
