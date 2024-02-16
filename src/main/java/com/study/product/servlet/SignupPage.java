package com.study.product.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/signup")
public class SignupPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupPage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ServletContext 전역 객체
		// 사용주기: 서버가 켜지고 꺼질 때까지 저장공간이 살아있다.
		ServletContext application = request.getServletContext();
		application.setAttribute("key4", "value1");
		application.setAttribute("key2", "value2");
		application.setAttribute("key3", "value3");
		
		// 사용주기: 요청이 들어오고 응답이 될 때까지 저장공간이 살아있다.
		// 들어올때마다 새로운 공간 생성
		request.setAttribute("key4", "ㅎ-ㅎ");
		request.setAttribute("key5", "ㅋ-ㅋ");
		request.setAttribute("key6", "value6");
		
		// 사용주기: 서버가 켜지고 꺼질 때까지 또는 세션 만료 시간까지 저장공간이 살아있다.	
		// 한번 저장되면 나갔다들어와도 공간 유지 but, 만료기간이 있음
		HttpSession session = request.getSession();
		session.setAttribute("key4", "value7");
		session.setAttribute("key8", "value8");
		session.setAttribute("key9", "value9");
		
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}
}
