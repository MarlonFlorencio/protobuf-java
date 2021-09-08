package com.github.marlonflorencio.protobuf;

import com.github.marlonflorencio.protobuf.proto.DecimalValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.StringValue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class BigDecimalExample {

    public static void main(String[] args) {

        final String value = "3.14159265358";
        final BigDecimal bigDecimal = new BigDecimal(value);

        final DecimalValue serialized = DecimalValue.newBuilder()
                .setScale(bigDecimal.scale())
                .setPrecision(bigDecimal.precision())
                .setValue(ByteString.copyFrom(bigDecimal.unscaledValue().toByteArray()))
                .build();

        final MathContext mc = new MathContext(serialized.getPrecision());
        final BigDecimal deserialized = new BigDecimal(
                new BigInteger(serialized.getValue().toByteArray()),
                serialized.getScale(),
                mc
        );

        System.out.println("DecimalValue: \n" + serialized);
        System.out.println("Same value: " + deserialized.equals(bigDecimal));
        System.out.println("DecimalValue size: " + serialized.getSerializedSize());
        System.out.println("String size: " + StringValue.of(value).getSerializedSize());

    }

}
