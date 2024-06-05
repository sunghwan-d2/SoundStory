package com.ksh.soundstory.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "index")
public class ArticleEntity {
    private int index;
    private String nickname;
    private String content;
    @Builder.Default
    private boolean liked = false;
    private LocalDateTime createdAt;
    private int songId;
    private String userEmail;

    public ArticleEntity() {
        this.liked = false;
    }
}

