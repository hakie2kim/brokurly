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

// 서버에서 Ajax 요청이 성공적으로 처리되었을 때 호출되는 콜백 함수
function updateReceiverDetails(data) {
    $("#checkout-rcvPlace").text(data.rcvPlace);
    $("#checkout-enterMthd").text(data.enterMthd);
    $("#checkout-name").text(data.rcvName);
    $("#checkout-telNo").text(data.telNo);
}
