package com.rafaelnarnajo.msone.application.port.out.db;

import com.rafaelnarnajo.msone.application.port.out.db.dto.CompanyOutDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CompanyStore {

    CompletableFuture<List<CompanyOutDto>> getAllCompany(int page, int offset);

}
