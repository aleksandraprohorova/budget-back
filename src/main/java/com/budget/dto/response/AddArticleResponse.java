package com.budget.dto.response;

import com.budget.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddArticleResponse {
    private final Article article;
}
