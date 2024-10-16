package com.rafaelnarnajo.msone.application.port.out.db.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CompanyOutDto {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String location;
}
