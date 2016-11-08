<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>
<h1>상세보기</h1>
제목 : ${board.subject }
<br/> 
내용 : ${board.content }
<br/> 
글쓴이 : ${board.user.userNickName }
<br/> 
날짜 : ${board.createdDate }
<br/> 
조회수 : ${board.hit }
<br/> 
추천수 : ${board.recommand }
<br/> 

첨부파일(display) : <a href="<c:url value="/doDownload/${board.boardId }" />">${board.displayFileName }</a>
<br/> 

<input type="button" onclick="location.href='<c:url value="/delete/${board.boardId }"/>'" value="삭제"/>
<input type="button" onclick="location.href='<c:url value="/edite/${board.boardId }"/>'" value="수정"/>
<input type="button" onclick="location.href='<c:url value="/board"/>'" value="리스트 보기"/>
</body>
</html>