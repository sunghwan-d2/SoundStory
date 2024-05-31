package com.ksh.soundstory.entites;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = "genreId")
public class GenreEntity {
    private int genreId;
    private String name;
}
