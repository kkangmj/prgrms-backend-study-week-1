package com.github.prgrms.socialserver.controller;

import com.github.prgrms.socialserver.domain.Email;
import com.github.prgrms.socialserver.domain.User;

import java.time.LocalDateTime;

public class UserDto {

    private Long seq;

    private Email email;

    private int loginCount;

    private LocalDateTime lastLoginAt;

    private LocalDateTime createAt;

    public UserDto(User user) {
        this.seq = user.getSeq();
        this.email = user.getEmail();
        this.loginCount = user.getLoginCount();
        this.lastLoginAt = user.getLastLoginAt();
        this.createAt = user.getCreateAt();
    }

    public Long getSeq() {
        return seq;
    }

    public Email getEmail() {
        return email;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }
}
