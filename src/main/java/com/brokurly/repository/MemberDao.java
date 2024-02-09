package com.brokurly.repository;

import com.brokurly.dto.Member;
import com.brokurly.dto.MemberAndSignup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    int insert(MemberAndSignup memberAndSignup);
    Member selectMember(String custId);
    int countMemberAll();
    int countMember(String custId);
    int deleteMemberAll();
    int deleteMember(String custId);

}
