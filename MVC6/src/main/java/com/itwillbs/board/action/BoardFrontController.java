package com.itwillbs.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.action.BoardDeleteAction;
import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;
@WebServlet("*.bo")

public class BoardFrontController extends HttpServlet{

	protected void 	doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : BoardFrontController-doProcess() 호출\n\n");
	
		System.out.println("C : ---------------1.가상주소 계산 - 시작 --------------------");
		String RequestURI = request.getRequestURI();
		System.out.println("C :RequestURI :"+ RequestURI);
		String CTXPath = request.getContextPath();
		System.out.println("C :CTXPath :"+ CTXPath);
		String Command = RequestURI.substring(CTXPath.length());
		System.out.println("C :Command :"+ Command);
		
		
		System.out.println("C : ---------------1.가상주소 계산 - 끝 ----------------------");
		
		System.out.println("C : ---------------2.가상주소 매핑 - 시작 --------------------");
		
		Action action = null;
		ActionForward forward = null;
		
		if(Command.equals("/BoardWrite.bo")) {
			System.out.println("C : /BoardWrite.bo 매핑");
			System.out.println("C : 패턴 1 - DB사용 X, 페이지 이동");
			
			forward = new ActionForward();
			forward.setPath("./board/boardWrite.jsp");
			forward.setRedirect(false);
			
			System.out.println("C : "+forward);
			
		}
		
		
		else if (Command.equals("/BoardWriteAction.bo")){
			System.out.println("C : BoardWriteAction.bo 매핑");
			System.out.println("C : 패턴 2 - DB사용O, 페이지 이동");
			action = new BoardWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(Command.equals("/BoardList.bo")) {
			System.out.println("C : /BoardWrite.bo 매핑");
			System.out.println("C : 패턴 3 - DB사용O,페이지 출력");
			
			//BoardListAction() 생성
			action = new BoardListAction();
			//execute() 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		else if(Command.equals("/BoardContent.bo")) {
			System.out.println("C : /BoardContent.bo 매핑");
			System.out.println("C : 패턴 3 - DB사용, 페이지 출력");
			
			//BoardContentAction () 객체
			action = new BoardContentAction();
			//execute () 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(Command.equals("/BoardUpdate.bo")){
			System.out.println("C : /BoardUpdate.bo 매핑");
			System.out.println("C : 패턴 3 - DB사용 O, 페이지 출력");
		
			//BoardUpdateAction()객체 생성
			action = new BoardUpdateAction();
			//execute() 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(Command.equals("/BoardUpdateProAction.bo")) {
			System.out.println("C : /BoardUpdateProAction.bo 매핑");
			System.out.println("C : 패턴 - 2 DB사용O, 페이지 이동");
			
			///BoardUpdatePro() 객체 생성
			action = new BoardUpdateProAction();
			
			try {
				//execute() 호출
				forward =	action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(Command.equals("/BoardDelete.bo")){
			System.out.println("c : BoardDelete.bo 매핑");
			System.out.println("c : 패턴 1 - DB사용X,페이지 이동O");
		
			forward = new ActionForward();
			forward.setPath("./board/boardDelete.jsp");
			forward.setRedirect(false);
			
		
		}
		
		else if(Command.equals("/BoardDeleteAction.bo")) {
			System.out.println("C : BoardDeleteAction.bo 매핑");
			System.out.println("C : 패턴 2 - 디비사용 O, 페이지 이동");
			
			//BoardDeleteAction() 객체생성
			action = new BoardDeleteAction();
			//execute() 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		else if(Command.equals("/BoardReWrite.bo")) {
			System.out.println("C : /BoardReWrite.bo 호출");
			System.out.println("C : 패턴 1 - DB사용X, 페이지 이동");
			
			forward = new ActionForward();
			forward.setPath("./board/boardReWrite.jsp");
			forward.setRedirect(false);
			
		}
		else if(Command.equals("/BoardReWriteAction.bo")) {
			System.out.println("C :/BoardReWriteAction.bo 매핑");
			System.out.println("C : 패턴 3 - DB사용O, 페이지 이동");
			
			//BoardReWriteAction
			action = new BoardReWriteAction();
			//execute() 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(Command.equals("/BoardSearchListAction.bo")) {
			System.out.println("C :/BoardSearchListAction.bo 매핑");
			System.out.println("C : 패턴 3 - DB사용O, 페이지 이동");	
			
			//BoardSearchListAction 
			action = new BoardSearchListAction();
			//excute() 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(Command.equals("/BoardFileWrite.bo")) {
			System.out.println("C :/BoardFileWrite.bo 매핑");		
			System.out.println("C : 패턴 1 - DB사용X, 페이지 이동");	
			
			forward = new ActionForward();
			forward.setPath("./board/boardFileWrite.jsp");
			forward.setRedirect(false);
		}
		
		else if(Command.equals("/BoardFileWriteAction.bo")) {
			System.out.println(" C : /BoardFileWriteAction.bo 매핑 ");
			System.out.println(" C : 패턴 2 - DB사용O, 페이지 이동 ");
			
			// BoardFileWriteAction() 객체생성
			action = new BoardFileWriteAction();
			// execute() 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(Command.equals("/BoardFileDownLoadAction.bo")) {
			System.out.println(" C : /BoardFileDownLoadAction.bo 매핑 ");
			System.out.println(" C : 패턴 3 - 처리작업O,페이지 출력 ");
			
			// BoardFileDownLoadAction객체 생성
			action = new BoardFileDownLoadAction();
			//execute 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		
		
		System.out.println("C : ---------------2.가상주소 매핑 - 끝 ----------------------");
		
		System.out.println("C : ---------------3.가상주소 이동 - 시작 --------------------");
		
		if(forward!=null) {
			System.out.println("C :"+forward.isRedirect()+"방식으로"+forward.getPath()+"주소로 이동");
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dis=
						request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}

		
		System.out.println("C : ---------------3.가상주소 이동 - 끝 ----------------------");
		
		
		System.out.println("C : -------------------doProcess() 끝 ------------------------");
		
	}//process()
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("C : BoardFrontController-doGet() 호출");
	doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("C : BoardFrontController-doPost() 호출");
	doProcess(request, response);
	}
	
	
}
