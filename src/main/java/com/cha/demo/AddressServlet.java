package com.cha.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addr/*")
public class AddressServlet extends HttpServlet {

	AddrDB db = new AddrDB();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인코딩 설정
		response.setCharacterEncoding("utf-8"); // tomcat에게 utf-8처리해서 보내라
		response.setContentType("text/html; charset=utf-8"); // 브라우저한테 내가 보내는 걸 utf-8로 처리해라

		String uri = request.getRequestURI();

		String[] uriPieces = uri.split("/");

		if (uriPieces.length < 3) {
			// 에러페이지
			System.out.println("잘못된 요청입니다.");
			return;
		}

		String func = uriPieces[2];

		if (func.equals("add")) {

			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");

			// 주소록 추가
			db.insertData(name, address, phone);
			list(request, response);
			
		} else if (func.equals("list")) {
			list(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주소록 조회
		ArrayList<Addr> addrList = db.selectDatas(); // 목적데이터

		// request 객체에 필요한 정보 저장
		request.setAttribute("addrList", addrList);

		// request 객체를 다른 서블릿으로 넘긴다 -> 포워딩
		// 서버 루트 경로 --> / (webapp)
		RequestDispatcher rd = request.getRequestDispatcher("/list.jsp"); // list.jsp로 포워딩하겠다.
		rd.forward(request, response); // list.jsp로 두객체가 넘어간다.

	}

}