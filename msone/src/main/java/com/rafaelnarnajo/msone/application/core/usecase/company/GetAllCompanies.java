package com.rafaelnarnajo.msone.application.core.usecase.company;

import com.rafaelnarnajo.msone.application.core.domain.Company;
import com.rafaelnarnajo.msone.application.core.service.company.ICompanyService;
import com.rafaelnarnajo.msone.application.port.in.company.IGetAllCompanies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Component
public class GetAllCompanies implements IGetAllCompanies {

    private final ICompanyService companyService;

    public GetAllCompanies(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public CompletableFuture<List<Company>> handler(int page, int offset) {
        return companyService.getAllCompany(page, offset);
    }
}
