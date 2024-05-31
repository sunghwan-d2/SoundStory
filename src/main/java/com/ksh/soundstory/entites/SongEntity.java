package com.ksh.soundstory.entites;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Builder
@EqualsAndHashCode(of = "songId")
public class SongEntity {
    private int songId;
    private String title;
    private int artistId;
    private int albumId;
    private LocalDateTime singTime;
    private int genreId;
}
