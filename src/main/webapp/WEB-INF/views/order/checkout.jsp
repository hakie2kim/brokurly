<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <script>
        window.onload = () => {
            // 주문 상품창 요약 & 리스트 변환 기능
            const orderGoodsButton = document.querySelector(".info-type1-title").children[1];
            orderGoodsButton.addEventListener("click", () => {
                let buttonText = orderGoodsButton.innerHTML;
                if (buttonText === "⋁") {
                    orderGoodsButton.innerHTML = "&xwedge;";
                    document.getElementById("order-goods").style.display = "none";
                    document.getElementById("order-goods-list").style.display = "block";
                } else {
                    orderGoodsButton.innerHTML = "&xvee;";
                    document.getElementById("order-goods").style.display = "block";
                    document.getElementById("order-goods-list").style.display = "none";
                }
            });

            // 배송지 변경 모달 띄우기
            const smallModal = document.querySelector(".small-modal");
            const locationChangeButton = document.getElementById("location-change");
            locationChangeButton.addEventListener("click", () => {
                smallModal.style.display = "block";
                document.body.style.overflow = "hidden";
            });

            // 배송지 변경 모달 끄기
            const cancelButton = document.getElementById("small-modal-cancel");
            cancelButton.addEventListener("click", () => {
                smallModal.style.display = "none";
                document.body.style.removeProperty("overflow");
            });

            // 배송지 변경 리다이렉트
            const okButton = document.getElementById("small-modal-ok");
            okButton.addEventListener("click", () => {
                window.location.href = '/cart';
            });

            // 결제 정보 헤더에 붙이기
            window.addEventListener("scroll", () => {
                const headerBottom = document.querySelector("header").offsetHeight;
                const rightElement = document.getElementById("right");
                const scrollPosition = window.scrollY;
                const rightTop = rightElement.getBoundingClientRect().top;

                if (scrollPosition <= headerBottom) {
                    rightElement.style.top = scrollPosition - headerBottom + "px";
                } else {
                    rightElement.style.top = "150px";
                }
            });

            // 배송 요청사항 입력창 띄우기
            const receiverDetails = document.querySelector(".receiver-details-btn");
            receiverDetails.addEventListener("click", () => {
                const left = screen.width / 2 - 300;
                const top = screen.height / 2 - 350;
                window.open(
                    "/order/receiver-details",
                    "_blank",
                    "width=600px, height=700px, left=" + left + ", top=" + top
                );
            });

            // 개인정보 수집 동의 정보 조회
            const bigModal = document.querySelectorAll(".big-modal");
            const showModalButton = document.querySelectorAll(".personal-info-consent");
            for (let i = 0; i < bigModal.length; i++) {
                showModalButton[i].addEventListener("click", () => {
                    bigModal[i].style.display = "block";
                    document.body.style.overflow = "hidden";
                });
            }

            // 개인정보 수집 동의 정보 모달창 닫기
            const closeModalButton = document.querySelectorAll(".big-modal-content");
            for (let i = 0; i < bigModal.length; i++) {
                closeModalButton[i].addEventListener("click", () => {
                    bigModal[i].style.display = "none";
                    document.body.style.removeProperty("overflow");
                });
            }
        };
    </script>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/order/checkout.css'/>"/>
    <title>브로컬리</title>
</head>
<body>
<header></header>
<section>
    <h2>주문서</h2>
    <div class="info-type1">
        <div class="info-type1-title">
            <h3>주문 상품</h3>
            <button id="order-goods-change">&xvee;</button>
        </div>
        <hr/>
        <div id="order-goods">실속 바나나 1kg 외 2개 상품을 주문합니다.</div>
        <div id="order-goods-list" style="display: none">상품 리스트 반복문</div>
    </div>

    <div class="info-type1">
        <h3>주문자 정보</h3>
        <hr/>
        <div class="info-type2">
            <div>보내는 분</div>
            <div>${member.name}</div>
        </div>
        <div class="info-type2">
            <div>휴대폰</div>
            <div>${member.telNo}</div>
        </div>
        <div class="info-type2">
            <div>이메일</div>
            <div>
                ${member.email}
                <p style="font-size: 12px">이메일을 통해 주문처리과정을 보내드립니다.</p>
                <p style="font-size: 12px">정보 변경은 마이컬리 > 개인정보 수정 메뉴에서 가능합니다.</p>
            </div>
        </div>
    </div>

    <div class="info-type1">
        <div class="info-type1-title">
            <h3>배송 정보</h3>
            <a href="">배송지 변경 안내 ?</a>
        </div>
        <hr/>
        <div class="info-type2">
            <div>배송지</div>
            <div>
                <span id="default-delivery">기본 배송지</span>
                <p>서울 강남구 강남로 111</p>
                <p class="caution">상세 주소를 입력해주세요</p>
                <button id="location-change">변경</button>
            </div>
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

        <div class="info-type2">
            <div>배송 요청사항</div>
            <c:if test="${receiverDetails == null}">
                <div>
                    <!-- 요청사항 저장되어 있으면, 요청사항을 표시하고 버튼은 수정으로-->
                    <!-- 없으면, 아래와 같이 표시하고 버튼을 입력으로 -->
                    <p class="caution">배송 요청사항을 입력해주세요</p>
                    <button class="receiver-details-btn">입력</button>
                </div>
            </c:if>
            <c:if test="${receiverDetails != null && member != null}">
                <div>
                    <div>${receiverDetails.rcvPlace} | ${receiverDetails.enterMthd}</div>
                    <div>${member.name},${member.telNo}</div>
                    <button class="receiver-details-btn">수정</button>
                </div>
            </c:if>
        </div>
    </div>
