package com.rafaelnarnajo.msone.infrastructure.out.db.adapter;

import com.rafaelnarnajo.msone.application.port.out.db.CompanyStore;
import com.rafaelnarnajo.msone.application.port.out.db.dto.CompanyOutDto;
import com.rafaelnarnajo.msone.infrastructure.in.api.dto.InfraestructureException;
import com.rafaelnarnajo.msone.infrastructure.out.db.converter.CompanyOutConverter;
import com.rafaelnarnajo.msone.infrastructure.out.db.repository.CompanyJpaRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class CompanyRepositoryImpl implements CompanyStore {

    private final CompanyJpaRepository companyJpaRepository;
    private final CompanyOutConverter companyOutConverter;

    public CompanyRepositoryImpl(CompanyJpaRepository companyJpaRepository, CompanyOutConverter companyOutConverter) {
        this.companyJpaRepository = companyJpaRepository;
        this.companyOutConverter = companyOutConverter;
    }

    @Override
    public CompletableFuture<List<CompanyOutDto>> getAllCompany(int page, int size) {
        return CompletableFuture.supplyAsync(()-> companyJpaRepository
                .findAll(PageRequest.of(page, size)).getContent())
                .thenApply(companyOutConverter::converterListEntityToDtoList);
    }
}
