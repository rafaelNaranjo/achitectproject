package com.rafaelnarnajo.msone.application.core.service.company.impl;

import com.rafaelnarnajo.msone.application.core.converter.CompanyDomainConverter;
import com.rafaelnarnajo.msone.application.core.domain.Company;
import com.rafaelnarnajo.msone.application.core.service.company.ICompanyService;
import com.rafaelnarnajo.msone.application.port.out.db.CompanyStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyStore companyStore;
    private final CompanyDomainConverter companyDomainConverter;

    public CompanyServiceImpl(CompanyStore companyStore, CompanyDomainConverter companyDomainConverter) {
        this.companyStore = companyStore;
        this.companyDomainConverter = companyDomainConverter;
    }

    @Override
    public CompletableFuture<List<Company>> getAllCompany(int page, int offset) {
        return companyStore.getAllCompany(page, offset)
                .thenApply(companyDomainConverter::converterOutListCompanyToDomainListCompany);
    }
}
