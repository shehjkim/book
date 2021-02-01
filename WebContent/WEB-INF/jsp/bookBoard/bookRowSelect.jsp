<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript">
	function deleteAlert(str) {
		var yn = confirm("정말 삭제할까요?");
		if(yn) {
			location.href="bookDelete.do?row="+str;
		}else {
			
		}
	}
	
	function updateAlert(str) {
			location.href="bookUpdateForm.do?row="+str;
	}
	
	function rental(str) {
		var form = document.frm;
		var count = form.count.value;
		
		if (count >= 1) {
		location.href="bookRental.do?row="+str;
		} else {
			alert("도서를 대여하실 수 없습니다.");
		}
	}
	
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 상세보기</h1>
		</div>
		<div>
			<form id="frm" name="frm">
			<table border="1">
				<tr>
					<th width="70">도서코드</th>
					<td align="center" width="50">${vos.bookCode }</td>
					<th width="70">도서명</th>
					<td allign="center" width="150">${vos.bookName }</td>
					<th width="80">기본수량</th>
					<td align="center" width="150">${vos.quantity }</td>
					<th width="80">현재수량</th>
					<td align="center" width="150">
					<input type="text" id="count" name="count" size="30" value="${vos.bCount }" readonly></td>
				</tr>
			
			</table>
			<div>
			<button type="button" onclick="location.href='bookList.do'">목록보기</button>
			<button type="button" onclick="updateAlert('${vos.bookCode }')")>도서수정</button>
			<button type="button" onclick="deleteAlert('${vos.bookCode }')")>도서삭제</button>
			
			<button type="button" onclick="rental('${vos.bookCode }')")>도서대여</button>
			
		</div>
		</form>	
		</div>
		<br />

		
		
		
		
</body>
</html>