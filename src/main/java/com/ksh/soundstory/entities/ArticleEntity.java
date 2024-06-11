package com.ksh.soundstory.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(of = "index")
public class ArticleEntity {
    private int index;
    private String nickname;
    private String content;
    private LocalDateTime createdAt;
    private String userEmail;


}

