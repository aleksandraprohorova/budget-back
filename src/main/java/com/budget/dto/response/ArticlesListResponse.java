package com.budget.dto.response;

import com.budget.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticlesListResponse {
    private final List<Article> articles;
}
