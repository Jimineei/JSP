package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.boardDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;

public class BoardContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : BoardContentAction_execute() 호출");
		
		//작성된 글의 내용을 화면에 출력
		
		//전달된 정보 저장(bno,pageNum)
		int bno = Integer.parseInt(request.getParameter("bno"));
		String pageNum = request.getParameter("pageNum");
		
		System.out.println("M : bno"+bno+",pageNum"+pageNum);
		
		
		//BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
		
		//조회수 증가가능한 상태인지 체크
		HttpSession session = request.getSession();
		boolean isUpdate = (boolean)session.getAttribute("isUpdate");
		
		
		
		if(isUpdate) {
		//DAO 객체 - 조회수 1 증가(update)
		dao.updateReadCount(bno);
		System.out.println("M : 조회수 1 증가 완료!");
		session.setAttribute("isUpdate", false);
		
		}
		
		//DAO 객체 - 작성된 글 정보 가져오기(select)
		boardDTO dto = dao.getBoard(bno);
		//객체 정보 출력
		System.out.println("M : dto"+dto);
		
		/////////////////////////////////////////////////////
		//이전글 제목 조회
		String prevTitle = dao.prevSubject(bno);
		System.out.println("M : prevTitle :"+prevTitle);
		
		
		//다음글 제목 조회
		String nextTitle = dao.nextSubject(bno);
		System.out.println("M : nextTitle :"+nextTitle);
		/////////////////////////////////////////////////////
		
		
		
		
		//request 영역에 저장
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("prevTitle", prevTitle);
		request.setAttribute("nextTitle", nextTitle);
		
		//페이지 이동 준비
		ActionForward forward = new ActionForward();
		forward.setPath("./board/boardContent.jsp");
		forward.setRedirect(false);
		
		
		
		return forward;
	}

}
