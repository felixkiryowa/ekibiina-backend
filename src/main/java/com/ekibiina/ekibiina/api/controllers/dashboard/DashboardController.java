package com.ekibiina.ekibiina.api.controllers.dashboard;

import com.ekibiina.ekibiina.api.dto.DashboardResponse;
import com.ekibiina.ekibiina.api.entities.Sacco;
import com.ekibiina.ekibiina.api.repository.MemberRepository;
import com.ekibiina.ekibiina.api.repository.SaccoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final MemberRepository memberRepository;
    private final SaccoRepository saccoRepository;

    @GetMapping
    public DashboardResponse getDashboard() {
        long totalMembers = memberRepository.count();
        long totalSaccos = saccoRepository.count();
        List<Sacco> saccos = saccoRepository.findAll();

        return new DashboardResponse(totalMembers, totalSaccos, saccos);
    }
}

