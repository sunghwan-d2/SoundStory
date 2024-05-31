package com.ksh.soundstory.entites;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = "artistId")
public class ArtistEntity {
    private int artistId;
    private String name;
}
