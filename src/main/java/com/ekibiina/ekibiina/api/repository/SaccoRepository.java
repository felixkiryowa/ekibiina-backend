package com.ekibiina.ekibiina.api.repository;

import com.ekibiina.ekibiina.api.entities.Sacco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SaccoRepository extends CrudRepository<Sacco, Long> {
    List<Sacco> findAll();

}
