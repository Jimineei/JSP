package com.itwillbs.board.action;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.utill.Action;
import com.itwillbs.utill.ActionForward;

public class BoardFileDownLoadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : BoardFileDownLoadAction_execute()호출");
		
		// 전달 정보(파라메터) 저장
		String fileName = request.getParameter("fileName");
		
		// 다운로드 할 파일의 이름 생성(+경로를 포함)
		
		String savePath = "upload"; // savePath 변수에 문자열 upload를 할당하는 이유? 파일 저장된 디렉토리의 이름인데..어떻게 참조하지.
		
		ServletContext context = request.getServletContext();
		// getRealPath 메서드 쓰려면 ServletContext객체가 필요한데 인터페이스니까
		// getServletContext 메서드를 request통해서 사용해서 ServletContext 객체를 반환
		// getServletContext 메서드는 서블릿안에서 사용가능 (httpServlet 클래스에서 정의된 메서드라서?)
		String downLoadPath = context.getRealPath(savePath); // 여기다가 그냥 "upload" 쓰면 안되는건가요.
		// 가상 경로를 실제 파일 시스템의 절대 경로로 변환하는 메서드?
		// savePath가 가상경로...? 
		System.out.println("M : downLoadPath :"+downLoadPath);
		
		//최종 다운로드할 경로 + 다운로드할 파일명 
		String dFilePath = downLoadPath +"\\" +fileName; 
		System.out.println("M : dFilePath" + dFilePath);

		
		//파일을 저장할 버퍼(배열)
		byte[] b = new byte[4096]; //총 4096 byte == 4KB 
		
		
		//파일 입출력 
		FileInputStream fis = new FileInputStream(dFilePath); 
		
		//파일의 MIME 타입 확인 
		String dMimeType = context.getMimeType(dFilePath);
		System.out.println("M: dMimeType :"+dMimeType);
		
		if(dMimeType == null) {
			dMimeType = "applicaiton/octet-stream";
			// => 알려지지 않은 이진 파일 형태로 설정
			// => 브라우저가 자동실행 X , 확인창 
		}
		
		// 응답 데이터 형태를 (다운로드할) MIME타입으로 설정
		response.setContentType(dMimeType);
		
		//(ie) 브라우저에 따른 인코딩 설정
		String agent = request.getHeader("User-Agent");
		boolean ieBrowser= agent.indexOf("MSIE") > -1 || agent.indexOf("Trident") > -1;
		if(ieBrowser) {//ie 브라우저일때 
			fileName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
		} else {//나머지 브라우저일때
			fileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
		}
		
		//다운로드 정보 출력
		response.setHeader("Content-Disposition", "attachment; filename="+fileName);
		//=>모든 형태의 다운로드를 다운로드 창으로 표시 
		
		//PrintWriter out = response.getWriter();
		//out.println("<html>");
		
		ServletOutputStream out2 = response.getOutputStream();
		
		int data = 0;
		while( ( data = fis.read(b,0,b.length) ) != -1) {
			out2.write(b,0,data);
		}
		
		out2.flush();
		out2.close();
		fis.close();
		
		return null;
	}

}
