package com.budget.dto.response;

import com.budget.entity.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddOperationResponse {
    private final Operation operation;
}
