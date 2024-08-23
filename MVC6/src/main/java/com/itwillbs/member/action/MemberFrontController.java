package com.itwillbs.member.action;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;

//controller
//사용자의 요청을 가장먼저 처리하는 객체
public class MemberFrontController extends HttpServlet {
//alt + shift + s + v
	
	

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : MemberFrontController-doProcess() 호출 ");
		System.out.println("C : GET/POST방식 상관없이 모두 실행\n\n");
		
		//가상주소
		//http://localhost:8088/MVC6/test.me(URL)
							  //MVC6/test.me(URI)
		System.out.println("C : -----------1.가상주소 계산-시작------------");
		//가상주소 가져오기
		String requestURI = request.getRequestURI();
		System.out.println("C : requestURI :"+requestURI);
		//프로젝트(컨텍스트)명 가져오기
		String CTXPath = request.getContextPath();
		System.out.println("C : CTXPath :"+CTXPath);
		//가상주소(URI)-프로젝트(컨텍스트)명
		String command = requestURI.substring(CTXPath.length());
		System.out.println("C : command :"+command);
		
		System.out.println("C : -----------1.가상주소 계산-끝------------");
		
		System.out.println("C : -----------2.가상주소 매핑-시작------------");
		
		Action action = null;
		ActionForward forward = null;
		
		//회원가입-정보입력
		if(command.equals("/MemberJoin.me")) {
			System.out.println("C : /MemberJoin.me 매핑");
			System.out.println("C : 패턴 1 - DB 사용하지 않음, VIEW페이지 이동");
			
			forward = new ActionForward();
			forward.setPath("./member/insertForm.jsp");
			forward.setRedirect(false); //true-sendRedirect . false-forward
			System.out.println("C :"+forward.toString());
		}else if(command.equals("/MemberJoinAction.me")) {
			System.out.println("C : /MemberJoinAction.me 매핑");
			System.out.println("C : 패턴 2 - DB사용O, 페이지 이동");
			
			//MemberJoinAction 객체 생성
			//MemberJoinAction mjAction = new MemberJoinAction();
			action = new MemberJoinAction(); //업캐스팅
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("c :"+forward);
		}
		else if(command.equals("/MemberLogin.me")) {
			System.out.println("C : /MemberLogin.me 매핑");
			System.out.println("C : 패턴 1 -DB사용X, view페이지 이동");
			
			//ActionForward 객체를 생성
			forward = new ActionForward();
			forward.setPath("./member/loginForm.jsp");
			forward.setRedirect(false);
			System.out.println("C :"+ forward);
		}
		else if(command.equals("/MemberLoginAction.me")){
			System.out.println("C :/MemberLoginAction.me 매핑");
			System.out.println("C : 패턴2 - DB사용 O, 페이지 이동");
			
			//MemberLoginAction() 객체 생성
			action = new MemberLoginAction();
			//객체의 execute() 메서드 호출, forward 리턴
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/Main.me")) {
			System.out.println("C : /Main.me 매핑");
			System.out.println("C : 패턴1 - DB사용 X, 페이지 이동");
			
			forward = new ActionForward();
			forward.setPath("./member/main.jsp");
			forward.setRedirect(false);
			
			System.out.println("C :"+forward);
		}
		else if(command.equals("/MemberLogout.me")) {
			System.out.println("C : /MemberLogout.me 매핑");
			System.out.println("C : 패턴2 - 작업 처리(DB사용X), 페이지 이동");
			
			//MemberLogoutAction() 객체 생성
			action = new MemberLogoutAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/MemberInfo.me")) {
			System.out.println("C : /MemberInfo.me 매핑");
			System.out.println("C : 패턴 - DB 사용 O, 페이지 출력");
		
		//MemberInfoAction()객체 생성
		action = new MemberInfoAction();
		//execute()메서드 호출
		
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else if(command.equals("/MemberUpdate.me")) {
			System.out.println("C : /MemberUpdate.me 매핑");
			System.out.println("C : 패턴 3 - DB사용 O, 페이지 출력");
			
			//MemberUpdateAction() 객체
			action = new MemberUpdateAction();
			//execute() 호출
			
			try {
				forward= action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		else if(command.equals("/MemberUpdateProAction.me")) {
			System.out.println("C : /MemberUpdateProAction.me 매핑");
			System.out.println("C : 패턴 2 - DB사용, 페이지 이동");
			
			//MemberUpdateProAction() 객체 생성
			action = new MemberUpdateProAction();
			//execute() 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if(command.equals("/MemberDelete.me")) {
			System.out.println("C : /MemberDelete.me 매핑");
			System.out.println("C : 패턴 1 - DB사용 X, 페이지 이동");
			
			forward = new ActionForward();
			forward.setPath("./member/deleteForm.jsp");
			forward.setRedirect(false);
			
			System.out.println("C :"+forward);
			
		}else if(command.equals("/MemberDeleteAction.me")) {
			System.out.println("C : /MemberDeleteAction.me 매핑");
			System.out.println("C : 패턴 2 - DB사용 O, 페이지 이동");
			
			//MemberDeleteAction() 객체 생성
			action = new MemberDeleteAction();
			//execute() 호출
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberList.me")) {
			System.out.println("C : /MemberList.me 매핑");
			System.out.println("C : 패턴 3 - DB사용 O, 페이지 출력");
			
			//MemberListAction() 객체생성
			action = new MemberListAction();
			//execute() 호출
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("C : -----------2.가상주소 매핑-끝------------");
		
		System.out.println("C : -----------3.가상주소 주소 이동-시작------------");
		
		if(forward != null) {
			//이동정보 객체가 있다 = 티켓이 있다
			System.out.println("C : "+forward.isRedirect()+"방식으로 "+forward.getPath()+"이동");
			
			if(forward.isRedirect()) {
				//true
				response.sendRedirect(forward.getPath());
			}else {
				//false
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
		System.out.println("C : -----------3.가상주소 주소 이동-끝------------\n\n");
	
		
		System.out.println("C: doProcess()동작 끝\n\n");
	}//doProcess()
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : MemberFrontController-doGet() 호출 ");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C : MemberFrontController-doPost() 호출 ");
		doProcess(request, response);
	}
	
}
