<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/mypage/shipping-address-result.css'/>"/>
    <title>컬리 - 마켓컬리/뷰티컬리</title>
</head>
<body>
<form class="form" method="post">
    <strong>
        <span type="direct">샛별배송</span>
        지역입니다.
        <p>매일 새벽, 문 앞까지 신선함을 전해드려요.</p>
    </strong>
    <div class="row1">
        <input name="addr" value="${addr}" readonly>
        <button width="120" height="44" radius="3" onclick="history.back()">
          <span>
            <img
                    src="https://res.kurly.com/pc/service/common/2006/ico_search.svg"
            />재검색
          </span>
        </button>
    </div>
    <div class="row2">
        <input
                data-testid="input-box"
                id="specAddr"
                name="specAddr"
                placeholder="나머지 주소를 입력해 주세요"
                type="text"
                value=""
        />
    </div>
    <div class="row3">
        <label>
            <input type="checkbox"/>
            <svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
            >
                <path
                        d="M23.5 12C23.5 18.3513 18.3513 23.5 12 23.5C5.64873 23.5 0.5 18.3513 0.5 12C0.5 5.64873 5.64873 0.5 12 0.5C18.3513 0.5 23.5 5.64873 23.5 12Z"
                        stroke="#ddd"
                        fill="#fff"
                ></path>
                <path
                        d="M7 12.6667L10.3846 16L18 8.5"
                        stroke="#ddd"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                ></path>
            </svg>
            <span>기본 배송지로 저장</span>
        </label>
    </div>
    <button type="submit" height="44" radius="3">
        <span>저장</span>
    </button>
    <div class="notice">
        <strong>샛별배송 지역 중 배송불가 장소 안내</strong>
        <p>
            관공서 / 학교 / 병원 / 시장 / 공단지역 / 산간지역 / 백화점 등
            <button>자세히 보기<span></span></button>
        </p>
    </div>
</form>
</body>
</html>
