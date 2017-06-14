package xt.lb.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xt.lb.dao.NewsMapper;
import xt.lb.dto.WebDto;
import xt.lb.entity.News;
import xt.lb.service.BaseService;
@Service("newsServiceImpl")
public class NewsServiceImpl implements BaseService{
	
	@Autowired
	public NewsMapper newsMapper; 
	
	
	//查询消息
	public WebDto queryNews(WebDto inDto) {
		System.out.println("----news/query/service--------");
		News news = new News();
		news.setMessageId(inDto.getMessageId());
		news.setMessageType(inDto.getMessageType());
		news.setMessage(inDto.getMessage());
		news.setFromName(inDto.getFromName());
		news.setToName(inDto.getToName());
		news.setUserName(inDto.getUserName());
		WebDto outDto = new WebDto();
		outDto.setStatus("0");
		//news.setUserName("tom");
		//inDto.setOpea("41");
		System.out.println("----------opea--"+inDto.getOpea());
		if("41".equals(inDto.getOpea()) && news.getUserName() !=null){
			//查询改用户的所有消息
			ArrayList<News> list = newsMapper.selectByUserName(news);
			outDto.setNews(list);
			return outDto;
		}else if("42".equals(inDto.getOpea())
				&& news.getUserName() !=null
				&& news.getFromName() !=null){
			//查询该用户发出的信息
			ArrayList<News> list = newsMapper.selectByFromName(news);
			outDto.setNews(list);
			return outDto;
		}else if("43".equals(inDto.getOpea())
				&& news.getUserName() !=null 
				&& news.getToName() !=null){
			//查询该用户收到的所有信息
			ArrayList<News> list = newsMapper.selectByToName(news);
			outDto.setNews(list);
			System.out.println("---------"+outDto.getStatus());
			return outDto;
		}else if("44".equals(inDto.getOpea())
				&& news.getUserName() != null 
				&& news.getMessageType() != null){
			//查询该用户所有的系统消息
			ArrayList<News> list = newsMapper.selectByType(news);
			outDto.setNews(list);
			System.out.println("---------"+outDto.getStatus());
			return outDto;
		}else if("45".equals(inDto.getOpea())
				&& news.getUserName() !=null 
				&& news.getMessageType() !=null){
			//查询该用户所有非系统消息
			ArrayList<News> list = newsMapper.selectByType(news);
			outDto.setNews(list);
			System.out.println("---------"+outDto.getStatus());
			return outDto;
		}
		
		//执行到此，说明没有查询成功，需要将处理状态设置为失败 即 != 0
		outDto.setStatus("1");
		System.out.println("---------"+outDto.getStatus());
		return outDto;
	}
//删除消息
	public WebDto removeNews(WebDto inDto) {
		News news = new News();
		news.setMessageId(inDto.getMessageId());
		news.setUserName(inDto.getUserName());
		int result = newsMapper.delete(news);
		WebDto outDto = new WebDto();
		if(result == 0){
			//影响条数为0，说明删除失败
			outDto.setStatus("1");
		}else {
			outDto.setStatus("0");
		}
		outDto.setNews(newsMapper.selectByUserName(news));
		return outDto;
	}
	/**
	 * 回复消息
	 * */
	public WebDto answerNews(WebDto inDto) {
		News news = new News();
		WebDto outDto = new WebDto();
		news.setFromName(inDto.getFromName());
		news.setToName(inDto.getToName());
		news.setUserName(inDto.getUserName());
		news.setMessageType(inDto.getMessageType());
		news.setMessageTime(new Timestamp(System.currentTimeMillis()));
		news.setMessageStatus("1");
		news.setMessage(inDto.getMessage());
		int result = newsMapper.insert(news);
		//像数据库中插入回复信息失败，回复失败，
		if(result == 0){
			outDto.setStatus("1");
			outDto.setLoggerMessage("回复消息失败，请检查您的信息是否正确，或者重新回复");
			//向数据库中插入成功
		}else {
			outDto.setStatus("0");
			outDto.setLoggerMessage("回复成功");
		}
		outDto.setNews(newsMapper.selectByUserName(news));
		return outDto;
	}
	/**
	 * 新建消息
	 * */
	public WebDto addNews(WebDto inDto) {

		News news = new News();
		WebDto outDto = new WebDto();
		news.setFromName(inDto.getFromName());
		news.setToName(inDto.getToName());
		news.setUserName(inDto.getUserName());
		news.setMessageType(inDto.getMessageType());
		news.setMessageTime(new Timestamp(System.currentTimeMillis()));
		news.setMessageStatus("1");
		news.setMessage(inDto.getMessage());
		int result = newsMapper.insert(news);
		//像数据库中插入回复信息失败，添加失败，
		if(result == 0){
			outDto.setStatus("1");
			outDto.setLoggerMessage("发消息失败，请检查您的信息是否正确，或者重新发送");
			//向数据库中插入成功
		}else {
			outDto.setStatus("0");
			outDto.setLoggerMessage("发送成功");
		}
		outDto.setNews(newsMapper.selectByUserName(news));
		return outDto;
	
	}
	

}
