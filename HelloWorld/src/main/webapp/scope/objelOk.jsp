<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
    %>

    ���̵� : <%= id %> <br />
    ��й�ȣ : <%=pw %> <br />

    <hr />
    ���̵� : ${ param.id } <br />
    ��й�ȣ : ${ param.pw } <br />
    ���̵� : ${ param["id"] } <br />
    ��й�ȣ : ${ param["pw"] } <br />
    <hr />

    applicationScope : ${ applicationScope.application_name }<br />
    sessionScope : ${ sessionScope.session_name }<br />
    pageScope : ${ pageScope.page_name }<br />
    requestScope : ${ requestScope.request_name }

    <hr />
    context �ʱ�ȭ �Ķ����<br />
    ${ initParam.dbId } <br />
    ${ initParam.dbPwd } <br />
    ${ initParam.dbSid } <br />
</body>
</html>