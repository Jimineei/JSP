package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.boardDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : BoardWriteAction_execute() 호출");
		
		
		//한글처리 인코딩
		//request.setCharacterEncoding("utf-8");
		//System.out.println("M :"+request.getParameter("name"));
		
		
		//전달정보를(파라메터) 저장
		//작성자, 비밀번호, 제목, 내용
		boardDTO dto = new boardDTO();
		dto.setName(request.getParameter("name"));
		dto.setPass(request.getParameter("pass"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		
		//+IP주소
		dto.setIp(request.getRemoteAddr());
		System.out.println("M : "+dto);
		
		//BoardDAO 객체 - 글쓰기 메서드
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(dto);
		
		
		//페이지 이동준비
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
