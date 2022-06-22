<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文字数超過</title>
</head>
<body>
<h1>短すぎます。もう一度入力してください。</h1>

<form action="WelcomeServlet" method="post">
<input type="hidden" name="hidden" value="login">
ユーザーid:<input type="text" name="id"><br>
パスワード:<input type="password" name="password"><br>
<input type="submit" value="ログイン"><br>

</form>

</body>
</html>