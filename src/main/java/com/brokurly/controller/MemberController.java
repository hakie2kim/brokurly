package com.brokurly.controller;

import com.brokurly.dto.MemberAndSignupDto;
import com.brokurly.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {


    private BCryptPasswordEncoder passEncoder;
    private MemberService memberService;

    MemberController(BCryptPasswordEncoder passEncoder, MemberService memberService){
        this.passEncoder = passEncoder;
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String signUp(){
        return "/member/signupForm";
    }

    @GetMapping("/login")
    public String login(){
        return "/member/loginForm";
    }
    @GetMapping("/signup/{custId}")
    @ResponseBody
    public ResponseEntity<String> checkId(@PathVariable String custId){
        try{
            if(memberService.getCount(custId) == 1){
                throw new Exception("Member IdChk failed.");
            }
            return new ResponseEntity<String>("IDCHK_OK", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("IDCHK_ERR", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/signup/email/{email}")
    @ResponseBody
    public ResponseEntity<String> checkEmail(@PathVariable String email){
        try{
            if(memberService.getCountEmail(email) == 1){
                log.debug("memberService.getCountEmail(email) = {}", memberService.getCountEmail(email));
                throw new Exception("Member EmailChk failed.");
            }
            return new ResponseEntity<String>("EMAILCHK_OK", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("EMAILCHK_ERR", HttpStatus.BAD_REQUEST);
        }
    }



    @PostMapping("/signup")
    public String signUp(@Valid MemberAndSignupDto memberAndSignupDto, Errors errors, Model model) {

        if(errors.hasErrors()) {    // 유효성 검사에 실패한 필드가 있는지 확인
            // 회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("memberAndSignupDto", memberAndSignupDto);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorRs = memberService.validateHandling(errors);
            Stream<String> streamValidatorRs = validatorRs.keySet().stream();
                            streamValidatorRs.forEach(i -> model.addAttribute(i));
//            streamValidatorRs.forEach(i -> log.info("i = {} ", i));


            return "/signup";
        }


        String pwd_before = memberAndSignupDto.getPwd();
        String pwd_after = passEncoder.encode(pwd_before);

        memberAndSignupDto.setPwd(pwd_after);
        memberService.signUp(memberAndSignupDto);

        return "index";
    }

}