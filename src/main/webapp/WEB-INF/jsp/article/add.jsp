<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시글 작성" />
<%@include file="../part/head.jspf"%>
<script>
	function addFormSumited(form) {
		form.title.value = form.title.value.trim();
		if (form.title.value.length == 0) {
			alert('제목을 입력해주세요.');
			form.title.focus();

			return false;
		}

		form.body.value = form.body.value.trim();
		if (form.body.value.length == 0) {
			alert('내용을 입력해주세요.');
			form.body.focus();

			return false;
		}

		form.submit();
	}
</script>


<div class="login-box con table-common">
	<form action="./doAdd" method="POST"
		onsubmit="addFormSumited(this); return false;">
		<input type="hidden" name="boardId" value="1">
		<table>
			<colgroup>
				<col width="150">
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" autocomplete="off"
						autofocus="autofocus" placeholder="제목을 입력해주세요."></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input type="text" name="body" autocomplete="off"
						placeholder="내용을 입력해주세요." ></td>
				</tr>
				<tr>
					<th>작성</th>
					<td><input class="btn-a" type="submit" value="작성완료"> <input
						class="btn-a" type="reset" value="취소"
						onclick="location.href = '/';"></td>
				</tr>

			</tbody>
		</table>
	</form>
</div>

<%@include file="../part/foot.jspf"%>