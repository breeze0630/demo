package com.example.demo.core.controller;

import com.example.demo.core.entity.Result;
import com.example.demo.core.entity.User;
import com.example.demo.core.jpa.UserJPA;
import com.example.demo.core.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/19.
 */
@Controller
@RequestMapping("/")
public class InfoController
{
	@Autowired
	private UserJPA userJPA;

	Logger logger = LoggerFactory.getLogger(InfoController.class);

	@RequestMapping("/index")
	public String index()
	{


		return  "index";
	}

	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}

	@RequestMapping(value = "/loginValida",method = RequestMethod.GET)
	@ResponseBody
	public Result login(final User user,HttpServletRequest request)
	{
		Result result = new Result();

		logger.info("InfoController.login user",user);

		User userRet = userJPA.findOne(new Specification<User>()
		{
			@Override public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder)
			{
				criteriaQuery.where(criteriaBuilder.equal(root.get("name"),user.getName()));
				return null;
			}
		});

		if(userRet==null)
		{
			result.setCode("fAILED");
			result.setMsg("用户不存在");
			return result;
		}

		logger.info("InfoController.loginValida userRet",userRet);

		if(user.getPass().equals(userRet.getPass()))
		{
			result.setCode("SUCCESS");
			result.setMsg("成功");
			request.getSession().setAttribute("_session_user",user);
		}else {
			result.setCode("FAILED");
			result.setMsg("用户名或者密码不正确");
		}

		request.setAttribute(LoggerUtils.LOGGER_RETURN,result);
		return  result;
	}

	@RequestMapping("/queryUserList")
	@ResponseBody
	public Map<String,Object> queryUserList()
	{
		HashMap<String,Object> resultMap = new HashMap<>();

		List<User> list= userJPA.findAll();
		resultMap.put("retData",list);
		resultMap.put("retCode","0001");
		resultMap.put("retMsg","SUCCESS");
		return resultMap;
	}

	@RequestMapping("/saveUser")
	@ResponseBody
	public User saveUser(User user)
	{
		return userJPA.save(user);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public List<User> delete(List<User> user)
	{
		userJPA.delete(user);
		return userJPA.findAll();
	}


}
