
    $(document).ready(function () {
    let modal = document.querySelector(".modal");
    let modalContent = document.querySelector("#modal_content");
    let closeModalBtn = document.querySelector(".close-modal-btn");

    let custId = document.querySelector("#custId");
    let name = document.querySelector("#name");
    let email = document.querySelector("#email");
    let pwdOrigin = document.querySelector("#pwd");
    let pwdChk = document.querySelector("#pwdChk");
    let telNo = document.querySelector("#telNo");

    //  생년월일
    let yyyy = document.querySelector("#yyyy");
    let mm  = document.querySelector("#mm");
    let dd  = document.querySelector("#dd");

    let regBtn = document.querySelector(".register-btn");
    let telNoBtn = document.querySelector("#telNo_btn");

    let authNum = ''; // 인증번호

    // 이용약관 동의
        let data_agreement1 = document.querySelector("#agreement1");
        let data_agreement2 = document.querySelector("#agreement2");
        let data_agreement3 = document.querySelector("#agreement3");
        let data_agreement4 = document.querySelector("#agreement4");
        let data_agreement5 = document.querySelector("#agreement5");
        let data_agreement6 = document.querySelector("#agreement6");

        // 최종값
        let consent = document.querySelector("#consent");


    // modal open
    function openModal(msg) {
    modal.style.display = "flex";
    document.body.style.overflow = "hidden"; // 모달 작동 시 스크롤바 비활성화
    modalContent.innerHTML = `<p>${msg}</p>`; //

}

    // modal close
    closeModalBtn.addEventListener("click", () => {
    modal.style.display = "none";
    document.body.style.overflow = "unset"; // 모달 작동 시 스크롤바 활성화

});


    function regExp(value){
    const idRegEx = /^[a-z]+[a-z0-9]{5,17}$/g; // 아이디 정규식
    const emailRegEx = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i; // 이메일 정규식
    const pwdRegEx = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{10,15}$/; // 비밀번호 > 영문 특수문자 조합 8자 이상
    const telNoRegEx = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;  // 휴대폰번호 > 숫자만 가능 01?-4자리-4자리
    const yyyyRegEx = /^(19|20)\d{2}$/; // yyyy 연도
    const mmRegEx = /(0[1-9]|1[0-2])$/; // mm 월
    const ddRegEx = /([0-2][1-9]|3[01])$/; // dd 일

    let inputed = "";
    let regEx = "";

    if(value === 1){  // 아이디 정규식
    inputed = custId.value.trim();
    regEx = idRegEx;
        }else if(value === 2){
            inputed = document.querySelector("#email").value.trim();
            regEx = emailRegEx;
        }else if(value === 3){
            let telNo = document.querySelector("#telNo").value.trim();
            inputed = telNo.slice(0,3)+'-'+telNo.slice(3,7)+"-"+telNo.slice(7,telNo.length);
            regEx = telNoRegEx;
        }else if(value === 4){
            inputed = document.querySelector("#pwd").value.trim();
            regEx = pwdRegEx;
        }else if(value === 5){
            inputed = yyyy.value.trim();
            regEx = yyyyRegEx;
        }else if(value === 6){
            if(mm.value.trim() < 10){
               inputed = '0'+mm.value.trim();
            }else{
                inputed = mm.value.trim();
            }
            regEx = mmRegEx;

        }else if(value === 7) {
            if (dd.value.trim() < 10) {
                inputed = '0' + dd.value.trim();
            } else {
                inputed = dd.value.trim();
            }

        regEx = ddRegEx;
    }

    return !regEx.test(inputed) || !inputed;
}

    // 휴대폰 번호 유효성 검사
    telNo.addEventListener("input", () => {
        let telNoInfoDiv = document.querySelector(".telNo-info-div");

        if(telNo.value.length === 0){
            telNoInfoDiv.style.display = "block";
            telNoInfoDiv.innerHTML = "휴대폰 번호를 입력해 주세요";
            }else if(regExp(3)){
                telNo.value = telNo.value.replace(/[^-0-9]/g, "");
                telNoInfoDiv.style.display = "none";
            }else{
                telNoInfoDiv.style.display = "none";
                telNoBtn.style.color = "#11967f";
                telNoBtn.style.borderColor = "#11967f";
                telNoBtn.disable = false;

                }

            });

    // 생년월일 유효성 start
    yyyy.addEventListener("input", () => {
        let birthInfoDiv = document.querySelector(".birth-info-div");

        if(yyyy.value.length < 4){
            birthInfoDiv.innerHTML = "태어난 년도 4자리를 정확히 입력해주세요";
            birthInfoDiv.style.display = "block";
            return false;
        }else if(regExp(5)){
            birthInfoDiv.innerHTML = "생년월일을 다시 확인해주세요";
            return false;
        }else if(mm.value.length === 0){
            birthInfoDiv.innerHTML = "태어난 월을 정확히 입력해주세요";
            return false;
        }else{
            birthInfoDiv.style.display = "none";
            return true;
        }
    });

        mm.addEventListener("input", () => {
            let birthInfoDiv = document.querySelector(".birth-info-div");

            if(regExp(6)){
                birthInfoDiv.innerHTML = "태어난 월을 정확히 입력해주세요";
                birthInfoDiv.style.display = "block";
                return false;
            }else if(dd.value.length === 0){
                birthInfoDiv.innerHTML = "태어난 일을 정확히 입력해주세요";
                return false;
            }else{
                birthInfoDiv.style.display = "none";
                return true;
            }
        });

        dd.addEventListener("input", () => {
            let birthInfoDiv = document.querySelector(".birth-info-div");

            if(regExp(7)){
                birthInfoDiv.innerHTML = "태어난 일을 정확히 입력해주세요";
                birthInfoDiv.style.display = "block";
                return false;
            }else{
                birthInfoDiv.style.display = "none";
                return true;
            }
        });
    // 생년월일 유효성 end

     //  비밀번호 유효성 검사
     pwdOrigin.addEventListener("input", () => {
        let pwdInfoDiv = document.querySelector(".pwd-info-div");


        if(pwdOrigin.value.length < 10){
            pwdInfoDiv.innerHTML = '최소 10자 이상 입력';
            pwdInfoDiv.style.display = "block";
        }else{
            if(regExp(4)){
                pwdInfoDiv.innerHTML = '영문/숫자/특수기호만 허용하며, 모두 조합';
                pwdInfoDiv.style.display = "block";
            }else{
                pwdInfoDiv.style.display = "none";
            }
        }
     });

     // 비밀번호 체크
        pwdChk.addEventListener("input" ,() => {
            let pwdChkInfoDiv = document.querySelector(".pwdChk-info-div");

            if(pwdChk.value.length === 0) {
                pwdChkInfoDiv.innerHTML = '비밀번호를 한번 더 입력해주세요.';
                pwdChkInfoDiv.style.display = 'block';
            }else if(pwdChk.value != pwdOrigin.value){
                pwdChkInfoDiv.innerHTML = '동일한 비밀번호를 입력';
                pwdChkInfoDiv.style.display = "block";
                return false;
            }else{
                pwdChkInfoDiv.style.display = 'none';
            }
        })

        // 이름 유효성 검사
    name.addEventListener("input", () => {
    let nameInfoDiv = document.querySelector(".name-info-div");

    if(!name.value.trim()){
    nameInfoDiv.style.display = "block";
}else{
    nameInfoDiv.style.display = "none";
}
});

    // 아이디 ajax로 유효성 검사
    $("#custId").keydown(function(){
    let idInfoDiv =  $(".id-info-div");

    $.ajax({
    success: function () {
    if (regExp(1)) {
    idInfoDiv.css("display", "block");
    $("#custId_btn").attr("disabled",false);
    $("#custId_btn").css("color","#11967f");
    $("#custId_btn").css("border-color","#11967f");
}else{
    idInfoDiv.css("display","none");
}
},
});
});




    // 이메일 ajax로 유효성 검사
    $("#email").keydown(function(){
    let emailInfoDiv =  $(".email-info-div");

    $.ajax({
    success: function () {
    if (regExp(2)) {
    emailInfoDiv.css("display", "block");
    $("#email_btn").attr("disabled",false);
    $("#email_btn").css("color","#11967f");
    $("#email_btn").css("border-color","#11967f");

             return false;
        }else{
            emailInfoDiv.css("display","none");
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
    url : '/member/signup/email/'+emailVal+'?cnt=1',
    success : function(result){
        openModal("사용 할 수 있는 이메일입니다");
    $("#email_btn").attr("disabled",true);
    $("#email_btn").css("color","#dddddd");
    $("#email_btn").css("border-color","#dddddd");
},
    error : function(){
        openModal("사용 불가능한 이메일입니다");
}
}); // end of ajax
}
});

    // 휴대폰번호 인증 api
    $("#telNo_btn").click(function(){
    if(regExp(3)){
        openModal("잘못된 휴대폰 번호입니다.\n확인 후 다시 시도 해주세요.") // 1. 숫자아니면 버튼 활성화 안함
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
                openModal("인증번호 발송에 실패하였습니다");
        } else {
            openModal("인증번호가 발송되었습니다");
                $("#telNo_btn").attr("disabled",true);
                $("#telNo_btn").css("color","#dddddd");
                $("#telNo_btn").css("border-color","#dddddd");

                $("#telNoChk-div").css("display","block");
                $("#telNoChk").attr("disabled", false);

                authNum = data;


            // 성공시 데이터 저장
                 }
              }
          });     // end of ajax
        }
    });

        function chkAuthNum(){
            let chkNum = document.querySelector("#telNoChk").value;

            if(chkNum === authNum){
                $(".loginBtn").attr("disabled",false);
                $(".loginBtn").css("background-color","#11967f");
                $(".loginBtn").css("border-color","#11967f");

                $("#email_btn").attr("disabled",true);
                $("#email_btn").css("background-color","#dddddd");
                $("#email_btn").css("border-color","#dddddd");
                $("#email_btn").html("확인 완료");

                $("#email").attr("disabled",true);

                chkCnt += 1;

            }else{
                alert("올바른 인증코드가 아닙니다.");
            }

        }

        let telNoChk = document.querySelector("#telNoChk");
        let telNoChkBtn = document.querySelector("#telNoChk_btn");

        telNoChk.addEventListener("input", () => {
            let telNoChkBtn = document.querySelector("#telNoChk_btn");

            if(telNoChk.value.length === 0){
                telNoChkBtn.style.color = "#dddddd";
                telNoChkBtn.style.borderColor = "#dddddd";
                telNoChkBtn.disable = true;
            }else{
                telNoChkBtn.style.color = "#11967f";
                telNoChkBtn.style.borderColor = "#11967f";
                telNoChkBtn.disable = false;
            }
        });

        telNoChkBtn.addEventListener("click", () => {

            if(telNoChk.value === authNum){
                openModal("인증 성공하였습니다");
                telNoChkBtn.style.color = "#dddddd";
                telNoChkBtn.style.borderColor = "#dddddd";
                telNoChkBtn.disable = true;

                telNoChk.style.color = "#dddddd";
                telNoChk.style.borderColor = "#dddddd";
                telNoChk.disable = true;

                authNum = '';

                return true;
            }else{
                openModal("인증 실패하였습니다");
                return false;
            }
        });

    // 동의
    data_agreement1.addEventListener("click", () =>{
        const isChecked = data_agreement1.checked;
        let all_agreement = document.querySelectorAll(".chk");

        if(isChecked){
            for(const checkbox of all_agreement) {
                checkbox.checked = true;
            }
            consent.value = 11;
        }else{
                for(const checkbox of all_agreement){
                    checkbox.checked = false;
                }
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
