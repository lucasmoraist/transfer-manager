package com.lucasmoraist.transfer_manager.application.utils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public final class TraceId {

    private TraceId() {}

    public static UUID fromDateAndUuid(LocalDate date, String otherUuid) {
        Objects.requireNonNull(date, "date must not be null");
        Objects.requireNonNull(otherUuid, "otherUuid must not be null");
        String seed = date + ":" + otherUuid;
        return UUID.nameUUIDFromBytes(seed.getBytes(StandardCharsets.UTF_8));
    }

    public static UUID fromTodayAndUuid(String otherUuid) {
        return fromDateAndUuid(LocalDate.now(), otherUuid);
    }

}
