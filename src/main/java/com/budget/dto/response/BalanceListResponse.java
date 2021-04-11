package com.budget.dto.response;

import com.budget.entity.Balance;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class BalanceListResponse {
    private final List<Balance> balances;
}
