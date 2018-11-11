package com.example.interpreter;

import com.example.common.data.Message;
import com.example.common.data.MessageType;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

public class MessageFactory  {

        private static Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        static final Logger log = LoggerFactory.getLogger(MessageFactory.class);
        private static Charset characterSet = Charset.forName("US-ASCII");

        private static byte[] stringTobyteArr(String msg){
            return msg.getBytes(characterSet);
        }

        private static String byteArrToString(byte[] arr){
            return new String(arr, characterSet);
        }

        public static byte[] emptyMessage(MessageType commandType){
            byte[] msg = stringTobyteArr("");
            return addToFront(commandType,msg);
        }

        public static byte[] createMessage(MessageType commandType, String message){
            byte[] msg = stringTobyteArr(message);
            return addToFront(commandType,msg);
        }

        private static byte[] addToFront(MessageType commandType, byte[] payload){
            byte[] msg = new byte[payload.length + 2];
            msg[0] = (byte)commandType.code;
            msg[1] = (byte)payload.length;
            System.arraycopy(payload, 0, msg, 2, payload.length);
            log.debug(String.format("Message created of command type: %s", commandType));
            return msg;
        }

        public static Message decodeMessage(byte[] message) throws IOException {
            int code = (int)message[0];
            int payloadLength = Byte.toUnsignedInt(message[1]);
            byte[] payload = new byte[payloadLength];
            System.arraycopy(message, 2, payload, 0, payloadLength);
            String decodedMsg = byteArrToString(payload);

            log.debug(String.format("Received message of [%d]: %s", code, decodedMsg));

            return gson.fromJson(decodedMsg, Message.class);

        }

        public static byte[] createTankMessage(String tankName)
        {
            String json = gson.toJson(Message.createTank(tankName));;
            log.debug("JSON String: " + json);

            byte[] clientMessageAsByteArray = stringTobyteArr(json);
            return addToFront(MessageType.CREATE_TANK, clientMessageAsByteArray);
        }

        public static byte[] createMovementMessage(MessageType type, float amount)
        {

            String json = gson.toJson(Message.withAmount(amount, type));
            log.debug("JSON String: " + json);
            byte[] clientMessageAsByteArray = stringTobyteArr(json);
            return addToFront(type, clientMessageAsByteArray);
        }
}
