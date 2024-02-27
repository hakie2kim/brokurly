<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%-- 가격에 ,찍기 기능용--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/cart/cart.css'/>"/>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"
          integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body style="padding-right: 0px;">

<div>
  <div></div>
  <div class="cart-1">
    <h2 class="cart-2">장바구니</h2>
    <div></div>
    <div class="cart-3">

      <div class="cart-4">
        <div class="cart-6">
          <div class="css-zbxehx">
            <label>
              <!-- 체크박스 전체 여부 -->
              <div class="all_check_input_div">
                <input type="checkbox" class="all_check_input input_size_20" checked="checked">
<%--                <div class="css-79hxr7 e1dcessg1">--%>
<%--                  <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">--%>
<%--                    <path d="M12 24C18.6274 24 24 18.6274 24 12C24 5.37258 18.6274 0 12 0C5.37258 0 0 5.37258 0 12C0 18.6274 5.37258 24 12 24Z" fill="#5f0080"></path>--%>
<%--                    <path d="M7 12.6667L10.3846 16L18 8.5" stroke="#fff" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>--%>
<%--                  </svg>--%>
<%--                </div>--%>
                <span class="all_chcek_span">전체선택
                  <span class="totalKind_span"></span>
                </span>
              </div>
            </label>
            <span class="css-454d5e"></span>
            <button class="selectDelete_btn">선택삭제</button>
          </div>
        </div>

        <div>
          <div>
            <h4 class="cart-7">
              <span>
                  <span class="css-12dwhid">
                      <span class="css-qct1ee"></span>
                  </span>냉장 상품
              </span>
              <button data-testid="fold-button">
                접기 버튼
              </button>
            </h4>
            <c:forEach items="${cart}" var="ci" >
              <c:if test="${ci.pkgType =='냉장'}">
                <ul>
                  <li class="cart_info_li">
                    <input type="checkbox" class="individual_cart_checkbox input_size_20" checked="checked">
                    <input type="hidden" class="individual_itemId_input" value="${ci.itemId}">
                    <input type="hidden" class="individual_itemQty_input" value="${ci.itemQty}">
                    <input type="hidden" class="individual_itemPrice_input" value="${ci.price}">
                    <input type="hidden" class="individual_salePrice_input" value="${ci.salePrice}">
                    <input type="hidden" class="individual_discountPrice_input" value="${ci.itemDcAmt}">
                    <input type="hidden" class="individual_totalDiscountPrice_input" value="${ci.itemDcAmt * ci.itemCnt}">
                    <input type="hidden" class="individual_itemCnt_input" value="${ci.itemCnt}">
                    <input type="hidden" class="individual_totalPrice_input" value="${ci.price * ci.itemCnt}">
                  </li>
                  <li class="cart-8">
                    <label>
                      <div>

                      </div>
                    </label>
                    <a href="http://localhost:8080/goods/${ci.itemId}" class="css-1u5t3pw">
                      <span class="css-1f44rj5"></span>
                    </a>
                    <div class="css-14sb0pe">
                      <a href="http://localhost:8080/goods/${ci.itemId}" style="text-decoration: none; color: black">
                        <p class="css-efcx1u">${ci.name}</p>
                      </a>
                      <div></div>
                    </div>
                    <div class="css-1gueo66">
                      <button type="button" class="minus_btn css-8azp8" onclick='count("minus")' value='+'
                              aria-label="수량내리기"></button>
                      <div class="count css-6m57y0">
                        <label>
                          <input type="text" disabled="disabled"
                                 style="background-color: rgb(255, 255, 255); text-align: center; width: 30px; border: none;"
                                 class="quantity_input" value="${ci.itemCnt}">
                        </label>
                      </div>
                      <button type="button" class="plus_btn css-18y6jr4" onclick='count("plus")' value='-'
                              aria-label="수량올리기"></button>
                    </div>
                    <div class="css-5w3ssu">
                      <span aria-label="할인 가격"><fmt:formatNumber value="${ci.salePrice}" pattern="#,### 원"/></span>
                      <span class="css-cwmxfz" aria-label="판매 가격"><fmt:formatNumber value="${ci.price}" pattern="#,### 원"/></span>
                    </div>
                    <button type="button" data-testid="delete" class="delete_btn">
                      <span class="css-6mgkir"></span>
                    </button>
                  </li>
                </ul>
              </c:if>
            </c:forEach>
            <h4 class="cart-7">
                <span>
                    <span class="css-12dwhid">
                        <span class="css-1791hip"></span>
                    </span>
                    냉동 상품
                </span>
              <button data-testid="fold-button">
                접기 버튼
              </button>
            </h4>
            <c:forEach items="${cart}" var="ci">
              <c:if test="${ci.pkgType =='냉동'}">
                <ul>
                  <li class="cart_info_li">
                    <input type="checkbox" class="individual_cart_checkbox input_size_20" checked="checked">
                    <input type="hidden" class="individual_itemId_input" value="${ci.itemId}">
                    <input type="hidden" class="individual_itemQty_input" value="${ci.itemQty}">
                    <input type="hidden" class="individual_itemPrice_input" value="${ci.price}">
                    <input type="hidden" class="individual_salePrice_input" value="${ci.salePrice}">
                    <input type="hidden" class="individual_discountPrice_input" value="${ci.itemDcAmt}">
                    <input type="hidden" class="individual_totalDiscountPrice_input" value="${ci.itemDcAmt * ci.itemCnt}">
                    <input type="hidden" class="individual_itemCnt_input" value="${ci.itemCnt}">
