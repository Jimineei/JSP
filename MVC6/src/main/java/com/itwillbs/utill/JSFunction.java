package com.itwillbs.utill;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/*
 * JSFunction : 자바스크립트 페이지 이동을 처리하는 객체
 * 
 * 
 * */
public class JSFunction {
	//alert + back 동작
	public static  void alertAndBack(HttpServletResponse response, String msg) {
		try {
			response.setContentType("text/html; charset=utf-8");
			
			//response.getWriter().append("Hello");
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
//			<다른방법>
//			String code ="";
//			code +="<script>";
//			code +="alert('"+msg+"');";
//			code +="history.back();";
//			code +="</script>";
//			out.print(code);
//			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//alert + location 동작
public static void alertAndLocation(HttpServletResponse response,
		String msg, String location) {
	try {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String code ="";
		code +="<script>";
		code +="alert('"+msg+"');";
		code +="location.href='"+location+"';";
		code +="</script>";
		out.print(code);
		out.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}



}//