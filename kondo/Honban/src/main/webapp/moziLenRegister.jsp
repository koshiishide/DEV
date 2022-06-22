<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>moziLenRegi</title>
</head>
<body>
<h1>長すぎます。もう一度入力してください。</h1>

<form action="WelcomeServlet" method="post">
<input type="hidden" name="hidden" value="register">
ユーザーid:<input type="text" name="id"><br>
パスワード:<input type="password" name="password"><br>
<input type="submit" value="新規登録"><br>
</form>


</body>
</html>