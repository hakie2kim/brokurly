<%--
  Created by IntelliJ IDEA.
  User: Sora
  Date: 2024-02-05
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원가입</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="<c:url value='/resources/css/member/signup.css'/>"/>
</head>
<body>
<form id="frm" action="<c:url value="/member/signup"/>" method="POST">
    <input type="hidden" name="_method" value="POST">
    <section>

        <!-- modal start -->
        <div class="modal">
            <div class="modal_content_body">
                <span id="modal_content"></span>
                <!-- modalContent -->
            </div>
            <div class="modal_alert_body">
                <button type="button" class="close-modal-btn">확인</button>
            </div>
        </div>
        <!-- modal end -->

        <span class="register-header">회원가입</span>
        <div class="Required-entr-div">
            <span class="Required-entr__label">*&nbsp;</span>필수입력사항
        </div>
        <div class="register-div">
            <div class="column-div">
          <span class="register-div__label"
          >아이디<span class="Required-entr__label">*</span></span
          >
                <input
                        type="text"
                        placeholder="아이디를 입력해주세요"
                        title="이 입력란을 작성하세요"
                        id="custId"
                        name="custId"
                />
                <button type="button" id="custId_btn" class="open-modal-btn" value="1">중복확인</button>
            </div>
            <div class="id-info-div">
          <span
          >6자 이상 16자 이하의 영문 혹은 영문과 숫자를 조합</span
          >
            </div>
            <div class="column-div">
          <span class="register-div__label"
          >비밀번호<span class="Required-entr__label">*</span></span
          >
                <input
                        type="text"
                        placeholder="비밀번호를 입력해주세요"
                        title="이 입력란을 작성하세요"
                        name="pwd"

                />
            </div>
            <div class="column-div">
          <span class="register-div__label"
          >비밀번호확인<span class="Required-entr__label">*</span></span
          >
                <input
                        type="text"
                        placeholder="비밀번호를 한번 더 입력해주세요"
                        title="이 입력란을 작성하세요"

                />
            </div>
            <div class="column-div">
          <span class="register-div__label"
          >이름<span class="Required-entr__label">*</span></span
          >
                <input
                        type="text"
                        placeholder="이름을 입력해주세요"
                        title="이 입력란을 작성하세요"
                        id="name"
                        name="name"
                />
            </div>
            <div class="column-div">
          <span class="register-div__label"
          >이메일<span class="Required-entr__label">*</span></span
          >
                <input
                        type="text"
                        placeholder="예: brokurly@gmail.com"
                        title="이 입력란을 작성하세요"
                        id="email"
                        name="email"
                />
                <button type="button" id="email_btn" class="open-modal-btn" value="2">중복확인</button>
            </div>
            <div class="column-div">
          <span class="register-div__label"
          >휴대폰<span class="Required-entr__label">*</span></span
          >
                <input
                        type="text"
                        placeholder="숫자만 입력해주세요"
                        title="이 입력란을 작성하세요"
                        id="telNo"
                        name="telNo"
                />
                <button type="button" class="open-modal-btn" value="3" id="telNo_btn">인증번호 받기</button>
            </div>
            <div class="column-div">
          <span class="register-div__label"
          >주소<span class="Required-entr__label">*</span></span
          >
                <button class="register-div__btn">주소검색</button>
            </div>
            <div class="order-info__label">
                배송지에 따라 상품정보가 달라질 수 있습니다.
            </div>
            <div class="column-div">
                <span class="register-div__label">성별</span>
                <input type="radio" id="sex-m" name="sex" value="M"/>
                <label for="sex-m">남자</label>
                <input type="radio" id="sex-f" name="sex" value="F"/>
                <label for="sex-f">여자</label>
                <input type="radio" id="sex-none" name="sex" value="N"/>
                <label for="sex-none">선택안함</label>
            </div>
            <div class="birth-div column-div">
                <span class="register-div__label">생년월일</span>
                <div class="birth-div__column">
                    <input type="text" id="yyyy" placeholder="YYYY" /><span>/</span>
                    <input type="text" id="mm" placeholder="MM" /><span>/</span>
                    <input type="text" id="dd" placeholder="DD" />
                    <input type="hidden" id="yyyymmdd" value="" name="birthDt">
                </div>
            </div>
        </div>
        <hr />
        <div class="agreement-div">
        <span class="register-div__label"
        >이용약관동의<span class="Required-entr__label">*</span></span
        >
            <div class="agreement-div__column">
                <div>
                    <input type="radio" id="agreement1" /><label for="agreement1"
                >전체 동의합니다.</label
                >
                    <div class="agreement-label">
                        <label>
                            선택항목에 동의하지 않은 경우도 회원가입 및 일반적인 서비스를
                            이용할 수 있습니다.
                        </label>
                    </div>
                </div>
            </div>
            <div class="agreement-div__column">
                <input type="radio" id="agreement2" /><label for="agreement2"
            >이용약관 동의<span>(필수)</span></label
            >
                <a href="#"
                ><span><label>약관보기></label></span></a
                >
            </div>
            <div class="agreement-div__column">
                <input type="radio" id="agreement3" /><label for="agreement3"
            >개인정보 수집 이용 동의<span>(필수)</span></label
            >
                <a href="#"
                ><span><label>약관보기></label></span></a
                >
            </div>
            <div class="agreement-div__column">
                <input type="radio" id="agreement4" /><label for="agreement4"
            >개인정보 수집 이용 동의<span>(선택)</span></label
            >
                <a href="#"
                ><span><label>약관보기></label></span></a
                >
            </div>
            <div class="agreement-div__column">
                <input type="radio" id="agreement5" /><label for="agreement5"
            >무료배송,할인쿠폰 등 혜택/정보 수신 동의<span>(선택)</span></label
            >
            </div>
            <div class="agreement-div__column">
                <input type="radio" id="agreement6" /><label for="agreement6"
            >본인은 만 14세 이상입니다.<span>(필수)</span></label
            >
            </div>
        </div>
        <hr />
        <button type="button" class="register-btn">가입하기</button>
    </section>
