package com.freelife.client.jpa;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by mskwon on 2024. 10. 8..
 */
@SpringBootTest
// @ActiveProfiles("test")
// @DataJpaTest
// @TestPropertySource(locations = "classpath:application-test.yml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberServiceMybatisTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Order(1)
    void saveMemberMybatis() {
        Member member = memberService.saveMemberMybatis();
        System.out.println("## insert member: " + member);
    }

    @Test
    @Order(2)
    void findMemberMybatis() {
        memberService.findMemberMybatis();
        System.out.println("## find member: " + memberService.findMemberMybatis());
    }

    @Test
    @Order(3)
    void updateMemberMybatis() {
        memberService.updateMemberMybatis(1L);
        memberService.findMemberMybatis();
        System.out.println("## update member: " + memberService.findMemberMybatis());
    }

    @Test
    @Order(4)
    void deleteMemberMybatis() {
        memberService.deleteMemberMybatis(1L);
    }
}