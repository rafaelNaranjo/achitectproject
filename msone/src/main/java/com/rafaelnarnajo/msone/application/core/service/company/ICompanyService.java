package com.rafaelnarnajo.msone.application.core.service.company;

import com.rafaelnarnajo.msone.application.core.domain.Company;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ICompanyService {

    CompletableFuture<List<Company>> getAllCompany(int page, int offset);

}
