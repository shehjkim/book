<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ����������</title>
<jsp:include page="../main/main.jsp" /><br />
</head>
<body>
	<p><div align="center">
		<h1>�Խñ� ����</h1>
		
		<div>
			<form id="frm" name="frm" action="memberUpdate.do" method="post">
			<div><br />
				<table border="1">
						<tr>
							<th width="50">I	D</th>
							<td align="center" width="300">${vo.memberId }</td>
						</tr>
						<tr>
							<th width="50">�н�����</th>
							<td align="center" width="300">
							<input type="text" value='${vo.memberPassword }'></td>
						</tr>
						<tr>
							<th width="50">��	��</th>
							<td align="center" width="300">${vo.memberName }</td>
						</tr>
						<tr>	
							<th width="80">��ȭ��ȣ</th>
							<td align="center" width="300">
							<input type="text" value='${vo.memberTel }'></td>
						</tr>
						<tr>
							<th width="150">��	��</th>
							<td align="center" width="300">
							<input type="text" value='${vo.memberAddress }'></td>
						</tr>
						<tr>
							<th width="50">��	��</th>
							<td align="center" width="300">
							<input type="text" value='${vo.memberAuth }'></td>
						</tr>
					</table><br />
			<input type="submit" value="���"> &nbsp;&nbsp;&nbsp;
			<button type="reset" >���</button>
		</div><br />
	</form>
	</div>
</div>
</body>
</html>