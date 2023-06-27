<%@page import="join.UsersDTO"%>
<%@page import="join.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Main Page</title>
<style>
    body {
        background-color: #ffffff;
    }
    div.container {
        width: 600px;
        margin: 50px auto;
        text-align: center;
    }
    h1 {
        color: #374a12;
    }
    button {
        margin-top: 10px;
        padding: 10px;
        background-color: #374a12;
        color: #ffffff;
        border: none;
        cursor: pointer;
    }
    button a {
        text-decoration: none;
        color: #ffffff;
    }
    table {
        margin-top: 20px;
        width: 500px;
        border-collapse: collapse;
    }
    table td {
        padding: 10px;
        border: 1px solid #374a12;
    }
</style>
</head>
<body>
    <div class="container">
        <%!
        String id;
        String pw;
        String auth;
        %>
        
        <%
        id = (String) session.getAttribute("id");
        pw = (String) session.getAttribute("pw");
        auth = (String) session.getAttribute("auth");
        UsersDAO md = new UsersDAO();
        UsersDTO dto = md.selectMember(id, pw);
        %>
        
        <% if(dto == null) {%> 
            로그인 전 입니다. <br/>
            <button type="button"><a href="login.jsp">로그인</a></button>
            <button type="button"><a href="join.jsp">회원가입</a></button>
        <% } else if (id != null ) { 
            if (auth.equals("N")) { %>
                <h1>일반 사용자</h1>
        <%	} else if (auth.equals("Y")) { %>
                <h1>관리자 페이지</h1>
                <button type="button"><a href="approveJoin.jsp">가입승인</a></button>
                <button type="button"><a href="withdraw.jsp">탈퇴승인</a></button>
                <button type="button"><a href="change.jsp">회원상태변경</a></button>
        <% } %>
                <button type="button"><a href="logout.jsp">로그아웃</a></button>
                
                <table>
                    <tr>
                        <td>아이디</td>
                        <td><%=id %></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><%=pw %></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><%=dto.getName() %></td>
                    </tr>
                    <tr>
                        <td>연락처</td>
                        <td><%=dto.getPhone() %></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><%=dto.getEmail() %></td>
                    </tr>
                </table>
        <% } %>
    </div>
</body>
</html>
