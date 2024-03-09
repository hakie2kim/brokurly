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
    <link rel="stylesheet" href="<c:url value='/resources/css/mypage/pick-list.css'/>"/>
    <title>컬리 - 마켓컬리/뷰티컬리</title>
</head>
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
        <div class="header">
            <div class="title">
                <h2>찜한 상품(${wishListItemCounter})</h2>
                <span class="desc">찜한 상품은 최대 200개까지 저장됩니다.</span>
            </div>
        </div>
        <div class="wish-list">
            <c:if test="${wishListItemCounter ne 0}">
                <c:forEach var="wishListItem" items="${wishListItemList}">
                    <div class="css-1pj4itr e1jp10d17" style="width: 100%">
                        <a href="/goods/1000431280" class="css-zw1kn5 e1jp10d16"
                        ><span width="60" height="78" class="css-s2pfj eq9umyc2"
                        ><span
                                style="
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
                      "
                        ><img
                                alt=""
                                sizes="100vw"
                                src="https://product-image.kurly.com/cdn-cgi/image/width=120,height=156,fit=crop,quality=85/product/image/4b6bba61-b8a0-49c6-95f2-4c178f13319f.jpg"
                                decoding="async"
                                data-nimg="fill"
                                class="css-0"
                                style="
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
                        "/></span></span
                        ></a>
                        <div class="css-14z46lg e1jp10d15">
                            <div class="css-a3z6ut e1jp10d14">
                                <div class="css-v2aaoi e1jp10d12">
                                    <a href="/goods/1000431280" class="css-4ejps8 e1jp10d13"
                                    >${wishListItem.name}</a
                                    >
                                </div>
                                <div class="css-1d6cvj1 e1jp10d11">
                                    <span class="css-x4qt93 e1alt0er2">${wishListItem.dcRt}%</span>
                                    <span class="css-153tu4t e1alt0er1"><fmt:formatNumber pattern="#,###원"
                                                                                          value="${wishListItem.price - wishListItem.itemDcAmt}"/></span>
                                    <span class="css-1h2g4dm e1alt0er0"><fmt:formatNumber pattern="#,###원"
                                                                                          value="${wishListItem.price}"/></span>
                                </div>
                            </div>
                            <div class="css-jx12wb e1jp10d10">
                                <button
                                        class="css-17giheb e4nu7ef3"
                                        type="button"
                                        width="104"
                                        height="36"
                                        radius="4"
                                >
                                    <span class="css-abcde e4nu7ef1">삭제</span>
                                </button>
                                <button
                                        class="css-x0zbdy e4nu7ef3"
                                        type="button"
                                        width="104"
                                        height="36"
                                        radius="4"
                                >
                                <span class="css-nytqmg e4nu7ef1">
                                    <img
                                            src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzYiIGhlaWdodD0iMzYiIHZpZXdCb3g9IjAgMCAzNiAzNiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTTM2IDM2SDBWMGgzNnoiLz4KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg1LjE2NCA2LjU0NykiIHN0cm9rZT0iIzVmMDA4MCIgc3Ryb2tlLWxpbmVjYXA9InNxdWFyZSIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIxLjciPgogICAgICAgICAgICA8cGF0aCBkPSJtMjUuNjggMy42Ni0yLjcyIDExLjU3SDcuMzdMNC42NiAzLjY2eiIvPgogICAgICAgICAgICA8Y2lyY2xlIGN4PSIyMC41MiIgY3k9IjIwLjc4IiByPSIyLjE0Ii8+CiAgICAgICAgICAgIDxjaXJjbGUgY3g9IjkuODEiIGN5PSIyMC43OCIgcj0iMi4xNCIvPgogICAgICAgICAgICA8cGF0aCBkPSJNMCAwaDMuOGwxLjc2IDcuNSIvPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+Cg=="
                                            alt=""
                                            class="css-1m3kac1 e4nu7ef0"
                                    />담기</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
