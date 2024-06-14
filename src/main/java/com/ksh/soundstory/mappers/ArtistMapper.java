package com.ksh.soundstory.mappers;

import com.ksh.soundstory.entities.ArtistEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArtistMapper {
    ArtistEntity selectArtistByIndex(@Param("artistId") int artistId);

}
