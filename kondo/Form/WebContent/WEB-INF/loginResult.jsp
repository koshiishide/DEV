<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="main.Java.User" %>

<% User loginUser = (User) session.getAttribute("loginUser"); 
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<% if(loginUser != null) { %>
  <p>ログインに成功しました</p>
  
  <%
    application.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response); // B.jspへフォワード
%>
    
<%} else { %> 
  <p>ログインに失敗しました</p>
  
<%} %>  
</body>
</html>