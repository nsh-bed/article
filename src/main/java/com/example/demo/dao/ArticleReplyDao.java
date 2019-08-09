package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.ArticleReply;

@Mapper
public interface ArticleReplyDao {
	public long addReply(Map<String, Object> args);

	public List<ArticleReply> getReplyList(Map<String, Object> args);
	
	public ArticleReply getReplyOne(long args);

	public void deleteReply(long article);
	
	public void modifyReply(Map<String, Object> args);
}
