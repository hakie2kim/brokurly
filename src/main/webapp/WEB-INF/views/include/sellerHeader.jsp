<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sookyung
  Date: 2024/03/11
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<%--<c:set var="loginSession" value="${pageContext.request.getSession(false)==null ? '로그인' : pageContext.request.session.getAttribute('loginName')+=''}"/>--%>


<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>

    <link rel="preconnect" href="https://fonts.googleapis.com%22%3E/">
    <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">


    <title>Title</title>
    <style>

        <%--    header    --%>
        * {
            padding: 0;
            margin: 0;
        }


        .whole {
            position: fixed;
            z-index: 20;
            margin-bottom: 55px;
        }

        body {
            position: relative;
            height: 100%;
            min-height: 100%;
            font-family: "Noto Sans KR", sans-serif;
            line-height: 20px;
            color: #4d5159;
            background-color: #edf0f5;
            font-size: 13px;
        }


        /* 상단 네비 */
        .header_ul {
            background-color: #003103;
            margin: 0;
            height: 55px;
            width: 30000px;
            spadding-left: 20px;

        }

        .header_li {
            list-style: none;
            display: inline-block;
            padding: 15px;
            margin: auto;
        }

        .header_a {
            display: block;
            text-decoration: none;
            color: white;
        }

        #top_navi > li:hover {
            background-color: black;
        }

        .logo {
            width: 50px;
            height: 100%;
            z-index: 1;
        }


        /*왼쪽 네비*/

        .submenu {
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 20%;
            background-color: #034007;
            color: white;
            position: fixed;
            height: 100%;
            overflow: auto;
        }

        .submenu_a {
            display: block;
            color: white;
            padding: 8px 16px;
            text-decoration: none;
        }

        .submenu_a.active {
            background-color: #04AA6D;
            color: white;
        }

        .submenu_a:hover:not(.active) {
            background-color: #555;
            color: white;
        }

    </style>


</head>
<body>

<div class="whole">


    <!-- 상단네비 -->
    <div id="top_navi" class="top_navi">
        <ul class="header_ul">
            <li class="header_li"><a class="header_a" href="/categories/best-page"><img src="/resources/image/brokurlyAdmin.png" class="logo"
                                                           style="width: 50px; height: 20px;"></a></li>
            <li class="header_li"><a class="header_a" href="/categories/best-page">브로컬리</a></li>
            <li class="header_li"><a class="header_a" href="">관리자센터</a></li>

        </ul>
    </div>

    <!-- 왼쪽 네비 -->

    <div class="submenu">

    <br><br>

        <ul role="menu" class="" style="margin: 15px">상품관리<!---->

            <li><!---->
                <a href="/seller/productsOriginList" class="submenu_a">상품 조회/수정 </a><!----><!---->
            </li><!---->
            <li class="" style=""><!---->
                <a href="/seller/productsCreate" class="submenu_a">상품 등록 </a><!----><!---->
            </li><!----><!----><!----><!---->
            <li><!---->
                <a href="#/products/delivery/bundle" class="submenu_a">배송정보 관리 </a><!----><!---->
            </li><!----><!---->
            <li><!---->
                <a href="#/notice/search" class="submenu_a">공지사항 관리 </a><!----><!---->
            </li><!----><!---->
        </ul>
    </div>



</div>

</body>
</html>
