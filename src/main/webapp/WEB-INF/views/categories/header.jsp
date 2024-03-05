
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: munnahye
  Date: 2/9/24
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/categories/header.css'/>"/>

    <style>
        .css-taug43 {
            max-height: calc(95vh - 55px);
            min-height: 200px;
            position: absolute;
            display: flex;
            top: 46px;
            padding-top: 10px;
        }

        .css-9d3cf6 {
            position: relative;
            z-index: 321;
            /* width: 249px;
        border: 1px solid rgb(221, 221, 221);
        background-color: rgb(255, 255, 255); */
            /* animation: 0s linear 0s 1 normal none running animation-w43n76; */
        }

        .css-13ct7qm {
            overflow-y: auto;
            width: 247px;
            height: 100%;
            background-color: rgb(255, 255, 255);
            cursor: pointer;
            width: 249px;
            border: 1px solid rgb(221, 221, 221);
            background-color: rgb(255, 255, 255);
            padding: 0;
        }

        ul {
            display: block;
            list-style-type: none;
            /* margin-block-start: 1em; */
            margin-block-end: 1em;
            margin-inline-start: 0px;
            margin-inline-end: 0px;
            padding-inline-start: 40px;
        }

        li {
            text-align: -webkit-match-parent;
        }

        .css-you2kh {
            padding: 7px 0px 9px 14px;
        }

        .css-11n7bn4 {
            display: flex;
            flex-wrap: wrap;
            align-items: flex-start;
        }

        .css-ar6ptu {
            flex: 0 1 0%;
            width: 24px;
            height: 24px;
        }

        .css-mhaka4 {
            flex: 1 1 0%;
            padding: 1px 20px 0px 10px;
            color: rgb(51, 51, 51);
            font-size: 14px;
            font-weight: 400;
            line-height: 22px;
        }

        /* .dropdown-content{
      display: none;
  }

  #category:hover .dropdown-content{
      display: block;

  } */

        #category {
            display: inline-block;
            position: relative;
        }

        #category ul{
            display: none;
        }

        .css-1cbaoeg {
            width: 266px;
            height: 100%;
            position: absolute;
            overflow-y: scroll;
            top: -1px;
            left: 249px;
            z-index: 320;
            animation-duration: 0.5s;
            animation-timing-function: linear;
            animation-delay: 0s;
            animation-iteration-count: 1;
            animation-direction: normal;
            animation-fill-mode: none;
            animation-play-state: running;
            animation-name: animation-plwpox;
            animation-timeline: auto;
            animation-range-start: normal;
            animation-range-end: normal;
        }

        .css-e0dnmk {
            cursor: pointer;
        }

        .css-o2oaem {
            padding: 11px 20px 11px 18px;
            display: flex;
            width: 100%;
            -webkit-box-align: center;
            align-items: center;
            font-weight: 400;
            font-size: 14px;
            color: rgb(51, 51, 51);
            line-height: 22px;
        }
    </style>

