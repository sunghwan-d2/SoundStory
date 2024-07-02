package com.ksh.soundstory.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(of = "albumId")
public class AlbumEntity {
    private int albumId;
    private int artistId;
    private int songId;
    private byte[] imageData;
    private int imageContentType;
    private String imageFileName;
    private String title;
}
