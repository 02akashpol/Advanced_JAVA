package com.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Category_Fetch")
public class Category {

	@Id
	private int cId;
	private String cName;
	@OneToMany
	@JoinColumn(name = "cId")
	//@Fetch(FetchMode.JOIN)
	private Set<Item> item = new HashSet<Item>();
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
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

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return cId + " " + cName;
	}
	
}
