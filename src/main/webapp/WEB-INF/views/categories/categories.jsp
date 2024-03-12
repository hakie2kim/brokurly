<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: munnahye
  Date: 2/10/24
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


    <link rel="stylesheet" href="<c:url value='/resources/css/categories/best-page.css'/>"/>
    <style>
        [type="checkbox"] {
            width: 18px;
            height: 18px;
            margin-right: 10px;
            appearance: none;
            border-radius: 50%;
            border: 1px solid rgb(221, 221, 221);
            background: url(/resources/image/img-check-gray.png) no-repeat center;
        }

        [type="checkbox"]:hover,
        .result-buttons button:hover {
            cursor: pointer;
        }

        [type="checkbox"]:checked {
            background: #11967f url(/resources/image/img-check.png) no-repeat center center;
            border: 0;
        }


        .css-1uk9d3w {
            max-width: 840px;
            display: inline-block;
            vertical-align: top;
        }

        .css-1qfsi3d {
            font-weight: 500;
            color: rgb(95, 0, 128);
        }

        .css-mmvz9h {
            font-weight: 400;
        }

        .current-page {
            /* 원하는 스타일을 여기에 추가하세요 */
            font-weight: bold; /* 예시: 텍스트를 굵게 표시 */
            color: #11967f; /* 예시: 텍스트 색상을 빨간색으로 지정 */
        }



        [type="checkbox"]:checked {
            background: #11967f url(/resources/image/img-check.png) no-repeat center center;
            border: 0;
        }
    </style>
    <script type="text/javascript" src="<c:url value='/resources/js/categories/categories.js'/>"></script>
</head>
<body>

