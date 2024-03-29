package com.koc.finans.api.service.model.repo;

import com.koc.finans.api.service.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer>, JpaSpecificationExecutor<Income> {

    List<Income> findAll();

    Optional<Income> findByCode(int code);
}
