package com.rafaelnarnajo.msone.application.core.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Company {

    private Long id;
    private String name;
    private String address;
    private String email;
    private String location;

}
