package com.ssafy.ws.step5.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.ws.step5.dto.User;
import com.ssafy.ws.step5.manager.UserManager;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getParameter("action");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickname");
		String email = request.getParameter("email");
		System.out.println(action+","+userId+","+password+","+passwordCheck+","+userName+","+nickName+","+email);
		switch(action) {
		case "signup" :
			doSignup(request,response);
			break;
		case "login" :
			break;
		case "logout" :
			break;
		}
	}

	//회원가입
	private void doSignup(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String action = request.getParameter("action");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickname");
		String email = request.getParameter("email");
		// 비밀번호 체크
		// 아이디 중복 검사
		if(password.equals(passwordCheck)) {
			User user = new User(0,userId,password,userName, nickName, email);
			UserManager.getInstance().addUser(user);
			// 바로 로그인 처리
			// 세션에 로그인된 유저를 넣으면됨
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", UserManager.getInstance().getUser(userId, password));
			response.sendRedirect("index.jsp");
			return;
			//페이지 이동하는 2가지 방식
			//1. redirect : 새로운 페이지를 요청 (기존의 request, response가 아닌), 단절
			//2. forward : request, response를 가지고 요청
			
		}
		
		//request에 msg저장
		request.setAttribute("msg", "회원가입실패");
		request.getRequestDispatcher("user/fail.jsp").forward(request, response);
	}
}
