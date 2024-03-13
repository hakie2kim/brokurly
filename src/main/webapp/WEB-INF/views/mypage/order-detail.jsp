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
    <link rel="stylesheet" href="<c:url value='/resources/css/mypage/order-detail.css'/>"/>
    <title>컬리 - 마켓컬리/뷰티컬리</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    window.onload = () => {
    }
</script>
<body>
<div class="top">
    <div class="tiles">
        <div class="tile1">
            <div class="member">
                <div class="grade">일반</div>
                <div class="info">
                    <strong class="name">정충교님</strong>
                    <div class="grade-check">
                        <button class="next-month">다음 달 등급 확인</button>
                        <span>·</span>
                        <button class="all">전체 등급 확인</button>
                    </div>
                </div>
            </div>
            <div class="membership">
                <a href="/member/membership">
              <span class="kurly-members">
                <span class="new">NEW</span>
                <span class="name">컬리멤버스</span>
                <span class="benefit">월 1,900원으로 10배 쿠폰 받기</span>
                <span>></span>
              </span>
                </a>
            </div>
        </div>
        <div class="tile2">
            <div class="box1">
                <button>
                    <div class="title">적립금 · 컬리캐시<span>></span></div>
                    <div class="desc">바로가기<span></span></div>
                </button>
            </div>
            <div class="box2">
                <button>
                    <div class="title">쿠폰<span>></span></div>
                    <div class="desc">1<span>개</span></div>
                </button>
            </div>
            <div class="box3">
                <button>
                    <div class="title">나의 컬리 스타일<span>></span></div>
                    <div class="desc">등록하기</div>
                </button>
            </div>
        </div>
        <div class="tile3">
            <div>
                <button>
                    <div class="title">컬리퍼플박스<span>></span></div>
                    <div class="desc">알아보기</div>
                </button>
            </div>
            <div>
                <button>
                    <div class="title">컬리멤버스<span>></span></div>
                    <div class="desc">혜택받기</div>
                </button>
            </div>
        </div>
    </div>
    <div class="event">
        <a
                href="https://www.kurly.com/shop/event/kurlyEventV2.php?lego=event/2024/0111/lucky"
        >
            <img
                    src="https://product-image.kurly.com/cdn-cgi/image/width=1150,quality=85,format=auto/banner/da-banner/e2b2bea9-934b-4ad2-8629-1c4999e5fac4.jpg"
                    alt="240126 [뷰티][MA] 1월 행운래플"
            />
        </a>
    </div>
