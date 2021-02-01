<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원정보수정</title>
<jsp:include page="../main/main.jsp" /><br />
</head>
<body>
	<p><div align="center">
		<h1>게시글 수정</h1>
		
		<div>
			<form id="frm" name="frm" action="memberUpdate.do" method="post">
			<div><br />
				<table border="1">
						<tr>
							<th width="50">I	D</th>
							<td align="center" width="300">${vo.memberId }</td>
						</tr>
						<tr>
							<th width="50">패스워드</th>
							<td align="center" width="300">
							<input type="text" value='${vo.memberPassword }'></td>
						</tr>
						<tr>
							<th width="50">이	름</th>
							<td align="center" width="300">${vo.memberName }</td>
						</tr>
						<tr>	
							<th width="80">전화번호</th>
							<td align="center" width="300">
							<input type="text" value='${vo.memberTel }'></td>
						</tr>
						<tr>
							<th width="150">주	소</th>
							<td align="center" width="300">
							<input type="text" value='${vo.memberAddress }'></td>
						</tr>
						<tr>
							<th width="50">권	한</th>
							<td align="center" width="300">
							<input type="text" value='${vo.memberAuth }'></td>
						</tr>
					</table><br />
			<input type="submit" value="등록"> &nbsp;&nbsp;&nbsp;
			<button type="reset" >취소</button>
		</div><br />
	</form>
	</div>
</div>
</body>
</html>