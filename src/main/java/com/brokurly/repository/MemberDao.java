package com.brokurly.repository;

import com.brokurly.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    int insert(Member memberDto);
    Member selectMember(String custId);
    int count(String custId);
    int deleteMember(String custId);
}
