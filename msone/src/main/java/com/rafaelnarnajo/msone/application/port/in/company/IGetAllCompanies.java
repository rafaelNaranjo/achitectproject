package com.rafaelnarnajo.msone.application.port.in.company;

import com.rafaelnarnajo.msone.application.core.domain.Company;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IGetAllCompanies {

    CompletableFuture<List<Company>> handler(int page, int offset);

}
