package com.brokurly.repository;

import com.brokurly.domain.Member;
import com.brokurly.dto.MemberAndSignupDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    int insert(Member member);
    void insertSnsMember(Member member);
    Member selectSnsMember(String snsId);
    int countMemberAll();
    int countMember(String custId);
    int countEmail(String email);
    int deleteMemberAll();
    int deleteMember(String custId);

}
