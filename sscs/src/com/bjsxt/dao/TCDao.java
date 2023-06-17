package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Course;

public interface TCDao {
	
	//��ѯ������ʦ�Ϳγ̵���Ϣ
	public  List<Course>  selectAll();
	
	//���ѡ�εĲ���
	public   int   inster(int cno,int  tno);
	
	//ɾ��ָ����ʦ�Ŀγ�
	public  int  delete(int cno,int tno);
	
	public  List<Course>  selectAll2(int  sno);

	public List<Course> selectAll3(int tno);
}
