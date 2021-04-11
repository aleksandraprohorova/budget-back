package com.budget.dto.response;

import com.budget.entity.IArticleFlow;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticlesFlowResponse {
    private final List<IArticleFlow> items;
}
