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
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="<c:url value='/resources/css/member/loginForm.css'/> ">
</head>
<style>
    .loginBtn{
        /*disabled : true;*/
        /*background-color:#dddddd;*/
        /*border-color: #dddddd;*/
    }
    input[type=text]{
        width: 340px;

    }
</style>
<body>
<form id="frm" action="<c:out value='/member/find/password/reset/${email}'/>" method="POST">
    <input type="hidden" name="_method" value="PATCH">
    <section>
        <div class="modal">
            <div class="modal_content_body">
                <span id="modal_content"></span>
                <!-- modalContent -->
            </div>
        </div>
        <span class="login-header">비밀번호 재설정</span>
        <div class="login-div">
            <div class="email-div">
                <div class="register-div__label">새 비밀번호 등록</div>
                <input
                        class="login-div__column"
                        id="pwd"
                        type="text"
                        name="pwd"
                        placeholder="새 비밀번호를 입력해주세요"
                        maxlength="33"
                />
            </div>
                <div class="email-div">
                <div class="register-div__label">새 비밀번호 확인</div>
                <input
                        class="login-div__column"
                        id="pwdChk"
                        type="text"
                        name="pwdChk"
                        placeholder="새 비밀번호를 한 번 더 입력해주세요"
                        maxlength="33"
                />
            </div>
            <button class="login-div__column loginBtn">확인</button>
        </div>

    </section>
    </form>
    <script>

    </script>
</body>
</html>