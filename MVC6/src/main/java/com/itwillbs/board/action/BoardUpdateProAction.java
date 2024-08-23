package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.boardDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;
import com.itwillbs.utill.JSFunction;

public class BoardUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : BoardUpdateProAction_execute() 호출");
		
		//한글처리 인코딩(web.xml의 필터설정 사용)
		//전달정보(파라메터) 저장 (pageNum)_
		String pageNum=request.getParameter("pageNum");
		System.out.println("M : pageNum :"+pageNum);
		//전달정보(파라메터) 저장(name,pass,subject,content)
		//=> BoardDTO에 저장
		
		boardDTO dto = new boardDTO();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setName(request.getParameter("name"));
		dto.setPass(request.getParameter("pass"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		
		System.out.println("M : 수정할 내용 dto :"+dto);
		
		//BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
		
		//글 내용 수정하는 메서드 호출
		int result = dao.updateBoard(dto);
		
		System.out.println("M :  result :"+result);
		
		//결과(result)값에 따른 페이지 이동준비(JS)
		if(result ==0) {
			JSFunction.alertAndBack(response, "수정X - 글, 비밀번호 오류");
			return null;
		}
		if(result==-1) {
			JSFunction.alertAndBack(response, "수정X - 글 정보가 없음");
			return null;
		}
		//정상 수정처리 완료
		JSFunction.alertAndLocation(response, "수정O - 글 수정 완료!", "./BoardList.bo?pageNum="+pageNum);
		
		return null;
	}

}
