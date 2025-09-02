package com.ekibiina.ekibiina.api.dto;

import com.ekibiina.ekibiina.api.entities.Sacco;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DashboardResponse {
    private long totalMembers;
    private long totalSaccos;
    private List<Sacco> saccos;
}
