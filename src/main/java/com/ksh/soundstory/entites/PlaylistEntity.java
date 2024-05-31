package com.ksh.soundstory.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "playlistId")
public class PlaylistEntity {
    private int playlistId;
    private String email;
    @Builder.Default
    private boolean isAppend = false;
    @Builder.Default
    private boolean isDeleted = false;

    public PlaylistEntity() {
        this.isAppend = false;
        this.isDeleted = false;
    }
}
