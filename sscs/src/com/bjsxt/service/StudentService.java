package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;

public interface StudentService {
	
	//ѧ����¼�Ĳ���
	public    Student   login(String  sname,String pwd);
	
	//ѧ���鿴ѡ�ε��б�
	public  List<Course>  tcFindAll(int  sno);
	
	//ѧ��ѡ�εĲ���
	public  int    scRegister(int  sno,int cno,int tno);
	
	//ѧ����ѯ�Ѿ�ѡ��Ŀγ���Ϣ
	public  List<Course>  scFindMore(int  sno);
	
	//ѧ��ȡ����ѡ��Ŀγ�
	public int scRemove(int sno, int cno);

}
