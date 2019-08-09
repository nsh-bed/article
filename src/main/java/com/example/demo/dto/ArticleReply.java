package com.example.demo.dto;

import groovy.transform.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ArticleReply {
	private long id;
	private String regDate;
	private long articleId;
	private long boardId;
	private long memberId;
	private String body;
}
