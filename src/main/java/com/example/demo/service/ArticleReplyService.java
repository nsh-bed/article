package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.demo.dto.ArticleReply;

public interface ArticleReplyService {
	public long addReply(Map<String, Object> args);

	public List<ArticleReply> getReplyList(Map<String, Object> args);

	public ArticleReply getReplyOne(long args);
	
	public String deleteReply(long article, HttpSession session);
	
	public String update(Map<String, Object> args, HttpSession session);
}
