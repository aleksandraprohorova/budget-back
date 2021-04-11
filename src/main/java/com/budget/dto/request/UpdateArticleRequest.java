package com.budget.dto.request;

import com.budget.entity.Article;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UpdateArticleRequest {
    @ApiParam(required = true)
    private Article article;
}
