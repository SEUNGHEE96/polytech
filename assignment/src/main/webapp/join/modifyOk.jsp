<%@page import="dto.UsersDTO"%>
<%@page import="dao.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Modify Information - Result</title>
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
        UsersDAO md = new UsersDAO();

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String newPw = request.getParameter("newPw");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        UsersDTO loginDto = md.selectMember(id, pw);
        UsersDTO dto = new UsersDTO(id, newPw, name, phone, email, loginDto.getStatus(), loginDto.getAuth());
        UsersDTO updateDto = md.updateMember(dto);

        if (updateDto != null) {
            %>
            <h1>ȸ�� ������ �����ϼ̽��ϴ�.</h1>
            <p>���̵�: <%=id %></p>
            <p>��й�ȣ: <%=newPw %></p>
            <p>�̸�: <%=name %></p>
            <%
            session.setAttribute("pw", newPw);
        } else {
            %>
            <h1>���� ������ �����ϼ̽��ϴ�.</h1>
            <%
        }
        %>
        <a href="main.jsp">����������</a>
    </div>
</body>
</html>