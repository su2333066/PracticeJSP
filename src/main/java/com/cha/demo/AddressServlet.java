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

@WebServlet("/addr")
public class AddressServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		AddrDB db = new AddrDB();
		
		int menu = Integer.parseInt(request.getParameter("menu"));
		
		switch(menu) {
			
		case 1: 
			
			//주소록 삽입
			db.insertData();
			
			ArrayList<Addr> addrList = db.selectDatas();
			
			request.setAttribute("list", addrList);
					
			RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
			rd.forward(request, response);
			
		
		case 2:
			
			//주소록 조회
			ArrayList<Addr> addrList2 = db.selectDatas();
					
			request.setAttribute("list", addrList2);
					
			RequestDispatcher rd2 = request.getRequestDispatcher("/list.jsp");
			rd2.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


