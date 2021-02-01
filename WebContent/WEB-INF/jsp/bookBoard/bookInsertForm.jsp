<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div align="center">
		<div>
			<h1>도서입력</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="bookInsert.do" method="post">
			
				<table border="1">
				<tr>
						
						<th width="70">도서코드</th>
						<td allign="center" width="150"><input type="text" id ="no" name="no"></td>
						
					</tr>

				
					<tr>
						
						<th width="70">도서명</th>
						<td allign="center" width="150"><input type="text" id="name" name="name" ></td>
						
					</tr>


				</table>

				<br />
				<div>
				
				<button type="submit">저장하기</button>

				</div>
			</form>
		</div>

</body>
</html>