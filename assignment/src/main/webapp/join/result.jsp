<%@page import="join.UsersDTO"%>
<%@page import="join.UsersDAO"%>
<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Update Member Status - Result</title>
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
        int result = 0;

        UsersDAO usersDAO = new UsersDAO();
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            result += usersDAO.updateStatus("STATUS", paramValue, paramName);
        }
        %>

        <h1><%= result %> 명의 회원이 변경되었습니다.</h1>
        <a href="main.jsp">메인페이지</a>
    </div>
</body>
</html>
