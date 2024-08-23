<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//MVC프로젝트의 시작지점

			//원하는 주소로 페이지 이동

			//** 절대로 JSP파일을 실행하지 않는다. (단,start.jsp제외)

			//* 주소줄에도 .jsp주소는 표시X

			//  (주소에 .jsp주소가 있을경우 잘못된 코드)

			//response.sendRedirect(" http://localhost:8088/MVC6/*.me");

			//response.sendRedirect("./ITWILL.me");

			//response.sendRedirect("./MemberJoin.me");

			//response.sendRedirect("./MemberLogin.me");

			//response.sendRedirect("./Main.me");

			//response.sendRedirect("./BoardWrite.bo");

			response.sendRedirect("./BoardList.bo");

			
		
	%>
</body>
</html>