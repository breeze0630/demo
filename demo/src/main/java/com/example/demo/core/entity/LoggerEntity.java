package com.example.demo.core.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/3/21.
 */
@Entity
@Table(name = "logger_info")
public class LoggerEntity implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "client_ip")
	private String clientIp;

	@Column(name = "uri")
	private String uri;

	@Column(name = "type")
	private String type;

	@Column(name = "method")
	private String method;

	@Column(name = "param_data")
	private String paramData;

	@Column(name = "session_id")
	private String sessionId;

	@Column(name = "time")
	private Timestamp time;

	@Column(name = "return_time")
	private String returnTime;

	@Column(name="return_data")
	private String returnData;

	@Column(name = "time_consuming")
	private Integer timeConsuming;

	@Column(name = "http_status_code")
	private String httpStatusCode;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getClientIp()
	{
		return clientIp;
	}

	public void setClientIp(String clientIp)
	{
		this.clientIp = clientIp;
	}

	public String getUri()
	{
		return uri;
	}

	public void setUri(String uri)
	{
		this.uri = uri;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getParamData()
	{
		return paramData;
	}

	public void setParamData(String paramData)
	{
		this.paramData = paramData;
	}

	public String getSessionId()
	{
		return sessionId;
	}

	public void setSessionId(String sessionId)
	{
		this.sessionId = sessionId;
	}

	public Timestamp getTime()
	{
		return time;
	}

	public void setTime(Timestamp time)
	{
		this.time = time;
	}

	public String getReturnTime()
	{
		return returnTime;
	}

	public void setReturnTime(String returnTime)
	{
		this.returnTime = returnTime;
	}

	public String getReturnData()
	{
		return returnData;
	}

	public void setReturnData(String returnData)
	{
		this.returnData = returnData;
	}

	public Integer getTimeConsuming()
	{
		return timeConsuming;
	}

	public void setTimeConsuming(Integer timeConsuming)
	{
		this.timeConsuming = timeConsuming;
	}

	public String getHttpStatusCode()
	{
		return httpStatusCode;
	}

	public void setHttpStatusCode(String httpStatusCode)
	{
		this.httpStatusCode = httpStatusCode;
	}

	@Override public String toString()
	{
		return "LoggerEntity{" + "id=" + id + ", clientIp='" + clientIp + '\'' + ", uri='" + uri + '\'' + ", type='"
				+ type + '\'' + ", method='" + method + '\'' + ", paramData='" + paramData + '\'' + ", sessionId='"
				+ sessionId + '\'' + ", time=" + time + ", returnTime='" + returnTime + '\'' + ", returnData='"
				+ returnData + '\'' + ", timeConsuming=" + timeConsuming + ", httpStatusCode='" + httpStatusCode + '\''
				+ '}';
	}
}
