package org.usc.beans;

import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable
{

	// Fields

	private Integer no;
	private String name;
	private String sex;
	private Integer age;
	private Double score;
	private Date eduTime;

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(String name, String sex)
	{
		this.name = name;
		this.sex = sex;
	}

	/** full constructor */
	public Student(String name, String sex, Integer age, Double score, Date eduTime)
	{
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.score = score;
		this.eduTime = eduTime;
	}

	// Property accessors

	public Integer getNo()
	{
		return this.no;
	}

	public void setNo(Integer no)
	{
		this.no = no;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Integer getAge()
	{
		return this.age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public Double getScore()
	{
		return this.score;
	}

	public void setScore(Double score)
	{
		this.score = score;
	}

	public Date getEduTime()
	{
		return this.eduTime;
	}

	public void setEduTime(Date eduTime)
	{
		this.eduTime = eduTime;
	}

}