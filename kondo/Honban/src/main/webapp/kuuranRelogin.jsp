<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relogin</title>
</head>
<body>

<h1>記入欄が空欄です。もう一度、入力してください。</h1>

<form action="WelcomeServlet" method="post">
<input type="hidden" name="hidden" value="login">
ユーザーid:<input type="text" name="id"><br>
パスワード:<input type="password" name="password"><br>
<input type="submit" value="ログイン"><br>
</form>

</body>
</html>