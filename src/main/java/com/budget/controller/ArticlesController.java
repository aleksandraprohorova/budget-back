package com.budget.controller;

import com.budget.dto.request.AddArticleRequest;
import com.budget.dto.request.UpdateArticleRequest;
import com.budget.dto.response.AddArticleResponse;
import com.budget.dto.response.ArticlesFlowResponse;
import com.budget.dto.response.ArticlesListResponse;
import com.budget.entity.Article;
import com.budget.entity.IArticleFlow;
import com.budget.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/articles")
public class ArticlesController {
    @Autowired
    ArticlesRepository articlesRepository;

    @GetMapping
    ArticlesListResponse getArticles()
    {
        return new ArticlesListResponse(articlesRepository.findAllByOrderByIdAsc());
    }

    @GetMapping("flow")
    ArticlesFlowResponse getArticleFlow(/*@RequestParam("flow") String flow*/) {
        List<IArticleFlow> tmp = articlesRepository.getArticleFlowCredit();
        return new ArticlesFlowResponse(tmp);
        /*List<Article> res = new ArrayList<>();
        for (IArticleFlow item: tmp) {
            res.add(new Article(item.getName()));
        }
        return res;*/
    }

    @PostMapping
    AddArticleResponse addArticle(@RequestBody AddArticleRequest request)
    {
        return new AddArticleResponse(articlesRepository.save(new Article(request.getName())));
    }

    @PutMapping
    void updateArticle(@RequestBody UpdateArticleRequest request)
    {
        System.out.println(request.getArticle().getId() + ", " + request.getArticle().getName());
        articlesRepository.save(request.getArticle());
    }
    @DeleteMapping
    void deleteArticle(@RequestParam ("id") long id)
    {
        System.out.println("delete article " + id);
        articlesRepository.deleteById(id);
    }
}
