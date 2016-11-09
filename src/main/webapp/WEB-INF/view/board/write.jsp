<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/head/header.jsp"></jsp:include>

<body>
<h1>글쓰기</h1>
<form method="post" action="<c:url value="/doWrite"/>" enctype="multipart/form-data">
	<lebel for="subject">제목</lebel>
	<input type="text" name="subject" id="subject"/><br/>

	<lebel for="content">내용</lebel>
	<textarea name="content" id="content"></textarea><br/>

	<input type="file" name="fileUpload" id="fileUpload"><br/>
	
	
	<input type="hidden" name="userId" value="${sessionScope._USER_.userId}"/>
	
	<input type="submit" value="작성하기">
</form>
</body>
</html>