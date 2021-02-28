package com.koc.finans.api.service.service;

import com.koc.finans.api.service.exception.IncomeNotFoundException;
import com.koc.finans.api.service.model.Income;
import com.koc.finans.api.service.model.repo.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    private final IncomeRepository incomeReposity;

    public IncomeService(IncomeRepository incomeReposity) {
        this.incomeReposity = incomeReposity;
    }

    /**
     * Get all income
     *
     * @return List<Income>
     */
    public List<Income> getAllIncome() {
        return this.incomeReposity.findAll();
    }

    /**
     * Get income by code
     *
     * @param code: int
     *
     * @return Income
     */
    public Income getIncomeByCode(int code) {
        return this.incomeReposity.findByCode(code).orElseThrow(IncomeNotFoundException::new);
    }
}
