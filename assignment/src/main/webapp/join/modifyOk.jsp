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
            <h1>회원 정보를 수정하셨습니다.</h1>
            <p>아이디: <%=id %></p>
            <p>비밀번호: <%=newPw %></p>
            <p>이름: <%=name %></p>
            <%
            session.setAttribute("pw", newPw);
        } else {
            %>
            <h1>정보 수정에 실패하셨습니다.</h1>
            <%
        }
        %>
        <a href="main.jsp">메인페이지</a>
    </div>
</body>
</html>