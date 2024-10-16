package com.rafaelnarnajo.msone.infrastructure.out.db.converter;

import com.rafaelnarnajo.msone.application.port.out.db.dto.CompanyOutDto;
import com.rafaelnarnajo.msone.infrastructure.out.db.entity.CompanyEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyOutConverter {

    public List<CompanyOutDto> converterListEntityToDtoList(List<CompanyEntity> entityList) {
        return entityList.stream().map(this::converterEntityToDto).toList();
    }

    public CompanyOutDto converterEntityToDto(CompanyEntity entity) {
        return CompanyOutDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getAddress())
                .address(entity.getAddress())
                .location(entity.getLocation())
                .build();
    }
}
