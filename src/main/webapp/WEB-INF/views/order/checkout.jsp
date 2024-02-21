<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <script>
    </script>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/order/checkout.css'/>"/>
    <script type="text/javascript" src="<c:url value='/resources/js/order/checkout.js'/>"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
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
        <div id="order-goods">${checkout.customerCart[0].name} 외 ${fn:length(checkout.customerCart) - 1}개 상품을 주문합니다.
        </div>
        <div id="order-goods-list" style="display: none">
            <c:forEach items="${checkout.customerCart}" var="item">
                <div class="item-list">
                    <div>상품 사진</div>
                    <div>${item.name}</div>
                    <div>${item.itemCnt}개</div>
                    <div>${item.price}원</div>
                </div>
            </c:forEach>
        </div>
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
            <c:if test="${checkout == null}">
                <div>
                    <!-- 요청사항 저장되어 있으면, 요청사항을 표시하고 버튼은 수정으로-->
                    <!-- 없으면, 아래와 같이 표시하고 버튼을 입력으로 -->
                    <p class="caution">배송 요청사항을 입력해주세요</p>
                    <button class="receiver-details-btn">입력</button>
                </div>
            </c:if>
            <c:if test="${checkout != null && member != null}">
                <div>
                    <div><span id="checkout-rcvPlace">${checkout.rcvPlace}</span> | <span
                            id="checkout-enterMthd">${checkout.enterMthd}</span></div>
                    <div><span id="checkout-name">${member.name}</span>,<span id="checkout-telNo">${member.telNo}</span>
                    </div>
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
            <div class="info-type2">
                <div>결제수단 선택</div>
                <button type="button" class="kakaopay">
                    <img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNTAiIGhlaWdodD0iMjAiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CiAgICA8ZyBmaWxsPSIjMDAwIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxwYXRoIGQ9Ik03LjUxNSAyLjhDMy4zNjUgMi44IDAgNS40NDUgMCA4LjcwN2MwIDEuOTM4IDEuMTg3IDMuNjU3IDMuMDIxIDQuNzM0LS4xOTEuNzY4LS42ODQgMi43NDItLjc1IDIuOTU3LS4wODMuMjY2LS4xMDMgMS4wNDYuNzAyLjUxMi42MzQtLjQyIDIuNDc5LTEuNyAzLjU3LTIuMzQ4LjMxOC4wMzMuNjQyLjA1MS45NzIuMDUxIDQuMTUgMCA3LjUxNS0yLjY0NCA3LjUxNS01LjkwNiAwLTMuMjYyLTMuMzY1LTUuOTA3LTcuNTE1LTUuOTA3TTIxLjA0OCA0LjExM2MxLjUxNy0xLjMxMyAzLjQ2OC0xLjUwOCA0Ljg5My0uNTg1IDEuNzA3IDEuMTA2IDIuMTY4IDIuNzU0IDIuMTY4IDQuODkyIDAgMi40LTEuMTE1IDMuOTY4LTEuNjQyIDQuNDYtLjUyNi40OTMtMS42NzMgMS4yOTItMi44OCAxLjI5MkgyMS40MnYzLjc4NGgtMi45MTFWMy4yODJoMi4xMDZzLjI2LjU0OC40MzMuODN6bTEuOTUxIDEuMTUzYy0uNjk3IDAtMS4xNTMuMTc3LTEuNTMzLjQ3N3Y2LjMwNmgxLjEzOGMuNTU4IDAgMi41NDctLjUwNyAyLjU0Ny0zLjM4MyAwLS42NzctLjA5LTEuMzg1LS4yNzgtMS45LS4zNTctLjk3Ny0xLjI0Ny0xLjUtMS44NzQtMS41ek0zMy44MTcgMy4wNDZjMi4wODUgMCAyLjk0Mi43MTggMy40NDggMS4zNTQuNDgxLjYwNC44NjIgMS40OTcuODYyIDIuOHY2LjY4aC0yLjI2di0uOTU0cy0uNDQyLjQyLTEuMzc5LjgzMWMtLjk4LjQzLTIuNjUzLjg3Ny00LjA0MS0uMTg0LTEuMzk3LTEuMDY4LTEuMi0zLjQ3MS0uODUyLTQuMTU0LjQ4LS45MzggMS4zNjMtMS45NjggMy43MTYtMS45NjhoMi4wMjl2LS45MDhjMC0uNTU0LS41ODMtMS4xMDctMS43My0xLjEwNy0xLjI4IDAtMS44MzMuMTkyLTIuODE3LjYzNWwtLjk5Ni0xLjk0M3MxLjQ5Ni0xLjA4MiA0LjAyLTEuMDgyem0xLjQ3NyA2LjI1aC0xLjQxNWMtLjU5OSAwLTEuOTYxLjIxNi0xLjk2MSAxLjQ3NyAwIDEuMjgzIDEuMDkgMS4yNiAxLjQ0OCAxLjIzIDEuMDg5LS4wOTEgMS45MzgtLjc5NCAxLjkzOC0uNzk0bC0uMDEtMS45MTN6TTQ3LjA2MSAzLjA0NmwtMi4yOTEgOC4xMTEtMi41NC04LjExLTIuODQ5LjgyczMuNSA5LjM4MyAzLjYyNCA5Ljc4M2MuMTIzLjQtLjAwNS44NTgtLjI4IDEuMzIyLS4zNzEuNjMtMS44MjYgMi4wMy0xLjgyNiAyLjAzbDEuODc4IDEuNjYzcy44NTctLjY4OCAxLjc0NS0xLjc1NWMuNzQzLS44OTIgMS42MzYtMi44MyAxLjkzOC0zLjU3Ny44NTktMi4xMTkgMy40Mi05LjQ2NiAzLjQyLTkuNDY2bC0yLjgxOS0uODJ6Ii8+CiAgICA8L2c+Cjwvc3ZnPgo="
                         alt="카카오페이">
                </button>
            </div>
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