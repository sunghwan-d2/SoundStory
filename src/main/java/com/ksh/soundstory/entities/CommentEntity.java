package com.ksh.soundstory.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode(of = "index")
public class CommentEntity {
    private int index;
    private String nickname;
    private String userEmail;
    private String content;
    private LocalDateTime createdAt;
}
