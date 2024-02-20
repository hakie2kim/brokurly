package com.brokurly.repository.member;


import com.brokurly.entity.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    int insert(Member member);
    void insertSnsMember(Member member);
    Member selectSnsMember(String snsId);
    String findBySnsId(String snsId);
    int countMemberAll();
    int countMember(String custId);
    int countEmail(String email);
    int deleteMemberAll();
    int deleteMember(String custId);

}