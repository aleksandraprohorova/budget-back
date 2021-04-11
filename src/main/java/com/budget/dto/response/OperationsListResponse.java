package com.budget.dto.response;

import com.budget.entity.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OperationsListResponse {
    private final List<Operation> operations;
}
