<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시물 리스트" />
<%@include file="../part/head.jspf"%>
<div class="con">
	<form action="./list" method="GET">
		<input type="hidden" name="page" value="1"> <input
			type="hidden" name="sort" value="${param.sort}"> <select
			name="searchType">
			<option value="title">제목</option>
			<option value="body">내용</option>
		</select>

		<c:if test="${param.searchType != null && param.searchType != ''}">
			<script>
				$('select[name="searchType"]').val('${param.searchType}');
			</script>
		</c:if>

		<input type="text" name="searchKeyword" placeholder="검색어"
			value="${param.searchKeyword}"> <input type="submit"
			value="검색" /> <br>
	</form>
</div>

<div class="con">
	<select class="sort-select" onchange="Article__sortChanged(this)">
		<option value="latest">최신순</option>
		<option value="old">오래된 순</option>
	</select>
	<c:if test="${param.sort != null && param.sort != ''}">
		<script>
			$('.sort-select').val("${param.sort}");
		</script>
	</c:if>
</div>

<div class="list-1 table-common con">
	<table border="1" >
			<colgroup>
				<col width="100">
				<col width="200">
				<col>
				<col width="100">
			</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>날짜</th>
				<th>제목</th>
				<th>댓글수</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="article" items="${list}">
				<tr>
					<td>${article.id}</td>
					<td>${article.regDate}</td>
					<td><a href="./detail?id=${article.id }">${article.title}</a></td>
					<td>${article.extra.repliesCount}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>

<div class="con page-nav text-align-center line-height-0-ch-only">
	<ul class="row inline-block">
		<c:forEach var="currentPage" begin="1" end="${pagedListRs.lastPage}">
			<!-- URL 초기값 -->
			<c:url var="url" value="">
				<c:forEach items="${param}" var="entry">
					<c:if test="${entry.key != 'page'}">
						<c:param name="${entry.key}" value="${entry.value}" />
					</c:if>
				</c:forEach>
				<c:param name="page" value="${currentPage}" />
			</c:url>
			<c:set var="aElclass"
				value="${currentPage == pagedListRs.page ? 'red bold' : ''}" />
			<li class="cell"><a href="${url}" class="block ${aElclass}">${currentPage}</a></li>
		</c:forEach>
	</ul>
</div>


<%@include file="../part/foot.jspf"%>