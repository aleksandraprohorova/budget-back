package com.budget.controller;

import com.budget.dto.request.AddBalanceRequest;
import com.budget.dto.response.AddBalanceResponce;
import com.budget.dto.response.BalanceListResponse;
import com.budget.dto.response.OperationsListResponse;
import com.budget.repository.BalancesRepository;
import com.budget.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balances")
@CrossOrigin
public class BalancesController {
    @Autowired
    BalancesRepository balancesRepository;

    @Autowired
    BalanceService balanceService;

    @GetMapping
    BalanceListResponse getBalances()
    {
        return new BalanceListResponse(balancesRepository.findAllByOrderByIdDesc());
        //return new BalanceListResponse(balancesRepository.findAllByOrderByCreate_dateDesc());
    }

    @PostMapping
    AddBalanceResponce addBalance(@RequestBody AddBalanceRequest request) {
        return new AddBalanceResponce(balanceService.AddBalance(request.getDateStart(), request.getDateEnd()));
    }

    @DeleteMapping
    void deleteBalance(@RequestParam("id") Long id) {
        balanceService.deleteBalance(id);
    }
}
