<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<style>
    body {
        background-color: #ffffff;
    }
    .container {
        width: 600px;
        margin: 50px auto;
    }
    label {
        display: block;
        margin-bottom: 10px;
        color: #374a12;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 5px;
        margin-bottom: 10px;
    }
    button[type="submit"],
    input[type="reset"] {
        padding: 10px;
        background-color: #374a12;
        color: #ffffff;
        border: none;
        cursor: pointer;
    }
    button[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #567e26;
    }
</style>
</head>
<body>
    <div class="container">
        <form action="joinOk.jsp" method="post" onsubmit="return validate()" class="needs-validation">
            <label>아이디:</label>
            <input type="text" name="id" required>
            <label>비밀번호:</label>
            <input type="password" name="pw" id="pw" required>
            <label>이름:</label>
            <input type="text" name="name" required>
            <label>전화번호:</label>
            <input type="text" name="phone" required>
            <label>이메일:</label>
            <input type="text" name="phone2" required>
            <button type="submit">가입</button>
            <input type="reset" value="초기화">
        </form>
    </div>
    <script>
        function validate() {
            let pw = document.getElementById("pw").value;
            let number = pw.search(/[0-9]/g);
            let english = pw.search(/[a-z]/ig);
            let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;

            if (pw.length < 4) {
                alert("4자리 이상으로 입력해주세요.");
                return false;
            } else if (pw.search(/\s/) != -1) {
                alert("비밀번호는 공백 없이 입력해주세요.");
                return false;
            } else if (number < 0 || english < 0) {
                alert("영문과 숫자를 혼합하여 입력해주세요.");
                return false;
            } else {
                return true;
            }
        }
    </script>
</body>
</html>
