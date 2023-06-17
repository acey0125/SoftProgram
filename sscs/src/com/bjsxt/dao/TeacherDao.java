package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Teacher;

public interface TeacherDao {
	
	//���������ʦ����Ϣ
	public   List<Teacher>  selectAll();
	
	//��ʦ��¼���ܲ���
    public Teacher   selectOne(String tno,String pwd);
    
    public int delete(int tno);
    
    public int insert(Teacher tea);

	public List<Teacher> selectLike(int teano, String tname);

	public Teacher selectOne(int tno);

	public int update(Teacher teacher);


}
