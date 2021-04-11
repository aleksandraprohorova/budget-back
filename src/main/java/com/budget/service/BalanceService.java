package com.budget.service;

import com.budget.entity.Balance;
import com.budget.entity.IBalanceInfo;
import com.budget.repository.BalancesRepository;
import com.budget.repository.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class BalanceService {
    @Autowired
    BalancesRepository balancesRepository;

    @Autowired
    OperationsRepository operationsRepository;

    @Transactional
    public Balance AddBalance(LocalDateTime dateStart, LocalDateTime dateEnd) {
        String date1 = dateStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String date2 = dateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        IBalanceInfo balanceInfo = operationsRepository.getBalanceInfo(date1, date2);
        Balance balance = new Balance(balanceInfo.getDebit(), balanceInfo.getCredit(),
                balanceInfo.getAmount(), balanceInfo.getCreateDate());
        balance = balancesRepository.save(balance);
        System.out.println("Balance id " + balance.getId());

        if (balance.getAmount() <= 0) throw new RuntimeException("Cannot form balance with negative amount");

        operationsRepository.setBalanceId(date1, date2, balance.getId());

        return balance;
    }

    @Transactional
    public void deleteBalance(Long balanceId) {
        operationsRepository.removeBalanceId(balanceId);
        balancesRepository.deleteById(balanceId);
    }

}
