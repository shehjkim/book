<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../main/main.jsp" /><br />
</head>
<body>
	<p><div align="center">
	<h2>${vo.memberName }님 로그아웃 되었습니다.</h2>
	<button type="button" onclick="location.href='main.do'">홈으로</button>
	</div>
</body>
</html>