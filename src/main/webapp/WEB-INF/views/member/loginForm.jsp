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
    <link rel="preconnect" href="https://fonts.googleapis.com%22%3E"/>
    <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
            rel="stylesheet"
    />
    <link rel="stylesheet" href="<c:url value='/resources/css/member/loginForm.css'/>"/>
    <title>로그인</title>
</head>
<body>
<form action="<c:url value='/member/login'/>" method="POST">
    <input type="hidden" name="_method" value="POST">
    <section>
        <span class="login-header">로그인</span>
        <div class="login-div">
            <input
                    class="login-div__column"
                    type="text"
                    name="custId"
                    placeholder="아이디를 입력해주세요"
            />
            <input
                    class="login-div__column"
                    type="text"
                    name="pwd"
                    placeholder="비밀번호를 입력해주세요"
            />
            <input type="hidden" name="reqURI" value="${param.redirectURL}">
            <div class="find-div">
                <a href="<c:url value='/member/find/password'/>"><span>비밀번호 재설정</span></a>
            </div>
            <button class="login-div__column loginBtn">로그인</button>
            <button onclick="location.href='/member/signup'" class="login-div__column regBtn">회원가입</button>
            <div class="col-lg-12 text-center mt-3">
                <img alt="카카오로그인" src="<c:url value='/resources/image/kakao_login_medium_wide.png'/>" onclick="loginWithKakao()">
            </div>
        </div>
    </section>
</form>

<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
<script>
    window.onload = function(){
        Kakao.init('b99b74015501ea2e7067d2dd45d23223'); // sdk 초기화 및 사용할 앱의 키 설정
        Kakao.isInitialized(); // SDK 초기화 여부를 판단
        console.log(Kakao.isInitialized());
    };


    function loginWithKakao(){
        Kakao.Auth.authorize({
            redirectUri: 'http://localhost:8080/kakao_callback'
        });
    }
</script>
</body>
</html>