package com.example.common;

import com.example.common.data.Message;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Optional;

public class DeserializerConfig implements Deserializer<Optional<Message>> {

    private ObjectInputStream objectsIn;
    private ByteArrayInputStream bytesIn;

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public Optional<Message> deserialize(String topic, byte[] data) {
        try {
            bytesIn = new ByteArrayInputStream(data);
            objectsIn = new ObjectInputStream(bytesIn);
            return Optional.of((Message) objectsIn.readObject());
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
