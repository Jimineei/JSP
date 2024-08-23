package com.itwillbs.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.boardDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : BoardListAaction_execute() 호출");
		
		//BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
		//저장된 글의 개수 조회
		int count = dao.getBoardCount();
		System.out.println("M : count :"+count);
		
		System.out.println("M :-----------------------페이징처리1---------------------------");
		
		//한 페이지에서 출력할 글의 갯수
		int pageSize = 5;
		
		//현재 페이지 정보 (몇 페이지인지)
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum = "1";
		}
		
		// 시작행 번호 계산 1 11 21 31 ...
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		
		// 끝행 번호 계산 10 20 30 ...
		int endRow =currentPage*pageSize;
		
		System.out.println("M :-----------------------페이징처리1---------------------------");
		
		List<boardDTO> boardList = null;
		if(count>0) { //저장된 글이 있을 때
			   //디비에 저장된 모든 글 정보를 조회
			   boardList =dao.getBoardList(startRow , pageSize);
				System.out.println("M : 조회 목록개수 "+boardList.size());

		}
		
		System.out.println("M :-----------------------페이징처리2---------------------------");
		//페이징 블럭처리
		
		//게시판 글 개수에 맞는 페이지 개수
		int pageCount = (count/pageSize) + (count%pageSize == 0? 0:1);
		
		
		//한 페이지에 출력될 페이징 블럭의 크기
		int pageBlock = 3;
		
		
		
		
		//페이지 블럭 시작번호 계산
		//1 11 21 31
		int startPage=((currentPage-1)/pageBlock)*pageBlock+1;
		
		//페이지 블럭 끝 번호 계산
		//10 20 30 40 50 
		
		int endPage = startPage + pageBlock -1;
		
		//계산된  endPage정보와 필요한 페이지 개수를 비교해서
		//endPage가 더 크다면(글 개수가 모자랄 때)pageCount 값으로 변경
		if(endPage > pageCount) {
			endPage=pageCount;
		}
		
		
		System.out.println("M :-----------------------페이징처리2---------------------------");

		//request영역에 정보 저장
		request.setAttribute("boardList", boardList);
		
		//request 영역에 페이징 처리 정보를 저장
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		//세션 영역에 조회수 증가 상태를 저장
		HttpSession session = request.getSession();
		session.setAttribute("isUpdate", true);
		
		
		
		
		//페이지 이동준비
		ActionForward forward = new ActionForward();
		forward.setPath("./board/boardList.jsp");
		forward.setRedirect(false);
		
		
		
		return forward;
	}

}
