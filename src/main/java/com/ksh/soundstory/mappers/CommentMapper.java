package com.ksh.soundstory.mappers;

import com.ksh.soundstory.entities.CommentEntity;
import com.ksh.soundstory.vos.PageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {

    int insertComment(CommentEntity comment);

    int deleteCommentByIndex(@Param("index") int index);

    int getCommentCount();

    CommentEntity selectCommentByIndex(@Param("index")int index);

    CommentEntity[] selectCommentsByPage(PageVo pageVo);

    CommentEntity[] selectCommentAll();

}