<div class="best-page">
    <div class="best-menu-wrap1">
        <h3 class="best-name">${categorydto[0].exp}</h3>
        <ul class="best-menu-wrap2">
            <li class="best-list">
                <a class="best-menu-name ${categorydto[0].codeId}"
                   href="http://localhost:8080/categories/${categorydto[0].codeId}?page=1">전체보기</a>
            </li>

            <c:forEach var="catelist" items="${categorydto}" begin="1" end="${fn:length(categorydto)}" varStatus="loop">
                <li class="best-list">
                    <a class="best-menu-name ${catelist.codeId}"
                       href="http://localhost:8080/categories/${catelist.codeId}?page=1">${catelist.exp}</a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="container">
        <div class="best-content-wrap">
            <div class="side-menu">
                <div class="side-menu-filter">
                    <span class="side-filter-font">필터</span>
                    <button class="filter-re-btn">
                        <svg
                                width="12"
                                height="12"
                                viewBox="0 0 16 16"
                                fill="none"
                                xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                    d="M13.78 3.96303C12.504 2.16973 10.4086 1 8.04 1C4.15192 1 1 4.15192 1 8.04C1 11.9281 4.15192 15.08 8.04 15.08C11.9281 15.08 15.08 11.9281 15.08 8.04"
                                    stroke="#ddd"
                                    stroke-width="1.6"
                                    stroke-linecap="square"
                                    stroke-linejoin="round"
                            ></path>
                            <path
                                    d="M14.4933 1L14.4933 4.52H10.9733"
                                    stroke="#ddd"
                                    stroke-width="1.6"
                                    stroke-linecap="square"
                                    stroke-linejoin="round"
                            ></path>
                        </svg>
                        <span class="filter-re-txt">초기화</span>
                    </button>
                </div>

                <div class="side-category-wrap">
                    <div class="side-category1">
                        <button class="side-cate-btn">
                            <div class="side-cate-txt">배송</div>
                            <svg width="18" height="18" viewBox="0 0 18 18" fill="none" stroke="#999"
                                 xmlns="http://www.w3.org/2000/svg" class="css-innaj4 e1frj59j6"
                                 style="transform: rotate(0deg);">
                                <path d="M5 11L9 7L13 11" stroke="#999" stroke-width="1.2"></path>
                            </svg>
                        </button>
                        <nav class="side-cate-menu" style="max-height: 100vh; opacity: 1;">
                            <li class="css-cate-list-1">
                                <a class="css-cate-list-2">
                                    <%--                                    <button class="css-cate-btn">--%>
                                    <input type="checkbox" onclick="addQueryString('dawn')" value="dawn"/>

                                    <%--                                        <svg width="18" height="18" viewBox="0 0 24 24" fill="none"--%>
                                    <%--                                             xmlns="http://www.w3.org/2000/svg">--%>
                                    <%--                                            <path class="myPath" d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"--%>
                                    <%--                                                  stroke="#ddd" fill="none"></path>--%>
                                    <%--                                            <path d="M7 12.6667L10.3846 16L18 8.5" stroke="#ddd" stroke-width="1.5"--%>
                                    <%--                                                  stroke-linecap="round" stroke-linejoin="round"></path>--%>
                                    <%--                                        </svg>--%>
                                    <%--                                    </button>--%>
                                    <span class="css-cate-txt">샛별배송</span><span class="css-cate-cnt">647</span>
                                </a>
                            </li>
                            <li class="css-cate-list-1">
                                <a class="css-cate-list-2">
                                    <input type="checkbox" onclick="addQueryString('normal_parcel')"
                                           value="normal_parcel"/>
                                    <%--                                    <button class="css-cate-btn">--%>
                                    <%--                                        <svg width="18" height="18" viewBox="0 0 24 24" fill="none"--%>
                                    <%--                                             xmlns="http://www.w3.org/2000/svg">--%>
                                    <%--                                            <path d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"--%>
                                    <%--                                                  stroke="#ddd" fill="none"></path>--%>
                                    <%--                                            <path d="M7 12.6667L10.3846 16L18 8.5" stroke="#ddd" stroke-width="1.5"--%>
                                    <%--                                                  stroke-linecap="round" stroke-linejoin="round"></path>--%>
                                    <%--                                        </svg>--%>
                                    <%--                                    </button>--%>
                                    <span class="css-cate-txt">판매자배송</span><span
                                        class="css-cate-cnt">5</span>
                                </a>
                            </li>
                        </nav>
                    </div>
                    <div class="side-category1">
                        <button class="side-cate-btn">
                            <div class="side-cate-txt">가격</div>
                            <svg width="18" height="18" viewBox="0 0 18 18" fill="none" stroke="#999"
                                 xmlns="http://www.w3.org/2000/svg" class="css-innaj4 e1frj59j6"
                                 style="transform: rotate(0deg);">
                                <path d="M5 11L9 7L13 11" stroke="#999" stroke-width="1.2"></path>
                            </svg>
                        </button>
                        <nav class="side-cate-menu" style="max-height: 100vh; opacity: 1;">
                            <li class="css-cate-list-1">
                                <a class="css-cate-list-2 price-filter-1">
                                    <button class="css-cate-btn price-btn1">
                                        <svg width="18" height="18" viewBox="0 0 24 24" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <path d="M12 23.5C18.3513 23.5 23.5 18.3513 23.5 12C23.5 5.64873 18.3513 0.5 12 0.5C5.64873 0.5 0.5 5.64873 0.5 12C0.5 18.3513 5.64873 23.5 12 23.5Z"
                                                  fill="#fff" stroke="#ddd"></path>
                                        </svg>
                                    </button>
                                    <span class="css-cate-txt price-criteria-1">원 미만</span><span
                                        class="css-cate-cnt">111</span>
                                </a>
                            </li>
                            <li class="css-cate-list-1">
                                <a class="css-cate-list-2 price-filter-2">
                                    <button class="css-cate-btn price-btn2">
                                        <svg width="18" height="18" viewBox="0 0 24 24" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <path d="M12 23.5C18.3513 23.5 23.5 18.3513 23.5 12C23.5 5.64873 18.3513 0.5 12 0.5C5.64873 0.5 0.5 5.64873 0.5 12C0.5 18.3513 5.64873 23.5 12 23.5Z"
                                                  fill="#fff" stroke="#ddd"></path>
                                        </svg>
                                    </button>
                                    <span class="css-cate-txt price-criteria-2">2,990원 ~ 4,290원</span>
                                    <span
                                            class="css-cate-cnt">141</span>
                                </a>
                            </li>
                            <li class="css-cate-list-1">
                                <a class="css-cate-list-2 price-filter-3 price-btn2">
                                    <button class="css-cate-btn">
                                        <svg width="18" height="18" viewBox="0 0 24 24" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <path d="M12 23.5C18.3513 23.5 23.5 18.3513 23.5 12C23.5 5.64873 18.3513 0.5 12 0.5C5.64873 0.5 0.5 5.64873 0.5 12C0.5 18.3513 5.64873 23.5 12 23.5Z"
                                                  fill="#fff" stroke="#ddd"></path>
                                        </svg>
                                    </button>
                                    <span class="css-cate-txt price-criteria-3 price-btn3">4,290원 ~ 5,990원</span><span
                                        class="css-cate-cnt">116</span>
                                </a>
                            </li>
                            <li class="css-cate-list-1">
                                <a class="css-cate-list-2 price-filter-4">
                                    <button class="css-cate-btn">
                                        <svg width="18" height="18" viewBox="0 0 24 24" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <path d="M12 23.5C18.3513 23.5 23.5 18.3513 23.5 12C23.5 5.64873 18.3513 0.5 12 0.5C5.64873 0.5 0.5 5.64873 0.5 12C0.5 18.3513 5.64873 23.5 12 23.5Z"
                                                  fill="#fff" stroke="#ddd"></path>
                                        </svg>
                                    </button>
                                    <span class="css-cate-txt price-criteria-4">5,990원 이상</span><span
                                        class="css-cate-cnt">142</span>
                                </a>
                            </li>
                        </nav>
                    </div>
                    <div class="side-category1">
                        <button class="side-cate-btn">
                            <div class="side-cate-txt">카테고리</div>
                            <svg
                                    width="18"
                                    height="18"
                                    viewBox="0 0 18 18"
                                    fill="none"
                                    stroke="#999"
                                    xmlns="http://www.w3.org/2000/svg"
                                    class="css-innaj4"
                                    style="transform: rotate(0deg)"
                            >
                                <path
                                        d="M5 11L9 7L13 11"
                                        stroke="#999"
                                        stroke-width="1.2"
                                ></path>
                            </svg>
                        </button>
                        <nav class="side-cate-menu"
                             style="max-height: 100vh; opacity: 1">
                            <li class="css-cate-list-1">
                                <a
                                        href="http://localhost:8080/categories/${codeId}?page=1&sortedtype=4"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button>
                                    <span class="css-cate-txt">간편식·밀키트·샐러드</span
                                    ><span class="css-cate-cnt">75</span></a
                                >
                            </li>
                            <li class="css-cate-list-1">
                                <a
                                        href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=category%3A910"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button
                                    >
                                    <span class="css-cate-txt">정육·가공육·계란</span
                                    ><span class="css-cate-cnt">50</span></a
                                >
                            </li>
                            <li class="css-cate-list-1">
                                <a
                                        href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=category%3A911"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button
                                    >
                                    <span class="css-cate-txt">국·반찬·메인요리</span
                                    ><span class="css-cate-cnt">50</span></a
                                >
                            </li>
                            <li class="css-cate-list-1">
                                <a
                                        href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=category%3A908"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button
                                    >
                                    <span class="css-cate-txt">과일·견과·쌀</span
                                    ><span class="css-cate-cnt">35</span></a
                                >
                            </li>
                            <li class="css-cate-list-1">
                                <a
                                        href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=category%3A914"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button
                                    >
                                    <span class="css-cate-txt">생수·음료·커피</span
                                    ><span class="css-cate-cnt">19</span></a
                                >
                            </li>
                            <li class="css-cate-list-1">
                                <a
                                        href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=category%3A909"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button
                                    >
                                    <span class="css-cate-txt">수산·해산·건어물</span
                                    ><span class="css-cate-cnt">18</span></a
                                >
                            </li>
                            <li class="css-cate-list-1">
                                <a
                                        href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=category%3A915"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button
                                    >
                                    <span class="css-cate-txt">베이커리</span
                                    ><span class="css-cate-cnt">17</span></a
                                >
                            </li>
                            <li class="css-cate-list-1">
                                <a
                                        href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=category%3A597"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button
                                    >
                                    <span class="css-cate-txt">2024 설 선물세트</span
                                    ><span class="css-cate-cnt">16</span></a
                                >
                            </li>
                            <li class="css-cate-list-1">
                                <a
                                        href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=category%3A913"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button
                                    >
                                    <span class="css-cate-txt">면·양념·오일</span
                                    ><span class="css-cate-cnt">16</span></a
                                >
                            </li>
                            <li class="css-cate-list-1">
                                <a
                                        href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=category%3A249"
                                        class="css-cate-list-2"
                                >
                                    <button class="css-cate-btn">
                                        <svg
                                                width="18"
                                                height="18"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                                                    stroke="#ddd"
                                                    fill="none"
                                            ></path>
                                            <path
                                                    d="M7 12.6667L10.3846 16L18 8.5"
                                                    stroke="#ddd"
                                                    stroke-width="1.5"
                                                    stroke-linecap="round"
                                                    stroke-linejoin="round"
                                            ></path>
                                        </svg>
                                    </button
                                    >
                                    <span class="css-cate-txt">간식·과자·떡</span
                                    ><span class="css-cate-cnt">12</span></a
                                >
                            </li>
                            <button class="css-more-btn">
                                카테고리 더보기
                                <svg
                                        width="18"
                                        height="18"
                                        viewBox="0 0 18 18"
                                        fill="none"
                                        stroke="#999"
                                        xmlns="http://www.w3.org/2000/svg"
                                        class="css-jbgpyq e1frj59j0"
                                >
                                    <path
                                            d="M5 11L9 7L13 11"
                                            stroke="#999"
                                            stroke-width="1.2"
                                    ></path>
                                </svg>
                            </button>
                        </nav>
                    </div>
                </div>
            </div>

            <div class="best-content">
                <div class="best-sorted-wrap">
                    <div class="goodstotalCnt">총 ${totalCnt}건</div>
                    <ul class="sorted-menu-wrap">
                        <li class="css-sorted-menu">
                            <a
                                    href="/collection-groups/market-best?page=1&amp;collection=market-best&amp;filters=&amp;per_page=96&amp;sorted_type=4"
                                    class="css-126imjl eudxpx30"
                            >추천순</a
                            >
                            <div class="css-f49ql3 e1kpyq4d1">
                                <svg
                                        width="14"
                                        height="20"
                                        viewBox="0 0 14 14"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                            fill-rule="evenodd"
                                            clip-rule="evenodd"
                                            d="M6.9932 0.700195C8.73506 0.700195 10.3116 1.40557 11.4528 2.54565C12.5943 3.68594 13.3002 5.26111 13.3002 7.0002C13.3002 8.73928 12.5943 10.3145 11.4528 11.4547C10.3116 12.5948 8.73506 13.3002 6.9932 13.3002C5.25512 13.3002 3.68233 12.595 2.54387 11.4554C1.40457 10.315 0.700195 8.73952 0.700195 7.0002C0.700195 5.26087 1.40457 3.68541 2.54387 2.54497C3.68233 1.40537 5.25512 0.700195 6.9932 0.700195Z"
                                            stroke="#ccc"
                                            stroke-width="1.4"
                                    ></path>
                                    <path
                                            d="M4.5 5.21081H5.77027C5.81351 4.55135 6.26216 4.12973 6.95946 4.12973C7.64054 4.12973 8.09459 4.53514 8.09459 5.0973C8.09459 5.58784 7.90383 5.86944 7.35576 6.22524L7.1973 6.32432C6.45135 6.76216 6.13784 7.24865 6.18649 8.05946L6.19189 8.42703H7.44595V8.11892C7.44595 7.58378 7.64595 7.30811 8.35405 6.89189C9.08919 6.45405 9.5 5.87568 9.5 5.04865C9.5 3.85405 8.51081 3 7.02973 3C5.42432 3 4.54324 3.92973 4.5 5.21081ZM6.87838 11.0054C6.33784 11.0054 5.98108 10.6649 5.98108 10.1459C5.98108 9.62162 6.33784 9.28108 6.87838 9.28108C7.42973 9.28108 7.77568 9.62162 7.77568 10.1459C7.77568 10.6649 7.42973 11.0054 6.87838 11.0054Z"
                                            fill="#ccc"
                                    ></path>
                                </svg>
                                <div class="css-2hay8 e1kpyq4d0">
                                    소비자 인기도(판매량, 판매금액, 조회수 등), 상품 출시일,
                                    수요 적합성, 상품 운영상 필요 등을 종합적으로 고려한
                                    순서입니다.
                                </div>
                            </div>
                        </li>
                        <li class="css-sorted-menu">

                            <%-- 클릭할때 클래스 이름 css-126imjl--%>
                            <a class="css-19ce13b eudxpx30">신상품순</a>
                        </li>
                        <li class="css-sorted-menu">
                            <a class="css-19ce13b eudxpx30">판매량순</a>
                        </li>
                        <li class="css-sorted-menu">
                            <a class="css-19ce13b eudxpx30">혜택순</a>
                        </li>
                        <li class="css-sorted-menu">
                            <a class="css-19ce13b eudxpx30">낮은 가격순</a>
                        </li>
                        <li class="css-sorted-menu">
                            <a class="css-19ce13b eudxpx30">높은 가격순</a>
                        </li>
                    </ul>
                </div>
                <div class="best-itemlist">
                    <%--상품 정보 시작--%>
                    <c:forEach var="goodsListDto" items="${goodsListDto}" varStatus="loop">
                        <a href="/goods/${goodsListDto.itemId}" class="css-9o2zup e1c07x4813">
                            <div class="css-0 e1c07x4811">
                                <div class="e1c07x4812 css-tou8lf e3um3060">
                                <span style="
                        box-sizing: border-box;
                        display: block;
                        overflow: hidden;
                        width: initial;
                        height: initial;
                        background: none;
                        opacity: 1;
                        border: 0px;
                        margin: 0px;
                        padding: 0px;
                        position: absolute;
                        inset: 0px;
                      ">
                                    <img alt="상품 이미지" sizes="100vw" srcset="
                                        https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg  640w,
                                        https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg  750w,
                                        https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg  828w,
                                        https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 1080w,
                                        https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 1200w,
                                        https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 1920w,
                                        https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 2048w,
                                        https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 3840w"
                                         src="https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg"
                                         decoding="async" data-nimg="fill" class="css-0" style="
                          position: absolute;
                          inset: 0px;
                          box-sizing: border-box;
                          padding: 0px;
                          border: none;
                          margin: auto;
                          display: block;
                          width: 0px;
                          height: 0px;
                          min-width: 100%;
                          max-width: 100%;
                          min-height: 100%;
                          max-height: 100%;
                          object-fit: cover;
                        "></span>
                                </div>
                            </div>
                            <div class="button-wrapper">
                                <button type="button" class="css-13xu5fn e17x72af0">
                                    <svg width="18" height="18" viewBox="0 0 18 18" fill="none"
                                         xmlns="http://www.w3.org/2000/svg">
                                        <path d="M1.53516 2.70001H3.93316L5.76816 10.609H13.6482L15.2992 4.35901H4.86916M12.8582 14.933C13.0098 14.9375 13.1609 14.9115 13.3024 14.8566C13.4438 14.8017 13.5728 14.7189 13.6817 14.6132C13.7906 14.5075 13.8771 14.381 13.9363 14.2412C13.9954 14.1015 14.0258 13.9513 14.0258 13.7995C14.0258 13.6478 13.9954 13.4975 13.9363 13.3578C13.8771 13.218 13.7906 13.0915 13.6817 12.9858C13.5728 12.8801 13.4438 12.7974 13.3024 12.7424C13.1609 12.6875 13.0098 12.6615 12.8582 12.666C12.5634 12.6748 12.2836 12.798 12.0782 13.0096C11.8727 13.2213 11.7578 13.5046 11.7578 13.7995C11.7578 14.0944 11.8727 14.3778 12.0782 14.5894C12.2836 14.801 12.5634 14.9243 12.8582 14.933ZM6.49316 14.933C6.64484 14.9375 6.79589 14.9115 6.93735 14.8566C7.07881 14.8017 7.20781 14.7189 7.31669 14.6132C7.42558 14.5075 7.51214 14.381 7.57126 14.2412C7.63037 14.1015 7.66083 13.9513 7.66083 13.7995C7.66083 13.6478 7.63037 13.4975 7.57126 13.3578C7.51214 13.218 7.42558 13.0915 7.31669 12.9858C7.20781 12.8801 7.07881 12.7974 6.93735 12.7424C6.79589 12.6875 6.64484 12.6615 6.49316 12.666C6.19836 12.6748 5.91858 12.798 5.71315 13.0096C5.50773 13.2213 5.39283 13.5046 5.39283 13.7995C5.39283 14.0944 5.50773 14.3778 5.71315 14.5894C5.91858 14.801 6.19836 14.9243 6.49316 14.933Z"
                                              stroke="#333333" stroke-linecap="square" stroke-linejoin="round"></path>
                                    </svg>
                                    담기
                                </button>
                            </div>
                            <div class="css-1kpzrna e1c07x489">
                                <span class="css-1qd61ut e1ms5t9c1">
                                    <span class="css-1vdqr5b e1ms5t9c0">${goodsListDto.shipType}</span></span>
                                <span class="css-1dry2r1 e1c07x488">${goodsListDto.name}</span>
                                <p class="css-1wejlc3 e1c07x486">${goodsListDto.exp}</p>
                                <div class="e1c07x487 discount-price css-1tl7659 ei5rudb2">
                                    <div>
                                        <c:if test="${goodsListDto.dcRt} != 0">
                                        <span class="dimmed-price css-18tpqqq ei5rudb1 price-rate">${goodsListDto.price}
                                            <span class="won price-rate">원</span></span>
                                        </c:if>
                                    </div>
                                    <div class="discount">
                                        <c:if test="${goodsListDto.dcRt} != 0">
                                        <span class="discount-rate css-19lkxd2 ei5rudb0 price-rate">
                                                ${goodsListDto.dcRt}%
                                        </span>
                                        </c:if>
                                        <span class="sales-price css-18tpqqq ei5rudb1">${goodsListDto.disPrice}
                                            <span class="won">원</span></span>
                                    </div>
                                </div>
                                <div class="review-count css-xezqwk e1c07x482">
                                    <span class="css-mz5g71 e1c07x481">
                                        <svg width="100%" height="100%" viewBox="0 0 14 14" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                        <mask id="path-1-inside-1_1513_17755" fill="white">
                                          <path fill-rule="evenodd" clip-rule="evenodd"
                                                d="M3 2C1.89543 2 1 2.89543 1 4V8.67201C1 9.77658 1.89543 10.672 3 10.672H5.11212L6.33682 12.7653C6.5299 13.0954 7.00688 13.0954 7.19995 12.7653L8.42465 10.672H10.5C11.6046 10.672 12.5 9.77658 12.5 8.67201V4C12.5 2.89543 11.6046 2 10.5 2H3Z"></path>
                                         </mask>
                                          <path fill="#999"
                                                d="M5.11212 10.672L5.97526 10.167L5.68564 9.67201H5.11212V10.672ZM6.33682 12.7653L5.47369 13.2703L5.47369 13.2703L6.33682 12.7653ZM7.19995 12.7653L6.33682 12.2604L6.33682 12.2604L7.19995 12.7653ZM8.42465 10.672V9.67201H7.85113L7.56152 10.167L8.42465 10.672ZM2 4C2 3.44772 2.44772 3 3 3V1C1.34315 1 0 2.34315 0 4H2ZM2 8.67201V4H0V8.67201H2ZM3 9.67201C2.44772 9.67201 2 9.22429 2 8.67201H0C0 10.3289 1.34315 11.672 3 11.672V9.67201ZM5.11212 9.67201H3V11.672H5.11212V9.67201ZM7.19995 12.2604L5.97526 10.167L4.24899 11.177L5.47369 13.2703L7.19995 12.2604ZM6.33682 12.2604C6.5299 11.9304 7.00688 11.9304 7.19995 12.2604L5.47369 13.2703C6.05291 14.2604 7.48386 14.2604 8.06309 13.2703L6.33682 12.2604ZM7.56152 10.167L6.33682 12.2604L8.06309 13.2703L9.28779 11.177L7.56152 10.167ZM10.5 9.67201H8.42465V11.672H10.5V9.67201ZM11.5 8.67201C11.5 9.22429 11.0523 9.67201 10.5 9.67201V11.672C12.1569 11.672 13.5 10.3289 13.5 8.67201H11.5ZM11.5 4V8.67201H13.5V4H11.5ZM10.5 3C11.0523 3 11.5 3.44772 11.5 4H13.5C13.5 2.34315 12.1569 1 10.5 1V3ZM3 3H10.5V1H3V3Z"
                                                mask="url(#path-1-inside-1_1513_17755)"></path>
                                        <circle fill="#999" cx="4.34998" cy="6.17871" r="0.75"></circle>
                                         <circle fill="#999" cx="6.75" cy="6.17871" r="0.75"></circle>
                                        <circle fill="#999" cx="9.15002" cy="6.17871" r="0.75"></circle></svg></span>
                                    <span class="review-number css-l610kl e1c07x480">${goodsListDto.revCnt}+</span>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                    <%--상품 정보 끝--%>
                </div>

                <div class="small-modal">
                    <div class="small-modal-border">
                        <div class="small-modal-content">
                            <p>장바구니로 이동하여</p>
                            <p>다른 배송지로 변경하시겠습니까?</p>
                        </div>
                        <div class="small-modal-buttons">
                            <button id="small-modal-cancel">취소</button>
                            <button id="small-modal-ok">확인</button>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
    <%--  페이징 네비게이터  --%>
    <div class="css-rdz8z7 e82lnfz1">

        <%-- 첫번째 페이지로 이동 --%>
        <c:url var="urlPaging" value="/categories/${codeId}">
            <c:param name="page" value="1"/>
            <c:if test="${not empty param.sortedtype}">
                <c:param name="sortedtype" value="${param.sortedtype}"/>
            </c:if>
        </c:url>
        <a class="css-1d20dg7 e82lnfz0 to-start">
            <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAkAAAAHCAQAAABwkq/rAAAAHUlEQVR42mNgAIPi/8X/kWkwA8SE0UQIMJAsCKMBBzk27fqtkcYAAAAASUVORK5CYII="
                 alt="처음 페이지로 이동하기 아이콘"/>
        </a>

        <%-- 이전 페이지 이동 --%>
        <c:url var="urlPaging" value="/categories/${codeId}">
            <c:param name="page" value="${pageHandler.beginPage-1}"/>
            <c:if test="${not empty param.sortedtype}">
                <c:param name="sortedtype" value="${param.sortedtype}"/>
            </c:if>
        </c:url>
        <a class="css-1d20dg7 e82lnfz0 move-once to-prev">
            <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAHCAQAAABqrk9lAAAAGElEQVR42mNgAIPi/8X/4QwwE5PBQJADAAKSG3cyVhtXAAAAAElFTkSuQmCC"
                 alt="이전 페이지로 이동하기 아이콘"/>
        </a>


        <%-- 페이지 목록--%>
        <c:forEach var="num" begin="${pageHandler.beginPage}" end="${pageHandler.endPage}">
            <c:url var="urlPaging" value="/categories/${codeId}">
                <c:param name="page" value="${num}"/>
                <c:if test="${not empty param.sortedtype}">
                    <c:param name="sortedtype" value="${param.sortedtype}"/>
                </c:if>
            </c:url>

            <a class="page-number e82lnfz0 ${pageHandler.page == num ? "css-19yo1fh":"css-1d20dg7"}">${num}</a>

            <%--            <a class=" e82lnfz0 ${pageHandler.page == num ? "css-19yo1fh":"css-1d20dg7"}"--%>
            <%--               href="<c:url value='/categories/${codeId}?page=${num}'/>">${num}</a>--%>
        </c:forEach>


        <%-- 다음 페이지로 이동 --%>
        <c:url var="urlPaging" value="/categories/${codeId}">
            <c:param name="page" value="${pageHandler.endPage+1}"/>
            <c:if test="${not empty param.sortedtype}">
                <c:param name="sortedtype" value="${param.sortedtype}"/>
            </c:if>
        </c:url>
        <a class="css-1d20dg7 e82lnfz0 move-once to-next">
            <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAHCAQAAABqrk9lAAAAGUlEQVR42mMo/l/8nwECQEwCHEwGhAlRBgA2mht3SwgzrwAAAABJRU5ErkJggg=="
                 alt="다음 페이지로 이동하기 아이콘"/>
        </a>

        <%-- 맨끝 페이지로 이동 --%>
        <c:url var="urlPaging" value="/categories/${codeId}">
            <c:param name="page" value="${pageHandler.totalPage}"/>
            <c:if test="${not empty param.sortedtype}">
                <c:param name="sortedtype" value="${param.sortedtype}"/>
            </c:if>
        </c:url>
        <a class="css-1d20dg7 e82lnfz0 to-end">
            <img
                    src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAkAAAAHCAQAAABwkq/rAAAAIElEQVR42mMo/l/8n4GBgQFGQ5kgDowmQZCwAMImhDkAb0k27Zcisn8AAAAASUVORK5CYII="
                    alt="마지막 페이지로 이동하기 아이콘"/></a>


    </div>
