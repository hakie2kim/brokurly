package com.brokurly.controller.member;


import com.brokurly.dto.member.MemberAndLoginDto;
import com.brokurly.dto.member.MemberAndSignupDto;
import com.brokurly.service.member.MemberService;
import com.brokurly.utils.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {


    private final MemberService memberService;

    MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // local signup start
    @GetMapping("/signup")
    public String signUp(){
        return "/member/signupForm";
    }

    @GetMapping("/signup/{custId}")
    @ResponseBody
    public ResponseEntity<String> checkId(@PathVariable String custId){
        log.info("custId = {}",custId);
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


            return "member/signup";
        }

        memberService.signUp(memberAndSignupDto);

        return  "redirect:/categories/best-page";
    }


    //local login start

    @GetMapping("/login")
    public String login(){
        return "/member/loginForm";
    }

    /**
     * @des   로그인 기능
     * @param memberAndLoginDto
     * @param reqURI
     * @param errors
     * @param res
     * @param req
     * @param model
     * @return String
     */
    @PostMapping("/login")
    public String login(@Valid MemberAndLoginDto memberAndLoginDto, String reqURI, Errors errors, HttpServletResponse res, HttpServletRequest req, Model model, RedirectAttributes Ra){
        // 비밀번호는 암호화 처리 되어있음.

        // 1. 로그인 정보 넘어오면 유효성 확인
        if(errors.hasErrors()){
            model.addAttribute("memberAndLoginDto", memberAndLoginDto);

            Map<String,String> validatorRs = memberService.validateHandling(errors);
            Stream<String> streamValidatorRs = validatorRs.keySet().stream();
                            streamValidatorRs.forEach(i -> model.addAttribute(i));

            return "member/loginForm";
        }
        // 2. 비밀번호 암호화 부분 값 확인
        MemberAndLoginDto resultLoginDto = new MemberAndLoginDto();
        resultLoginDto = memberService.localLogin(memberAndLoginDto);

        // 2-1. 불일치
        if(resultLoginDto == null){
            errors.reject("LOGINCHK_ERR","아이디 또는 비밀번호가 맞지 않습니다.");
            return "member/loginForm";
        }

        // 3. 일치하면 세션에 저장
        HttpSession session = req.getSession();
        //  3-1. 세션 있으면 있는 세션 반환, 없으면 신규 생성 후 메인 이동 (기본값 true)
        session.setAttribute(SessionConst.LOGIN_MEMBER, resultLoginDto);
        MemberAndLoginDto custIdDto = (MemberAndLoginDto) session.getAttribute(SessionConst.LOGIN_MEMBER);

        String loginName = custIdDto.getName();
        log.info("loginName = {}", loginName);

        session.setAttribute("loginName",loginName);
//        Ra.addFlashAttribute("loginName",loginName);

//        return "redirect:/categories/best-page" *** db 연결 후 수정;
        // 4. reqURL 여부에 따른 이동
        reqURI = reqURI == null || reqURI.equals("") ? "/categories/best-page" : reqURI;

        return "redirect:"+reqURI;
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        // create : false > 세션이 있으면 기존 세션을 반환하고,
        // 없으면 새로운 세션을 생성하지 않고 null을 반환한다
        HttpSession session = req.getSession(false);

        if(session != null){
            session.invalidate();
        }

        return "redirect:/categories/best-page";

//        return "redirect:/";
    }

    //local login end

    //find id&pwd
    @GetMapping("/find/pwd")
    public String findIdByEmail(){
        return "/member/findForm";
    }

    // mypage/info/modify
    @GetMapping("/info/modify")
    public String modify(HttpServletRequest req, Model model){
        HttpSession session = req.getSession(false);
        MemberAndLoginDto dto = (MemberAndLoginDto)session.getAttribute(SessionConst.LOGIN_MEMBER);

        MemberAndSignupDto memberDto = new MemberAndSignupDto();
        memberDto = memberService.readMemberByOne(dto.getCustId());

        model.addAttribute("memberDto", memberDto);

        return "/member/modifyForm";
    }

}