package com.freelife.client.querydsl.repo;

import com.freelife.client.querydsl.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {}
