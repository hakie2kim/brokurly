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
    <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
            rel="stylesheet"
    />
    <title>회원가입</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="<c:url value='/resources/css/member/signupForm.css'/>"/>
</head>
<body>
<form id="frm" action="<c:url value="/member/signup"/>" method="POST">
    <input type="hidden" name="_method" value="POST">
    <section>
        <!-- modal start -->
        <jsp:include page="../include/modal.jsp"/>
        <!-- modal end -->
        <span class="register-header">회원가입</span>
        <div class="Required-entr-div">
            <span class="Required-entr__label">*&nbsp;</span>필수입력사항
        </div>
        <div class="register-div">
            <div class="column-div">
          <span class="register-div__label"
          >이메일<span class="Required-entr__label">*</span></span
          >
                <input
                        type="text"
                        placeholder="예: brokurly@kurly.com"
                        title="이 입력란을 작성하세요"
                        id="email"
                        name="email"
                />
                <button type="button" id="email_btn" class="open-modal-btn btn css-x0zbdy e4nu7ef3">중복확인</button>
            </div>
            <div class="email-info-div">
          <span
          >이메일 형식으로 입력해 주세요</span
          >
            </div>
            <div class="email-infoSec-div">
          <span
          >이메일을 입력해주세요</span
          >
            </div>
<%--            <div class="column-div">--%>
<%--          <span class="register-div__label"--%>
<%--          >아이디<span class="Required-entr__label">*</span></span--%>
<%--          >--%>
<%--                <input--%>
<%--                        type="text"--%>
<%--                        placeholder="아이디를 입력해 주세요"--%>
<%--                        title="이 입력란을 작성하세요"--%>
<%--                        id="custId"--%>
<%--                        name="custId"--%>
<%--                        maxlength="17"--%>
<%--                />--%>
<%--                <button type="button" id="custId_btn" class="open-modal-btn">중복확인</button>--%>
<%--            </div>--%>
<%--            <div class="id-info-div">--%>
<%--          <span--%>
<%--          >6자 이상 16자 이하의 영문 혹은 영문과 숫자를 조합</span--%>
<%--          >--%>
<%--            </div>--%>
            <div class="column-div">
          <span class="register-div__label"
          >비밀번호<span class="Required-entr__label">*</span></span
          >
                <input
                        type="password"
                        placeholder="비밀번호를 입력해 주세요"
                        title="이 입력란을 작성하세요"
                        name="pwd"
                        id="pwd"
                        maxlength="15"

                />
            </div>
            <div class="pwd-info-div">
            </div>
            <div class="column-div">
          <span class="register-div__label"
          >비밀번호확인<span class="Required-entr__label">*</span></span
          >
                <input
                        type="password"
                        placeholder="비밀번호를 한번 더 입력해 주세요"
                        title="이 입력란을 작성하세요"
                        maxlength="15"
                        id="pwdChk"

                />
            </div>
            <div class="pwdChk-info-div">
            </div>
            <div class="column-div">
          <span class="register-div__label"
          >이름<span class="Required-entr__label">*</span></span
          >
                <input
                        type="text"
                        placeholder="이름을 입력해 주세요"
                        title="이 입력란을 작성하세요"
                        id="name"
                        name="name"
                />
            </div>
            <div class="name-info-div">
          <span
          >이름을 입력해 주세요</span
          >
            </div>
