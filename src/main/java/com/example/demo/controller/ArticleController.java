package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.groovy.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;
import com.example.demo.dto.ArticleReply;
import com.example.demo.service.ArticleReplyService;
import com.example.demo.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleReplyService articleReplyService;

	@RequestMapping("/article/add")
	public String showAdd() {
		return "article/add";
	}

	@RequestMapping("/article/doAdd")
	@ResponseBody
	public String doAdd(@RequestParam Map<String, Object> param, HttpSession session) {
		StringBuilder sb = new StringBuilder();


		long loginedMemberId = (long)session.getAttribute("loginedMemberId");
		param.put("memberId", loginedMemberId);
		articleService.add(param);

	

		sb.append("<script>alert('게시물이 추가되었습니다.');location.replace('./detail?id=" + param.get("id") + "')</script>");

		return sb.toString();
	}

	@RequestMapping("/article/list")
	public String showList(Model model, @RequestParam Map<String, Object> param) {
		param.put("extra__repliesCount", true);
		List<Article> list = articleService.getList(param);

		model.addAttribute("list", list);

		return "article/list";
	}

	@RequestMapping("article/detail")
	public String showDetail(@RequestParam(value = "id", defaultValue = "0") int id, Model model) {
		Article article = articleService.getOne(Maps.of("id", id));
		List<ArticleReply> articleReplies = articleReplyService.getReplyList(Maps.of("articleId", id));

		model.addAttribute("article", article);
		model.addAttribute("articleReplies", articleReplies);

		return "article/detail";
	}

	@RequestMapping("article/modify")
	public String showModify(@RequestParam(value = "id", defaultValue = "0") int id, Model model) {
		Article article = articleService.getOne(Maps.of("id", id));

		model.addAttribute("article", article);

		return "article/modify";
	}

	@RequestMapping("/article/doModify")
	@ResponseBody
	public String doModify(@RequestParam Map<String, Object> param, HttpSession session) {
		StringBuilder sb = new StringBuilder();

		articleService.update(param, session);

		sb.append("<script>alert('게시물이 수정되었습니다.');location.replace('./detail?id=" + param.get("id") + "')</script>");

		return sb.toString();
	}

	@RequestMapping("article/doDelete")
	@ResponseBody
	public String doDelete(@RequestParam Map<String, Object> param,
			@RequestParam(value = "id", defaultValue = "0") int article) {
		StringBuilder sb = new StringBuilder();

		articleService.delete(article);

		sb.append("<script>alert('게시물이 삭제되었습니다.');location.replace('./list')</script>");

		return sb.toString();
	}

	@RequestMapping("/article/doAddReply")
	@ResponseBody
	public String doAddReply(@RequestParam Map<String, Object> param, HttpSession session) {
		StringBuilder sb = new StringBuilder();

		long loginedMemberId = (long)session.getAttribute("loginedMemberId");
		param.put("memberId", loginedMemberId);
		articleReplyService.addReply(param);

		sb.append("<script> alert('댓글이 추가되었습니다.'); location.replace('./detail?id=" + param.get("articleId")
				+ "') </script>");

		return sb.toString();
	}

	@RequestMapping("article/doDeleteReply")
	@ResponseBody
	public String doDeleteReply(@RequestParam(value = "id", defaultValue = "0") long article, HttpSession session, HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();

		articleReplyService.deleteReply(article, session);

		sb.append("<script>alert('댓글이 삭제되었습니다.');location.replace('" + request.getHeader("REFERER") + "')</script>");

		return sb.toString();
	}
	
	
	@RequestMapping("article/sort")
	public String sort(Model model, @RequestParam Map<String, Object> param) {
		param.put("extra__repliesCount", true);
		param.put("desc_list", true);
		Map<String, Object> pagedListRs = articleService.getPagedList(param);
		
		model.addAttribute("pagedListRs", pagedListRs);
		
		return "article/list";
	}
	
	@RequestMapping("article/oldSort")
	public String oldSort(Model model, @RequestParam Map<String, Object> param) {
		param.put("extra__repliesCount", true);
		param.put("desc_list", false);
		Map<String, Object> pagedListRs = articleService.getPagedList(param);
		
		model.addAttribute("pagedListRs", pagedListRs);
		
		return "article/list";
	}
	
	@RequestMapping("/article/doModifyReply")
	@ResponseBody
	public String doModifyReply(@RequestParam Map<String, Object> param, HttpSession session) {
		StringBuilder sb = new StringBuilder();

		articleReplyService.update(param, session);

		sb.append("<script>alert('게시물이 수정되었습니다.');location.replace('./detail?id=" + param.get("id") + "')</script>");

		return sb.toString();
	}

}
