package com.brokurly.service.member;



import com.brokurly.dto.member.MemberAndSignupDto;
import com.brokurly.entity.member.Member;
import com.brokurly.repository.member.MemberDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDao memberDao;

    @Override
    // 회원가입 시 , 유효성 체크
    public Map<String, String> validateHandling(Errors errors){
        Map<String, String> validatorRs = new HashMap<>();

        for(FieldError err : errors.getFieldErrors()) {  // 유효성 검사에 실패한 필드 목록을 가져옴
            String validKeyName = String.format("valid_%s", err.getField()); // 실패한 필드명을 가져옴
            validatorRs.put(validKeyName, err.getDefaultMessage()); // 실패한 필드에 정의된 메시지를 가져옴

        }

        return validatorRs;
    }
    @Override
    public int signUp(MemberAndSignupDto memberAndSignupDto) {
        Member member = new Member();
        member.changeStatus(memberAndSignupDto);
        return memberDao.insert(member);
    }

    // 카카오 로그인
    @Override
    public void kakaoJoin(MemberAndSignupDto memberAndSignupDto){
        Member member = new Member();
        member.changeStatus(memberAndSignupDto);
        memberDao.insertSnsMember(member);

        String custId = memberAndSignupDto.getCustId();
        log.info("custId = {} ", custId);

    }
    @Override
    public MemberAndSignupDto kakaoLogin(String snsId){
        log.info("snsId = {}",snsId);
        Member member = memberDao.selectSnsMember(snsId);
        return member.makeFullDto();
    }
    @Override
    public int getCountAll(){
        return memberDao.countMemberAll();
    }

    @Override
    public int getCount(String custId){
        return memberDao.countMember(custId);
    }

    @Override
    public int getCountEmail(String email) { return memberDao.countEmail(email); }

    @Override
    public int removeAll(){
        return memberDao.deleteMemberAll();
    }
}