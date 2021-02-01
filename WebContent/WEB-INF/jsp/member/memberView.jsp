<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보보기</title>
<script type="text/javascript">
	function deleteAlert(str) {
		var yn = confirm("정말 삭제할까요?");
		if (yn) {
			location.href = "memberDelete.do?memberId=" + str;
		} else {

		}
	}

	function updateAlert(str) {
		location.href = "memberUpdateForm.do?memberId=" + str;
	}

</script>
<jsp:include page="../main/main.jsp" /><br />
</head>
<body>
	<p>
	<div align="center">
		<h1>회원 상세보기</h1>
	</div>
	<form id="frm" name="frm" method="post">
		<div align="center">
			<table border="1">
				<tr>
					<th width="50">I D</th>
					<td align="center" width="300">${vo.memberId }</td>
				</tr>
				<tr>
					<th width="50">이 름</th>
					<td align="center" width="300">${vo.memberName }</td>
				</tr>
				<tr>
					<th width="80">전화번호</th>
					<td align="center" width="300">${vo.memberTel }</td>
				</tr>
				<tr>
					<th width="150">주 소</th>
					<td align="center" width="300">${vo.memberAddress }</td>
				</tr>
				<tr>
					<th width="50">권 한</th>
					<td align="center" width="300">${vo.memberAuth }</td>
				</tr>
			</table>
		</div>
		<br />

		<div align="center">
			<button type="button" onclick="location.href='memberList.do'">목록보기</button>
			<button type="button" onclick="deleteAlert('${vo.memberId }')")>삭 제</button>
			<button type="button" onclick="updateAlert('${vo.memberId}')")>수 정</button>
		</div>
	</form>
	</div>
</body>
</html>