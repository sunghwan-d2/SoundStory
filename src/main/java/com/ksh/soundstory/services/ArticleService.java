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

    public ArticleEntity get(int index) {

        return this.articleMapper.selectArticleByIndex(index);
    }

    public ArticleEntity[] selectArticle() {
        return this.articleMapper.selectArticleAll();
    } // 전체 댓글을 불러옴

    public CommonResult modify(ArticleEntity article) {
        ArticleEntity dbArticle = this.articleMapper.selectArticleByIndex(article.getIndex());
        if (dbArticle == null) return CommonResult.FAILURE;
        dbArticle.setNickname(article.getNickname());
        dbArticle.setContent(article.getContent());
        dbArticle.setCreatedAt(LocalDateTime.now());


        return this.articleMapper.updateArticle(dbArticle) > 0
                ? CommonResult.SUCCESS
                : CommonResult.FAILURE;

    }

//    public CommonResult modify(ArticleEntity article) {
//        ArticleEntity dbArticle = this.articleMapper.selectArticle(article.getIndex());
//        if (dbArticle == null) return CommonResult.FAILURE;
//        dbArticle.setWriter(article.getWriter());
//        dbArticle.setTitle(article.getTitle());
//        dbArticle.setContent(article.getContent());
//        dbArticle.setModifiedAt(new Date());
//        return this.articleMapper.updateArticle(dbArticle) > 0
//                ? CommonResult.SUCCESS
//                : CommonResult.FAILURE;
//    }

}