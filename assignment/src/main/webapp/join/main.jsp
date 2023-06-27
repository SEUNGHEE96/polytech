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
            �α��� �� �Դϴ�. <br/>
            <button type="button"><a href="login.jsp">�α���</a></button>
            <button type="button"><a href="join.jsp">ȸ������</a></button>
        <% } else if (id != null ) { 
            if (auth.equals("N")) { %>
                <h1>�Ϲ� �����</h1>
        <%	} else if (auth.equals("Y")) { %>
                <h1>������ ������</h1>
                <button type="button"><a href="approveJoin.jsp">���Խ���</a></button>
                <button type="button"><a href="withdraw.jsp">Ż�����</a></button>
                <button type="button"><a href="change.jsp">ȸ�����º���</a></button>
        <% } %>
                <button type="button"><a href="logout.jsp">�α׾ƿ�</a></button>
                
                <table>
                    <tr>
                        <td>���̵�</td>
                        <td><%=id %></td>
                    </tr>
                    <tr>
                        <td>��й�ȣ</td>
                        <td><%=pw %></td>
                    </tr>
                    <tr>
                        <td>�̸�</td>
                        <td><%=dto.getName() %></td>
                    </tr>
                    <tr>
                        <td>����ó</td>
                        <td><%=dto.getPhone() %></td>
                    </tr>
                    <tr>
                        <td>�̸���</td>
                        <td><%=dto.getEmail() %></td>
                    </tr>
                </table>
        <% } %>
    </div>
</body>
</html>
