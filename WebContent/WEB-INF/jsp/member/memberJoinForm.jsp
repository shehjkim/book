<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<script type="text/javascript">
	function formCheck() {
		
		if(frm.memberPassword.value == ""){
			alert("패스워드는 반드시 입력해야 합니다. ");
			frm.memberPassword.focus();
			return false;
		}

		if (frm.memberPassword.value != frm.memberPassword1.value) {
			alert("패스워드가 일치 하지 않습니다.");
			frm.memberPassword1.value = null;
			frm.memberPassword.focus();
			return false;
		}
		if (frm.memberName.value == "") {
			alert("이름은 반드시 입력해야 합니다. ");
			frm.memberName.focus();
			return false;
		}
		
		return true;
	}
	function idCheck(str) {
		var url = "idCheck.do?memberId="+str;
		if(str == "") {
			alert("아이디를 입력하세요. ") 
			frm.memberId.focus();
		}else{
			window.open(url, "아이디중복체크", "width=400, height=400, top=100, left=100");
		}
		
	}
	
</script>
<jsp:include page="../main/main.jsp" /><br />
</head>
<body>
	<p><div align="center">
		<h1>회원가입</h1>
		<div>
			<form id="frm" name="frm" action="memberJoin.do" method="post">
				<div>
					<br />
					<table border="1">
						<tr>
							<th width="100">아 이 디</th>
							<td width="350">
							<input type="text" id="memberId" name="memberId" size="30" required="required"> &nbsp;&nbsp;&nbsp;
 							<button type="button" onclick="idCheck(memberId.value)">중복체크</button></td>
						</tr>
						<tr>
							<th width="100">Password</th>
							<td width="300"><input type="password" id="memberPassword" name="memberPassword" size="30"></td>
						</tr>
						<tr>
						<th width="120">Password 확인</th>
							<td width="300"><input type="password" id="memberPassword1" name="memberPassword1" size="30"></td> 
						</tr>
						<tr>
							<th width="100">이름</th>
							<td width="300"><input type="text" id="memberName" name="memberName"size="30" required="required"></td>
						</tr>
						<tr>
							<th width="100">전화번호</th>
							<td width="300"><input type="text" id="memberTel" name="memberTel"size="30" required="required"></td>
						</tr>
						<tr>
							<th width="100">주소</th>
							<td width="300"><input type="text" id="memberAddress" name="memberAddress"size="30" required="required"></td>
						</tr>
					</table>
				</div><br />
				<div>
				 <input type="submit" value="회원가입"> &nbsp;&nbsp;&nbsp; 
						<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>