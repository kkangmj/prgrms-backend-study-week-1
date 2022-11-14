package com.github.prgrms.socialserver.domain;

import static com.github.prgrms.socialserver.error.ErrorMessage.INVALID_FORMAT;
import static com.github.prgrms.socialserver.util.FormatChecker.PASSWORD;
import static com.google.common.base.Preconditions.checkArgument;

public class Password {
    private final String passwd;

    public Password(String passwd) {
        checkArgument(isValidFormat(passwd), INVALID_FORMAT.getMessage("password"));

        this.passwd = passwd;
    }

    private boolean isValidFormat(String passwd) {
        return PASSWORD.isValid(passwd);
    }

    public String getPasswd() {
        return passwd;
    }
}
