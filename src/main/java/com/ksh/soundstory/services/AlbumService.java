package com.ksh.soundstory.services;

import com.ksh.soundstory.entities.AlbumEntity;
import com.ksh.soundstory.entities.CommentEntity;
import com.ksh.soundstory.mappers.AlbumMapper;
import com.ksh.soundstory.mappers.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    private final AlbumMapper albumMapper;

    @Autowired
    public AlbumService(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }


    public AlbumEntity get(int albumId) {
        return this.albumMapper.selectAlbumByIndex(albumId);
    }
}
