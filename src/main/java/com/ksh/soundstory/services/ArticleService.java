package com.ksh.soundstory.services;


import com.ksh.soundstory.entities.ArticleEntity;
import com.ksh.soundstory.mappers.ArticleMapper;
import com.ksh.soundstory.results.CommonResult;
import com.ksh.soundstory.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleService {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public ArticleEntity getArticle(int index) {
        ArticleEntity article = this.articleMapper.selectArticleByIndex(index);
        this.articleMapper.updateArticle(article);
        return article;
    }

    public Result<?> write(ArticleEntity article) {
        article.setCreatedAt(LocalDateTime.now());
        return this.articleMapper.insertArticle(article) > 0
                ? CommonResult.SUCCESS
                : CommonResult.FAILURE;
    }
}

