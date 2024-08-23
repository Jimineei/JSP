package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("M : MemberLoginAction_execute() 호출");
		
		
		//한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		//전달된 정보(파라메터)를 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(request.getParameter("pw"));
		
		System.out.println("M : "+dto);
		
		
		//MemberDAO 객체 생성
	    MemberDAO dao = new MemberDAO();
		
		// 로그인 여부 체크 메서드 호출
		int result = dao.loginCheck(dto);
		System.out.println("M : result"+ result);
		
		//result값(-1,0,1)에 따른 페이지 이동(정보생성)
		
		//아이디 없을 때(-1)=>JS 페이지 이동
		if(result == -1) {
		response.setContentType("text/html; charset=utf-8");
		
		//response.getWriter().append("Hello");
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('아이디 정보가 없음!');");
		out.println("history.back();");
		out.println("</script>");
		out.close();
		return null;
		}
		
		//비밀번호 오류일 때(0)=>JS 페이지 이동
		if(result == 0) {
			response.setContentType("text/html; charset=utf-8");
			
			//response.getWriter().append("Hello");
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호 오류!');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;//JS 페이지 이동 O, 컨트롤러 페이지 이동 X
			}
		
		//정상처리 (1)
		//사용자의 아이디를 세션영역에 저장
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		
		//페이지 이동정보 준비
		ActionForward forward = new ActionForward();
		forward.setPath("./Main.me");
		forward.setRedirect(true);
		
		
		return forward;
		
	}

}