<%--            <div class="column-div">--%>
<%--          <span class="register-div__label"--%>
<%--          >이메일<span class="Required-entr__label">*</span></span--%>
<%--          >--%>
<%--                <input--%>
<%--                        type="text"--%>
<%--                        placeholder="예: brokurly@gmail.com"--%>
<%--                        title="이 입력란을 작성하세요"--%>
<%--                        id="email"--%>
<%--                        name="email"--%>
<%--                />--%>
<%--                <button type="button" id="email_btn" class="open-modal-btn">중복확인</button>--%>
<%--            </div>--%>
<%--            <div class="email-info-div">--%>
<%--          <span--%>
<%--          >이메일 형식으로 입력해 주세요</span--%>
<%--          >--%>
<%--            </div>--%>
<%--            <div class="email-infoSec-div">--%>
<%--          <span--%>
<%--          >이메일을 입력해주세요</span--%>
<%--          >--%>
<%--            </div>--%>
            <div class="column-div">
          <span class="register-div__label"
          >휴대폰<span class="Required-entr__label">*</span></span
          >
                <input
                        type="text"
                        placeholder="숫자만 입력해 주세요"
                        title="이 입력란을 작성하세요"
                        id="telNo"
                        name="telNo"
                />
                <button type="button" class="open-modal-btn btn" id="telNo_btn">인증번호 받기</button>
            </div>
            <div class="telNo-info-div"></div>
            <div class="column-div" id="telNoChk-div">
          <span class="register-div__label"
          >&nbsp;&nbsp;&nbsp;<span class="Required-entr__label"></span></span
          >
                <input
                        type="text"
                        placeholder="인증번호를 입력해주세요"
                        title="이 입력란을 작성하세요"
                        id="telNoChk"

                />
                <button type="button" class="open-modal-btn btn"  id="telNoChk_btn">인증번호 확인</button>
            </div>
            <div class="column-div" style="margin-top:20px;">
                <span class="register-div__label">성별</span>
                <div class="gender-div">
                <div>
                <input type="radio" id="sex-m" name="sex" value="M"/>
                <label for="sex-m">남자</label>
                </div>
                <div>
                <input type="radio" id="sex-f" name="sex" value="F"/>
                <label for="sex-f">여자</label>
                </div>
                <div>
                <input type="radio" id="sex-none" name="sex" value="N" checked/>
                <label for="sex-none">선택안함</label>
                </div>
                    </div>
            </div>


            <div class="birth-div column-div">
                <span class="register-div__label">생년월일</span>
                <div class="birth-div__column">
                    <input type="text" id="yyyy" placeholder="YYYY" maxlength="4"/><span>/</span>
                    <input type="text" id="mm" placeholder="MM" maxlength="2"/><span>/</span>
                    <input type="text" id="dd" placeholder="DD" maxlength="2"/>
                    <input type="hidden" id="yyyymmdd" value="" name="birthDt">
                    <div class="birth-info-div"></div>
                </div>
            </div>
        </div>
        <hr />
        <div class="agreement-div">
        <div class="register-div__label"
        >이용약관동의<span class="Required-entr__label">*</span></div
        >
            <div class="test_div">
            <div class="agreement-div__column">
                <div>
                    <input type="checkbox" id="agreement1" class="chk" /><label for="agreement1" style="font-weight: 500"
                >전체 동의합니다.</label
                >
                    <div class="agreement-label">
                        <label style="font-size: 12px;">
                            선택항목에 동의하지 않은 경우도 회원가입 및 일반적인 서비스를
                            이용할 수 있습니다.
                        </label>
                    </div>
                </div>
            </div>
            <div class="agreement-div__column">
                <input type="checkbox" id="agreement2" class="chk" /><label for="agreement2"
            >이용약관 동의<span>(필수)</span></label
            >
                <a href="#"
                ><span><label class="agreement-label__chk" style="left:237px">약관보기></label></span></a
                >
            </div>
            <div class="agreement-div__column">
                <input type="checkbox" id="agreement3" class="chk" /><label for="agreement3"
            >개인정보 수집 이용 동의<span>(필수)</span></label
            >
                <a href="#"
                ><span><label class="agreement-label__chk">약관보기></label></span></a
                >
            </div>
            <div class="agreement-div__column">
                <input type="checkbox" id="agreement4" class="chk" /><label for="agreement4"
            >개인정보 수집 이용 동의<span>(선택)</span></label
            >
                <a href="#"
                ><span><label class="agreement-label__chk">약관보기></label></span></a
                >
            </div>
            <div class="agreement-div__column">
                <input type="checkbox" id="agreement5" class="chk"/><label for="agreement5"
            >무료배송,할인쿠폰 등 혜택/정보 수신 동의<span>(선택)</span></label
            >
            </div>
            <div class="agreement-div__column">
                <input type="checkbox" id="agreement6"class="chk" /><label for="agreement6"
            >본인은 만 14세 이상입니다.<span>(필수)</span></label
            >
            </div>
            </div>
        </div>
        <input type="hidden" name="consent" id="consent"/>
        <div class="line_div"></div>
        <button type="button" class="register-btn btn">가입하기</button>
    </section>
</form>
<%--<script type="text/javascript" src="<c:url value='/resources/js/member/modal.js'/>"></script>--%>
<script type="text/javascript" src="<c:url value='/resources/js/member/member.js'/>"></script>
</body>
</html>