</head>
<body>
<div>
    <div class="head-1">
        <div class="login-wrap">
            <a class="lg-text">회원가입</a>
            <div class="lg-bar"></div>
            <a class="lg-text">로그인</a>
            <div class="lg-bar"></div>
            <div class="lg-text3wrap">
                <a class="lg-text"
                >고객센터 <span class="css-1lrerrk eo4j3y50"></span
                ></a>
                <div class="menu cs-bar-wrap">
                    <div class="cscenter-bar">공지사항</div>
                    <div class="cscenter-bar">자주하는 질문</div>
                    <div class="cscenter-bar">1:1 문의</div>
                    <div class="cscenter-bar">대량주문 문의</div>
                </div>
            </div>
        </div>

        <div class="search-bar-wrap">
            <div class="mainlogo">
                <img
                        src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iODIiIGhlaWdodD0iNDIiIHZpZXdCb3g9IjAgMCA4MiA0MiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxnIGZpbGwtcnVsZT0ibm9uemVybyIgZmlsbD0ibm9uZSI+CiAgICAgICAgPHBhdGggZD0iTTAgMGg4MnY0MkgweiIvPgogICAgICAgIDxwYXRoIGQ9Ik02Mi41Ljk2NWMxLjAyNi0uNTU3IDIuNDY2LS43MTggMy4zNTYuMTA3Ljg5LjgyNS42NzYgMi4wNDggMCAzLjk3MyAwIDAtMS41MDUgNC4wNjYtMy4wNTUgOC4yNjJsLS4zOTggMS4wOGMtMS40MTQgMy44My0yLjc2MiA3LjQ4Ny0yLjkyNyA3Ljk2My0xLjQ5OCA0LjI0NSAxLjk2NyA0LjEyMiA0LjAyNC0uMTUyIDEuMTU5LTIuMzk0IDIuNjQ0LTYuMzU3IDIuNjQ0LTYuMzU3LjUyNC0xLjU2My42ODItMi41MDQuMzU5LTIuODI4LS4xMDctLjExMy4wNDUtLjI1Mi4xOC0uMzIzIDIuMjY5LTEuMTQ5IDQuNjMtLjA3MiAzLjMzNiAzLjMxbC0uMDU0LjEzOGMtLjM4Ny45NzgtMi42OCA2LjczMy0yLjY4IDYuNzMzLS42NzYgMS42Ni0uNTk1IDMuMjM2LjQxOCAzLjIzNi42ODYtLjAwNCAxLjQ2LS4zODUgMi4zMDQtMS4wODggMS44MTgtMS41MDQgMy4yMjItNC4zMTIgMy43MjctNS40NTQuMjMtLjUwOCAxLjA4Ny0yLjQyIDEuNzY2LTQuMzYxLjIzNi0uNjY1LjM2OS0xLjM2LjM5NS0yLjA2NWEuNDQzLjQ0MyAwIDAgMSAuMTk0LS40NTkgMy41NzggMy41NzggMCAwIDEgMS42Ny0uNDIgMS44MDUgMS44MDUgMCAwIDEgMS40NjUuNzA1Yy40NDMuNTk4LjU2NiAxLjU3OS4xMDMgMi44MDgtLjEyLjMyLTMuNzc1IDkuOTU4LTMuNzc1IDkuOTU4di4wMjZjMi4wNDEtMS4yMjMgMy44Ny0xLjMxMyA0Ljk1My0uODU0bC0uMDAzLS4wMTNjMS40OTUuNjQ3IDEuOTkgMi40NC45MzggMy41NTktLjEwMy4xMS0uMzYyLjA4NC0uMzYyLS4wOS0uMDk0LTEuMjUzLTIuNTE3LTMuNDk1LTYuMTA5LTEuMDc1bC0uMTQ1LjM4NS0xLjA2OCAyLjgwOGMtMi42MiA3LjAxOC01LjQwMyAxMi4xMzYtOS40MTUgMTEtMi42ODgtLjc2LTIuMzc3LTQuNjA3LjUxNS03Ljc5YTU0LjkgNTQuOSAwIDAgMSA2LjQ5LTUuODk4Yy4wNjgtLjE4OC4xMy0uMzUuMTg4LS41MTEuMjc4LS43OC40OTEtMS40MzQuNzkyLTIuMjY1bC4xNTktLjUxOGMtLjE3OC4yLS40OTguNTczLS43MTIuODEyLS43MTIuOC0yLjQ5NCAyLjc1Ny01LjMyOSAyLjIwN2wtLjIzNC0uMDUyYy0yLjA1LS41MDgtMi42MDgtMS45ODYtMi42NTUtMy4yNzctMi4xNDIgMi42NTYtNC4zNTEgMy40MjYtNS44MDcgMy4zOS0xLjk0OC0uMDQ4LTMuMzc4LTEuNTE0LTIuNDI3LTQuMjkgMS4wNTgtMy4xMDYgNS41LTE1LjMzMiA2Ljc5NS0xOSAuNDg1LTEuNTguNjY2LTIuNTguMTg0LTIuOTc0LS4xMjMtLjEwMy4wNTItLjI2NS4yLS4zNDZ6bTguMzY0IDI4Ljc3OGMtMS4xMDMuODgtNS41MjYgNC41My02Ljc1MiA3LjQ0MS0uNTA1IDEuMTk3LS4zNzYgMi4xNDkuNDg4IDIuMjMzIDEuOTYuMTk0IDQuMDEyLTMuODE4IDYuMjI4LTkuNTEyek0xNi4wMjggNS4zNTJjLS4wODcuMzMyLTEuMzE5IDMuODYtMi43MDEgNy43NDlsLS4yMDkuNTg2LS4yMS41ODktLjIxNS42MDRjNC42OTEtMS4xMjMgMTMuMDY0LTYuNTcgMTQuMDM1LTEwLjA4NS4xMi0uMTYxLjI5LS4yMi41NjYtLjAzNS40OTUuMzMuNjg2IDEuMTU1LjQ5NSAxLjkxOC0uNzY0IDMuMDM4LTYuNDE2IDcuMzQxLTExLjM3OSA5LjU1NC42MTIgMS42MzcgMi42ODIgNi4yNjcgNC4yMDYgOS4xMTEgMS42NjMgMy4xMTkgMy40MiA0LjU3NSA2LjE0NyA0LjczNyAxLjQ2LjA4NSAzLjAxNC0uNDQ3IDMuODkzLTEuMjJsLjE0OC0uMTQtLjAxMy4wM2MuMTk0LS4yMDQuNTExLjA3Ny4zNjYuMzIzYTYuNSA2LjUgMCAwIDEtNC45OTIgMi44NjdjLTYuMzQ1LjQyNy04Ljc3NC0zLjg3LTEzLjMwNC0xNC40OTQtLjM2Ni4xMjYtLjgwOS4yODgtMS4yNTUuNDUtLjA3NS4xODctMi4wNyA1LjY0Mi0yLjEzIDUuODIzLS45NDQgMi44Ny0xLjAwNSA0LjQ0Mi0uMzU4IDQuODk1LjE0NS4wOS4wNzQuMzMzLS4xNzguNDE0LTIuNTI3Ljc5Ni00Ljg1My0uNjk2LTMuNTU5LTQuNDQyIDEuMTYxLTMuMzE2IDUuNjktMTYuMTggNi45MTQtMTkuNjI2LjQyNy0xLjI5NC4xOTctMi4xMjUtLjQ5Mi0yLjMwNkM4LjUwNiAxLjc4Ljg3NyA4Ljc0OSAxLjk3MSAxNS4xODRjLjE5IDEuMTIuOTggMS43NDcgMS4zNzggMS42NjNhLjEzMy4xMzMgMCAwIDEgLjE1Ni4xNTkgMS41MDggMS41MDggMCAwIDEtMS44NDUgMS4wMzJDLjQ5IDE3Ljc4Mi4xMDcgMTYuNTI3LjA0MyAxNS44OC0uNjAxIDkuMjIgNi4xNDggMS4yMyAxMi4zODkuNThjMi4zNzgtLjI1IDQuNjEuOTYgMy42NCA0Ljc3MnptMjQuMDQgOS45MTMtLjA2LjIwNy0yLjgzIDguMTZjLS4zMDQuODUtLjEgMS43MzcuNTAxIDEuOTAyIDEuNzU3LjQ4MiA0LjAyOC0yLjE0NSA1LjEzMS00LjczM2E2Ny43OTQgNjcuNzk0IDAgMCAwIDEuNDc2LTMuODE1Yy41ODItMS42NDMgMS4xMDYtMy4xODMuNzgzLTMuOTA4LS4wNzUtLjE2OC4wNDUtLjI1Ni4yMjMtLjM1LjUwNS0uMjU1IDIuMjI2LS44MjUgMy4xNDEuMDY4LjY5NS42NzQuNjA5IDEuNzcxLS4wMyAzLjQzN2wtLjA5Ni4yNDIuMjItLjI3M2MyLjcwMy0zLjMgNC43OTItNC4yOTIgNi41NjMtMy41OTdsLjE0Ny4wNjJjMi4zODEgMS4wNzQgMS4xNDYgNS4yMTUtMi4xMTYgNS40OC0uMi4wMTctLjM1Ni0uMTI2LS4xNTgtLjQwNy4zOTUtLjYwNS4zNTYtMS45MDktLjc5Ni0yLjAyMi0xLjE1Mi0uMTEzLTIuODMgMS4yMDctNC4wMzggMi44NDQtMS4wODQgMS40NS0yLjIgMy45MTEtMy4zMjIgNy4yNzMtLjI3Mi44MTgtLjE0MyAxLjAxMi0uMTEgMS4wNjdhLjEuMSAwIDAgMSAwIC4wOTRjLS4xNDMuMjcyLS45NjUuNTk2LTEuNzYuNTk2LTEuNjI1LS4wMDctMi4yOTEtLjk0NS0xLjk2Ny0yLjQzNy0xLjg0OCAxLjc2NC0zLjcxMSAyLjYxNC01LjM1NSAyLjQ2NmEyLjUyNCAyLjUyNCAwIDAgMS0yLjIzNi0zLjEwM2MtMS40MjYgMS44MDktMy41NDIgMy4yNjgtNS42OTcgMy4wNjctMi4xNTUtLjItMy41LTEuNjY2LTIuODAyLTQuNzg4LjU5LTIuNTk4IDEuNTkyLTUuMjkgMi4yMDctNy4wMjcuNTE0LTEuNDU2LjYxOC0yLjQwNy4yOTQtMi43NS0uMTAzLS4xMTQuMDU1LS4yNS4xOTQtLjMyNCAxLjY5LS44ODYgNC4zOTQtLjMxNCAzLjYzIDIuMDktLjgwMiAyLjUyNy0yLjI1NSA2LjQ5LTIuNTUgNy40LS43MzcgMi4yODctLjI5IDMuNTIzLjc1NSAzLjU4IDEuMDQ1LjA2IDIuNDMtLjk2IDMuNDItMi41MDMgMS43Ni0yLjUyNCAyLjU4MS01LjY4NSAzLjM3Ny03Ljg4Mi4yMDQtLjU2LjUyNy0xLjg2Ni4xODUtMi4zNTItLjA5MS0uMTIzLjA2Ny0uMjU4LjI3NS0uMzcyIDEuNTM3LS44NDkgNC4yODUtLjY0IDMuNDAyIDIuNjA4eiIgZmlsbD0iIzVGMDA4MCIvPgogICAgPC9nPgo8L3N2Zz4K"
                        alt="마켓컬리 로고"
                        class="mainlogo-img"
                /><button class="active css-mxd3pm ekdqe1a0">마켓컬리</button>
            </div>

            <div class="searchbox-wrap">
                <div class="searchbox">
                    <form id="search_container" method="get" action="/search">
                    <input
                            id="gnb_search"
                            placeholder="검색어를 입력해주세요"
                            required=""
                            class="searchbox-text"
                            name="sword"
                            value=""
                    /><button
                        id="submit"
                        aria-label="submit"
                        class="searchbox-btn"
                ></button>
                    </form>
                </div>
            </div>

            <div class="wishlist-wrap1">
                <div class="wishlist-wrap2">
                    <div class="location-icon"></div>
                    <button
                            class="wishlist-icon"
                            aria-label="찜하기"
                            type="button"
                    ></button>
                    <div class="cart-icon">
                        <button class="cart-icon-btn"></button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="header">
        <div class="menu-bar-wrap">
            <div id="category">
                <div class="category-1">
              <span class="css-1k5gn9s eqn756m1"></span
              ><span class="category-2">카테고리</span>
                    <div class="css-taug43 e7s0tnu0 dropdown-content">
                        <div width="0" class="css-9d3cf6 e1vs1ym87">
                            <ul class="css-13ct7qm e1vs1ym86" >
