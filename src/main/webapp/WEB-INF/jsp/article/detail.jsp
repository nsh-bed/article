<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시물 상세페이지" />
<%@include file="../part/head.jspf"%>
<script>
	function addReplyFormSubmited(form) {
		form.body.value = form.body.value.trim();

		if (form.body.value.length == 0) {
			alert('댓글을 작성해 주세요.');

			form.body.focus();
			return false;
		}
		form.submit();
	}
</script>
<h1>${article.id}번</h1>
<table border="1">
	<tr>
		<td>번호</td>
		<td>${article.id}</td>
	</tr>

	<tr>
		<td>날짜</td>
		<td>${article.regDate}</td>
	</tr>

	<tr>
		<td>제목</td>
		<td>${article.title}</td>
	</tr>

	<tr>
		<td>내용</td>
		<td>${article.body}</td>
	</tr>
</table>

<h2>댓글 작성</h2>
<form action="./doAddReply"
	onsubmit="addReplyFormSubmited(this); return false;">
	<div>
		<input type="hidden" name="articleId" value="${article.id}">
	</div>
	<div>
		<input type="hidden" name="boardId" value="1">
	</div>

	<div>
		내용 :
		<textarea name="body" placeholder="댓글 작성"></textarea>
	</div>
	<div>
		작성 : <input type="submit" value="댓글 작성">
	</div>
</form>

<table border="1">
	<thead>
		<tr>
			<td>번호</td>
			<td>날짜</td>
			<td>내용</td>
			<td>비고</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="articleReply" items="${articleReplies}">
			<tr>
				<td>${articleReply.id }</td>
				<td>${articleReply.regDate }</td>
				<td>${articleReply.body }</td>
				<td><a href="./doDeleteReply?id=${articleReply.id}">삭제</a> <a
					href="./ModifyReply?id=${articleReply.id}">수정</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@include file="../part/foot.jspf"%>