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
        return memberRepository.save(Member.generateMember());
    }

    @Transactional(readOnly = true)
    public List<Member> findMemberJPA() {
        return memberRepository.findAll();
    }

    public List<Member> updateMemberJPA(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) return List.of();
        memberRepository.findById(member.getId())
                .map(m -> {
                    m.setName("홍길순");
                    m.setNickName("freelife2");
                    m.setPassword("5678");
                    return m;
                }).ifPresent(m -> m.updateMember(m));
        return findMemberJPA();
    }

    public List<Member> deleteMemberJPA(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) return List.of();
        memberRepository.delete(member);
        return findMemberJPA();
    }

    public Member saveMemberMybatis() {
        Member member = Member.generateMember();
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
        member.setPassword("5678");
        memberMapper.update(member);
    }

    public void deleteMemberMybatis(Long id) {
        memberMapper.delete(id);
    }
}
