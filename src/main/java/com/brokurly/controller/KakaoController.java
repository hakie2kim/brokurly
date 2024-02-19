package com.brokurly.controller;

import com.brokurly.dto.MemberAndSignupDto;
import com.brokurly.service.KaKaoService;
import com.brokurly.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@Slf4j
@AllArgsConstructor
public class KakaoController {
    private KaKaoService kaKaoService;
    private MemberService memberService;

    @GetMapping("/kakao_callback")
    public String redirectkakao(@RequestParam String code, HttpSession session) throws IOException{
        log.info("code = {} ", code);

        // 접속토큰 get
        String kakaoToken = kaKaoService.getReturnAccessToken(code);
        log.info("kakaoToken = {}", kakaoToken);
        // 접속자 정보 get
        Map<String, Object> result = kaKaoService.getUserInfo(kakaoToken);
        log.info("result = {}", result);
        String snsId = (String)result.get("id");
        String userName = (String)result.get("name");
        String email = (String)result.get("email");
        String userpw = snsId;

        MemberAndSignupDto memberAndSignupDto = null;

        // 일치하는 snsId 없을 시 회원가입
        log.info(" memberServiece.kakaoLogin(snsId) = {} ", memberService.kakaoLogin(snsId));
        if(memberService.kakaoLogin(snsId) == null){
//            log.warn("kakao register");
//            memberAndSignupDto = new MemberAndSignupDto(email,userpw,userName,snsId);
////            memberAndSignupDto.setCustId(email);
////            memberAndSignupDto.setPwd(userpw);
////            memberAndSignupDto.setName(userName);
////            memberAndSignupDto.setSnsId(snsId);
//            memberService.kakaoJoin(memberAndSignupDto);
        }

        return  "";
    }
}
