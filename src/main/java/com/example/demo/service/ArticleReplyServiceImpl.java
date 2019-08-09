package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleReplyDao;
import com.example.demo.dto.ArticleReply;


@Service
public class ArticleReplyServiceImpl implements ArticleReplyService {
	@Autowired
	private ArticleReplyDao articleReplyDao;
	
	
	public long addReply(Map<String, Object> args) {
		return articleReplyDao.addReply(args);
	}

	public ArticleReply getReplyOne(long args) {
		return articleReplyDao.getReplyOne(args);
	} 

	
	public List<ArticleReply> getReplyList(Map<String, Object> args) {
		return articleReplyDao.getReplyList(args);
	}
	
	public String deleteReply(long article, HttpSession session) {
		ArticleReply articleReply = (ArticleReply) articleReplyDao.getReplyOne(article);
		long loginedMemberId = (long) session.getAttribute("loginedMemberId");
		if( loginedMemberId == articleReply.getMemberId() ) {
			articleReplyDao.deleteReply(article);
			return "<script>alert('삭제되었습니다.'); location.replace('detail?id="+articleReply.getArticleId()+"');</script>";
		}
		return "<script>alert('삭제 권한이 없습니다.'); history.back();</script>";
	}
	
	public String update(Map<String, Object> param, HttpSession session) {
		long loginedMemberId = (long) session.getAttribute("loginedMemberId");
		if( loginedMemberId == Long.parseLong((String)param.get("memberId")) ) {
			articleReplyDao.modifyReply(param);
			return "<script>alert('수정되었습니다.'); location.replace('detail?id="+param.get("id")+"');</script>";
		}
		return "<script>alert('수정 권한이 없습니다.'); history.back();</script>";
	}
}
