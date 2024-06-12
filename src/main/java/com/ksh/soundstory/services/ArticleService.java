package com.ksh.soundstory.services;

import com.ksh.soundstory.entities.ArticleEntity;
import com.ksh.soundstory.mappers.ArticleMapper;
import com.ksh.soundstory.results.CommonResult;
import com.ksh.soundstory.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ArticleService {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public Result<?> write(ArticleEntity article) {

        article.setCreatedAt(LocalDateTime.now()); // createdAt 설정
        return this.articleMapper.insertArticle(article) > 0
                ? CommonResult.SUCCESS
                : CommonResult.FAILURE;
    }

    public ArticleEntity getArticle(int index) {
        return this.articleMapper.selectArticleByIndex(index);
    }


}