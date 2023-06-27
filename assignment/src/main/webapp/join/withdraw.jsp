<%@page import="join.UsersDTO"%>
<%@page import="join.UsersDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Withdrawal Requests</title>
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
        <h1>Ż�� ��û ���</h1>
        <% 
        UsersDAO usersDAO = new UsersDAO();
        ArrayList<UsersDTO> dtos = usersDAO.memberSelect("4");
        %>
        <form action="result.jsp" method="post">
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>���̵�</th>
                        <th>��й�ȣ</th>
                        <th>�̸�</th>
                        <th>����ó</th>
                        <th>�̸���</th>
                        <th>����</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    for (int i = 0; i < dtos.size(); i++) {
                        UsersDTO dto = dtos.get(i);

                        String id = dto.getId();
                        String pw = dto.getPw();
                        String name = dto.getName();
                        String phone = dto.getPhone();
                        String email = dto.getEmail();
                    %>
                    <tr>
                        <td><%=i+1 %></td>
                        <td><%=id%></td>
                        <td><%=pw%></td>
                        <td><%=name%></td>
                        <td>010-XXXX-XXXX</td>
                        <td><%=email %></td>
                        <td><input type="checkbox" name="<%=id%>" value="5"></td>
                    </tr>
                    <% 
                    }
                    %>
                </tbody>
            </table>
            <input type="submit" value="����">
            <input type="reset" value="�ʱ�ȭ">
        </form>
        <a href="main.jsp">����������</a>
    </div>
</body>
</html>
