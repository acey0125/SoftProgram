package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Student;

public interface StudentDao {
	
	//���
	public   int   insert(Student  stu);
	
	//��ѯ���еĲ���
	public   List<Student> selectAll();
	
	//ɾ������
	public   int   delete(int  sno);
	
	//��ѯ��������
	public   Student  selectOne(int sno);

	//�޸ĵĲ���
	public  int  update(Student  stu);
	
	//��������ѯѧ������Ϣ
	public   List<Student>  selectLike(int   clazzno,String sname);
	
	
	public   Student  selectOne2(String  sname,String pwd);
	
	
}
