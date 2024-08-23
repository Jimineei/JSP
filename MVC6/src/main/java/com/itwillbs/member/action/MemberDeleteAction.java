package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;
import com.itwillbs.utill.JSFunction;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("M : MemberDeleteAction_execute() 호출");
		
		//로그인 체크
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id==null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		
		//한글처리 인코딩
		request.setCharacterEncoding("utf-8");

		//회원정보 비밀번호를 저장(전달받은 파라메터)
		String pw = request.getParameter("pw");
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		//MemberDAO 객체 - 회원정보 삭제
		MemberDAO dao = new MemberDAO();
		
		int result = dao.deleteMember(dto);
		//회원정보 삭제 결과에 따른 페이지 이동
		if(result== -1) {
			JSFunction.alertAndBack(response,"삭제 - 회원정보 없음");
			return null;
		}
		if(result== 0) {
			JSFunction.alertAndBack(response,"삭제 - 비밀번호 오류");
			return null;
		}
		//result==1
		//로그인된 사용자 정보 초기화
		session.invalidate();
		
		JSFunction.alertAndLocation(response,"삭제 - 탈퇴완료","./Main.me");
		return null;
		
		
	}

}
