package com.github.marlonflorencio.protobuf;

import com.github.marlonflorencio.protobuf.proto.MyDateTime;
import com.google.protobuf.Duration;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeMain {

    private static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");

    public static void main(String[] args) throws InvalidProtocolBufferException {

        ZonedDateTime zonedDateTime = ZonedDateTime.of(1950, 3, 20, 17, 20, 15, 1, ZONE_ID);

        Instant instant = zonedDateTime.toInstant();

        Timestamp timestamp = Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();

        java.time.Duration javaDuration = java.time.Duration.ofMillis(7234);
        Duration duration = Duration.newBuilder()
                .setSeconds(javaDuration.getSeconds())
                .setNanos(javaDuration.getNano())
                .build();

        MyDateTime myDateTime = MyDateTime.newBuilder()
                .setMyDate(timestamp)
                .setMyDuration(duration)
                .build();

        byte[] bytes = myDateTime.toByteArray();
        MyDateTime result = MyDateTime.parseFrom(bytes);

        System.out.println(result);
        System.out.println(toZonedDateTime(result.getMyDate()));
    }

    private static ZonedDateTime toZonedDateTime(Timestamp timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
        return ZonedDateTime.ofInstant(instant, ZONE_ID);
    }

}
