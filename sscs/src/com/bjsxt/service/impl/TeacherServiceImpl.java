package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.SCDao;
import com.bjsxt.dao.TCDao;
import com.bjsxt.dao.TeacherDao;
import com.bjsxt.dao.impl.SCDaoImpl;
import com.bjsxt.dao.impl.TCDaoImpl;
import com.bjsxt.dao.impl.TeacherDaoImpl;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.SCC;
import com.bjsxt.entity.Teacher;
import com.bjsxt.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
   
	TeacherDao  teadao=new  TeacherDaoImpl();
	
	SCDao   scdao=new SCDaoImpl();
	
	TCDao  tcdao = new TCDaoImpl();
	@Override
	public Teacher login(String tname, String pwd) {
		// TODO Auto-generated method stub
		return teadao.selectOne(tname, pwd);
	}

	@Override
	public List<SCC> sccFindAll(int tno) {
		// TODO Auto-generated method stub
		return scdao.selectAll(tno);
	}
	
	@Override
	public int sccUpdate(int sno, int cno, int tno, int score) {
		return scdao.update(sno,cno,tno,score);
	}
	
	@Override
	public List<Course> tcFindOne(int tno){
		return tcdao.selectAll3(tno);
	}

}
