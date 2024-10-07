package com.freelife.client.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickName;

    public void addMember(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

    public void updateMember(Member member) {
        this.name = member.getName();
        this.nickName = member.getNickName();
    }
}