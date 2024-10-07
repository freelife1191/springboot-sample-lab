package com.freelife.client.jpa;

import com.freelife.client.mybatis.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Member saveMemberJPA() {
        Member member = new Member();
        member.addMember("홍길동", "freelife");
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public List<Member> findMemberJPA() {
        return memberRepository.findAll();
    }

    public void updateMemberJPA(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) return;
        memberRepository.findById(member.getId())
                .map(m -> {
                    m.setName("홍길순");
                    m.setNickName("freelife2");
                    return m;
                }).ifPresent(m -> m.updateMember(m));
    }

    public void deleteMemberJPA(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) return;
        memberRepository.delete(member);
    }

    public Member saveMemberMybatis() {
        Member member = new Member();
        member.addMember("홍길동", "freelife");
        memberMapper.save(member);
        return findByIdMyabatis(member.getId());
    }

    @Transactional(readOnly = true)
    public List<Member> findMemberMybatis() {
        List<Member> results = memberMapper.findAll();
        log.info("results: {}", results);
        return results;
    }

    private Member findByIdMyabatis(Long id) {
        return memberMapper.findById(id);
    }

    public void updateMemberMybatis(Long id) {
        Member member = memberMapper.findById(id);
        if (member == null) return;
        member.setName("홍길순");
        member.setNickName("freelife2");
        memberMapper.update(member);
    }

    public void deleteMemberMybatis(Long id) {
        memberMapper.delete(id);
    }
}
