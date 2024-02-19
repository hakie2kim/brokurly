<%--
  Created by IntelliJ IDEA.
  User: hakjun
  Date: 2024-02-02
  Time: 오후 2:56
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
    <link rel="preconnect" href="https://fonts.googleapis.com%22%3E/
    <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
            rel="stylesheet"
    />
    <title>로그인</title>
</head>
<style>
    :root {
        --main-color: #11967f;
        --main-font: "Noto Sans KR", sans-serif;
        --main-border-radius: 3px;
    }

    body {
        font-family: var(--main-font);
    }
    section {
        height: 100vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    .login-div {
        width: 340px;
        height: 295px;
        display: flex;
        flex-direction: column;
        justify-content: space-evenly;
    }

    .login-div__column {
        height: 54px;
        margin-bottom: 10px;
    }
    .find-div {
        display: flex;
        justify-content: flex-end;
        font-size: 13px;
        color: #333;
        cursor: pointer;
        padding-bottom: 20px;
    }

    a {
        text-decoration: none;
        color: #333;
    }

    .loginBtn,
    .regBtn {
        font-size: 16px;
        font-weight: 500;
        border-radius: var(--main-border-radius);
    }

    .loginBtn {
        background-color: var(--main-color);
        border: none;
        color: white;
        margin-bottom: 10px;
    }
    .regBtn {
        background-color: white;
        border: 1px solid var(--main-color);
        color: var(--main-color);
    }

    input[type="text"] {
        border-radius: var(--main-border-radius);
        border: 1px solid rgb(221, 221, 221);
    }

    ::placeholder {
        font-size: 14px;
        padding: 0 11px 1px 15px;
    }

    .login-header {
        font-size: 20px;
        font-weight: 800;
        line-height: 20px;
        margin-bottom: 20px;
    }
</style>
<body>
<section>
    <span class="login-header">로그인</span>
    <div class="login-div">
        <input
                class="login-div__column"
                type="text"
                name="id"
                placeholder="아이디를 입력해주세요"
        />
        <input
                class="login-div__column"
                type="text"
                name="pwd"
                placeholder="비밀번호를 입력해주세요"
        />
        <div class="find-div">
            <a href="#"><span>아이디 찾기</span></a
            >&nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="#"><span>비밀번호 찾기</span></a>
        </div>
        <button class="login-div__column loginBtn">로그인</button>
        <button class="login-div__column regBtn">회원가입</button>
    </div>
</section>
</body>
</html>
