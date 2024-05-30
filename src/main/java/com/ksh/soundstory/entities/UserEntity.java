package com.ksh.soundstory.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = "email")
public class UserEntity {
    private String email;
    private String password;
    private String nickname;
}

