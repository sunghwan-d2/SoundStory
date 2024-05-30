package com.ksh.soundstory.entities;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = "genreId")
public class GenreEntity {
    private int genreId;
    private String name;
}
