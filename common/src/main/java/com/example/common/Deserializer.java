package com.example.common;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Optional;

public class Deserializer implements org.apache.kafka.common.serialization.Deserializer {

    private ObjectInputStream objectsIn;
    private ByteArrayInputStream bytesIn;

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        try {
            bytesIn = new ByteArrayInputStream(data);
            objectsIn = new ObjectInputStream(bytesIn);
            return Optional.of(objectsIn.readObject());
        } catch (ClassNotFoundException | IOException e) {
            return Optional.empty();
        }
    }

    @Override
    public void close() {
        try {
            bytesIn.close();
            objectsIn.close();
        } catch (IOException ignore) {}
    }
}
