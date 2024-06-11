package com.ksh.soundstory.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class BoardEntity {
    private String code;
    private String text;
    private boolean isAdminOnly;

    public boolean isAdminOnly() {
        return isAdminOnly;
    }

    public void setAdminOnly(boolean adminOnly) {
        isAdminOnly = adminOnly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardEntity that = (BoardEntity) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}