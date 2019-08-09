package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Article;

@Mapper
public interface ArticleDao {
	public long add(Map<String, Object> args);

	public List<Article> getList(Map<String, Object> args);

	public Article getOne(Map<String, Object> args);

	public void update(Map<String, Object> args);

	public long delete(int args);
	
	public int getCount(Map<String, Object> args);

	public void oldSort(Map<String, Object> args);

	public List<Article> sort();
	
}
