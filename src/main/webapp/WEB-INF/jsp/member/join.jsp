<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="회원가입" />
<%@include file="../part/head.jspf"%>
<script>
	function subJoinForm(form) {
		form.loginId.value = form.loginId.value.trim();
		if (form.loginId.value.length == 0) {
			alert('아이디를 입력해주세요.');
			form.loginId.focus();
			return false;
		}
		form.loginPw.value = form.loginPw.value.trim();
		if (form.loginPw.value.length == 0) {
			alert('비밀번호를 입력해주세요.');
			form.loginPw.focus();
			return false;
		}
		form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
		if (form.loginPwConfirm.value.length == 0) {
			alert('비밀번호 확인을 입력해주세요.');
			form.loginPwConfirm.focus();
			return false;
		}

		if( form.loginPw.value != form.loginPwConfirm.value ) {
			alert('비밀번호가 일치하지않습니다.');

			form.loginPwConfirm.value = '';
			form.loginPwConfirm.focus();
			
			return false;
		}

		form.name.value = form.name.value.trim();
		if (form.name.value.length == 0) {
			alert('이름을 입력해주세요.');
			form.name.focus();

			return false;
		}
		form.submit();
	}
</script>
<div class="login-box con table-common">
	<form action="./doJoin" method="POST"
		onsubmit="subJoinForm(this); return false;">
		<table>
			<colgroup>
				<col width="150">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="loginId" autocomplete="off"
						autofocus="autofocus" placeholder="아이디를 입력해주세요."></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="loginPw"
						placeholder="비밀번호를 입력해주세요."></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="loginPwConfirm"
						placeholder="비밀번호 확인을 입력해주세요."></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" autocomplete="off"
						placeholder="이름을 입력해주세요."></td>
				</tr>
				<tr>
					<th>가입</th>
					<td><input class="btn-a" type="submit" value="가입"> <input
						class="btn-a" type="reset" value="취소"
						onclick="location.href = '/';"></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<%@include file="../part/foot.jspf"%>