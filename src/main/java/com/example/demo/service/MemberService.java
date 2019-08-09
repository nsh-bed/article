package com.example.demo.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.demo.dto.Member;

public interface MemberService {
	public long join(Map<String, Object> args);

	public Map<String, Object> login(Map<String, Object> args);

	public Member getOne(long loginedMemberId);

	public String doModify(Map<String, Object> param, HttpSession session);
}
