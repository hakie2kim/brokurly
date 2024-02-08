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
    <link rel="stylesheet" href="<c:url value='/resources/css/mypage/point-usage-log.css'/>"/>
    <title>적립금 내역</title>
</head>
<body>
    <div class="app">
        <main>
            <header>적립금 내역</header>
            <div class="content">
                <div class="stat">
                    <div class="avail">
                        <div class="header">
                            <div class="wrapper">
                                <span>사용 가능 적립금</span>
                                <div class="icon">
                                    <svg
                                            width="12"
                                            height="12"
                                            viewBox="0 0 12 12"
                                            fill="none"
                                            xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                                d="M5.39732 7.18162H6.32143V6.91317C6.32143 6.45988 6.48661 6.22664 7.0625 5.89218C7.65179 5.54452 8 5.06483 8 4.3871V4.3783C8 3.44093 7.20536 2.75 6.02679 2.75C4.73214 2.75 4.04018 3.50694 4 4.50152V4.51032L4.91964 4.50592H4.92857C4.96429 3.92502 5.36161 3.55975 5.97768 3.55975C6.58929 3.55975 6.98661 3.92502 6.98661 4.41791V4.42671C6.98661 4.87559 6.79464 5.13084 6.25446 5.4521C5.64286 5.81297 5.37054 6.20904 5.39286 6.82955L5.39732 7.18162ZM5.91518 9.25C6.32589 9.25 6.60268 8.98595 6.60268 8.59428C6.60268 8.19821 6.32589 7.93416 5.91518 7.93416C5.50446 7.93416 5.22321 8.19821 5.22321 8.59428C5.22321 8.98595 5.50446 9.25 5.91518 9.25Z"
                                                fill="#5F0080"
                                        ></path>
                                        <circle cx="6" cy="6" r="5.5" stroke="#5F0080"></circle>
                                    </svg>
                                </div>
                            </div>
                            <div class="price">
                                <div class="wrapper">
                                    <span class="amount">0</span><span class="won">원</span>
                                </div>
                            </div>
                            <div class="details">
                                <div class="row">
                                    <span>소멸예정 금액 (30일 이내)</span>
                                    <span class="amount">0원</span>
                                </div>
                                <div class="row">
                                    <span>총 누적 적립금 (가입일 기준)</span>
                                    <span class="amount">8,223원</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="blank-line"></div>
                <img
                        alt="컬리상품권 2% 혜택 안내 배너"
                        loading="lazy"
                        width="1125"
                        height="186"
                        decoding="async"
                        data-nimg="1"
                        class="u75ne30 u75ne35 _1siu7xkt"
                        srcset="
                  https://www.kurlypay.co.kr/images/mypage/point/PointPromotionBannerA.png?width=1200 1x,
                  https://www.kurlypay.co.kr/images/mypage/point/PointPromotionBannerA.png?width=3840 2x
                "
                        src="https://www.kurlypay.co.kr/images/mypage/point/PointPromotionBannerA.png?width=3840"
                        style="color: transparent"
                />
                <div class="blank-line"></div>
                <div class="bottom">
                    <div class="row1">
                        <div class="button-wrapper"><span>전체</span></div>
                        <div class="button-wrapper"><span>적립</span></div>
                        <div class="button-wrapper"><span>사용</span></div>
                        <div class="button-wrapper"><span>소멸</span></div>
                    </div>
                    <div class="row2">
                        <span>총 ${pointLogUsageCount}건</span>
                        <form action="/mypage/point" method="get">
                            <select name="period" onchange="this.form.submit()">
                                <option value="3" <c:if test="${period == 3}">selected</c:if>>3개월</option>
                                <option value="6" <c:if test="${period == 6}">selected</c:if>>6개월</option>
                                <option value="12" <c:if test="${period == 12}">selected</c:if>>12개월</option>
                            </select>
                        </form>
                    </div>
                    <div class="row3">
                        <c:forEach var="pointUsageLog" items="${pointLogUsageList}" varStatus="status">
                            <div class="wrapper">
                                <div class="date"><fmt:formatDate pattern="yyyy.MM.dd" value="${pointUsageLog.procDt}"/></div>
                                <div class="details">
                                    <div class="left">
                                        <div class="icon">
                                            <div class="background"></div>
                                            <div class="icon-wrapper">
                                                <div class="icon-status">
                                                    <span>${pointUsageLog.pointStat}</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="titles">
                                            <span class="main">${pointUsageLog.pointSpec}</span>
                                            <span class="sub">주문번호 (${pointUsageLog.orderId})</span>
                                        </div>
                                    </div>
                                    <div class="right"><fmt:formatNumber pattern="#,###원" value="${pointUsageLog.pointAmt}"/></div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
