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
        // nickname이 null인지 확인
        if (article.getNickname() == null) {
            // 예외 발생
            throw new IllegalArgumentException("닉네임을 작성하세요");
        }

        // createdAt 설정
        article.setCreatedAt(LocalDateTime.now());

        // article 삽입 시도 및 결과 반환
        return this.articleMapper.insertArticle(article) > 0
                ? CommonResult.SUCCESS
                : CommonResult.FAILURE;
    }
}