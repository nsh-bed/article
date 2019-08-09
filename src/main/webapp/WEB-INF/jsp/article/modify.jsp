<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시글 수정" />
<%@include file="../part/head.jspf"%>
<h1>${article.id}번${pageTitle}</h1>
<script>
	function modifyFormSumited(form) {
		form.title.value = form.title.value.trim();
		if (form.title.value.length == 0) {
			alert('수정할 제목을 입력해주세요.');
			form.title.focus();

			return false;
		}

		form.body.value = form.body.value.trim();
		if (form.body.value.length == 0) {
			alert('수정할 내용을 입력해주세요.');
			form.body.focus();

			return false;
		}

		form.submit();
	}
</script>
<form action="./doModify" onsubmit="addFormSumited(this); return false;">
	<input type="hidden" name="memberId" value="${article.memberId}">
	<input type="hidden" name="id" value="${article.id}">
	<div>
		제목 : <input type="text" name="title" value="${article.title}"
			placeholder="제목">
	</div>
	<div>
		내용 :
		<textarea name="body" placeholder="제목">${article.body }</textarea>
	</div>
	<div>
		수정 : <input type="submit" value="수정완료">
	</div>
</form>
<%@include file="../part/foot.jspf"%>