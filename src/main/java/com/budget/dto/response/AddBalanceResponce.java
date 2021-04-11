package com.budget.dto.response;

import com.budget.entity.Balance;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddBalanceResponce {
    private final Balance balance;
}
