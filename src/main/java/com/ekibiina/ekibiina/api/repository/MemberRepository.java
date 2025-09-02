package com.ekibiina.ekibiina.api.repository;

import com.ekibiina.ekibiina.api.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Long countBySaccoId(Long saccoId);
}
