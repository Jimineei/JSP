package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("M :MemberUpdateAction_execute() 실행");
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
			//response.sendRedirect(id);
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		//MemberDAO 객체 -
		MemberDAO dao = new MemberDAO();
		//-아이디에 해당하는 기존 회원정보를 가져오는 메서드 실행
		MemberDTO dto = dao.getMember(id);
		//DAO에서 가져온 객체를 request 영역에 저장
		request.setAttribute("dto", dto);
		//출력할 페이지로 이동("./member/updateForm.jsp")
		forward.setPath("./member/updateForm.jsp");
		forward.setRedirect(false);
		
		
		
		return forward;
	}

}
