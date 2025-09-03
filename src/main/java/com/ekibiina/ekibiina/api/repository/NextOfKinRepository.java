package com.ekibiina.ekibiina.api.repository;

import com.ekibiina.ekibiina.api.entities.NextOfKin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NextOfKinRepository extends JpaRepository<NextOfKin, Long> {
    List<NextOfKin> findByMemberId(Long memberId);
}
