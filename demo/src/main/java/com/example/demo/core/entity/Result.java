package com.example.demo.core.entity;

/**
 * Created by Administrator on 2018/3/21.
 */
public class Result
{
	private String code;
	private String msg;
	private Object data;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	@Override public String toString()
	{
		return "Result{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + ", data=" + data + '}';
	}
}
