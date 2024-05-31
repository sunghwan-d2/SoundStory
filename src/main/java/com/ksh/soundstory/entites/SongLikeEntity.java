package com.ksh.soundstory.entites;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = "likeId")
public class SongLikeEntity {
    private int likeId;
    private int likeCount;
    private int articleIndex;
}
