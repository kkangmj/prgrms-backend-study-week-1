package com.github.prgrms.socialserver.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeConverter {

    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }
}
