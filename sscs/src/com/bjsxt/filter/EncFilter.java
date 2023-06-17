package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncFilter  implements Filter{
    
	String  enc;
	
	//���ٵķ���----ִ��һ��
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
    //������----ÿһ�����󶼻�ִ��
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		   //��1��ִ��Ԥ�������
		   req.setCharacterEncoding(enc);
		
		   //��2��ִ����һ������������Ŀ����Դ
		     chain.doFilter(req, resp);
		   
		   //��3���뿪������֮ǰ�Ĵ������
		   
		
		
		
	}

	  //��ʼ��---ִ��һ��
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		//��ȡȫ�ֵĲ���
		enc=arg0.getServletContext().getInitParameter("enc");
		
		
		
	}

}
