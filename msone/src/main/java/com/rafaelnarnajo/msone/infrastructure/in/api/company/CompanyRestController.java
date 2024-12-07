package com.rafaelnarnajo.msone.infrastructure.in.api.company;

import com.rafaelnarnajo.msone.application.core.domain.Company;
import com.rafaelnarnajo.msone.application.port.in.company.IGetAllCompanies;
import com.rafaelnarnajo.msone.application.port.out.db.CompanyStore;
import com.rafaelnarnajo.msone.application.port.out.db.dto.CompanyOutDto;
import com.rafaelnarnajo.msone.infrastructure.in.api.exceptions.InfraestructureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


@RestController
@RequestMapping("/companies")
@Slf4j
public class CompanyRestController {

    private final IGetAllCompanies getAllCompanies;

    public CompanyRestController(IGetAllCompanies getAllCompanies) {
        this.getAllCompanies = getAllCompanies;
    }

    @GetMapping("/")
    public ResponseEntity<List<Company>> getAllCompanies(@RequestParam int page, @RequestParam int size){

        try{
            List<Company> companies = getAllCompanies.handler(page,size).join();
            return ResponseEntity.ok(companies);
        }catch (Exception e) {
            throw new InfraestructureException(e.getMessage());
        }
    }

    @ExceptionHandler(InfraestructureException.class)
    public ResponseEntity<String> handleInfraestructureException(InfraestructureException e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}
