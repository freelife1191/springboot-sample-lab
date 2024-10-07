package com.freelife.client.querydsl.dto;

import com.freelife.client.querydsl.common.dto.AuditDto;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

  @Getter
  @Setter
  @SuperBuilder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class UserSearchDto extends AuditDto {

    private String userId;

    private String userName;

    private String email;

    @Builder.Default
    @Parameter(name = "deleteYn")
    private List<Boolean> deleteYnList = new ArrayList<>();

    public void setDeleteYn(List<Boolean> deleteYnList) {
      this.deleteYnList = deleteYnList;
    }
  }

  @Getter
  @Setter
  @SuperBuilder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class UserRequestDto {

    private String userId;

    private String userName;

    private String email;

    private String password;

    private String passwordCheck;
  }

  @Getter
  @Setter
  @SuperBuilder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class UserResponseDto extends AuditDto {

    private String userId;

    private String userName;

    private String email;

    private boolean deleteYn;
  }
}
