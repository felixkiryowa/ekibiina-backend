package com.ekibiina.ekibiina.api.repository;

import com.ekibiina.ekibiina.api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUid(String uid);
}
