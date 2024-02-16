<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 스크립틀릿 - 자바 문법 작성가능

	// < ssr > 서버사이드 렌더링
	
	// * model1 - html 사이사이에 코드를 정의하는 것
	// <h1>Hello</h1>
	// <%
	// 	String name = "김준일";
	//  % >
	// <ul>
	//	<li><%=name % > </li>
	// </ul>
				
	// * model2 - 사이사이에 코드를 정의 없이 맨위에 선언 변수를 몰아넣는 것
	
	// * mvc(model, view, controller)
	//	model -> 데이터 	=>	DTO 역할
	//	view -> html(화면)	=>	HTML, JSP 역할
	//	controller -> model, view를 제어, 요청, 응답 처리 => servlet 역할
	
	// WEB-INF 폴더 안에 파일을 넣으면 접근 불가
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>
	<%
		String name = "김준일";
	%>
	<ul>
		<li><%=name %></li>
	</ul>
</body>
</html>