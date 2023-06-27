<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Logout</title>
<style>
    body {
        background-color: #ffffff;
        text-align: center;
    }
    div.container {
        width: 400px;
        margin: 100px auto;
    }
    h1 {
        color: #374a12;
    }
    a {
        color: #374a12;
        text-decoration: none;
        margin-top: 10px;
        display: inline-block;
    }
</style>
</head>
<body>
    <div class="container">
        <% 
        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement().toString();
            String value = session.getAttribute(name).toString();
            session.removeAttribute(name);
        }
        %>
        <h1>로그아웃 되었습니다.</h1>
        <br/>
        <a href="main.jsp">메인페이지</a>
        <a href="login.jsp">다시 로그인</a>
    </div>
</body>
</html>
