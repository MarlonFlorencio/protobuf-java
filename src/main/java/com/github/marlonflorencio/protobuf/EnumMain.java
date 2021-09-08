package com.github.marlonflorencio.protobuf;

import marlonflorencio.proto.EnumExample;
import marlonflorencio.proto.EnumExample.EnumMessage;

public class EnumMain {

    public static void main(String[] args) {

        EnumMessage message = EnumMessage.newBuilder()
                .setId(345)
                .setDayOfTheWeek(EnumExample.DayOfTheWeek.FRIDAY)
                .build();

        System.out.println(message);
    }
}
