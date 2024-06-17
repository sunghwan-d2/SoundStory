package com.ksh.soundstory.services;

import com.ksh.soundstory.entities.ArtistEntity;
import com.ksh.soundstory.mappers.ArtistMapper;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private final ArtistMapper artistMapper;

    public ArtistService(ArtistMapper artistMapper) {
        this.artistMapper = artistMapper;
    }
    public ArtistEntity getArtist(int artistId){
        return this.artistMapper.selectArtistByIndex(artistId);
    }


}
