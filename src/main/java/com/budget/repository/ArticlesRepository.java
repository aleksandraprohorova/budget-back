package com.budget.repository;

import com.budget.entity.Article;
import com.budget.entity.IArticleFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface ArticlesRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByOrderByIdAsc();

    @Query(value = "select * from articles_flow_credit", nativeQuery = true)
    List<IArticleFlow> getArticleFlowCredit();
}
