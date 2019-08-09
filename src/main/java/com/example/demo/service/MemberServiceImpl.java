package com.example.demo.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.groovy.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public long join(Map<String, Object> args) {
		return memberDao.join(args);
	}
	
	
	
	@Override
	public Map<String, Object> login(Map<String, Object> param) {
		Member loginedMember = (Member) memberDao.getMatchedOne(param);

		String msg = null;
		String resultCode = null;

		long loginedMemberId = 0;

		if (loginedMember == null) {
			resultCode = "F-1";
			msg = "일치하는 회원이 없습니다.";

			return Maps.of("resultCode", resultCode, "msg", msg);
		}

		loginedMemberId = loginedMember.getId();

		resultCode = "S-1";
		msg = "로그인 되었습니다.";

		return Maps.of("resultCode", resultCode, "msg", msg, "loginedMemberId", loginedMemberId);
	}

	@Override
	public Member getOne(long loginedMemberId) {
		return memberDao.getOne(loginedMemberId);
	}
	
	public String doModify(Map<String, Object> param, HttpSession session) {
		long loginedMemberId = (long) session.getAttribute("loginedMemberId");
		param.put("id", loginedMemberId);
		Member member = memberDao.getOne(loginedMemberId);
		
		if ( loginedMemberId == member.getId() && param.get("loginPw").equals(member.getLoginPw())) {
			memberDao.doModify(param);
			return "<script>alert('수정되었습니다.'); location.replace('./myPage');</script>";
		}
		
		return "<script>alert('수정이 실패했습니다.'); location.replace('./myPage');</script>";
	}
}
