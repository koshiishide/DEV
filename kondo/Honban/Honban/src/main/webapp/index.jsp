<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォーム</title>
</head>
<body>
<h1>ログイン</h1>

<form action="WelcomeServlet" method="post">
<input type="hidden" name="hidden" value="login">
ユーザーid:<input type="text" name="id"><br>
パスワード:<input type="password" name="password"><br>
<input type="submit" value="ログイン"><br>
</form>

<form>
 <input type="button" onclick="location.href='./shinki.jsp'" value="新規登録">
</form>


</body>