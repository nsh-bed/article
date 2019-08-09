package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("member/join")
	public String showJoin() {
		return "member/join";
	}
	
	@RequestMapping("member/login")
	public String showLogin() {
		return "member/login";
	}
	
	@RequestMapping("member/doJoin")
	public long doJoin(@RequestParam Map<String, Object> param) {
		return memberService.join(param);
	}
	
	@RequestMapping("member/doLogin")
	public String doLogin(@RequestParam Map<String, Object> param, HttpSession session, Model model) {
		Map<String, Object> rs = memberService.login(param);

		String resultCode = (String) rs.get("resultCode");
		String msg = (String) rs.get("msg");
		model.addAttribute("alertMsg", msg);

		String redirectUrl = (String) param.get("redirectUrl");

		if (redirectUrl == null || redirectUrl.length() == 0) {
			redirectUrl = "/member/myPage";
		}

		if (resultCode.startsWith("S-")) {
			model.addAttribute("locationReplaceUrl", redirectUrl);
			session.setAttribute("loginedMemberId", rs.get("loginedMemberId"));
		} else {
			model.addAttribute("historyBack", true);
		}

		return "common/redirect";
	}
	
	@RequestMapping("member/doLogout")
	public String doLogout(HttpSession session, Model model) {
		session.removeAttribute("loginedMemberId");
		model.addAttribute("locationReplaceUrl", "/member/login");
		return "common/redirect";
	}
	
	@RequestMapping("member/myPage")
	public String myPage(Model model, HttpSession session) {
		long loginedMemberId = (long) session.getAttribute("loginedMemberId");
		Member member = memberService.getOne(loginedMemberId);
		model.addAttribute("member", member);
		return "member/myPage";
	}

	@RequestMapping("member/modify")
	public String modify(HttpSession session) {
		return "member/modify";
	}
	
	@RequestMapping("member/doModify")
	@ResponseBody
	public String doModify(@RequestParam Map<String, Object> param, HttpSession session) {
		return memberService.doModify(param, session);
	}
}
