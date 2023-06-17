package com.bjsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.SCDao;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.SCC;
import com.bjsxt.entity.Teacher;
import com.bjsxt.util.DBUtil;

public class SCDaoImpl  implements SCDao{

	@Override
	public int insert(int sno, int cno, int tno) {
		
		String  sql="insert  into  t_sc(sno,cno,tno) values(?,?,?) ";
		
		Object  []  prams={sno,cno,tno};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public List<Course> selectMore(int sno) {
		
		String  sql="select *  from  t_course  cou    join   t_sc   sc   on   cou.cno=sc.cno join   t_teacher  tea  on  tea.tno=sc.tno   where   sc.sno=?";
		
		Object  []  prams={sno};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Course>  list=new ArrayList<Course>();
		
		try {
			while(rs.next()){
				//��ÿγ̵���Ϣ
				int  cno=rs.getInt("cno");
				
				String name=rs.getString("name");
				
                 int  credit=rs.getInt("credit");
                 
                 Date  periodstart=rs.getDate("periodstart");
                 
                 Date  periodend=rs.getDate("periodend");
				
				 Course  cou=new  Course(cno, name, credit, periodstart, periodend);
				
				 //�����ʦ����Ϣ
				 int  tno=rs.getInt("tno");
				 
				 String  tname=rs.getString("tname");
				 
				 String  pwd=rs.getString("pwd");
				 
				 String  phone=rs.getString("phone");
				 
				 Date  hiredate=rs.getDate("hiredate");
				 
				 String remark=rs.getString("remark");
				 
				 Teacher  tea=new Teacher(tno, tname, pwd, phone, hiredate, remark);
				 
				 //����ʦ�Ķ���ŵ�ѧ����
				 cou.setTea(tea);
				
				  list.add(cou);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}

	@Override
	public List<SCC> selectAll(int tno) {
		
		String  sql="select  *  from   t_student  stu   join  t_clazz  cla on   stu.clazzno=cla.clazzno"+

					" join   t_sc sc  on   stu.sno=sc.sno"+

					" join  t_course   cou  on  sc.cno=cou.cno"+

					" where  sc.tno=?";
		
		Object  [] prams={tno};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<SCC>  list=new ArrayList<SCC>();
		
		try {
			while(rs.next()){
				
				int  sno=rs.getInt("sno");
				
				String  sname=rs.getString("sname");
				
				int  cno=rs.getInt("cno");
				
				int clazzroom=rs.getInt("clazzroom");
					
				String  name=rs.getString("name");
				
				int  credit=rs.getInt("credit");
				
				int score=rs.getInt("score");
				
				SCC  scc=new SCC(sno, sname, clazzroom, cno, name, credit, score);
				
				list.add(scc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		
		return list;
	}
	
	public int remove(int sno, int cno) {
		String  sql="delete  from  t_sc   where  sno=?  and  cno=?";
		
		Object  []  prams={sno,cno};
		
		
	    int  update=	DBUtil.executeUpdate(sql, prams);
		
	   	DBUtil.closeAll();
	
	   	return update;
	   	
	}
	
	public int update(int sno, int cno, int tno, int score) {
		String sql ="update  t_sc  set score=? where  sno=? and cno=? and tno=?";
		Object  []  prams={score,sno,cno,tno};
		int  update=	DBUtil.executeUpdate(sql, prams);
	   	DBUtil.closeAll();
		return update;
	}

}
