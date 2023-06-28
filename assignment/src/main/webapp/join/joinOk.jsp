<%@page import="dto.UsersDTO"%>
<%@page import="dao.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Result</title>
<style>
    body {
        background-color: #ffffff;
    }
    .container {
        width: 600px;
        margin: 50px auto;
        text-align: center;
    }
    button {
        padding: 10px 20px;
        margin-top: 10px;
        background-color: #374a12;
        color: #ffffff;
        border: none;
        cursor: pointer;
        text-decoration: none;
    }
    button a {
        color: #ffffff;
        text-decoration: none;
    }
</style>
</head>
<body>
    <div class="container">
        <% 
        UsersDAO md = new UsersDAO();
    
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        UsersDTO dto = new UsersDTO(id, pw, name, phone, email);
        int result = md.insertMember(dto);
        
        if (result >= 1) { %> 
            회원가입에 성공하셨습니다.<br>
            <button type="button"><a href="login.jsp">로그인</a></button>
            <button type="button"><a href="main.jsp">메인페이지</a></button>
        <% } else { %>
            회원가입에 실패하셨습니다.<br>
            <button type="button"><a href="join.jsp">회원가입</a></button>
        <% } %>
    </div>
</body>
</html>
