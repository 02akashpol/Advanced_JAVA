package com.dto;

public class Student {

	private int rno;
	private String stdName;
	private float fee;

	public Student() {
		
		super();
		
	}

	public Student(int rno, String stdName, float fee) {
		super();
		this.rno = rno;
		this.stdName = stdName;
		this.fee = fee;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return rno + " " + stdName + " " + fee;
	}
		
}
