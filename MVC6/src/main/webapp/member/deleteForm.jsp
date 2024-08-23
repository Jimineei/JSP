<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h1>/member/deleteForm.jsp</h1>
 	<h2>회원정보 삭제(탈퇴)</h2>
 	
 	<fieldset>
 		<legend>회원 탈퇴</legend>
 		<form action="./MemberDeleteAction.me" method="post">
 			비밀번호 :<input type="password" name="pw"><br>
 			<input type="submit" value="탈퇴하기">
 		</form>
 	</fieldset>
</body>
</html>