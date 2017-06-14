package xt.lb.dao;

import java.util.ArrayList;

import xt.lb.entity.News;



public interface NewsMapper {
	ArrayList<News> selectByUserName(News news);
	ArrayList<News> selectByFromName(News news);
	ArrayList<News> selectByToName(News news);
	ArrayList<News> selectByType(News news);
	
	int selectByMessageId(News news);
	 
	
	ArrayList<NewsMapper> selectAll();
	
	int insert(News news);
	
	int  delete(News news);
	
}
