window.onload = () => {
    // 주문 상품창 요약 & 리스트 변환 기능
    const orderGoodsButton = $(".info-type1-title").children().eq(1);
    orderGoodsButton.click(() => {
        let buttonText = orderGoodsButton.html();
        if (buttonText === "⋁") {
            orderGoodsButton.html("&xwedge;");
            $("#order-goods").css("display", "none");
            $("#order-goods-list").css("display", "block");
        } else {
            orderGoodsButton.html("&xvee;");
            $("#order-goods").show();
            $("#order-goods-list").hide();
        }
    });

    // 배송지 변경 모달 띄우기
    $("#location-change").click(() => {
        $(".small-modal").show();
        $("body").css('overflow', 'hidden');
    });

    // 배송지 변경 모달 끄기
    $("#small-modal-cancel").click(() => {
        $(".small-modal").hide();
        $("body").css("overflow", "");
    });

    // 배송지 변경 리다이렉트
    $("#small-modal-ok").click(() => {
        window.location.href = '/cart';
    });

    // 결제 정보 헤더에 붙이기
    $(window).on("scroll", function () {
        const headerBottom = $("header").outerHeight();
        const rightElement = $("#right");
        const scrollPosition = $(this).scrollTop();

        if (scrollPosition <= headerBottom) {
            rightElement.css("top", scrollPosition - headerBottom + "px");
        } else {
            rightElement.css("top", "150px");
        }
    });

    // 배송 요청사항 입력창 띄우기
    $(".receiver-details-btn").click(() => {
        const left = screen.width / 2 - 300;
        const top = screen.height / 2 - 350;
        window.open(
            "/order/receiver-details",
            "_blank",
            "width=600px, height=700px, left=" + left + ", top=" + top
        );
    })

    // 개인정보 수집 동의 정보 조회
    $(".personal-info-consent").each(function (i) {
        $(this).click(function () {
            $(".big-modal").eq(i).show();
            $("body").css("overflow", "hidden");
        });
    });

    // 개인정보 수집 동의 정보 모달창 닫기
    $(".big-modal-content").each(function () {
        $(this).click(function () {
            $(".big-modal").hide();
            $("body").css("overflow", "");
        });
    });

    const $kakaopay = $("#kakaopay");
    const $creditCard = $("#credit-card");
    $kakaopay.click(() => {
        offPaymentButton();

        if ($kakaopay.val() === "false") {
            $kakaopay.val("true")
            $kakaopay.addClass("kakaopay");
        }
    })

    $creditCard.click(() => {
        offPaymentButton();

        if ($creditCard.val() === "false") {
            $creditCard.val("true");
            $creditCard.addClass("credit-card");
        }
    })

    function offPaymentButton() {
        $(".payment-button").each(function () {
            $(this).val("false");
            $(this).removeClass().addClass("payment-button");
        })
    }
};

// 서버에서 Ajax 요청이 성공적으로 처리되었을 때 호출되는 콜백 함수
function updateReceiverDetails(data) {
    $("#checkout-rcv-place").text(data.rcvPlace);
    $("#checkout-enter-mthd").text(data.enterMthd);
    $("#checkout-name").text(data.rcvName);
    $("#checkout-telNo").text(data.telNo);
    $("#checkout-place-exp").text(data.placeExp);
    $("#checkout-msg-time").text(data.msgTime);
}

function redirectPayment() {
    const customerCart = [];
    $(".item-list").each(function () {
        customerCart.push({
            name: $(this).find($(".item-name")).text(),
            itemCnt: parseInt($(this).find($(".item-cnt")).text().replace("개", "")),
            price: parseInt($(this).find($(".item-price")).text().replace("원", ""))

        })
    });

    let checkoutInfo = {
        rcvName: $("#checkout-name").text(),
        telNo: $("#checkout-tel-no").text(),
        rcvPlace: $("#checkout-rcv-place").text(),
        enterMthd: $("#checkout-enter-mthd").text(),
        placeExp: $("#checkout-place-exp").text(),
        msgTime: $("#checkout-msg-time").text(),
        customerCart: customerCart,
        paymentAmount: {
            orderAmt: parseInt($("#order-amount").text().replace(/[,\s원]/g, ''), 10),
            itemAmt: parseInt($("#item-amount").text().replace(/[,\s원]/g, ''), 10),
            itemDcAmt: parseInt($("#item-dc-amount").text().replace(/[,\s원]/g, ''), 10),
        }
    };

    $(".payment-button").each(function () {
        if ($(this).val() === "true") {
            switch ($(this).attr("id")) {
                case "kakaopay":
                    fetch("/payment/kakaopay", {
                        method: "POST",
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(checkoutInfo)
                    })
                        .then(response => {
                            if (!response.ok)
                                throw new Error(`Server responded with status: ${response.status}`);
                            return response.text()
                        })
                        .then(url => window.location.href = url)
                        .catch(error => console.log("Error: ", error));
                    break;
                case "credit-card":
                    window.location.href = "/payment/credit-card";
                    break;
            }
        }
    });
}