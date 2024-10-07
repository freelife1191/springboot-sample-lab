package com.freelife.client.jpa;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Tag(name = "Member API", description = "MemberController")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "JPA 회원 추가")
    @PostMapping("/jpa/member")
    public Member saveMemberJPA() {
        return memberService.saveMemberJPA();
    }

    @Operation(summary = "JPA 회원 조회")
    @GetMapping("/jpa/member")
    public List<Member> selectMemberJPA() {
        return memberService.findMemberJPA();
    }

    @Operation(summary = "JPA 회원 수정")
    @PutMapping("/jpa/member")
    public void updateMemberJPA(
            @Parameter(description = "회원 ID", required = true, example = "1")
            @RequestParam("id") Long id) {
        memberService.updateMemberJPA(id);
    }

    @Operation(summary = "JPA 회원 삭제")
    @DeleteMapping("/jpa/member")
    public void deleteMemberJPA(
            @Parameter(description = "회원 ID", required = true, example = "1")
            @RequestParam("id") Long id) {
        memberService.deleteMemberJPA(id);
    }

    @Operation(summary = "Mybatis 회원 추가")
    @PostMapping("/mybatis/member")
    public Member saveMemberMybatis() {
        return memberService.saveMemberMybatis();
    }

    @Operation(summary = "Mybatis 회원 조회")
    @GetMapping("/mybatis/member")
    public List<Member> selectMemberMybatis() {
        return memberService.findMemberMybatis();
    }

    @Operation(summary = "Mybatis 회원 수정")
    @PutMapping("/mybatis/member")
    public void updateMemberMybatis(
            @Parameter(description = "회원 ID", required = true, example = "1")
            @RequestParam("id") Long id) {
        memberService.updateMemberMybatis(id);
    }

    @Operation(summary = "Mybatis 회원 삭제")
    @DeleteMapping("/mybatis/member")
    public void deleteMemberMybatis(
            @Parameter(description = "회원 ID", required = true, example = "1")
            @RequestParam("id") Long id) {
        memberService.deleteMemberMybatis(id);
    }

}
