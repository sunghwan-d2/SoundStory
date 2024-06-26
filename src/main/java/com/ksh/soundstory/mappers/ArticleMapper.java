package com.ksh.soundstory.mappers;

import com.ksh.soundstory.entities.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    int deleteArticle(@Param("index")int index);

    int updateArticle(ArticleEntity article);

    int insertArticle(ArticleEntity article);

    ArticleEntity selectArticleByIndex(@Param("index") int index);

    ArticleEntity[] selectArticleAll();

}
