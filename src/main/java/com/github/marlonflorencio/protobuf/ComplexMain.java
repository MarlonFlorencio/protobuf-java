package com.github.marlonflorencio.protobuf;


import com.github.marlonflorencio.protobuf.proto.ComplexMessage;
import com.github.marlonflorencio.protobuf.proto.SimpleMessage;

import java.util.Arrays;

public class ComplexMain {

    public static void main(String[] args) {

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        // singular message field
        builder.setOneDummy(newMessage(55, "one dummy message"));

        builder.addAllMultipleDummy(Arrays.asList(
                newMessage(69, "other dummy"),
                newMessage(70, "other other dummy")
        ));

        ComplexMessage message = builder.build();

        System.out.println(message);
    }

    public static SimpleMessage newMessage(Integer id, String name) {
        return SimpleMessage.newBuilder()
                .setName(name)
                .setId(id)
                .build();
    }

}
