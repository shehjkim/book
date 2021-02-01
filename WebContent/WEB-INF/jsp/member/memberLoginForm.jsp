<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<jsp:include page="../main/main.jsp" /><br />
</head>
<body>
	<p><div align="center">
			<h1>로 그 인</h1>
		<div>
			<form id="frm" name="frm" action="memberlogin.do" method="post">
				<div><br/>
					<table border="1">
						<tr>
							<th width="100">아 이 디</th>
							<th width="150"><input type="text" id="memberId" name="memberId" size="30"></th>
						</tr>
							<th width="100">패스워드</th>
							<th width="150"><input type="password" id="memberPassword" name="memberPassword" size="30"></th>
					</table>
		</div><br/>
		<input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소">
		</form>
	</div>
</div>
</body>
</html>