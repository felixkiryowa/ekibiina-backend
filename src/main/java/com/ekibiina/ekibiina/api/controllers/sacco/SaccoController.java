package com.ekibiina.ekibiina.api.controllers.sacco;

import com.ekibiina.ekibiina.api.entities.Sacco;
import com.ekibiina.ekibiina.api.service.SaccoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sacco")
public class SaccoController {
    @Autowired
    private SaccoService saccoService;


    @PostMapping("/create")
    public Sacco createSacco(@RequestBody Sacco sacco) {
        return saccoService.createSacco(sacco);
    }

    @GetMapping("/list")
    public List<Sacco> getAllSaccos() {
        return saccoService.getAllSaccos();
    }

    // Get a single Sacco by ID
    @GetMapping("/{id}")
    public Sacco getSaccoById(@PathVariable  Long id) {
        return saccoService.getSaccoById(id);
    }

    @PutMapping("/update/{id}")
    //Update Sacco
    public Sacco updateSacco(@PathVariable  Long id, @RequestBody  Sacco sacco) {
        return saccoService.updateSacco(id, sacco);
    }
}
