package com.budget.dto.request;

import com.budget.entity.Operation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AddOperationRequest {
    @ApiParam(required = true)
    private Operation operation;
}
