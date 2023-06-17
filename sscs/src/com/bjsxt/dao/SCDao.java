package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Course;
import com.bjsxt.entity.SCC;

public interface SCDao {
	
	//ѧ��ѡ�εĲ���
	public   int  insert(int sno,int cno,int tno);
	
	//ѧ����ѯ��ѡ�γ̵���Ϣ
	public   List<Course>  selectMore(int  sno);
	
	//��ʦ��ѯ�γ̵Ĳ���
	public   List<SCC> selectAll(int tno);
	
	//ѧ��ȡ����ѡ�γ�
	public int remove(int sno, int cno);

	//��ʦ�޸ķ���
	public int update(int sno, int cno, int tno, int score);

}
