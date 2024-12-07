package com.rafaelnarnajo.msone.application.core.converter;

import com.rafaelnarnajo.msone.application.core.domain.Company;
import com.rafaelnarnajo.msone.application.port.out.db.dto.CompanyOutDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyDomainConverter {

    public List<Company> converterOutListCompanyToDomainListCompany(final List<CompanyOutDto> list) {
        return list.stream().map(companyOut -> Company.builder()
                .id(companyOut.getId())
                .name(companyOut.getName())
                .email(companyOut.getEmail())
                .address(companyOut.getAddress())
                .location(companyOut.getLocation())
                .build()).toList();
    }

}
