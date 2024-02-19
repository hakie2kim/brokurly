package com.brokurly.service.member;

import com.brokurly.entity.member.MemberAndSignup;
import com.brokurly.repository.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDao memberDao;

    @Override
    public int signUp(MemberAndSignup memberAndSignup) {
       return memberDao.insert(memberAndSignup);
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
