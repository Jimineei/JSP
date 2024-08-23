package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.boardDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;

public class BoardReWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : BoardReWriteAction_execute() 호출");
		
		
		//한글처리 인코딩(필터처리)
		//전달된 정보(파라메터) 저장
		//bno, re_ref,re_lev,re_seq,pageNum,name,subject,pass,content
		
		//boardDTO 객체
		boardDTO dto = new boardDTO();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		dto.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
		dto.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		dto.setName(request.getParameter("name"));
		dto.setSubject(request.getParameter("subject"));
		dto.setPass(request.getParameter("pass"));
		dto.setContent(request.getParameter("content"));
		
		//+IP
		dto.setIp(request.getRemoteAddr());
		
		String pageNum = request.getParameter("pageNum");
		System.out.println("M : dto :"+dto);
		//BoardDAO 객체 생성 - 답글쓰기 메서트 호출
		BoardDAO dao = new BoardDAO();
		
		dao.reInsertBoard(dto);
		
		//페이지 이동준비
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo?pageNum="+pageNum);
		forward.setRedirect(true);
		
		
		
		
		return forward;
	}

}
