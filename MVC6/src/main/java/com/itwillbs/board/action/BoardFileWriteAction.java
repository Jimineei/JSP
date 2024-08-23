package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.boardDTO;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardFileWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : BoardFileWriteAction_execute() 호출");
		
		// 파일업로드
		// 1) 파일이 저장될 장소(webapp/upload 폴더)를 지정
		// 실제 작업파일 위치 
		// D:\\Shared\\workspace_jsp6\\MVC6\\src\\main\\webapp\\upload
		// realPath(서버에 배포된 작업파일 위치) 
		// D:\Shared\\workspace_jsp6\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\MVC6\\upload
		String realPath = request.getRealPath("/upload");
		System.out.println(" M : realPath : "+realPath);
		
		// 2) 업로드할 파일의 크기 제한 (5MB)
		// bit > byte > KB > MB > GB > TB
		int maxSize = 5 * 1024 * 1024;  // 5MB
		//int maxSize = 5242880;
		
		// 3) 파일 업로드
		MultipartRequest multi 
		    = new MultipartRequest(
		    		request,
		    		realPath,
		    		maxSize,
		    		"UTF-8",
		    		new DefaultFileRenamePolicy()
		    		); 
		
		
		// request : request 영역객체 정보를 전달(+parameter)
		// realPath : 서버에 배포될 업로드 폴더의 위치
		// maxSize : 업로드시 파일크기 제한
		// UTF-8 : 인코딩 정보 설정 
		// new DefaultFileRenamePolicy() : 중복파일 이름 처리
		
		
		
		System.out.println(" M : 파일 업로드 성공! ");
		
		//전달 정보 (파라메터) 저장
		//BoardDTO 객체 생성
		boardDTO dto = new boardDTO();
		//dto.setName(request.getParameter("name"));
		//                      => 사용불가		
		dto.setName(multi.getParameter("name"));
		dto.setPass(multi.getParameter("pass"));
		dto.setSubject(multi.getParameter("subject"));
		dto.setContent(multi.getParameter("content"));
		dto.setIp(request.getRemoteAddr());
		
		//dto.setFile(multi.getParameter("file"));
		dto.setFile(multi.getFilesystemName("file"));
		System.out.println( "M : dto : "+ dto); 
		System.out.println( "M : oFile : "+ multi.getOriginalFileName("file")); 
	
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
		// 글정보 + 파일이름 저장하는 메서드 
		
		dao.insertBoard(dto); 
		
		// 페이지 이동 준비
		
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo");
		forward.setRedirect(true);
		return forward;
		
		


		
		
		
		
		
		
		

		
		
		 
	

	}

}
