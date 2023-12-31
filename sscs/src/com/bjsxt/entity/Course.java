package com.bjsxt.entity;

import java.util.Date;
import java.util.List;

public class Course {
	
    private int cno;
	
	private String name;
	
	private int credit;
	
	private Date periodstart;
	
	private Date periodend;
	
	
	private  Teacher  tea;
	
	 
	//���ֶ�Զ�Ĳ���
	//private  List<Teacher>  list;


	public Teacher getTea() {
		return tea;
	}


	public void setTea(Teacher tea) {
		this.tea = tea;
	}


	public Course() {
		super();
	}


	public Course(int cno, String name, int credit, Date periodstart,
			Date periodend) {
		super();
		this.cno = cno;
		this.name = name;
		this.credit = credit;
		this.periodstart = periodstart;
		this.periodend = periodend;
	}

	
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Date getPeriodstart() {
		return periodstart;
	}

	public void setPeriodstart(Date periodstart) {
		this.periodstart = periodstart;
	}

	public Date getPeriodend() {
		return periodend;
	}

	public void setPeriodend(Date periodend) {
		this.periodend = periodend;
	}

	@Override
	public String toString() {
		return "Course [cno=" + cno + ", name=" + name + ", credit=" + credit
				+ ", periodstart=" + periodstart + ", periodend=" + periodend
				+ "]";
	}
	
	

}
