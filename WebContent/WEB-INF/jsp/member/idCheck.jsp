<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복체크</title>
</head>
<script type="text/javascript">

	function formClose(check) {
				
		if(${check }) {
			opener.frm.memberPassword.focus();
		}else{
			opener.frm.memberId.value = null;
			opener.frm.memberId.focus();
			
		}
		window.close();
	}
</script>
<body>
<div align = "center">
	<h3>${msg }</h3>
		<input id ="cancelId" type="button" value="취소" onclick="window.close()">
		<input id ="useId" type="button" value="사용하기" onclick="formClose(check)">
</div>
</body>
</html>