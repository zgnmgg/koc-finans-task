package com.koc.finans.api.service.controller;

import com.koc.finans.api.service.model.Income;
import com.koc.finans.api.service.service.IncomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    /**
     * Handle income request. Returns all city incomes
     *
     * @return List<Income>
     *
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<Income>> getAllIncome() {
        List<Income> incomes = this.incomeService.getAllIncome();

        return ResponseEntity.ok().body(incomes);
    }
}
