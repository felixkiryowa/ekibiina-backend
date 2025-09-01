package com.ekibiina.ekibiina.api.service;

import com.ekibiina.ekibiina.api.entities.Sacco;
import com.ekibiina.ekibiina.api.repository.SaccoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaccoService {

    @Autowired
    SaccoRepository saccoRepository;

    public List<Sacco> getAllSaccos() {
        return saccoRepository.findAll();
    }


    public Sacco createSacco(Sacco sacco) {
        return saccoRepository.save(sacco);
    }

    public Sacco getSaccoById(Long id) {
        return saccoRepository.findById(id).orElse(null);
    }

    public void deleteSacco(Long id) {
        saccoRepository.deleteById(id);
    }

    // update sacco
    public Sacco updateSacco(Long id, Sacco sacco) {
        Sacco existingSacco = saccoRepository.findById(id).orElse(null);
        if (existingSacco != null) {
            existingSacco.setName(sacco.getName());
            existingSacco.setRegistrationNumber(sacco.getRegistrationNumber());
            existingSacco.setAddress(sacco.getAddress());
            existingSacco.setContactNumber(sacco.getContactNumber());
            existingSacco.setEmail(sacco.getEmail());
            existingSacco.setWebsite(sacco.getWebsite());
            existingSacco.setAddress(sacco.getAddress());
            return saccoRepository.save(existingSacco);
        }
        throw new RuntimeException("Sacco not found with id " + id);
    }
}
