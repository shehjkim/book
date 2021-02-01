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
<h1>${vo.memberName }님 환영합니다. </h1>
<h3>회원가입 완료 되었습니다. </h3>
<button type="button" onclick="location.href='memberLoginForm.do'">로그인하기</button>
</div>
</body>
</html>