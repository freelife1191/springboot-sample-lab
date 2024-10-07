package com.freelife.client.querydsl.repo;

import com.freelife.client.querydsl.dto.UserDto;
import com.freelife.client.querydsl.dto.UserDto.UserSearchDto;
import com.freelife.client.querydsl.entity.UserEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import static com.freelife.client.querydsl.entity.QUserEntity.userEntity;


@Repository
@RequiredArgsConstructor
public class UserQueryRepo {

  private final JPAQueryFactory queryFactory;

  public Page<UserEntity> getUserList(
    UserSearchDto userSearchDto,
    Pageable pageable
  ) {
    JPAQuery<UserEntity> selectQuery = queryFactory
      .selectFrom(userEntity)
      .where(
        userIdContains(userSearchDto.getUserId()),
        userNameContains(userSearchDto.getUserName()),
        emailContains(userSearchDto.getEmail())
      )
      .offset(pageable.getOffset())
      .limit(pageable.getPageSize())
      .orderBy(userEntity.createdAt.desc());

    JPAQuery<Long> countQuery = queryFactory
      .select(userEntity.count())
      .from(userEntity)
      .where(
        userIdContains(userSearchDto.getUserId()),
        userNameContains(userSearchDto.getUserName()),
        emailContains(userSearchDto.getEmail())
      )
      .offset(pageable.getOffset())
      .limit(pageable.getPageSize());

    return PageableExecutionUtils.getPage(
      selectQuery.fetch(),
      pageable,
      countQuery::fetchOne
    );
  }

  private BooleanExpression userIdContains(String userId) {
    return StringUtils.hasText(userId)
      ? userEntity.userId.contains(userId)
      : null;
  }

  private BooleanExpression userNameContains(String userName) {
    return StringUtils.hasText(userName)
      ? userEntity.userName.contains(userName)
      : null;
  }

  private BooleanExpression emailContains(String email) {
    return StringUtils.hasText(email) ? userEntity.email.contains(email) : null;
  }
}
