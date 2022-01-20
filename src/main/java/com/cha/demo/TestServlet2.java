package com.cha.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sbs2")
public class TestServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트 브라우저에 응답
		// request => 요청에 관한 다양한 정보와 기능들이 모여있음. 입력도구
		// response => 응답에 관한 다양한 정보와 기능들이 모여있음. 출력도구
		
		// 인코딩 설정
		response.setCharacterEncoding("utf-8"); // tomcat에게 utf-8처리해서 보내라
		response.setContentType("text/html; charset=utf-8"); // 브라우저한테 내가 보내는 걸 utf-8로 처리해라 
		
		PrintWriter out = response.getWriter();				
		out.println("<h1>구구단</h1>");

		
		// 이쯤에서 고객이 넘긴 dan 값을 사용해야 함.
		// 고객이 넘긴 데이터 == 요청 파라미터
		// 요청 파라미터를 꺼내는 방법 -> request.getPrameter()
		// 무조건 String으로 반환됨.
		// 
		String sdan = request.getParameter("dan");		
		int dan = Integer.parseInt(sdan);
		
		String sgop = request.getParameter("gop");
		int gop = Integer.parseInt(sgop);
		
		out.println("===" + dan + "단 === <br />");
		for(int i = 1; i <= gop; i++) {
			out.println(dan + " X " + i + " = " + dan * i + "<br />");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