<%--                    <input type="hidden" class="individual_totalPrice_input" value="${ci.totalPrice}">--%>
                    <input type="hidden" class="individual_totalPrice_input" value="${ci.price * ci.itemCnt}">
                  </li>
                  <li class="cart-8">
                      <%--                                <label>--%>
                      <%--                                    <input type="checkbox" checked="">--%>
                      <%--                                    <div>--%>
                      <%--                                    </div>--%>
                      <%--                                </label>--%>
                    <a href="http://localhost:8080/goods/${ci.itemId}" class="css-1u5t3pw">
                      <span class="css-1f44rj5"></span>
                    </a>
                    <div class="css-14sb0pe">
                      <a href="http://localhost:8080/goods/${ci.itemId}" style="text-decoration: none; color: black">
                        <p class="css-efcx1u">${ci.name}</p>
                      </a>
                    </div>
                    <div class="css-1gueo66">
                      <button type="button" class="minus_btn css-8azp8" onclick='count("minus")' value='+' aria-label="수량내리기"></button>
                      <div class="count css-6m57y0">
                        <label>
                          <input type="text" disabled="disabled" style="background-color: rgb(255, 255, 255); text-align: center; width: 30px; border: none;" class="quantity_input" value="${ci.itemCnt}">
                        </label>
                      </div>
                      <button type="button" class="plus_btn css-18y6jr4" onclick='count("plus")' value='-' aria-label="수량올리기"></button>
                    </div>
                    <div class="css-5w3ssu">
                      <span aria-label="할인 가격"><fmt:formatNumber value="${ci.salePrice}" pattern="#,### 원"/></span>
                      <span class="css-cwmxfz" aria-label="판매 가격"><fmt:formatNumber value="${ci.price}" pattern="#,### 원"/></span>
                    </div>
                    <button type="button" data-testid="delete" class="delete_btn">
                      <span class="css-6mgkir"></span>
                    </button>
                  </li>
                </ul>
              </c:if>
            </c:forEach>
          </div>
        </div>

      </div>

      <div class="cart-5">
        <div class="css-50ad8x">
          <div class="css-oft680">
            <h3 class="css-1guaarh">배송지</h3>
            <div>
              <p>경기 용인시 기흥구 동백7로 56 (호수마을서해그랑블)</p>
              <div>
                <span type="direct">샛별배송</span>
              </div>
              <button class="css-122i3z7" type="button" height="36" radius="3">
                <span>배송지 변경</span>
              </button>
            </div>
          </div>
          <div class="css-1t6so8j">
            <div class="css-8jmoub">
              <span class="css-vmo0an">상품금액</span>
              <span class="totalPrice_span"></span>
            </div>
            <div class="css-t4mc5m">
              <span>상품할인금액</span>
              <span class="totalDiscountPrice"></span>
            </div>
            <div class="css-t4mc5m">
              <span>배송비</span>
              <span class="delivery_price"></span>
            </div>
            <div class="css-7ygxxm">
              <span>결제예정금액</span>
              <span>
                  <span class="finalTotalPrice_span"></span>
              </span>
            </div>

          </div>
          <div class="css-8qz8ia">
            <button type="button" height="56" class="order_btn">
              <span>주문하기</span>
            </button>
            <ul class="css-19kxq7d">
              <li class="css-1741abm">쿠폰/적립금은 주문서에서 사용 가능합니다</li>
              <li class="css-1741abm">[주문완료] 상태일 경우에만 주문 취소 가능합니다.</li>
              <li class="css-1741abm">[마이컬리 &gt; 주문내역 상세페이지] 에서 직접 취소하실 수 있습니다.</li>
              <li class="css-1741abm">쿠폰, 적립금 사용 금액을 제외한 실 결제 금액 기준으로 최종 산정됩니다.</li>
              <li class="css-1741abm">상품별로 적립금 지급 기준이 다를 수 있습니다. (상품 상세 페이지에서 확인 가능합니다)</li>
            </ul>
          </div>
          <!-- 수량 조정 form -->
          <%--                    <form action="/update" method="post" class="quantity_update_form">--%>
          <%--                        <input type="hidden" name="itemId" class="update_itemId">--%>
          <%--                        <input type="hidden" name="itemCnt" class="update_itemCnt">--%>
          <%--&lt;%&ndash;                        <input type="hidden" name="memberId" value="${customer.custId}">&ndash;%&gt;--%>
          <%--                        <input type="hidden" name="custId" value="hong">--%>
          <%--                    </form>--%>
        </div>
      </div>
    </div>
  </div>
