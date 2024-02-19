package com.brokurly.controller.oauth;

import com.brokurly.dto.member.MemberAndSignupDto;
import com.brokurly.service.oauth.KaKaoService;
import com.brokurly.service.member.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
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
        String snsId = (String)result.get("id");
        String userName = (String)result.get("name");
        String email = (String)result.get("email");
        String userpw = snsId;

        MemberAndSignupDto memberAndSignupDto = new MemberAndSignupDto();

        // 일치하는 snsId 없을 시 회원가입
      //  log.info(" memberServiece.kakaoLogin(snsId) = {} ", memberService.kakaoLogin(snsId));
        if(memberService.kakaoLogin(snsId) == null){
            log.info("kakao register");
            memberAndSignupDto.setCustId(email);
            memberAndSignupDto.setPwd(userpw);
            memberAndSignupDto.setName(userName);
            memberAndSignupDto.setSnsId(snsId);
            memberService.kakaoJoin(memberAndSignupDto);
        }

        // 일치하는 snsId가 있으면 멤버객체에 담음
        log.warn("카카오로 로그인");
        String userId = memberService.findBySnsId(snsId);
        log.info("userId = {}", userId);
//        MemberAndSignupDto dto = memberService.findByUserId(userId);


//        Authentication auth = new AbstractAuthenticationToken(user, null, roles);

        return  "redirect:/";
    }
}