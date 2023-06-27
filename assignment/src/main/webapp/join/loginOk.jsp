<%@page import="join.UsersDTO"%>
<%@page import="join.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login Result</title>
<style>
    body {
        background-color: #ffffff;
    }
    div.container {
        width: 600px;
        margin: 50px auto;
        text-align: center;
    }
    a {
        display: inline-block;
        margin: 10px;
        padding: 10px;
        background-color: #374a12;
        color: #ffffff;
        text-decoration: none;
    }
</style>
</head>
<body>
    <div class="container">
        <%!
        String id;
        String pw;
        %>
        
        <%
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        
        UsersDAO md = new UsersDAO();
        UsersDTO dto = md.selectMember(id, pw);
        
        if (dto != null) {
            if(dto.getStatus().equals("1")) {
                out.println("아직 가입 승인 전입니다. <br/>");
            } else if (dto.getStatus().equals("2")) {
                if (dto.getAuth().equals("N")) {
                    session.setAttribute("auth", "N");
                } else if (dto.getAuth().equals("Y")) {
                    session.setAttribute("auth", "Y");
                }
                session.setAttribute("id", id);
                session.setAttribute("pw", pw);
                response.sendRedirect("main.jsp");
            } else if (dto.getStatus().equals("3")) {
                out.println("일시정지된 유저입니다. <br/>");
            } else if (dto.getStatus().equals("4")) {
                out.println("탈퇴 신청한 유저입니다. <br/>");
            } else if (dto.getStatus().equals("5")) {
                out.println("탈퇴 완료된 유저입니다. <br/>");
            }
        } else {
            out.println("정보가 틀렸습니다");
        }
        %>
        <div>
            <a href="main.jsp">메인페이지</a>
            <a href="login.jsp">다시로그인</a>
        </div>
    </div>
</body>
</html>
