package com.ksh.soundstory.entities;

import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
public class ArticleEntity {
    private int index;
    private String userEmail;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String nickname;
    private int artistId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleEntity that = (ArticleEntity) o;
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}