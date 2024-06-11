package com.ksh.soundstory.mappers;

import com.ksh.soundstory.entities.BoardEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    BoardEntity[] selectBoards();
}
