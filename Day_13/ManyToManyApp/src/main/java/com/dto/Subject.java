package com.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {

	@Id
	private int sId;
	private String sName;
	@ManyToMany(mappedBy = "subject")
	private Set<Course> course = new HashSet<Course>();
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int sId, String sName) {
		super();
		this.sId = sId;
		this.sName = sName;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return sId + " " + sName;
	}
	
}
