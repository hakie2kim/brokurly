package com.brokurly.repository.member;

import com.brokurly.entity.member.Member;
import com.brokurly.entity.member.MemberAndSignup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    int insert(MemberAndSignup memberAndSignup);
    Member selectMember(String custId);
    int countMemberAll();
    int countMember(String custId);
    int countEmail(String email);
    int deleteMemberAll();
    int deleteMember(String custId);

}
