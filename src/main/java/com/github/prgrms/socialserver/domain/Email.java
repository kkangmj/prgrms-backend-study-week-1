package com.github.prgrms.socialserver.domain;

import static com.github.prgrms.socialserver.error.ErrorMessage.INVALID_FORMAT;
import static com.github.prgrms.socialserver.util.RegexCheckUtil.EMAIL;
import static com.google.common.base.Preconditions.checkArgument;

public class Email {
    private final String address;

    public Email(String address) {
        checkArgument(isValidFormat(address), INVALID_FORMAT.getMessage("email"));

        this.address = address;
    }

    private boolean isValidFormat(String address) {
        return EMAIL.isValid(address);
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("{address: %s}", address);
    }
}
