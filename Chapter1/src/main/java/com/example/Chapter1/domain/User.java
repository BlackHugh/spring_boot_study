package com.example.Chapter1.domain;

public class User {
	private long id;
	private String name;
	private Integer age;
	
	public long getId(){
		return this.id;
	}
	public void setId(long value){
		id=value;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String value){
		name=value;
	}
	
	public Integer getAge(){
		return this.age;
	}
	public void setAge(Integer value){
		age=value;
	}
	
	
}
