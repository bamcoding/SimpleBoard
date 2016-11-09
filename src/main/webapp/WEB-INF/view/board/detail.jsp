<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/view/head/header.jsp"></jsp:include>

<script type="text/javascript">
	function deleteBtn(){
		if(confirm("are you sure?")){
		location.href="<c:url value='/delete/${board.boardId }' />";
		}
	}
	
	function downloadBtn(){
	<c:choose>
		<c:when test="${sessionScope._USER_.userId ne board.userId }">
			if(confirm("3포인트가 필요한데, 다운로드 하실겁니까?")){
			location.href="<c:url value='/doDownload/${board.boardId }' />";
			}
		</c:when>
		<c:otherwise>
			location.href="<c:url value='/doDownload/${board.boardId }' />";
		</c:otherwise>
	</c:choose>
	}
</script>

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

첨부파일(display) : <a href="javascript:downloadBtn();">${board.displayFileName }</a>
<br/> 


<c:if test="${sessionScope._USER_.userId eq board.userId }">
<input type="button" onclick="javascript:deleteBtn();" value="삭제"/>
</c:if>
<input type="button" onclick="location.href='<c:url value="/edite/${board.boardId }"/>'" value="수정"/>
<input type="button" onclick="location.href='<c:url value="/board"/>'" value="리스트 보기"/>
</body>
</html>