<%--                                <li class="css-you2kh e1vs1ym83 menuItem1">--%>


<%--                                    <c:forEach var="item" items="${selectMain}">--%>

<%--                                        <li class="css-you2kh e1vs1ym83 menuItem1">--%>
<%--                                            <div class="css-11n7bn4 e1vs1ym81">--%>
<%--                                                <img src="/resources/image/icon-.png" alt="채소" class="css-ar6ptu e1vs1ym82" />--%>
<%--                                                <span class="css-mhaka4 e1vs1ym84">${item.exp}</span>--%>
<%--                                            </div>--%>
<%--                                        </li>--%>
<%--                                    </c:forEach>--%>

                                <c:forEach var="item" items="${selectMain}" varStatus="loop">
                                    <li class="css-you2kh e1vs1ym83 menuItem1">
                                        <div class="css-11n7bn4 e1vs1ym81">
                                            <!-- 이미지 파일명 설정 -->
                                            <img src="/resources/image/icon-<c:out value="${loop.index + 1}" />.png" alt="${item.exp}" class="css-ar6ptu e1vs1ym82" />
                                            <span class="css-mhaka4 e1vs1ym84"><a href="/categories/${item.codeId}?page=1">${item.exp}</a></span>

                                        </div>
                                    </li>
                                </c:forEach>







                                <li width="535" class="css-1jdpv96 e1vs1ym85"></li>
                                <li width="0" class="css-1xy9xh5 e1vs1ym85"></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <ul class="cate-menu-wrap">
                <li class="cate-menu-1">
                    <span class="cate-menu-txt">신상품</span>
                </li>
                <li class="cate-menu-1">
                    <span class="cate-menu-txt"><a href="/categories/best-page">베스트</a></span>
                </li>
                <li class="cate-menu-1">
                    <span class="cate-menu-txt">알뜰쇼핑</span>
                </li>
                <li class="cate-menu-1">
                    <span class="cate-menu-txt">특가/혜택</span>
                </li>
            </ul>

            <div class="delivery-nt1">
                <div class="delivery-nt2">
                    <span class="delivery-nt-txt">샛별・하루</span>
                    배송안내
                </div>
            </div>
        </div>
    </div>
