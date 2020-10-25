package com.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Manager {

	@Id
	private int mgrId;
	private String mgrName;
	@OneToOne
	@JoinColumn(unique = true)
	private Department dept;
	
	public Manager() {
	
		super();
	}

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

	public String getMgrName() {
		return mgrName;
	}

	public Manager(int mgrId, String mgrName) {
		super();
		this.mgrId = mgrId;
		this.mgrName = mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return mgrId + " " + mgrName;
	}
	
}
