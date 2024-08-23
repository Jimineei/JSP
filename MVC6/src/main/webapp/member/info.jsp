<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/member/info.jsp</h1>
	
	<%-- ${dto }<hr> --%>
	<%-- ${requestScope.dto }<hr> --%>
	
	
	<!-- 7행 2열  -->
	<table border ="1">
	<tr>
	 <td>아이디</td>
	 <td>${dto.id }</td>
	</tr>
	<tr>
	 <td>비밀번호</td>
	 <td>${dto.pw }</td>
	</tr>
	<tr>
	 <td>이름</td>
	 <td>${dto.name }</td>
	</tr>
	<tr>
	 <td>성별</td>
	 <td>${dto.gender }</td>
	</tr>
	<tr>
	 <td>나이</td>
	 <td>${dto.age }</td>
	</tr>
	<tr>
	 <td>이메일</td>
	 <td>${dto.email }</td>
	</tr>
	<tr>
	 <td>회원가입일</td>
	 <td>
	 <fmt:formatDate value="${dto.regdate }" type="both"/>	</td>
	</tr>
	</table>
	
	<h3><a href="./Main.me">메인페이지로 이동....</a></h3>
	
</body>
</html>