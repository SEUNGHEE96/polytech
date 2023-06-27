<%@page import="join.UsersDTO"%>
<%@page import="join.UsersDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Change Member Status</title>
<style>
    body {
        background-color: #ffffff;
    }
    div.container {
        width: 800px;
        margin: 50px auto;
        text-align: center;
    }
    h1 {
        color: #374a12;
    }
    table {
        margin-top: 20px;
        width: 100%;
        border-collapse: collapse;
    }
    table th,
    table td {
        padding: 10px;
        border: 1px solid #374a12;
    }
    input[type="submit"],
    input[type="reset"] {
        margin-top: 10px;
        padding: 10px;
        background-color: #374a12;
        color: #ffffff;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #537a1e;
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
        <h1>일반 회원 목록</h1>
        <% 
        UsersDAO usersDAO = new UsersDAO();
        ArrayList<UsersDTO> dtos = usersDAO.memberSelect("2");
        ArrayList<UsersDTO> dtos2 = usersDAO.memberSelect("3");
        for (UsersDTO dto : dtos2) {
            dtos.add(dto);
        }
        %>
        <form action="result.jsp" method="post">
            <table>
                <tr>
                    <th>아이디</th>
                    <th>비밀번호</th>
                    <th>이름</th>
                    <th>정보수정</th>
                    <th>정상</th>
                    <th>일시정지</th>
                </tr>
                <% 
                for (int i = 0; i < dtos.size(); i++) {
                    UsersDTO dto = dtos.get(i);

                    String id = dto.getId();
                    String pw = dto.getPw();
                    String name = dto.getName();
                    String phone = dto.getPhone();
                %>
                <tr>
                    <td><%=id%></td>
                    <td><%=pw%></td>
                    <td><%=name%></td>
                    <td><a href="modify.jsp?id=<%=id %>&pw=<%=pw %>">수정하기</a></td>
                    <% if (dto.getStatus().equals("2")) { %>
                    <td><input type="radio" name="<%=id%>" value="2" checked="checked">정상</td>
                    <td><input type="radio" name="<%=id%>" value="3">일시정지</td>
                    <% } else if (dto.getStatus().equals("3")) { %>
                    <td><input type="radio" name="<%=id%>" value="2">정상</td>
                    <td><input type="radio" name="<%=id%>" value="3" checked="checked">일시정지</td>
                    <% } %>
                </tr>
                <% 
                }
                %>
            </table>
            <input type="submit" value="전송">
            <input type="reset" value="초기화">
        </form>
        <a href="main.jsp">메인페이지</a>
    </div>
</body>
</html>