</div>
<div hidden="" class="css-1px7x3s e1py5jsz0"></div>

<script>
    //   const mainMenu = document.getElementById("category"); //div id
    //   const menuItem1 = document.getElementsByClassName("menuItem1"); // li ld
    //   const subMenu1 = document.getElementsByClassName("subMenu1");

    //   mainMenu.addEventListener("mouseenter", () => {
    //     mainMenu.querySelector("ul").style.display = "block";
    //   });

    //   mainMenu.addEventListener("mouseleave", () => {
    //     mainMenu.querySelector("ul").style.display = "none";
    //     subMenu1.style.display = "none";
    //   });

    //   menuItem1.addEventListener("mouseenter", () => {
    //     subMenu1.style.display = "block";
    //   });

    // menuItem1.addEventListener("mouseleave", () => {
    //     subMenu1.style.display = "none";
    // });
    // const mainMenu = document.getElementById("category"); // div id
    // const menuItem1 = document.getElementsByClassName("menuItem1"); // li id
    // const subMenu1 = document.getElementsByClassName("subMenu1");

    // mainMenu.addEventListener("mouseenter", () => {
    // mainMenu.querySelector("ul").style.display = "block";
    // });

    // mainMenu.addEventListener("mouseleave", () => {
    // mainMenu.querySelector("ul").style.display = "none";
    // subMenu1.style.display = "none";
    // });

    // menuItem1.addEventListener("mouseenter", () => {
    // subMenu1.style.display = "block";
    // });

    // menuItem1.addEventListener("mouseleave", () => {
    // subMenu1.style.display = "none";
    // });

    const mainMenu = document.getElementById("category"); // div id
    const menuItem1 = document.querySelectorAll(".menuItem1"); // li id
    const subMenu1 = document.querySelectorAll(".subMenu1");

    for (let i = 0; i < subMenu1.length; i++) {
        subMenu1[i].style.display = "none";}

    mainMenu.addEventListener("mouseenter", () => {
        mainMenu.querySelector("ul").style.display = "block";
    });

    mainMenu.addEventListener("mouseleave", () => {
        mainMenu.querySelector("ul").style.display = "none";
        for (let i = 0; i < subMenu1.length; i++) {
            subMenu1[i].style.display = "none";
        }
    });

    for (let i = 0; i < menuItem1.length; i++) {
        menuItem1[i].addEventListener("mouseenter", () => {
            for (let j = 0; j < subMenu1.length; j++) {
                subMenu1[j].style.display = "block";
            }
        });

        menuItem1[i].addEventListener("mouseleave", () => {
            for (let j = 0; j < subMenu1.length; j++) {
                subMenu1[j].style.display = "none";
            }
        });
    }











</script>
</body>
</html>
