package com.freelife.client.jpa;

import com.freelife.client.jpa.converter.EncryptConverter;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String nickName;
    @Convert(converter = EncryptConverter.class)
    @Column(nullable = false)
    private String password;

    @Builder
    public Member(String name, String nickName, String password) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
    }

    public static Member generateMember() {
        return Member.builder()
                .name("홍길동")
                .nickName("freelife")
                .password("1234")
                .build();
    }

    public void updateMember(Member member) {
        this.name = member.getName();
        this.nickName = member.getNickName();
    }
}