<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
</head>
<body>
<h1>게시판 목록</h1>
<style>
td,th{
	font-size:1em;
	border:1px solid black;
}

</style>
<table>
<tr>
<th>게시판 번호</th>
<th>제목</th>
<th>글쓴이</th>
<th>날짜</th>
<th>조회수</th>
<th>추천수</th>
<th>파일여부</th>
</tr>
<c:choose>
<c:when test="${not empty boardList.boardList }">
<c:forEach var="board" items="${boardList.boardList }">
<tr>
<td>${board.boardId }</td>
<td><a href="./detail/${board.boardId}">${board.subject }</a></td>
<td>${board.user.userNickName }</td>
<td>${board.createdDate }</td>
<td>${board.hit }</td>
<td>${board.recommand }</td>
<c:choose>
<c:when test="${not empty board.displayFileName }">
<th>v</th>
</c:when>
<c:otherwise>
<th> </th>
</c:otherwise>
</c:choose>
</tr>
</c:forEach>
</c:when>
<c:otherwise>
	<th colspan="6">데이터가 없습니다.</th>
</c:otherwise>
</c:choose>
</table>
<c:if test="${not empty sessionScope._USER_}">
<input type="button" value="글쓰기" onclick="location.href='./write'"/>
</c:if>
</body>
</html>