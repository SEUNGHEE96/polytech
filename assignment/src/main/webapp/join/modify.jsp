<%@page import="dto.UsersDTO"%>
<%@page import="dao.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Modify Information</title>
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
    form {
        text-align: left;
    }
    label {
        display: block;
        margin-top: 10px;
        color: #374a12;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 5px;
        font-size: 16px;
    }
    input[type="submit"],
    input[type="reset"] {
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #374a12;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #293907;
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
        String id;
        String pw;
        String name;
        String phone;
        String email;
        String auth;

        id = request.getParameter("id");
        pw = request.getParameter("pw");
        auth = (String) session.getAttribute("auth");

        if (id == null) {
            id = (String) session.getAttribute("id");
        }
        if (pw == null) {
            pw = (String) session.getAttribute("pw");
        }

        UsersDAO md = new UsersDAO();
        UsersDTO dto = md.selectMember(id, pw);

        name = dto.getName();
        phone = dto.getPhone();
        email = dto.getEmail();
        %>

        <h1>수정할 정보</h1>
        <form action="modifyOk.jsp" method="post">
            <input type="hidden" name="id" value="<%=id %>">
            <input type="hidden" name="pw" value="<%=pw %>">
            <label for="newPw">비밀번호:</label>
            <input type="password" id="newPw" name="newPw" placeholder="<%=pw %>" required>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" placeholder="<%=name %>" required>
            <% if (auth.equals("N")) { %>
            <label for="phone">전화번호:</label>
            <input type="text" id="phone" name="phone" placeholder="<%=phone %>" required>
            <% } else { %>
            <input type="hidden" name="phone" value="<%=phone %>">
            <% } %>
            <label for="email">이메일:</label>
            <input type="text" id="email" name="email" placeholder="<%=email %>" required>
            <input type="submit" value="전송">
            <input type="reset" value="초기화">
        </form>
        <a href="main.jsp">메인페이지</a>
    </div>
</body>
</html>
