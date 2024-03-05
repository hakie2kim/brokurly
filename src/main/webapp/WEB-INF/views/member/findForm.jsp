<%--
  Created by IntelliJ IDEA.
  User: Sora
  Date: 2024-03-02
  Time: 오후 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="preconnect" href="https://fonts.googleapis.com%22%3E"/>
    <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
            rel="stylesheet"
    />
    <title>비밀번호 재설정</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/member/loginForm.css'/> ">
</head>
<body>
<form action="<c:url value='/member/login'/>" method="POST">
    <input type="hidden" name="_method" value="POST">
    <section>
        <span class="login-header">비밀번호 재설정</span>
        <div class="login-div">
            <div class="email-div">
            <input
                    class="login-div__column"
                    type="text"
                    name="email"
                    placeholder="가입하신 이메일을 입력해주세요"
            />
                <button>확인</button>
            </div>
            <button class="login-div__column loginBtn">인증번호 보내기</button>
        </div>
    </section>
</form>
</body>
</html>