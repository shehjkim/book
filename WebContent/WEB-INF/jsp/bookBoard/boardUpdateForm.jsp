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
			<h1>수정화면</h1>
		</div>
		<form id="frm" name="frm" action="bookUpdate.do" method="post">
		<div>
			<table border="1">
				<tr>
					<th width="70">도서코드</th>
					<td align="center" width="50">
					<input tpye="text" id="code" name="code" value="${voServ.bookCode }" readonly>
					</td>
					<th width="70">도서명</th>
					<td allign="center" width="150"><input type="text" id="name" name="name" value="${voServ.bookName }"></td>
					<th width="80">기본수량</th>
					<td align="center" width="150"><input type="text" id="quantity" name="quantity" value="${voServ.quantity }"></td>
					<th width="80">현재수량</th>
					<td align="center" width="150"><input type="text" id="count" name="count" value="${voServ.bCount }"></td>

				
				
			</table>
			<input type="submit" value="수정"> &nbsp;&nbsp;&nbsp;
			</form>
		</div><br />
		
</body>
</html>
</body>
</html>