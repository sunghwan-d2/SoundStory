package com.ksh.soundstory.entites;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = "albumId")
public class AlbumEntity {
    private int albumId;
    private int artistId;
    private String title;
}
