package com.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	private int cId;
	private String cName;
	@ManyToMany
	@JoinTable(name="course_subject", joinColumns = {@JoinColumn(name="courseNo")}, inverseJoinColumns = {@JoinColumn(name="subjectNo")})
	private Set<Subject> subject = new HashSet<Subject>();
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Set<Subject> getSubject() {
		return subject;
	}

	public void setSubject(Set<Subject> subject) {
		this.subject = subject;
	}

	public Course(int cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}

	@Override
	public String toString() {
		return cId + " " + cName;
	}
	
	
}
