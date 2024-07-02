package com.ksh.soundstory.mappers;

import com.ksh.soundstory.entities.AlbumEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AlbumMapper {
    AlbumEntity selectAlbumByIndex(@Param("albumId") int albumId);
}
