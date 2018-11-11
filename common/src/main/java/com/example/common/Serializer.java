package com.example.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class Serializer implements org.apache.kafka.common.serialization.Serializer {

    private ObjectOutputStream objectOut;
    private ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public byte[] serialize(String topic, Object o) {
        try {
            objectOut = new ObjectOutputStream(this.bytesOut);
            objectOut.writeObject(o);
            return bytesOut.toByteArray();
        } catch (IOException e) {
            return new byte[0];
        }
    }

    @Override
    public void close() {
        try {
            objectOut.close();
            bytesOut.close();
        } catch (IOException ignore) {}
    }
}
