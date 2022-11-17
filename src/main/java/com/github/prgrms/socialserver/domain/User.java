package com.github.prgrms.socialserver.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.github.prgrms.socialserver.util.LocalDateTimeUtil.simplify;
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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;
        return seq == user.seq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq);
    }

    @Override
    public String toString() {
        return String.format("{seq: %s, email: %s, loginCount: %s, lastLoginAt: %s, createAt: %s}",
            seq, email, loginCount, simplify(lastLoginAt), simplify(createAt));
    }
}
