package com.budget.entity;

import java.time.LocalDateTime;

public interface IBalanceInfo {
    LocalDateTime getCreateDate();
    Long getDebit();
    Long getCredit();
    Long getAmount();
}
