package com.github.marlonflorencio.protobuf;

import com.github.marlonflorencio.protobuf.proto.SimpleMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import java.util.Arrays;

import static com.github.marlonflorencio.protobuf.proto.SimpleMessage.newBuilder;


public class ProtoToJSONMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        SimpleMessage.Builder builder = newBuilder()
                .setId(42)
                .setIsSimple(true)
                .setName("My Simple Message Name")
                .addAllSampleList(Arrays.asList(4, 5, 6));

        // Print this as a JSON
        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        // parse JSON into Protobuf
        SimpleMessage.Builder builder2 = newBuilder();

        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder2);

        System.out.println(builder2);
    }
}
