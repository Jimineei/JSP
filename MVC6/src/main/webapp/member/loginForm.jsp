<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member/loginForm.jsp(MVC)</h1>
	<h2>로그인 페이지</h2>
	
	
	<fieldset>
		<form action="./MemberLoginAction.me" method="post">
		<!--이전페이지 정보를 저장  -->
		<input type="hidden" name="oldURL" value="<%=request.getParameter("oldURL")%>">
			아이디:<input type="text" name="id"><br>
			비밀번호:<input type="password" name="pw"><br>
			<hr>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='./MemberJoin.me';">
		</form>
	</fieldset>
</body>
</html>