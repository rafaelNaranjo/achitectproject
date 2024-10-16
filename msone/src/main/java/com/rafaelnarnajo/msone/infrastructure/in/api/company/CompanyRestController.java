package com.rafaelnarnajo.msone.infrastructure.in.api.company;

import com.rafaelnarnajo.msone.application.port.out.db.CompanyStore;
import com.rafaelnarnajo.msone.application.port.out.db.dto.CompanyOutDto;
import com.rafaelnarnajo.msone.infrastructure.in.api.dto.InfraestructureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyRestController {

    private final CompanyStore companyStore;

    public CompanyRestController(CompanyStore companyStore) {
        this.companyStore = companyStore;
    }

    @GetMapping("/")
    public ResponseEntity<List<CompanyOutDto>> getAllCompanies(@RequestParam int page, @RequestParam int size) {
        try{
            return ResponseEntity.ok(companyStore.getAllCompany(page,size).join());
        }catch (Exception e) {
            throw new InfraestructureException(e.getMessage());
        }
    }

    @ExceptionHandler(InfraestructureException.class)
    public ResponseEntity<String> handleInfraestructureException(InfraestructureException e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}
