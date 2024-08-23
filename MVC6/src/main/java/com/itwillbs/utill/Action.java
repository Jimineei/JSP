package com.itwillbs.utill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//상수
		//추상메서드
		
		//excute() 정의 : 실행시 requset, response 정보가 필요함.
		//                실행후 ActionForward 객체 리턴
		
		//public /*abstract*/ ActionForward execute
		public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;

}
