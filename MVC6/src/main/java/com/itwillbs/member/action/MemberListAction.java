package com.itwillbs.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("M : MemberListAction_execute () 실행");
		
		//로그인 체크 (로그인이 된 상태여야함, 사용자의 아이디가 admin 이어야 함)
		
		
		HttpSession session = request.getSession();
		String id= (String)session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id==null ||  !id.equals("admin")) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		
		//memberDAO 객체
		MemberDAO dao =new MemberDAO();
			
		//회원정보 목록을 가져오는 메서드
		ArrayList<MemberDTO> memberList = dao.getMemberList();
		System.out.println("M : memberList.size()");
		
		
		request.setAttribute("memberList", memberList);
		
		
		forward.setPath("./member/list.jsp");
		forward.setRedirect(false);
		
		
		
		
		return forward;
	}

}
