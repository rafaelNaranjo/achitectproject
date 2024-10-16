package com.rafaelnarnajo.msone.infrastructure.out.db.repository;

import com.rafaelnarnajo.msone.infrastructure.out.db.entity.CompanyEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompanyJpaRepository extends PagingAndSortingRepository<CompanyEntity, Long> {
}
