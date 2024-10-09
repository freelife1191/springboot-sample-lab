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
class MemberServiceJPATest {

    @Autowired
    private MemberService memberService;

    @Test
    @Order(1)
    void saveMemberJPA() {
        memberService.saveMemberJPA();
    }

    @Test
    @Order(2)
    void findMemberJPA() {
        memberService.findMemberJPA();
    }

    @Test
    @Order(3)
    void updateMemberJPA() {
        memberService.updateMemberJPA(1L);
    }

    @Test
    @Order(4)
    void deleteMemberJPA() {
        memberService.deleteMemberJPA(1L);
    }
}