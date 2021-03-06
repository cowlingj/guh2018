package com.example.common;

import com.example.common.data.Message;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Optional;

public class SerializerConfig implements Serializer<Optional<Message>> {

    private ObjectOutputStream objectOut;
    private ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public byte[] serialize(String topic, Optional<Message> m) {
        try {
            objectOut = new ObjectOutputStream(this.bytesOut);
            objectOut.writeObject(m);
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
