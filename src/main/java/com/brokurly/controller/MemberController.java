package com.brokurly.controller;

import com.brokurly.entity.MemberAndSignup;
import com.brokurly.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/signup")
    public String signUp(MemberAndSignup memberAndSignup) {

        String pwd_before = memberAndSignup.getPwd();
        String pwd_after = passEncoder.encode(pwd_before);

        memberAndSignup.setPwd(pwd_after);
        memberService.signUp(memberAndSignup);

        return "index";
    }

}
