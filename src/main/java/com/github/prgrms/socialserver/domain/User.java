package com.github.prgrms.socialserver.domain;

import java.time.LocalDateTime;

import static com.google.common.base.Preconditions.checkArgument;

public class User {
    private final long seq;
    private final Email email;
    private final Password passwd;
    private final int loginCount;
    private final LocalDateTime lastLoginAt;
    private final LocalDateTime createAt;

    public User(long seq, Email email, Password passwd, int loginCount, LocalDateTime lastLoginAt, LocalDateTime createAt) {
        checkArgument(email != null, "email is required");
        checkArgument(passwd != null, "password is required");

        this.seq = seq;
        this.email = email;
        this.passwd = passwd;
        this.loginCount = loginCount;
        this.lastLoginAt = lastLoginAt;
        this.createAt = createAt == null ? LocalDateTime.now() : createAt;
    }

    public long getSeq() {
        return seq;
    }

    public Email getEmail() {
        return email;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }
}
