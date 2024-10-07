package com.freelife.client.mybatis;

import com.freelife.client.jpa.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {

    void save(@Param("member") Member member);
    List<Member> findAll();
    Member findById(@Param("id") Long id);
    void update(@Param("member") Member member);
    void delete(@Param("id") Long id);
}
