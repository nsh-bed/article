package com.example.demo.dto;

import java.util.Map;

import org.springframework.web.util.HtmlUtils;

import groovy.transform.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Article {
	private long id;
	private String regDate;
	private String title;
	private String body;
	private long memberId;
	private long boardId;
	private Map<String, String> extra;

	public String getBodyForPrint() {
		String bodyForPrint = HtmlUtils.htmlEscape(body);
		bodyForPrint = bodyForPrint.replace("\n", "<br>");

		return bodyForPrint;
	}
}
