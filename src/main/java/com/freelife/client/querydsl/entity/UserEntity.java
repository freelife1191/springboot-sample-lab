package com.freelife.client.querydsl.entity;

import com.freelife.client.config.JpaConfig;
import com.freelife.client.querydsl.dto.UserDto.UserResponseDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.StringUtils;

@Entity
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class UserEntity extends AuditEntity {

  @Id
  @Column(length = 20, nullable = false)
  @Comment(value = "사용자 ID")
  private String userId;

  @Column(length = 100, nullable = false)
  @Comment(value = "비밀번호")
  private String password;

  @Column(length = 50, nullable = false)
  @Comment(value = "사용자 이름")
  private String userName;

  @Column(length = 100, nullable = false, unique = true)
  @Comment(value = "이메일")
  private String email;

  @Builder.Default
  @Setter
  @Column(length = 1)
  @ColumnDefault(value = "'N'")
  @Comment(value = "삭제 여부")
  @Convert(converter = JpaConfig.class)
  private boolean deleteYn = false;

  public void setUserName(String userName) {
    if (StringUtils.hasText(userName)) {
      this.userName = userName;
    }
  }

  public void setEmail(String email) {
    if (StringUtils.hasText(email)) {
      this.email = email;
    }
  }

  public void setPassword(String password) {
    if (StringUtils.hasText(password)) {
      this.password = password;
    }
  }

  public UserResponseDto toDto() {
    return UserResponseDto
      .builder()
      .userId(this.userId)
      .userName(this.userName)
      .email(this.email)
      .deleteYn(this.deleteYn)
      .build();
  }
}