</div>
<script>
    $(document).ready(function () {
        setTotalInfo(); //계산정보 삽입
    });

    function setTotalInfo() {

        /* 종합 정보 섹션 정보 삽입 */
        let totalPrice = 0;				// 총 가격
        let totalCount = 0;				// 총 갯수
        let totalDiscount = 0;      //총 할인가격
        let totalKind = 0;				// 총 종류
        // let totalPoint = 0;				// 총 마일리지
        let deliveryPrice = 0;			// 배송비
        let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)

        $(".cart_info_li").each(function (index, element) {
            if ($(element).find(".individual_cart_checkbox").is(":checked") === true) {    //체크여부 확인용

                // 총 가격
                totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());

                // 총 갯수
                totalCount += parseInt($(element).find(".individual_itemCnt_input").val());
                // alert(totalCount);

                // totalCount += parseInt($(element).find(".quantity_input").val());
                // 총 할인 가격
                totalDiscount += parseInt($(element).find(".individual_totalDiscountPrice_input").val());

                // 총 종류
                totalKind += 1;
                // // 총 마일리지
                // totalPoint += parseInt($(element).find(".individual_totalPoint_input").val());
            }
        });
        /* 배송비 결정 */
        if (totalPrice >= 40000) {
            deliveryPrice = 0;
        } else if (totalPrice === 0) {
            deliveryPrice = 0;
        } else {
            deliveryPrice = 3000;
        }
        /* 최종 가격 */
        finalTotalPrice = totalPrice + deliveryPrice -totalDiscount;

        if(totalDiscount !== 0){  //0일경우 "-" 빼기
            totalDiscount = "-" + totalDiscount;
        }

        /* 값 삽입 */
        // 총 가격
        // $(".totalPrice_span").text(totalPrice);
        $(".totalPrice_span").text(new Intl.NumberFormat('ko-KR').format(totalPrice) + " 원");
        // 총 할인금액
        $(".totalDiscountPrice").text(new Intl.NumberFormat('ko-KR').format(totalDiscount) + " 원");
        // 총 갯수
        $(".totalCount_span").text(totalCount);
        // $(".quantity_input").val(totalCount);
        // 총 종류
        $(".totalKind_span").text( "(" + totalKind + "/" + $(".individual_cart_checkbox").length + ")" );
        // // 총 마일리지
        // $(".totalPoint_span").text(totalPoint);
        // 배송비
        $(".delivery_price").text(new Intl.NumberFormat('ko-KR').format(deliveryPrice) + " 원");
        // 최종 가격(총 가격 + 배송비)
        $(".finalTotalPrice_span").text(new Intl.NumberFormat('ko-KR').format(finalTotalPrice) + " 원");
    }

    //체크 여부에 따른 종합 정보 변화
    $(".individual_cart_checkbox").on("change", function () {
        if ($(".individual_cart_checkbox:checked").length === $(".individual_cart_checkbox").length) {  //체그박스가 전부 체크되면 전체 체크박스 체그로 바꿈
            $(".all_check_input").prop('checked', true);
        } else {
            $(".all_check_input").prop('checked', false);
        }
        setTotalInfo($(".cart_info_li"));   //총 주문 정보 세팅(배송비, 총가격, 물품 수, 종류)
    });

    /* 체크박스 전체 선택 */
    $(".all_check_input").on("click", function () {
        if ($(".all_check_input").prop("checked")) {
            $(".individual_cart_checkbox").prop('checked', true);
        } else {
            $(".individual_cart_checkbox").prop('checked', false);
        }
        /* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
        setTotalInfo($(".cart_info_li"));
    });

    /* 수량버튼 */
    $(".plus_btn").on("click", function () {
        let inputField = $(this).parent("div").find("input");
        let quantity = parseInt(inputField.val());
        let itemId = $(this).closest("ul").find(".individual_itemId_input").val();
        let itemQty = $(this).closest("ul").find(".individual_itemQty_input").val();
        let totalPrice = $(this).closest("ul").find(".individual_totalPrice_input").val();
        let itemPrice = $(this).closest("ul").find(".individual_itemPrice_input").val();
        let discount = $(this).closest("ul").find(".individual_discountPrice_input").val();
        let totalDiscount = $(this).closest("ul").find(".individual_totalDiscountPrice_input").val();

        if (quantity < itemQty) {    //재고보다 수량이 적어야 한다
            quantity++; // 수량 증가
            inputField.val(quantity); // 증가된 수량을 입력란에 설정
            $(this).closest("ul").find(".individual_totalPrice_input").val(parseInt(totalPrice) + parseInt(itemPrice));
            $(this).closest("ul").find(".individual_totalDiscountPrice_input").val(parseInt(totalDiscount) + parseInt(discount));
        }
        $.ajax({
            url: '/cart/update',
            method: "POST",
            dataType: "text",
            data: {
                custId: "hong",
                itemId: itemId,
                itemCnt: quantity
            },
            success: function () {
                setTotalInfo($(".cart_info_li"));
            }
        })
    });
    $(".minus_btn").on("click", function () {
        let inputField = $(this).parent("div").find("input");
        let quantity = parseInt(inputField.val());
        let itemIdField = $(this).closest("ul").find(".individual_itemId_input");
        let itemId = itemIdField.val();
        let totalPrice = $(this).closest("ul").find(".individual_totalPrice_input").val();
        let itemPrice = $(this).closest("ul").find(".individual_itemPrice_input").val();
        let discount = $(this).closest("ul").find(".individual_discountPrice_input").val();
        let totalDiscount = $(this).closest("ul").find(".individual_totalDiscountPrice_input").val();

        if (quantity > 1) {
            quantity--; // 수량 감소
            inputField.val(quantity); // 증가된 수량을 입력란에 설정
            $(this).closest("ul").find(".individual_totalPrice_input").val(parseInt(totalPrice) - parseInt(itemPrice));
            $(this).closest("ul").find(".individual_totalDiscountPrice_input").val(parseInt(totalDiscount) - parseInt(discount));
        }
        $.ajax({
            url: '/cart/update',
            method: "POST",
            dataType: "text",
            data: {
                custId: "hong",
                itemId: itemId,
                itemCnt: quantity,
            },
            success: function () {
                setTotalInfo($(".cart_info_li"));
            }
        })
    });

    // X 삭제 버튼
    $(".delete_btn").on("click", function(e) {
        var deleteButton = $(this); // 삭제 버튼
        var itemId = deleteButton.closest("ul").find(".individual_itemId_input").val(); // 삭제할 아이템 ID

        $.ajax({
            url: '/cart/delete',
            method: "POST",
            dataType: "text",
            data: {
                custId: "hong",
                itemId: itemId
            },
            success: function() {
                location.reload();
                alert("삭제 완료");
            }
        });
    });

    // 체그박스 선택 삭제 버튼
    $(".selectDelete_btn").on("click", function(e) {
        let selectCnt = $(".individual_cart_checkbox:checked").length;
        let deleteCnt = 0;
        if(selectCnt === 0) {
            alert("삭제할 상품을 선택해 주세요")
        }else{
        $(".individual_cart_checkbox:checked").each(function() {
        let deleteButton = $(this); // 삭제 버튼
        let itemId = deleteButton.closest("ul").find(".individual_itemId_input").val(); // 삭제할 아이템 ID
                $.ajax({
                    url: '/cart/delete',
                    method: "POST",
                    dataType: "text",
                    data: {
                        custId: "hong",
                        itemId: itemId
                    },
                    success: function () {
                        deleteCnt++; // 삭제된 상품 개수 증가
                        if (deleteCnt === selectCnt) { // 모든 상품이 삭제되었을 때
                            location.reload(); // 페이지 새로고침
                            alert("삭제 완료"); // 삭제 완료 알림 표시
                        }
                    }
                });
          });
        }
    });


</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
