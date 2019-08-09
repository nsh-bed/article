package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.demo.dto.Article;


public interface ArticleService {
	public long add(Map<String, Object> args);
	
	public List<Article> getList(Map<String, Object> args);
	
	public Article getOne(Map<String, Object> args);

	public String update(Map<String, Object> args, HttpSession session);

	public long delete(int args);
	
	public Map<String, Object> getPagedList(Map<String, Object> param);

	public void oldSort(Map<String, Object> args);
	
	public List<Article> sort();
}
