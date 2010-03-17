package org.usc.beans;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String name;
	private String sex;
	private String positional;

	// Constructors

	/** default constructor */
	public Teacher()
	{
	}

	/** minimal constructor */
	public Teacher(String name, String sex)
	{
		this.name = name;
		this.sex = sex;
	}

	/** full constructor */
	public Teacher(String name, String sex, String positional)
	{
		this.name = name;
		this.sex = sex;
		this.positional = positional;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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

	public String getPositional()
	{
		return this.positional;
	}

	public void setPositional(String positional)
	{
		this.positional = positional;
	}

}