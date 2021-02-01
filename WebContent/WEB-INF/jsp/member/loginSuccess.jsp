<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
<jsp:include page="../main/main.jsp" /><br />
</head>
<body>
	<p><div align="center">
<h1>${vo.memberName }님 로그인 되었습니다. </h1>
<button type="button" onclick="location.href='main.do'">홈으로</button>
</div>
</body>
</html>