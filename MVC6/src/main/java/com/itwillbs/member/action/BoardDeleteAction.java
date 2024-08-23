package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.boardDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;
import com.itwillbs.utill.JSFunction;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : BoardDelteAction_execute() 호출");
		
		//한글처리 인코딩(필터처리-생략)
		//전달정보(파라메터) 저장 (bno,pass,pageNum)
		
		boardDTO dto = new boardDTO();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setPass(request.getParameter("pass"));
		
		String pageNum = request.getParameter("pageNum");
		
		//BoardDAO 객체 생성 - 게시판 글 삭제 메서드 호출
		BoardDAO dao = new BoardDAO();
		
		int result = dao.deleteBoard(dto);
		
		//결과에 따른 페이지 이동
		if(result == 0) {
			JSFunction.alertAndBack(response, "삭제X-비밀번호 오류!");
			return null;
		
		}if(result ==-1) {
			JSFunction.alertAndBack(response, "삭제X-게시판 글 없음!");
			return null;
		}
		JSFunction.alertAndLocation(response, "삭제O-글삭제", "./BoardList.bo?pageNum="+pageNum);
		
		
		return null;
	}

}
