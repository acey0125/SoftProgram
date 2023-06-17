package com.bjsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.TeacherDao;
import com.bjsxt.entity.Teacher;
import com.bjsxt.util.DBUtil;

public class TeacherDaoImpl  implements TeacherDao{

	@Override
	public List<Teacher> selectAll() {
		
		String  sql="select  *  from  t_teacher";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Teacher>  list=new ArrayList<Teacher>();
		try {
			while(rs.next()){
				
				int  tno=rs.getInt("tno");
				
				String  tname=rs.getString("tname");
				
				String pwd=rs.getString("pwd");
				
				String  phone=rs.getString("phone");
				
				Date hiredate=rs.getDate("hiredate");
				
				String  remark=rs.getString("remark");
			
				Teacher  tea=new Teacher(tno, tname, pwd, phone, hiredate, remark);
			
			   list.add(tea);
			
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
	public Teacher selectOne(String tname, String pwd) {
String  sql="select *  from t_teacher where tname=?  and pwd=?";
		
		Object [] prams={tname,pwd};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Teacher  tea=null;
		try {
			while(rs.next()){
				  
				int tno = rs.getInt("tno");
			
				String  tname1=rs.getString("tname");
				
				String pwd1=rs.getString("pwd");
				
				String phone=rs.getString("phone");
				
				Date hiredate=rs.getDate("hiredate");
				
				String remark=rs.getString("remark");
				
			   tea=new Teacher(tno, tname, pwd, phone, hiredate, remark);
			    
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll();
		}
		
		return tea;
	}

	public int delete(int tno)
	{
		
		String  sql="delete  from  t_teacher  where  tno=?";
		
		String  sql1="delete  from  t_tc  where  tno=?";
		
		Object [] prams={tno};
		
		DBUtil.executeUpdate(sql1, prams);
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		
		DBUtil.closeAll();
		
		return update;
	}
	
	
	public int insert(Teacher tea) {
		String  sql="insert  into   t_teacher  values(?,?,?,?,?,?)";
		
		Object [] prams= {tea.getTno(),tea.getTname(),tea.getPwd(),tea.getPhone(),tea.getHiredate(),tea.getRemark()};
		
		int update = DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
	
	public List<Teacher> selectLike(int teano, String tname){
		String  sql="select  *  from  t_teacher ";
		
		if(teano!=0){
			
			sql+=" where tno="+teano;
		}
		if(teano!=0&&tname!=null&&!"".equals(tname)){
			
			sql+=" and tname like  '%"+tname+"%'";
		}
		if(teano == 0&&tname!=null&&!"".equals(tname)) {
			sql+="where tname like  '%"+tname+"%'";
		}

		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Teacher>  list=new  ArrayList<Teacher>();
		try {
			while(rs.next()){
				
				int  tno=rs.getInt("tno");
				 
				String tname1 = rs.getString("tname");
				
				String pwd=rs.getString("pwd");
				 
				String phone=rs.getString("phone");
			    
			    Date  hiredate =rs.getDate("hiredate");
			    		
				String  remark=rs.getString("remark");
				
				Teacher tea = new Teacher(tno,tname1,pwd,phone,hiredate,remark);
				
				list.add(tea);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}
	
	public Teacher selectOne(int tno)
	{
		String  sql="select  *  from t_teacher  where tno=?";
		
		Object  [] prams={tno};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Teacher  tea=null;
		try {
			while(rs.next()){
				int  tno1=rs.getInt("tno");
				 
				String tname=rs.getString("tname"); 
				
				String pwd=rs.getString("pwd");
				 
				 
				 
				 String phone=rs.getString("phone");
			    
			    Date  hiredate = rs.getDate("hiredate");
 		
				String  remark=rs.getString("remark");		 
				
			    tea =new  Teacher(tno1, tname,pwd, phone, hiredate, remark);
			   
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return tea;
	}
	
	public int update(Teacher teacher) {
		String  sql="update  t_teacher  set tname=?,pwd = ?,phone=?,hiredate=?,remark=? where  tno=?";
		  
		  Object [] prams={teacher.getTname(),teacher.getPwd(),teacher.getPhone(),teacher.getHiredate(),teacher.getRemark(),teacher.getTno()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
}
