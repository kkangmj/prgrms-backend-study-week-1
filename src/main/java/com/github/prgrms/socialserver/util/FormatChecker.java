package com.github.prgrms.socialserver.util;

import java.util.regex.Pattern;

public enum FormatChecker {
    EMAIL("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"),
    PASSWORD("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$");

    private final Pattern pattern;

    FormatChecker(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean isValid(String target) {
        return pattern.matcher(target).matches();
    }
}
