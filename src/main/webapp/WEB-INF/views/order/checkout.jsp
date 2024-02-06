<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <script>
        window.onload = () => {
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
            const receiverDetails = document.getElementById("receiver-details");
            receiverDetails.addEventListener("click", () => {
                const left = screen.width / 2 - 300;
                const top = screen.height / 2 - 350;
                window.open(
                    "receiver-details",
                    "_blank",
                    "width=600px, height=700px, left=" + left + ", top=" + top
                );
            });

            // 개인정보 수집 동의 정보 조회
            const modal = document.querySelector(".modal");
            const showModalButton = document.querySelectorAll(".personal-info-consent");
            showModalButton.forEach((button) =>
                button.addEventListener("click", () => {
                    modal.style.display = "block";
                })
            );

            // 개인정보 수집 동의 정보 모달창 닫기
            const closeModalButton = document.querySelector(".modal-content").children[2];
            closeModalButton.addEventListener("click", (e) => {
                modal.style.display = "none";
            });
        };
    </script>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/order/checkout.css'/>"/>
    <title>Document</title>
</head>
<body>
<header></header>
<section>
    <h2>주문서</h2>
    <div class="info-type1">
        <div class="info-type1-title">
            <h3>주문 상품</h3>
            <button>V</button>
        </div>
        <hr/>
        <div id="order-goods">실속 바나나 1kg 외 2개 상품을 주문합니다.</div>
    </div>
    <div class="info-type1">
        <h3>주문 상품</h3>
        <hr/>
        <div class="info-type2">
            <div>보내는 분</div>
            <div>홍길동</div>
        </div>
        <div class="info-type2">
            <div>휴대폰</div>
            <div>010-1234-1234</div>
        </div>
        <div class="info-type2">
            <div>이메일</div>
            <div>
                abc123@google.com
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
                <p>상세 주소를 입력해주세요</p>
                <button>변경</button>
            </div>
        </div>
        <div class="info-type2">
            <div>배송 요청사항</div>
            <div>
                <!-- 요청사항 저장되어 있으면, 요청사항을 표시하고 버튼은 수정으로-->
                <!-- 없으면, 아래와 같이 표시하고 버튼을 입력으로 -->
                <p>배송 요청사항을 입력해주세요</p>
                <button id="receiver-details">입력</button>
            </div>
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
                        <div>
                            <div>ㄴ 적립금</div>
                            <div>0 원</div>
                        </div>
                        <div>
                            <div>컬리캐시</div>
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
            <div id="caution">
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
                <div>적립금</div>
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
                <div>컬리카드 결제 시 최대 4,905원 추가 적립</div>
            </div>
        </div>
    </div>
</section>
<div class="modal">
    <div class="modal-content">
        <h1>개인정보 수집·이용 및 처리 동의 (필수)</h1>
        <div></div>
        <button>확인</button>
    </div>
</div>
<footer></footer>
</body>
</html>
