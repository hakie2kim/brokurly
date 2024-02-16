package com.brokurly.controller;

import com.brokurly.domain.MemberAndSignup;
import com.brokurly.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String signUp(MemberAndSignup memberAndSignup) {

        String pwd_before = memberAndSignup.getPwd();
        String pwd_after = passEncoder.encode(pwd_before);

        memberAndSignup.setPwd(pwd_after);
        memberService.signUp(memberAndSignup);

        return "index";
    }

}