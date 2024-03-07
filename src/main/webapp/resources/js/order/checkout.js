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
        $(".shipping-location-modal").show();
        $("body").css('overflow', 'hidden');
    });

    // 배송지 변경 모달 끄기
    $("#small-modal-cancel").click(() => {
        $(".shipping-location-modal").hide();
        $("body").css("overflow", "");
    });

    // 배송지 변경 리다이렉트
    $("#small-modal-ok").click(() => {
        window.location.href = '/cart/' + $(".cust-id").text();
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
    $(document).on("click", ".receiver-details-btn", () => {
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
function modifyReceiverDetails(data) {
    $("#checkout-rcv-place").text(data.rcvPlace);
    $("#checkout-enter-mthd").text(data.enterMthd);
    $("#checkout-name").text(data.rcvName);
    $("#checkout-telNo").text(data.telNo);
    $("#checkout-place-exp").text(data.placeExp);
    $("#checkout-msg-time").text(data.msgTime);
}

function saveReceiverDetails(receiverDetails) {
    const $receiverInfo = $(".receiver-info");
    $receiverInfo.html("");

    // 장소 정보 업데이트
    const $rcvPlace = $("<span id='checkout-rcv-place'></span>").text(receiverDetails.rcvPlace + " | ");
    const $enterMthd = $("<span id='checkout-enter-mthd'></span>").text(receiverDetails.enterMthd);
    const $place = $("<div></div>");
    $place.append($rcvPlace);
    $place.append($enterMthd);
    $receiverInfo.append($place);

    // 수령자 정보 업데이트
    const $name = $("<span id='checkout-name'></span>").text(receiverDetails.rcvName + ", ");
    const telNo = receiverDetails.telNo.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3");
    const $telNo = $("<span id='checkout-tel-no'></span>").text(telNo);
    const $receiver = $("<div></div>");
    $receiver.append($name);
    $receiver.append($telNo);
    $receiverInfo.append($receiver);

    // 버튼 추가
    const $button = $("<button class='receiver-details-btn'>수정</button>");
    $receiverInfo.append($button);
}

function redirectReceiverDetails() {
    window.location.href = "#receiver-details-title";
    $(".receiver-details-modal").hide();
}

function redirectPayment() {
    // 배송 요청사항이 없으면, 주문을 못하게 모달 띄우기
    if ($(".check-receiver-details").text() === "true") {
        $(".receiver-details-modal").show();
        return;
    }

    const customerCartList = [];
    $(".item-list").each(function () {
        let customerCart = {
            itemId: $(this).find($(".item-id")).text(),
            name: $(this).find($(".item-name")).text(),
            itemCnt: parseInt($(this).find($(".item-cnt")).text().replace("개", "")),
            price: parseInt($(this).find($(".item-price")).text().replace("원", ""))
        }
        customerCartList.push(customerCart);
    });

    let checkoutInfo= {
        receiverDetails: {
            rcvName: $("#checkout-name").text(),
            telNo: $("#checkout-tel-no").text(),
            rcvPlace: $("#checkout-rcv-place").text(),
            enterMthd: $("#checkout-enter-mthd").text(),
            placeExp: $("#checkout-place-exp").text(),
            msgTime: $("#checkout-msg-time").text()
        },
        customerCart: customerCartList,
        paymentAmount: {
            orderAmt: parseInt($("#order-amount").text().replace(/[,\s원]/g, ''), 10),
            itemAmt: parseInt($("#item-amount").text().replace(/[,\s원]/g, ''), 10),
            itemDcAmt: parseInt($("#item-dc-amount").text().replace(/[,\s원]/g, ''), 10),
            shipFee: parseInt($("#ship-fee").text().replace(/[,\s원]/g, ''), 10),
            point: parseInt($("#use-point").text().replace(/[,\s원]/g, ''), 10),
            payAmt: parseInt($("#pay-amount").text().replace(/[,\s원]/g, ''), 10)
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