<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="메인페이지" />
<%@include file="../part/head.jspf"%>

<h1 class="con">
	<c:if test="${loginedMember != null}">
		<c:out value="${loginedMember.name}님 반갑습니다." />
	</c:if>
</h1>

<%@include file="../part/foot.jspf"%>