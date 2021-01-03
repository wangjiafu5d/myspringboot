package com.chuan.myspringboot.bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private Integer id;
	private String name;
	private Double score;
	private Date birthday;
    // get()... & set()...
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+name+score+birthday;
	}
	public Student(Integer id, String name, Double score, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
