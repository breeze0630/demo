package com.example.demo.core.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Administrator on 2018/3/19.
 */
@Entity
@Table(name = "user")
public class User
{
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name="name")
	private String name;

	@Column
	private String pass;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	@Override public String toString()
	{
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", pass='" + pass + '\'' + '}';
	}
}