</section>
<section id="bottom">
    <div id="left">
        <div>
            <h3>쿠폰</h3>
            <hr/>
            <div class="info-type2">
                <div>쿠폰 적용</div>
                <div>
                    <button id="coupon-list">사용가능 쿠폰 0장/전체0장</button>
                    <p>쿠폰 적용 불가 상품입니다</p>
                    <div>
                        <a href="">쿠폰 사용 문의 (카카오톡) &gt;</a>
                    </div>
                    <hr/>
                    <p>
                        <a href=""><span>컬리멤버스</span> 추가 2,000원 즉시 할인 받기 &gt;</a>
                    </p>
                </div>
            </div>
        </div>
        <div>
            <h3>적립금</h3>
            <hr/>
            <div class="info-type2">
                <div>적립금</div>
                <div>
                    <div id="point">
                        <div>
                            <div>사용가능 잔액</div>
                            <div>0 원</div>
                        </div>
                        <div id="point-input">
                            <input type="text" placeholder="0"/>
                            <button>모두사용</button>
                        </div>
                    </div>
                    <div>사용 시 적립금이 먼저 소진됩니다.</div>
                    <div>컬리캐시 사용 시 컬리페이 간편결제만 가능합니다.</div>
                </div>
            </div>
        </div>
        <div>
            <h3>결제수단</h3>
            <hr/>
        </div>
        <div>
            <h3>개인정보 수집/제공</h3>
            <hr/>
            <div id="personal-info">
                <div>
                    <p>개인정보 수집∙이용 및 처리 동의</p>
                    <button class="personal-info-consent">보기</button>
                </div>
                <div>
                    <p>결제대행 서비스 약관 동의</p>
                    <button class="personal-info-consent">보기</button>
                </div>
                <div>
                    <p>전자지급 결제대행 서비스 이용약관 동의</p>
                    <button class="personal-info-consent">보기</button>
                </div>
                <div>위 내용을 확인하였으며 결제에 동의합니다.</div>
                <hr style="border: 0; height: 1px; background-color: #e8e8e8"/>
            </div>
            <div class="personal-info-caution">
                <p>
                    주문완료 상태일 경우에만 주문 취소가 가능하며, 상품 미배송 시 결제하신 수단으로 환불됩니다.
                </p>
                <p>
                    컬리 내 개별 판매자가 등록한 오픈마켓 상품의 경우 컬리는 통신판매중개자로서 주문, 품질,
                    교환/환불 등 의무와 책임을 부담하지 않습니다.
                </p>
            </div>
        </div>
        <button id="pay-btn">98,090원 결제하기</button>
    </div>
    <div id="right">
        <h3>결제 금액</h3>
        <div id="right-inner">
            <div>
                <div>주문금액</div>
                <div>98,090 원</div>
            </div>
            <div>
                <div>ㄴ 상품금액</div>
                <div>110,670 원</div>
            </div>
            <div>
                <div>ㄴ 상품할인금액</div>
                <div>-12,580 원</div>
            </div>
            <div>
                <div>배송비</div>
                <div>0원</div>
            </div>
            <div>
                <div>쿠폰할인</div>
                <div>0원</div>
            </div>
            <div>
                <div>카드즉시할인</div>
                <div>0원</div>
            </div>
            <div>
                <div>적립금</div>
                <div>0원</div>
            </div>
            <hr/>
            <div>
                <div>최종결제금액</div>
                <div>98,090 원</div>
            </div>
            <div>
                <div></div>
                <div><span id="yellow-circle">적립</span> 구매 시 0원(5%)</div>
            </div>
            <div>
                <div></div>
                <%--  <div>컬리카드 결제 시 최대 4,905원 추가 적립</div>  --%>
            </div>
        </div>
    </div>
</section>
<div class="big-modal">
    <div class="big-modal-content">
        <h1>개인정보 수집·이용 및 처리 동의 (필수)</h1>
        <div></div>
        <button>확인</button>
    </div>
</div>
<div class="big-modal">
    <div class="big-modal-content">
        <h1>NHN한국사이버결제 전자결제 서비스 이용약관</h1>
        <div></div>
        <button>확인</button>
    </div>
</div>
<div class="big-modal">
    <div class="big-modal-content">
        <h1>컬리페이 전자지급 결제대행 서비스 이용약관</h1>
        <div></div>
        <button>확인</button>
    </div>
</div>
<footer></footer>
</body>
</html>