</form>
<script>
    $(document).ready(function () {
        let modal = document.querySelector(".modal");
        let modalContent = document.querySelector("#modal_content");
        let closeModalBtn = document.querySelector(".close-modal-btn");

        let custId = document.querySelector("#custId");
        let email = document.querySelector("#email");

        let regBtn = document.querySelector(".register-btn");


        // modal open
        function openModal(msg) {
            modal.style.display = "flex";
            document.body.style.overflow = "hidden"; // 모달 작동 시 스크롤바 비활성화
            modalContent.innerHTML = `<p>${'${msg}'}</p>`; //

        }

        // modal close
        closeModalBtn.addEventListener("click", () => {
            modal.style.display = "none";
            document.body.style.overflow = "unset"; // 모달 작동 시 스크롤바 활성화

        });

        // // 아이디 정규식
        // function custIdRegExp(){
        //     let regEx = /^[a-z]+[a-z0-9]{5,17}$/g;    // 영어로 시작하고 영문자숫자 조합 6자이상 16자이하
        //     let inputed = custId.value.trim();
        //
        //     return !regEx.test(inputed) || !inputed;
        // }
        //
        // // 이메일 정규식
        // function emailRegExp(){
        //     let regEx = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;    // 숫자만 가능 01?-4자리-4자리
        //     let inputed = document.querySelector("#email").value.trim();
        //
        //     return !regEx.test(inputed) || !inputed;
        // }
        //
        //
        // // 핸드폰 번호 정규식
        // function telNoRegExp(){
        //     let regEx = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;    // 숫자만 가능 01?-4자리-4자리
        //     let inputed = document.querySelector("#telNo").value.trim();
        //
        //     let telNo = inputed.slice(0,3)+'-'+inputed.slice(3,7)+"-"+inputed.slice(7,inputed.length);
        //
        //     return !regEx.test(telNo) || !telNo;
        // }

        function regExp(value){
            let regEx = "";
            let inputed = "";

            if(value === 1){  // 아이디 정규식
                regEx = /^[a-z]+[a-z0-9]{5,17}$/g;
                inputed = custId.value.trim();
            }else if(value === 2){
                regEx = /[a-z0-9]+@gmail.com/;    // 이메일 정규식 > 추후에 메일인증을 gmail로 구현할 예정
                inputed = document.querySelector("#email").value.trim();
            }else if(value === 3){  // 휴대폰 번호 정규식
                regEx = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;    // 숫자만 가능 01?-4자리-4자리
                let telNo = document.querySelector("#telNo").value.trim();

                inputed = telNo.slice(0,3)+'-'+telNo.slice(3,7)+"-"+telNo.slice(7,telNo.length);
            }

            return !regEx.test(inputed) || !inputed;
        }


        // 아이디 ajax로 유효성 검사
        $("#custId").keydown(function(){
            let idInfoDiv =  $(".id-info-div");

            $.ajax({
                success: function () {
                    if (regExp(1)) {
                        idInfoDiv.css("display", "block");
                    }else{
                        idInfoDiv.css("display","none");
                    }
                },
            });
        });


        //    id 중복체크 btn
        $("#custId_btn").click(function(){
            if(regExp(1)){
                openModal("6자 이상 16자 이하의 영문 혹은 영문과 숫자를 조합");
                return false;
            }else{
                let custIdVal = $("#custId").val();
                $.ajax({
                    type : 'GET',
                    url : '/member/signup/'+custIdVal,
                    success : function(result){
                        alert("사용 할 수 있는 아이디입니다");
                        $("#custId_btn").attr("disabled",true);
                        $("#custId_btn").css("color","#dddddd");
                        $("#custId_btn").css("border-color","#dddddd");
                    },
                    error : function(){
                        alert("사용 불가능한 아이디입니다");
                    }
                }); // end of ajax
            }
        });


        // email 중복체크 btn
        $("#email_btn").click(function(){
            if(regExp(2)){
                openModal("이메일 형식으로 입력해 주세요");
                return false;
            }else{
                let emailVal = $("#email").val();
                $.ajax({
                    type : 'GET',
                    url : '/member/signup/email/'+emailVal,
                    success : function(result){
                        alert("사용 할 수 있는 이메일입니다");
                        $("#email_btn").attr("disabled",true);
                        $("#email_btn").css("color","#dddddd");
                        $("#email_btn").css("border-color","#dddddd");
                    },
                    error : function(){
                        alert("사용 불가능한 이메일입니다");
                    }
                }); // end of ajax
            }
        });

        // 휴대폰번호 인증 api
        $("#telNo_btn").click(function(){
            if(regExp(3)){
                // 1. 숫자아니면 버튼 활성화 안함
                return false;
            }else{
            let telNoVal = $("#telNo").val(); // 휴대폰 번호
            $.ajax({
                type : "POST",
                url : "/sms/telNoCheck",
                data : {telNo : telNoVal},
                cache : false,
                success : function(data) {
                    if (data == "err") { // 실패시
                        alert("SEND ERR");
                    } else {
                        alert("SEND OK");
                        // 성공시 데이터 저장
                    }
                }
            });     // end of ajax
            }
        });


        regBtn.addEventListener("click", () =>{
            // 생년월일 합치기
            let yyyy = document.querySelector("#yyyy").value;
            let mm = document.querySelector("#mm").value;
            let dd = document.querySelector("#dd").value;
            let yyyymmdd = document.querySelector("#yyyymmdd");
            yyyymmdd.value = yyyy+mm+dd;


            let signupFrm = document.querySelector("#frm");
            signupFrm.submit();

        });


    });


</script>
</body>
</html>