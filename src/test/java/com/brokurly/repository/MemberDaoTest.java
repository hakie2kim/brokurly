package com.brokurly.repository;

import com.brokurly.dto.MemberAndSignup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/root-context.xml"})
class MemberDaoTest {
    @Autowired
    private MemberDao dao;

    @Test
    public void insertTest() throws Exception{
        MemberAndSignup memberAndSignup = new MemberAndSignup("aaaa","1234","김학준1","abc@cod.com","01012341111","M","2024-02-0",0);
        System.out.println("memberAndSignup = " + memberAndSignup);
        int rowCnt = dao.insert(memberAndSignup);
        System.out.println("rowCnt = " + rowCnt);

        assertTrue(rowCnt == 1);
    }

}