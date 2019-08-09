package com.example.demo.dto;

import groovy.transform.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Member {
	private long id;
	private String regDate;
	private String loginId;
	private String loginPw;
	private String name;
	private long delStatus;
}