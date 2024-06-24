package com.ksh.soundstory.mappers;

import com.ksh.soundstory.entities.CommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {

    int insertComment(CommentEntity comment);

    int deleteCommentByIndex(@Param("index") int index);

    CommentEntity selectCommentByIndex(@Param("index")int index);

    CommentEntity[] selectCommentAll();

}

