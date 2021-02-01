<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<jsp:include page="../main/main.jsp" /><br />
</head>
<style>
#tableMenu .memberId:hover {
	background-color: beige;
}
</style>
<script type="text/javascript">
function formSubmit(str) {
	frm.memberId.value=str;
	frm.submit();
}
</script>

<body>
	<p>
	<div align="center">
		<h1>회원명단조회</h1>
		<div>
			<form id="frm" name="frm" action="memberView.do" method="post">
			<input type="hidden" id="memberId" name="memberId">
			</form>
			<table border="1" id="tableMenu">
				<tr>
					<th width="100">I D</th>
					<th width="100">이 름</th>
					<th width="200">전화번호</th>
					<th width="200">주 소</th>
					<th width="100">권 한</th>
				</tr>
						<c:forEach var="vo" items="${list }">
							<tr class="memberId" onclick="formSubmit('${vo.memberId }')">
								<td align="center">${vo.memberId}</td>
								<td align="center">${vo.memberName }</td>
								<td align="center">${vo.memberTel }</td>
								<td align="center">${vo.memberAddress }</td>
								<td align="center">${vo.memberAuth }</td>
							</tr>
					</c:forEach>
			</table>
		</div>
		<br />
		<div>
			<button type="button" size="10"
				onclick="location.href='memberJoinForm.do'">회원등록</button>
		</div>
	</div>

	</div>
</body>
</html>