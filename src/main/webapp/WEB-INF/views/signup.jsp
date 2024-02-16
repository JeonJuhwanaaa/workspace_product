<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  
<%
	//	내장 객체 (servlet 객체 사용)
	
	//	<저장소> 
	
	//	application	객체 저장소
	//	생명주기:	서버가 켜지고 꺼질 때까지 저장공간이 살아있다.
	
	//	request	객체 저장소
	//	생명주기:	요청이 들어오고 응답이 될 때까지 저장공간이 살아있다.
	
	//	session 객체 저장소 주로 사용
	//	생명주기:	서버가 켜지고 꺼질 때까지 또는 세션 만료 시간까지 저장공간이 살아있다.	
	
	// ${} EL 을쓰면 다운케스팅 사용안해도 된다
	
	// 저장소에 같은 키값이 application, request, session 에 있다면 첫번째로 request를 가져온다
	// request -> session -> application 순서로 우선순위가 다르다
	
	// 다운케스팅해줘야한다
	// String value4 = (String) request.getAttribute("key4");
	// String value44 = (String) application.getAttribute("key4");
	// String value444 = (String) session.getAttribute("key4");
%> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" placeholder="username">
	<input type="password" placeholder="password">
	<input type="text" placeholder="name">
	<input type="email" placeholder="email">
	
	<button onclick="handleSignupSubmit();">회원가입</button>
	
	<img src="/product/hellotest/java.png">
	
	<script src="/product/static/js/signup.js"></script>
</body>
</html>