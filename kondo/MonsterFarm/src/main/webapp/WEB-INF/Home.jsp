<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Servlet.User" %> 
<%@page import="Servlet.CookieTest"%>

<%
//User user = (User) session.getAttribute("userID");
//String id = user.getId();

 //Cookieから"test_cookie_name"というKeyで登録された値(文字列)を取り出す
// String value = CookieTest.getCookie(request, "id");

  //valueがnullの場合のみCookieをセットする(期限は5分)
// if (value == null) {
// CookieTest.setCookie(request, response, "/", "id", id,  -1);
// }
  
%>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Home

<script>var cookies = document.cookie;
var cookiesArray = cookies.split(';');

for(var c of cookiesArray){
    var cArray = c.split('=');

    var pattern = "id";   // 正規表現の条件
    if( cArray[0].match(pattern) ){  // keyになる文字列が正規表現にマッチしたら
      console.log(cArray[1]);
    }
}
//console.log(document.cookie["id"]);


</script>

<p>下記のユーザーを登録します</p>

<p>
登録完了
</p>



<form>
<input type="button" value="ログアウト" onclick="location.href='Logout'">
</form>

</body>
</html>