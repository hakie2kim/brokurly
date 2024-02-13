<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/cart/cart.css'/>"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body style="padding-right: 0px;">
<div >
    <div></div>
    <div class="cart-1">
        <h2 class="cart-2">장바구니</h2>
        <div></div>
        <div class="cart-3">
            <div class="cart-4">
                <div class="cart-6">
                    <div>
                        <label>
                            <input type="checkbox" checked="">
                            <span>전체선택 (2/2)</span>
                        </label>
                        <button>선택삭제</button>
                    </div>
                </div>
                <div>
                    <div>
                        <h4 class="cart-7">
                                <span>
                                    <span>
                                        <span>[냉장식품 아이콘]</span>
                                    </span>냉장 상품
                                </span>
                            <button data-testid="fold-button" >
                                접기 버튼
                            </button>
                        </h4>
                        <ul>
                            <li class="cart-8">
                                <label>
                                    <input type="checkbox" checked="">
                                    <div>
                                    </div>
                                </label>
                                <a>
                                    <span>[사진 넣기]</span>
                                </a>
                                <div>
                                    <a>
                                        <p>밀푀유나베</p>
                                    </a>
                                    <div></div>
                                </div>
                                <div>
                                    <button type="button">-</button>
                                    <div>1</div>
                                    <button type="button">+</button>
                                </div>
                                <div>
                                    <span aria-label="판매 가격">16,900원</span>
                                </div>
                                <button type="button">
                                </button>
                            </li>
                        </ul>
                        <h4 class="cart-7">
                                <span>
                                    <span>
                                        <span>[냉동식품 아이콘]</span>
                                    </span>
                                    냉동 상품
                                </span>
                            <button data-testid="fold-button">
                                접기 버튼
                            </button>
                        </h4>
                        <ul>
                            <li class="cart-8">
                                <label>
                                    <input type="checkbox" checked="">
                                    <div>
                                    </div>
                                </label>
                                <a>
                                    <span>[사진 넣기]</span>
                                </a>
                                <div class="css-14sb0pe">
                                    <a>
                                        <p class="css-efcx1u">손질 생새우살 200g (냉동)(26/30사이즈)</p>
                                    </a>
                                </div>
                                <div class="css-1gueo66">
                                    <button type="button" class="css-8azp8">-</button>
                                    <div class="count css-6m57y0">1</div>
                                    <button type="button" class="css-18y6jr4">+</button>
                                </div>
                                <div class="css-5w3ssu">
                                    <span aria-label="할인 가격">5,900원(할인가)</span>
                                    <span aria-label="판매 가격">8,400원(원가)</span>
                                </div>
                                <button type="button" data-testid="delete">
                                    <span class="css-6mgkir"></span>
                                </button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="cart-5">
                <div>
                    <div>
                        <h3>배송지</h3>
                        <div>
                            <p>경기 용인시 기흥구 동백7로 56 (호수마을서해그랑블)</p>
                            <div>
                                <span type="direct">샛별배송</span>
                            </div>
                            <button type="button" height="36" radius="3">
                                <span>배송지 변경</span>
                            </button>
                        </div>
                    </div>
                    <div>
                        <div>
                            <span>상품금액</span>
                            <span>25,300
                                    <span>원</span>
                                </span>
                        </div>
                        <div>
                            <span>상품할인금액</span>
                            <span>-2,500
                                    <span>원</span>
                                </span>
                        </div>
                        <div>
                            <span>배송비</span>
                            <span>무료 (첫구매 우대)</span>
                        </div>
                        <div>
                            <span>결제예정금액</span>
                            <span>
                                    <strong>22,800</strong>
                                    <span>원</span>
                                </span>
                        </div>
                        <div>
                            <span>적립</span>최대
                            <strong>845원 적립</strong>
                            <span>첫구매 우대 5%</span>
                        </div>
                    </div>
                    <div>
                        <button type="button" height="56">
                            <span>주문하기</span>
                        </button>
                        <ul>
                            <li>쿠폰/적립금은 주문서에서 사용 가능합니다</li>
                            <li>[주문완료] 상태일 경우에만 주문 취소 가능합니다.</li>
                            <li>[마이컬리 &gt; 주문내역 상세페이지] 에서 직접 취소하실 수 있습니다.</li>
                            <li>쿠폰, 적립금 사용 금액을 제외한 실 결제 금액 기준으로 최종 산정됩니다.</li>
                            <li>상품별로 적립금 지급 기준이 다를 수 있습니다. (상품 상세 페이지에서 확인 가능합니다)</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