</div>


<script>

    //가격필터 기준 계산하기
    let numbers = ['${criteria[0]}', '${criteria[1]}', '${criteria[2]}'];

    for (let i = 0; i < numbers.length; i++) {
        numbers[i] = parseInt(numbers[i], 10);
        numbers[i] = Math.floor(numbers[i] / 100) * 100;
        numbers[i] = numbers[i].toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }

    let codeId = "";
    let uri = "";
    let sortedType;
    let filters = "";
    let PriceFilterNum;

    let page = 1;
    let endPage = 9999;

    let queryString = window.location.search;
    var searchParams = new URLSearchParams(queryString);
    var sword = searchParams.get('sword');


    $(document).ready(function () {
        $(".css-19ce13b").each(function () {
            $(this).on("click", function () {
                $(".css-19ce13b").removeClass("css-126imjl"); // css클래스 초기화
                $(this).addClass("css-126imjl"); //클릭한 곳에 css클래스 추가

                switch ($(this).text()) {
                    case "신상품순":
                        sortedType = 1;
                        break;
                    case "판매량순":
                        sortedType = 2;
                        break;
                    case "혜택순":
                        sortedType = 3;
                        break;
                    case "낮은 가격순":
                        sortedType = 4;
                        break;
                    case "높은 가격순":
                        sortedType = 5;
                        break;
                }
                page = 1;
                extractCodeId();
                loadNewGoodsList();
            });
        });


        let previousButton = null;
        $('.css-cate-list-2').each(function () {
            $(this).on("click", function () {

                let className = $(this).attr('class');

                var button = $(this).find('button');
                var svg = button.find('svg');
                var paths = svg.find('path');

                // 클릭된 버튼 다시 누를때
                if (previousButton && button.is(previousButton)) {
                    // 현재 버튼의 클래스에 PriceFilterNum 값이 있는지 확인
                    if (className.includes('price-filter-' + PriceFilterNum)) {
                        // PriceFilterNum 값 초기화
                        PriceFilterNum = null;
                        // SVG 색상을 원래대로 변경
                        paths.attr('fill', '#fff');
                        // 이전 버튼 초기화
                        previousButton = null;
                        // 페이지 다시 로드
                        page = 1;
                        loadNewGoodsList();
                        return; // 함수 종료
                    }
                }

                if (previousButton) { //이전 버튼이 있으면 색을 바꿈
                    let previousButtonSvg = previousButton.find('svg');
                    let previousButtonPaths = previousButtonSvg.find('path');
                    previousButtonPaths.attr('fill', '#fff');
                }

                previousButton = button; //현재버튼을 이전버튼으로

                if (className.includes('price-filter-1')) {
                    paths.attr('fill', '#11967f');
                    PriceFilterNum = 1;
                }
                if (className.includes('price-filter-2')) {
                    paths.attr('fill', '#11967f');
                    PriceFilterNum = 2;
                }
                if (className.includes('price-filter-3')) {
                    paths.attr('fill', '#11967f');
                    PriceFilterNum = 3;
                }
                if (className.includes('price-filter-4')) {
                    paths.attr('fill', '#11967f');
                    PriceFilterNum = 4;
                }

                page = 1;
                loadNewGoodsList();
            });
        });


        // 특정 페이지로 이동
        $(document).on("click", ".page-number", function () {
            page = parseInt($(this).text());//생성된 페이지 값을 page에 저장
            loadNewGoodsList();
        });

        // 한 페이지씩 이동
        $(document).on("click", ".move-once", function () {
            if ($(this).hasClass("to-prev")) {
                if (page - 1 < 1) return;
                page--;
            } else {
                if (page + 1 > endPage) return;
                page++;
            }
            loadNewGoodsList();
        });

        $(document).on("click", ".to-start", function () {
            page = 1;
            loadNewGoodsList();
        });

        $(document).on("click", ".to-end", function () {
            page = endPage;
            loadNewGoodsList();
        })

        // 가격필터 값 바꾸기
        $(".price-criteria-1").text(numbers[0] + '원 미만');
        $(".price-criteria-2").text(numbers[0] + '원 ~ ' + numbers[1] + '원');
        $(".price-criteria-3").text(numbers[1] + '원 ~ ' + numbers[2] + '원');
        $(".price-criteria-4").text(numbers[2] + '원 이상');

    });

    // 검색했을 경우
    if (sword != null) {

        $(".best-menu-wrap2").hide();

        let showSearchKeyword = "'"
            + '<div class="css-1uk9d3w e1yof8004">'
            + '<span class="css-1qfsi3d e1yof8003">'
            + sword
            + "</span>"
            + "</div>"
            + "'"
            + '<span class="css-mmvz9h e1yof8002">에 대한 검색결과</span>'

        $(".best-name").html(showSearchKeyword);

        if (!goodsListDto || goodsListDto.length === 0) {

            $(".best-content-wrap").hide();
            $(".css-rdz8z7").hide(); //페이징 숨기기

        }
    }


    $('.best-menu-name').each(function () {
        const codeURI = window.location.pathname.replace("/categories/", "");

        if (codeURI === $(this).attr('class').replace("best-menu-name ", "")) {
            $(this).css('color', '#11967f');
            $(this).css('font-weight', '600');

        }
    });

    function extractCodeId() {
        let pathname = window.location.pathname;
        codeId = pathname.replace("/categories/", "");
    }

    function readGoodsListHTML(goods) {
        let itemHTML = '<a href="/goods/' + goods.itemId + '" class="css-9o2zup e1c07x4813">'
            + '<div class="css-0 e1c07x4811">' + '<div class="e1c07x4812 css-tou8lf e3um3060">'
            + '<span style="'
            + 'box-sizing: border-box;'
            + 'display: block;'
            + 'overflow: hidden;'
            + 'width: initial;'
            + 'height: initial;'
            + 'background: none;'
            + 'opacity: 1;'
            + 'border: 0px;'
            + 'margin: 0px;'
            + 'padding: 0px;'
            + 'position: absolute;'
            + 'inset: 0px;">'
            + '<img alt="상품 이미지" sizes="100vw" srcset='
            + 'https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg  640w,'
            + 'https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg  750w,'
            + 'https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg  828w,'
            + 'https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 1080w,'
            + 'https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 1200w,'
            + 'https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 1920w,'
            + 'https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 2048w,'
            + 'https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg 3840w"'
            + 'src="https://img-cf.kurly.com/cdn-cgi/image/fit=crop,width=360,height=468,quality=85/shop/data/goods/1646377916155l0.jpg"'
            + 'decoding="async" data-nimg="fill" class="css-0"'
            + 'style="'
            + 'position: absolute;'
            + 'inset: 0px;'
            + 'box-sizing: border-box;'
            + 'padding: 0px;'
            + 'border: none;'
            + 'margin: auto;'
            + 'display: block;'
            + 'width: 0px;'
            + 'height: 0px;'
            + 'min-width: 100%;'
            + 'max-width: 100%;'
            + 'min-height: 100%;'
            + 'max-height: 100%;'
            + 'object-fit: cover;'
            + '"></span>'
            + '</div>'
            + '</div>'
            + '<div class="button-wrapper">'
            + '<button type="button" class="css-13xu5fn e17x72af0">'
            + '<svg width="18" height="18" viewBox="0 0 18 18" fill="none"'
            + 'xmlns="http://www.w3.org/2000/svg">'
            + '<path d="M1.53516 '
            + '2.70001H3.93316L5.76816 10.609H13.6482L15.2992 '
            + '4.35901H4.86916M12.8582 14.933C13.0098 14.9375 13.1609 '
            + '14.9115 13.3024 14.8566C13.4438 14.8017 13.5728 14.7189 '
            + '13.6817 14.6132C13.7906 14.5075 13.8771 14.381 13.9363 '
            + '14.2412C13.9954 14.1015 14.0258 13.9513 14.0258 '
            + '13.7995C14.0258 13.6478 13.9954 13.4975 13.9363 '
            + '13.3578C13.8771 13.218 13.7906 13.0915 13.6817 '
            + '12.9858C13.5728 12.8801 13.4438 12.7974 13.3024 '
            + '12.7424C13.1609 12.6875 13.0098 12.6615 12.8582 '
            + '12.666C12.5634 12.6748 12.2836 12.798 12.0782 '
            + '13.0096C11.8727 13.2213 11.7578 13.5046 11.7578 '
            + '13.7995C11.7578 14.0944 11.8727 14.3778 12.0782 '
            + '14.5894C12.2836 14.801 12.5634 14.9243 12.8582 '
            + '14.933ZM6.49316 14.933C6.64484 14.9375 6.79589 14.9115 '
            + '6.93735 14.8566C7.07881 14.8017 7.20781 14.7189 7.31669 '
            + '14.6132C7.42558 14.5075 7.51214 14.381 7.57126 '
            + '14.2412C7.63037 14.1015 7.66083 13.9513 7.66083 '
            + '13.7995C7.66083 13.6478 7.63037 13.4975 7.57126 '
            + '13.3578C7.51214 13.218 7.42558 13.0915 7.31669 '
            + '12.9858C7.20781 12.8801 7.07881 12.7974 6.93735 '
            + '12.7424C6.79589 12.6875 6.64484 12.6615 6.49316 '
            + '12.666C6.19836 12.6748 5.91858 12.798 5.71315 '
            + '13.0096C5.50773 13.2213 5.39283 13.5046 5.39283 '
            + '13.7995C5.39283 14.0944 5.50773 14.3778 5.71315 '
            + '14.5894C5.91858 14.801 6.19836 14.9243 6.49316 14.933Z" '
            + 'stroke="#333333" stroke-linecap="square" stroke-linejoin="round"></path>'
            + '</svg>'
            + "담기"
            + '</button>'
            + '</div>'
            + '<div class="css-1kpzrna e1c07x489">'
            + '<span class="css-1qd61ut e1ms5t9c1">'
            + '<span class="css-1vdqr5b e1ms5t9c0">'
            + goods.shipType
            + '</span></span>'
            + '<span class="css-1dry2r1 e1c07x488">'
            + goods.name
            + '</span>'
            + '<p class="css-1wejlc3 e1c07x486">'
            + goods.exp
            + '</p>'
            + '<div class="e1c07x487 discount-price css-1tl7659 ei5rudb2">'
            + '<div>';
        if (goods.dcRt !== 0) {
            itemHTML += '<span class="dimmed-price css-18tpqqq ei5rudb1">'
                + goods.price
                + '<span class="won">'
                + '원'
                + '</span>'
                + '</span>';
        }
        itemHTML += '</div>'
            + '<div class="discount">';
        if (goods.dcRt !== 0) {
            itemHTML += '<span class="discount-rate css-19lkxd2 ei5rudb0">'
                + goods.dcRt + '%'
                + '</span>';
        }
        itemHTML += '<span class="sales-price css-18tpqqq ei5rudb1">'
            + goods.disPrice
            + '<span class="won">' + '원'
            + '</span></span>'
            + '</div>'
            + '</div>'
            + '<div class="review-count css-xezqwk e1c07x482">'
            + '<span class="css-mz5g71 e1c07x481">'
            + '<svg width="100%" height="100%" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">'
            + '<mask id="path-1-inside-1_1513_17755" fill="white">'
            + '<path fill-rule="evenodd" clip-rule="evenodd"'
            + 'd="M3 2C1.89543 2 1 2.89543 1 4V8.67201C1 '
            + '9.77658 1.89543 10.672 3 10.672H5.11212L6.33682 '
            + '12.7653C6.5299 13.0954 7.00688 13.0954 7.19995 '
            + '12.7653L8.42465 10.672H10.5C11.6046 10.672 12.5 9.77658 '
            + '12.5 8.67201V4C12.5 2.89543 11.6046 2 10.5 2H3Z"></path>'
            + '</mask>'
            + '<path fill="#999" '
            + 'd="M5.11212 10.672L5.97526 10.167L5.68564 '
            + '9.67201H5.11212V10.672ZM6.33682 12.7653L5.47369 '
            + '13.2703L5.47369 13.2703L6.33682 12.7653ZM7.19995 '
            + '12.7653L6.33682 12.2604L6.33682 12.2604L7.19995 '
            + '12.7653ZM8.42465 10.672V9.67201H7.85113L7.56152 '
            + '10.167L8.42465 10.672ZM2 4C2 3.44772 2.44772 3 3 '
            + '3V1C1.34315 1 0 2.34315 0 4H2ZM2 8.67201V4H0V8.67201H2ZM3 '
            + '9.67201C2.44772 9.67201 2 9.22429 2 8.67201H0C0 10.3289 '
            + '1.34315 11.672 3 11.672V9.67201ZM5.11212 '
            + '9.67201H3V11.672H5.11212V9.67201ZM7.19995 12.2604L5.97526 '
            + '10.167L4.24899 11.177L5.47369 13.2703L7.19995 '
            + '12.2604ZM6.33682 12.2604C6.5299 11.9304 7.00688 11.9304 '
            + '7.19995 12.2604L5.47369 13.2703C6.05291 14.2604 7.48386 '
            + '14.2604 8.06309 13.2703L6.33682 12.2604ZM7.56152 '
            + '10.167L6.33682 12.2604L8.06309 13.2703L9.28779 '
            + '11.177L7.56152 10.167ZM10.5 '
            + '9.67201H8.42465V11.672H10.5V9.67201ZM11.5 8.67201C11.5 '
            + '9.22429 11.0523 9.67201 10.5 9.67201V11.672C12.1569 '
            + '11.672 13.5 10.3289 13.5 8.67201H11.5ZM11.5 '
            + '4V8.67201H13.5V4H11.5ZM10.5 3C11.0523 3 11.5 3.44772 11.5 '
            + '4H13.5C13.5 2.34315 12.1569 1 10.5 1V3ZM3 3H10.5V1H3V3Z" '
            + 'mask="url(#path-1-inside-1_1513_17755)"></path>'
            + '<circle fill="#999" cx="4.34998" cy="6.17871" r="0.75"></circle>'
            + '<circle fill="#999" cx="6.75" cy="6.17871" r="0.75"></circle>'
            + '<circle fill="#999" cx="9.15002" cy="6.17871" r="0.75">'
            + '</circle></svg></span>'
            + '<span class="review-number css-l610kl e1c07x480">'
            + goods.revCnt
            + '</span>'
            + '</div>'
            + '<div class="css-1hrnl0u e1cvv2hm1">'
            + '</div>'
            + '</div>'
            + '</a>';

        return itemHTML;
    }


    function loadNewGoodsList() {
        console.log("IN");
        $.ajax({
            url: window.location.pathname, // /categories/901?page=1
            type: "POST",
            data: {
                "codeId": codeId,
                "sortedType": sortedType,
                "page": page,
                "PriceFilterNum": PriceFilterNum,
                "sword": sword
            },
            success: function (response) {
                let sortedGoodsList = response.sortedGoodsList;
                let readGoodsLisByFilter = response.readGoodsLisByFilter;
                let containerForSort = $('.best-itemlist');
                containerForSort.html(" ");

                let pageHandler = response.pageHandler;
                endPage = pageHandler.endPage;

                console.log(pageHandler);

                let containerForPaging = $('.css-rdz8z7');
                containerForPaging.html(" ");

                //신상품순, 판매량순, 혜택순, 낮은가격순, 높은가격순
                // itemHTML=sortedGoodsList.map(readGoodsListHTML);

                // if(PriceFilterNum!=null){
                itemHTML = readGoodsLisByFilter.map(readGoodsListHTML);
                // }

                containerForSort.append(itemHTML);

                let pagingHTML = '';

                let firstPageBtn = '<a class="css-1d20dg7 e82lnfz0 to-start">'
                    + '<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAkAAAAHCAQAAABwkq/rAAAAHUlEQVR42mNgAIPi/8X/kWkwA8SE0UQIMJAsCKMBBzk27fqtkcYAAAAASUVORK5CYII=" alt="처음 페이지로 이동하기 아이콘"/>'
                    + '</a>';

                let prevBtn = '<a class="css-1d20dg7 e82lnfz0 move-once to-prev" >'
                    + '<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAHCAQAAABqrk9lAAAAGElEQVR42mNgAIPi/8X/4QwwE5PBQJADAAKSG3cyVhtXAAAAAElFTkSuQmCC" alt="이전 페이지로 이동하기 아이콘"/>'
                    + '</a>';

                pagingHTML += firstPageBtn + prevBtn;

                for (let currentPage = 1; currentPage <= pageHandler.endPage; currentPage++) {
                    let className = (pageHandler.page === currentPage ? "css-19yo1fh" : "css-1d20dg7");
                    pagingHTML += '<a class="e82lnfz0 page-number ' + className + '" >' + currentPage + '</a>';
                }

                let nextBtn = '<a class="css-1d20dg7 e82lnfz0 move-once" >'
                    + '<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAHCAQAAABqrk9lAAAAGUlEQVR42mMo/l/8nwECQEwCHEwGhAlRBgA2mht3SwgzrwAAAABJRU5ErkJggg==" alt="다음 페이지로 이동하기 아이콘"/>'
                    + '</a>';

                let endPageBtn = '<a class="css-1d20dg7 e82lnfz0 to-end" >'
                    + '<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAkAAAAHCAQAAABwkq/rAAAAIElEQVR42mMo/l/8n4GBgQFGQ5kgDowmQZCwAMImhDkAb0k27Zcisn8AAAAASUVORK5CYII=" alt="마지막 페이지로 이동하기 아이콘"/>'
                    + '</a>';

                pagingHTML += nextBtn + endPageBtn;
                containerForPaging.append(pagingHTML);


                $(".goodstotalCnt").text('총 ' + response.totalCnt + '건');


            },
            error: function (xhr, status, error) {
                // 오류 처리 로직
            }
        });
    }


    // function addQueryString(text) {

    //
    //     var storageKey = 'filter_' + text;
    //     if (localStorage.getItem(storageKey) == null) {
    //         localStorage.setItem(storageKey, '0');
    //     }
    //     var clickCnt = localStorage.getItem(storageKey);
    //     var url = window.location.href;
    //
    //     var result;
    //     var encodedText = encodeURIComponent(text); // 미리 encode 해두기
    //     console.log(clickCnt);
    //
    //     if (clickCnt === '0') {
    //         if (!url.includes('filters')) {
    //             if (!url.includes(encodedText)) {
    //                 result = url + '&filters=delivery_type' + encodeURIComponent(':') + encodedText;
    //             } else {
    //                 result = url;
    //             }
    //         } else {
    //             if (!url.includes(encodedText)) {
    //                 result = url + encodeURIComponent(',') + encodedText;
    //             } else {
    //                 result = url;
    //             }
    //         }
    //         clickCnt = '1';
    //
    //     } else if (clickCnt === '1') {
    //         if (url.includes(encodedText + encodeURIComponent(','))) {
    //             result = url.replace(encodedText + encodeURIComponent(','), "");
    //         } else if (url.includes(encodeURIComponent(',') + encodedText)) {
    //             result = url.replace(encodeURIComponent(',') + encodedText, "");
    //         } else {
    //             result = url.replace('&filters=delivery_type%3A' + encodedText, "");
    //         }
    //         clickCnt = '0';
    //
    //     }
    //     localStorage.setItem(storageKey, clickCnt);
    //     window.location.href = result;
    //
    // }


    // let clickCnt =0
    //
    // function addQueryString(text){
    //
    //     var url = window.location.href;
    //     var result;
    //
    //
    //
    //
    //     if(clickCnt===0) {
    //         if (!url.includes('filters')) {
    //             if (!url.includes(text)) {
    //
    //                 result = url + '&filters=delivery_type' + encodeURIComponent(':' + text);
    //                 console.log(clickCnt);
    //             } else {
    //                 result = url;
    //             }
    //         } else {
    //             if (!url.includes(text)) {
    //
    //                 result = url + encodeURIComponent(',' + text);
    //             } else {
    //                 result = url;
    //             }
    //         }
    //         clickCnt=1;
    //
    //
    //     }
    //      else if(clickCnt===1){
    //          if(!url.includes(encodeURIComponent(','))){
    //
    //              result = url.replace('delivery_type%3A' + encodeURIComponent(text), "");
    //          }
    //          else{
    //
    //              result = url.replace( encodeURIComponent(','+text), "");
    //          }
    //
    //
    //          clickCnt =0;
    //      }
    //
    //     window.location.href = result;
    //
    // }


</script>



</body>
</html>
