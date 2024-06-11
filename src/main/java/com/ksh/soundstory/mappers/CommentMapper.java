package com.ksh.soundstory.mappers;

import com.ksh.soundstory.entities.CommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {

    int insertComment(CommentEntity comment);

    CommentEntity[] selectCommentByArticleIndex(@Param("articleIndex") int articleIndex);

    CommentEntity selectCommentByIndex(@Param("index") int index);

    int deleteCommentByIndex(@Param("index") int index);

    int updateComment(CommentEntity comment);

}

