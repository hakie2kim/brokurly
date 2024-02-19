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
    <link rel="stylesheet" href="<c:url value='/resources/css/member/loginForm.css'/>"/>
    <title>로그인</title>
</head>
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
        <button onclick="location.href=signup" class="login-div__column regBtn">회원가입</button>
        <span onclick="loginWithKakao()">카카오</span>
    </div>
</section>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
<script>
    window.onload = function(){
        Kakao.init('fe1e90401e6f79d66eb56c138430a308'); // sdk 초기화 및 사용할 앱의 키 설정
        Kakao.isInitialized(); // SDK 초기화 여부를 판단
    };


    function loginWithKakao(){
        Kakao.Auth.authorize({
           redirectUri: 'http://localhost:80/kakao_callback'
        });
    }
</script>
</body>
</html>
