<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="회원정보수정" />
<%@include file="../part/head.jspf"%>
<script>
function subModifyForm(form) {
	form.loginPw.value = form.loginPw.value.trim();
	if (form.loginPw.value.length == 0) {
		alert('기존 비밀번호를 입력해주세요.');
		form.loginPw.focus();
		return false;
	}
	form.newLoginPw.value = form.newLoginPw.value.trim();
	if (form.newLoginPw.value.length == 0) {
		alert('새 비밀번호를 입력해주세요.');
		form.newLoginPw.focus();
		return false;
	}

	form.newLoginPwConfirm.value = form.newLoginPwConfirm.value.trim();
	if (form.newLoginPwConfirm.value.length == 0) {
		alert('새 비밀번호 확인을 입력해주세요.');
		form.newLoginPwConfirm.focus();
		return false;
	}
	
	if( form.newLoginPw.value != form.newLoginPwConfirm.value ) {
		alert('새 비밀번호가 일치하지않습니다.');

		form.newLoginPwConfirm.value = '';
		form.newLoginPwConfirm.focus();
		
		return false;
	}

	form.name.value = form.name.value.trim();
	if (form.name.value.length == 0) {
		alert('수정할 이름을 입력해주세요.');
		form.name.focus();

		return false;
	}
	form.submit();
}
</script>
<div class="login-box con table-common">
	<form action="./doModify" method="POST"
		onsubmit="subModifyForm(this); return false;">
		<table>
			<colgroup>
				<col width="150">
			</colgroup>
			<tbody>
				<tr>
					<th>기존비밀번호</th>
					<td><input type="password" name="loginPw"
						placeholder="비밀번호를 입력해주세요."></td>
				</tr>
				<tr>
					<th>새 비밀번호</th>
					<td><input type="password" name="newLoginPw"
						placeholder="새 비밀번호를 입력해주세요."></td>
				</tr>
				
				<tr>
					<th>새 비밀번호 확인</th>
					<td><input type="password" name="newLoginPwConfirm"
						placeholder="새 비밀번호 확인을 입력해주세요."></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" autocomplete="off"
						placeholder="수정할 이름을 입력해주세요."></td>
				</tr>
				<tr>
					<th>수정</th>
					<td><input class="btn-a" type="submit" value="수정완료"> <input
						class="btn-a" type="reset" value="취소"
						onclick="location.href = '/';"></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<%@include file="../part/foot.jspf"%>