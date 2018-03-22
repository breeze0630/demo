package com.example.demo.core.controller;

import com.example.demo.core.entity.Result;
import org.apache.tomcat.jni.Multicast;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/22.
 */
@Controller
@RequestMapping("/file")
public class UploadController
{
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public Result upload(HttpServletRequest request,MultipartFile file)
	{
		Result result = new Result();
		try
		{
			String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
			File dir = new File(uploadDir);
			if(!dir.exists())
			{
				dir.mkdir();
			}
			String fileName = file.getOriginalFilename();
			File serverFile = new File(uploadDir+fileName);

			file.transferTo(serverFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			result.setCode("9999");
			result.setData(null);
			result.setMsg("上传失败");
			return result;
		}
		result.setCode("1");
		result.setData(null);
		result.setMsg("上传成功");
		return result;
	}
}
