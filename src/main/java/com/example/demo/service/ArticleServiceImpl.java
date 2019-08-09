package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dto.Article;
import com.example.demo.util.CUtil;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	private int _getCount(Map<String, Object> args) {
		return articleDao.getCount(args);
	}
	
	private static final int LIST_ITEMS_COUNT_IN_A_PAGE = 5;
	
	public long add(Map<String, Object> args) {
		return articleDao.add(args);
	}
	
	public List<Article> getList(Map<String, Object> args) {
		
		int page = 1;
		if (args.containsKey("page")) {
			String pageStr = (String) args.get("page");
			page = Integer.parseInt(pageStr);
		}
		
		if (args.containsKey("extra__repliesCount") && (boolean) args.containsKey("extra__repliesCount") == true) {
			args.put("leftJoin__articleReply", true);
			args.put("groupBy__id", true);
		}
		
		args.put("limitOffset", LIST_ITEMS_COUNT_IN_A_PAGE * (page - 1));
		args.put("limit", LIST_ITEMS_COUNT_IN_A_PAGE);
		
		return articleDao.getList(args);
	}
	
	public Article getOne(Map<String, Object> args) {
		return articleDao.getOne(args);
	}
	
	public String update(Map<String, Object> args, HttpSession session) {
		long loginedMemberId = (long) session.getAttribute("loginedMemberId");
		if( loginedMemberId == Long.parseLong((String)args.get("memberId")) ) {
			articleDao.update(args);
			return "<script>alert('수정되었습니다.'); location.replace('detail?id="+args.get("id")+"');</script>";
		}
		return "<script>alert('수정 권한이 없습니다.'); history.back();</script>";
	}
	
	public long delete(int args) {
		return articleDao.delete(args);
	}
	
	@Override
	public Map<String, Object> getPagedList(Map<String, Object> param) {
		Map<String, Object> rs = new HashMap<>();

		int totalItemsCount = _getCount(param);
		int lastPage = (int) Math.ceil(totalItemsCount / (double) ArticleServiceImpl.LIST_ITEMS_COUNT_IN_A_PAGE);

		rs.put("page", CUtil.getAsInt(param.get("page")));
		rs.put("lastPage", lastPage);

		List<Article> list = getList(param);

		rs.put("list", list);
		
		log.info("rs : " + rs);

		return rs;
	}
	@Override
	public void oldSort(Map<String, Object> args) {
		articleDao.oldSort(args);
	}
	
	@Override
	public List<Article> sort() {
		return articleDao.sort();
	}

	
}