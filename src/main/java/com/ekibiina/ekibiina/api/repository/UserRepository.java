package com.ekibiina.ekibiina.api.repository;

import com.ekibiina.ekibiina.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByFirebaseUid(String firebaseUid);
}
