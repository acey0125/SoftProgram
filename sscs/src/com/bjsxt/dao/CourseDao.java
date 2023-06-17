package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Course;

public interface CourseDao {
	
	//��ѯ���пγ̵���Ϣ
	public  List<Course>  selectAll();

	//����
	public   int   insert(Course  cou);
}
