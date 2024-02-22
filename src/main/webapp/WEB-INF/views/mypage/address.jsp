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
    <link rel="stylesheet" href="<c:url value='/resources/css/mypage/address.css'/>"/>
    <title>컬리 - 마켓컬리/뷰티컬리</title>
</head>
<script>
    window.onload = () => {
        const receiverDetails = document.querySelector(".add-new-deli");
        receiverDetails.addEventListener("click", () => {
            const left = screen.width / 2 - 300;
            const top = screen.height / 2 - 350;
            window.open(
                "/mypage/address/shipping-address",
                "_blank",
                "width=600, height=700, left=" + left + ", top=" + top
            );
        });
    };
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
        <div class="header">
            <div class="title">
                <h2>배송지 관리</h2>
                <span class="desc"
                >배송지에 따라 상품정보 및 배송유형이 달라질 수 있습니다.</span
                >
            </div>
            <button class="add-new-deli">+ 새 배송지 추가</button>
        </div>
        <div class="sub-header">
            <div class="column" style="flex-basis: 60px">선택</div>
            <div class="column" style="flex: 1 1 0%">주소</div>
            <div class="column" style="flex-basis: 120px">받으실 분</div>
            <div class="column" style="flex-basis: 100px">연락처</div>
            <div class="column" style="flex-basis: 100px">배송유형</div>
            <div class="column" style="flex-basis: 60px">수정</div>
        </div>
        <div class="deli-list">
            <ul>
                <li>
                    <div style="display: flex">
                        <div class="column default">
                            <label for="kurly-address-18241898"
                            ><input
                                    id="kurly-address-18241898"
                                    type="checkbox"
                                    value="18241898"
                                    checked
                            />
                                <div style="margin-right: 12px">
                                    <svg
                                            width="24"
                                            height="24"
                                            viewBox="0 0 24 24"
                                            fill="none"
                                            xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                                d="M12 24C18.6274 24 24 18.6274 24 12C24 5.37258 18.6274 0 12 0C5.37258 0 0 5.37258 0 12C0 18.6274 5.37258 24 12 24Z"
                                                fill="#5f0080"
                                        ></path>
                                        <path
                                                d="M7 12.6667L10.3846 16L18 8.5"
                                                stroke="#fff"
                                                stroke-width="1.5"
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                        ></path>
                                    </svg>
                                </div>
                            </label>
                        </div>
                        <div class="column address">
                            <div>
                                <div class="default-addr-icon">기본 배송지</div>
                                서울 양천구 목동서로 100 (목동신시가지아파트3단지) 310동
                                603호
                            </div>
                        </div>
                        <div class="column deli-to">정충교</div>
                        <div class="column tel-no">010-2288-7320</div>
                        <div class="column deli-type">
                            <span type="direct">샛별배송</span>
                        </div>
                        <div class="column fix">
                            <button>
                                <svg
                                        width="24"
                                        height="24"
                                        viewBox="0 0 24 24"
                                        xmlns="http://www.w3.org/2000/svg"
                                >
                                    <g fill="none" fill-rule="evenodd">
                                        <path fill="none" d="M0 0h24v24H0z"></path>
                                        <path
                                                d="m13.83 5.777 4.393 4.393-10.58 10.58H3.25v-4.394l10.58-10.58zm3.204-2.527c.418 0 .837.16 1.157.48l2.08 2.08a1.63 1.63 0 0 1 0 2.314l-2.157 2.156-4.394-4.394 2.157-2.156c.32-.32.738-.48 1.157-.48z"
                                                stroke="#ccc"
                                                stroke-width="1.5"
                                        ></path>
                                    </g>
                                </svg>
                            </button>
                        </div>
                    </div>
                </li>
                <li>
                    <div style="display: flex">
                        <div class="column default">
                            <label for="kurly-address-22936411"
                            ><input
                                    id="kurly-address-22936411"
                                    type="checkbox"
                                    value="22936411"
                            />
                                <div style="margin-right: 12px">
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
                                </div>
                            </label>
                        </div>
                        <div class="column address">
                            <div>
                                경기 성남시 분당구 판교역로 100 (백현마을6단지아파트) 10층 F
                                강의실
                            </div>
                        </div>
                        <div class="column deli-to">김학준</div>
                        <div class="column tel-no">010-1234-5611</div>
                        <div class="column deli-type">
                            <div>
                                <span type="direct">샛별배송</span>
                            </div>
                        </div>
                        <div class="column fix">
                            <button>
                                <svg
                                        width="24"
                                        height="24"
                                        viewBox="0 0 24 24"
                                        xmlns="http://www.w3.org/2000/svg"
                                >
                                    <g fill="none" fill-rule="evenodd">
                                        <path fill="none" d="M0 0h24v24H0z"></path>
                                        <path
                                                d="m13.83 5.777 4.393 4.393-10.58 10.58H3.25v-4.394l10.58-10.58zm3.204-2.527c.418 0 .837.16 1.157.48l2.08 2.08a1.63 1.63 0 0 1 0 2.314l-2.157 2.156-4.394-4.394 2.157-2.156c.32-.32.738-.48 1.157-.48z"
                                                stroke="#ccc"
                                                stroke-width="1.5"
                                        ></path>
                                    </g>
                                </svg>
                            </button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
