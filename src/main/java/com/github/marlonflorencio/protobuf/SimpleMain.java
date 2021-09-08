package com.github.marlonflorencio.protobuf;


import com.github.marlonflorencio.protobuf.proto.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {

        SimpleMessage message = SimpleMessage.newBuilder()
                .setId(42)
                .setIsSimple(true)
                .setName("My Simple Message Name")
                .addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6))
                .build();

        try {
            //Writing the protocol buffers binary to a file
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();

            //Reading from file
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(fileInputStream);
            System.out.println(messageFromFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // send as byte array
            byte[] bytes = message.toByteArray();
            SimpleMessage parsedMessage = SimpleMessage.parseFrom(bytes);
            System.out.println(parsedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
