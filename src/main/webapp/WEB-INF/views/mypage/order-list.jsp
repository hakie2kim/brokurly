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
    <link rel="stylesheet" href="<c:url value='/resources/css/mypage/order-list.css'/>"/>
    <title>컬리 - 마켓컬리/뷰티컬리</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    window.onload = () => {
    }
</script>
<body>
<jsp:include page="/WEB-INF/views/mypage/tiles.jsp"/>
<div class="bottom">
    <jsp:include page="/WEB-INF/views/mypage/sidebar.jsp"/>
    <div class="content">
        <div class="header">
            <div class="title">
                <h2>주문 내역</h2>
                <span class="desc">최대 지난 3년간의 주문 내역까지 확인할 수 있어요</span>
            </div>
            <div class="period">
                <select name="period">
                    <option value="0.25">3개월</option>
                    <option value="0.5">6개월</option>
                    <option value="1">1년</option>
                    <option value="3">3년</option>
                </select>
            </div>
        </div>
        <div class="order-list">
            <c:if test="${orderLogCnt ne 0}">
                <c:forEach var="orderLog" items="${orderLogList}">
                    <div class="order">
                        <div class="title">
                            <span><fmt:formatDate value="${orderLog.order.orderDt}"
                                                  pattern="yyyy.MM.dd (HH'시' mm'분')"/></span>
                            <a href="/mypage/order/${orderLog.order.orderId}">주문내역 상세보기</a>
                        </div>
                        <div class="desc">
                            <div class="desc1">
                                <img
                                        src="https://img-cf.kurly.com/cdn-cgi/image/width=120,height=156,fit=crop,quality=85/shop/data/goods/1657530497306l0.jpg"
                                        alt="[조선호텔김치] 갓김치 상품 이미지"
                                />
                                <div class="details">
                                    <dl class="css-1ccl3pq e1437c646">
                                        <dt class="css-dzjp62 e1437c645">상품명</dt>
                                        <dd class="css-1o8e829 e1437c643">
                                                ${orderLog.itemName}
                                        </dd>
                                    </dl>
                                    <dl class="css-1ccl3pq e1437c646">
                                        <dt class="css-dzjp62 e1437c645">주문번호</dt>
                                        <dd class="css-1i58pf4 e1437c644">${orderLog.order.orderId}</dd>
                                    </dl>
                                    <dl class="css-1ccl3pq e1437c646">
                                        <dt class="css-dzjp62 e1437c645">결제방법</dt>
                                        <dd class="css-1i58pf4 e1437c644">${orderLog.payMthd}</dd>
                                    </dl>
                                    <dl class="css-1ccl3pq e1437c646">
                                        <dt class="css-dzjp62 e1437c645">결제금액</dt>
                                        <dd class="css-1i58pf4 e1437c644"><fmt:formatNumber
                                                value="${orderLog.order.totalPrice}" pattern="#,###원"/></dd>
                                    </dl>
                                </div>
                            </div>
                            <div class="desc2">
                                <span class="deli-stat">${orderLog.order.orderStat}</span>
                                <div style="width: 96px">
                                    <button>
                                        <span>1:1 문의</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${orderLogCnt eq 0}">
                <div class="warning-orders">
                    <div class="wrapper">
                        <p>3개월 간의 주문내역이 없습니다.</p>
                        <button>
                            <span>베스트 상품 보기</span>
                        </button>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
