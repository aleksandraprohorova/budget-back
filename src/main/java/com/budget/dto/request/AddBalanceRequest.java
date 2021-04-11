package com.budget.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class AddBalanceRequest {
    @ApiParam(required = true)
    private LocalDateTime dateStart;

    @ApiParam(required = true)
    private LocalDateTime dateEnd;
}
