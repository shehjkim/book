<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		tr.row:hover {background-color : lightyellow; }
	</style>
	<script type="text/javascript">
		function formSubmit(str) {
			frm.bId.value=str;
			frm.submit();
		}

	</script>
</head>

<body>
	<div align ="center">
		<h1>책 목록</h1>
			<div>
		<!-- 화면에는 보이지 않는 hidden form -->
		<form id="frm" name="frm" action="bookRowSelect.do" method="post">
			<input type="hidden" id="bId" name="bId">
		</form> 
	</div>

		<div>
			<table border="1">
				<tr>
					<th width="100">도서코드</th>
					<th width="100">도서명</th>
					<th width="100">기본수량</th>
					<th width="100">현재수량</th>

				</tr>
				
			<c:forEach var="vo" items="${list }">
				<tr class="row" onclick="formSubmit('${vo.bookCode }')" >
					<td align = "center">${vo.bookCode } </td>
					<td align = "center">${vo.bookName }</td> 
					<td align = "center">${vo.quantity }</td> 
					<td align = "center">${vo.bCount }</td>
				</tr>
			</c:forEach>
			</table>
		</div>
		
		<div>
			<button type="button" onclick="location.href='bookInsertForm.do'">도서등록</button>
		</div>

		
</div>
</body>
</html>