package com.example.demo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Member;

@Mapper
public interface MemberDao {
	public long join(Map<String, Object> args);

	public long login(Map<String, Object> args);

	public Member getMatchedOne(Map<String, Object> param);

	public Member getOne(long loginedMemberId);

	public void doModify(Map<String, Object> param);
}