</div>
<div class="bottom">
    <div class="sidebar">
        <div class="name">마이컬리</div>
        <ul>
            <li>
                <a>주문내역 ></a>
            </li>
            <li>
                <a>선물내역 ></a>
            </li>
            <li>
                <a>자주 사는 상품 ></a>
            </li>
            <li>
                <a>찜한상품 ></a>
            </li>
            <li>
                <a>배송지 관리 ></a>
            </li>
            <li>
                <a>상품후기 ></a>
            </li>
            <li>
                <a>결제수단 · 컬리페이 ></a>
            </li>
            <li>
                <a>상품 문의 ></a>
            </li>
            <li>
                <a>적립금 · 컬리캐시 ></a>
            </li>
            <li>
                <a>쿠폰 ></a>
            </li>
            <li>
                <a>개인 정보 수정 ></a>
            </li>
        </ul>
        <a href="/mypage/inquiry/list" class="inquiry">
            <div class="wrapper">
                <span class="title">도움이 필요하신가요 ?</span>
                <span class="desc">1:1 문의하기</span>
            </div>
            <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="19"
                    height="19"
                    viewBox="0 0 24 24"
            >
                <defs>
                    <path
                            id="gfk9q0rhta"
                            d="M1.657 1.657L9.657 1.657 9.657 9.657"
                    ></path>
                </defs>
                <g fill="none" fill-rule="evenodd">
                    <g>
                        <g>
                            <g>
                                <g
                                        transform="translate(-339 -398) translate(0 386) translate(339 12) translate(4.69 6.343)"
                                >
                                    <use
                                            stroke="#333"
                                            stroke-linecap="round"
                                            stroke-width="1.8"
                                            stroke-linejoin="round"
                                            transform="rotate(45 5.657 5.657)"
                                            xlink:href="#gfk9q0rhta"
                                    ></use>
                                </g>
                            </g>
                        </g>
                    </g>
                </g>
            </svg>
        </a>
    </div>
    <div class="content">
        <div class="title">
            <h2>주문 내역 상세</h2>
        </div>
        <div class="box">
            <div class="deli-stat">
            <span class="date">
              <span>09/19(화)</span> 배송 완료되었습니다.
            </span>
                <p class="time">배송완료 시간 04:44</p>
            </div>
        </div>
        <div class="header">
            <h3>주문번호 <span>2318222270324</span></h3>
            <span class="inquiry">
            배송 또는 상품에 문제가 있나요?
            <a href="/mypage/inquiry/list"> 1:1 문의 ></a>
          </span>
        </div>
        <div class="item">
            <img
                    src="https://img-cf.kurly.com/cdn-cgi/image/width=120,height=156,fit=crop,quality=85/shop/data/goods/1657530497306l0.jpg"
                    alt="[조선호텔김치] 갓김치"
                    class="item-img"
            />
            <div class="item-info">
                <a data-testid="deal-name" href="/goods/5156430"
                >[조선호텔김치] 갓김치</a
                >
                <div>
                    <span class="item-price">16,000원</span>
                    <span class="item-amt">1개</span>
                </div>
            </div>
            <span class="deli-stat">배송완료</span>
            <div class="button-wrapper">
                <button width="96" height="36" radius="3">
                    <span>장바구니 담기</span>
                </button>
            </div>
        </div>
        <div class="entire-items">
            <button>
                <span>전체 상품 다시 담기</span>
            </button>
            <button disabled>
                <span>전체 상품 주문 취소</span>
            </button>
        </div>
        <span class="css-15leche e1egl70z0">
          주문취소는 [주문완료] 상태일 경우에만 가능합니다.
        </span>
        <div class="header">
            <h3>결제정보</h3>
        </div>
        <ul>
            <li>
            <span class="column-payment">상품금액</span
            ><span class="value">51,800<span class="won">원</span></span>
            </li>
            <li>
            <span class="column-payment">배송비</span
            ><span class="value">0<span class="won">원</span></span>
            </li>
            <li>
            <span class="column-payment">쿠폰할인</span
            ><span class="value">-6,734<span class="won">원</span></span>
            </li>
            <li>
            <span class="column-payment">카드즉시할인</span
            ><span class="value">0<span class="won">원</span></span>
            </li>
            <li>
            <span class="column-payment">적립금</span
            ><span class="value">0<span class="won">원</span></span>
            </li>
            <li>
            <span class="column-payment">결제금액</span
            ><span class="value">13,920<span class="won">원</span></span>
            </li>
            <li>
            <span class="column-payment">환불완료금액</span
            ><span class="value">31,146<span class="won">원</span></span>
            </li>
            <li>
                <span class="column-payment">결제방법</span>
                <div class="value">신용카드</div>
            </li>
            <div class="end-line"></div>
        </ul>
        <div class="header">
            <h3>주문정보</h3>
        </div>
        <ul>
            <li>
                <span class="column">주문번호</span>
                <span class="value">2318222270324</span>
            </li>
            <li>
                <span class="column">보내는 분</span>
                <span class="value">갱얼쥐</span>
            </li>
            <li>
                <span class="column">결제일시</span>
                <span class="value">2023-09-18 22:28:42</span>
            </li>
            <div class="end-line"></div>
        </ul>
        <div class="header">
            <h3>배송정보</h3>
        </div>
        <ul>
            <li>
                <span class="column">받는 분</span>
                <span class="value">갱얼쥐</span>
            </li>
            <li>
                <span class="column">핸드폰</span>
                <span class="value">010-2288-****</span>
            </li>
            <li>
                <span class="column">주소</span>
                <span class="value"
                >(08564) 서울특별시 양천구 강남대로 124 (미왕빌딩) 엘리베이터 옆
              구덩이</span
                >
            </li>
            <li>
                <span class="column">받으실 장소</span>
                <span class="value">문 앞</span>
            </li>
            <li>
                <span class="column">공동현관 출입방법</span>
                <span class="value">자유 출입 가능</span>
            </li>
            <li>
                <span class="column">메시지 전송시점</span>
                <span class="value">배송 직후</span>
            </li>
            <div class="end-line"></div>
        </ul>
    </div>
</div>
</body>
</html>
