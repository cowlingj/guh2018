package com.example.interpreter;

import com.example.common.DeserializerConfig;
import com.example.common.SerializerConfig;
import com.example.common.data.Message;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.apache.kafka.streams.kstream.ValueMapper;
//import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.log4j.LogManager;
import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;
import java.util.Properties;

public class App {

  public static final String ACTION_CONFIG = "actions.properties";
  public static final String ALERT_CONFIG = "alerts.properties";
  public static final String UPDATE_CONFIG = "update.properties";
  public static final String KAFKA_CONFIG = "kafka.properties";
  public static final String ACTION_TOPIC_KEY = "topic.action";
  public static final String ALERT_TOPIC_KEY = "topic.alert";
  public static final String UPDATE_TOPIC_KEY = "topic.update";
  public static final String HOST_PROPERTY_KEY = "listeners";

  public static void main(String[] args) {
    try {
      Properties actionPropertiesFile = new Properties();
      actionPropertiesFile.load(ClassLoader.getSystemResourceAsStream(ACTION_CONFIG));
      Properties actionStreamProperties = new Properties();
      actionStreamProperties.put(StreamsConfig.APPLICATION_ID_CONFIG,
              App.class.getCanonicalName());
      actionStreamProperties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
              actionPropertiesFile.getProperty(HOST_PROPERTY_KEY));
      actionStreamProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              SerializerConfig.class.getCanonicalName());
      actionStreamProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
              SerializerConfig.class.getCanonicalName());
      actionStreamProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
              DeserializerConfig.class.getCanonicalName());
      actionStreamProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
              DeserializerConfig.class.getCanonicalName());

      Properties alertsPropertiesFile = new Properties();
      alertsPropertiesFile.load(ClassLoader.getSystemResourceAsStream(ALERT_CONFIG));
      Properties alertStreamProperties = new Properties();
      alertStreamProperties.put(StreamsConfig.APPLICATION_ID_CONFIG,
              App.class.getCanonicalName());
      alertStreamProperties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
              alertsPropertiesFile.getProperty(HOST_PROPERTY_KEY));
      alertStreamProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              SerializerConfig.class.getCanonicalName());
      alertStreamProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
              SerializerConfig.class.getCanonicalName());
      alertStreamProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
              DeserializerConfig.class.getCanonicalName());
      alertStreamProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
              DeserializerConfig.class.getCanonicalName());

      Properties updatePropertiesFile =  new Properties();
      updatePropertiesFile.load(ClassLoader.getSystemResourceAsStream(UPDATE_CONFIG));
      Properties updateStreamProperties = new Properties();
      updateStreamProperties.put(StreamsConfig.APPLICATION_ID_CONFIG,
              App.class.getCanonicalName());
      updateStreamProperties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
              updatePropertiesFile.getProperty(HOST_PROPERTY_KEY));
      updateStreamProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              SerializerConfig.class.getCanonicalName());
      updateStreamProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
              SerializerConfig.class.getCanonicalName());
      updatePropertiesFile.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
              DeserializerConfig.class.getCanonicalName());
      updatePropertiesFile.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
              DeserializerConfig.class.getCanonicalName());

      Serdes.serdeFrom(new SerializerConfig(), new DeserializerConfig());

      Properties kafkaProperties = new Properties();
      kafkaProperties.load(ClassLoader.getSystemResourceAsStream(KAFKA_CONFIG));

      KStream<Object, Optional<Message>> k = new StreamsBuilder()
              .stream(kafkaProperties.getProperty(ACTION_TOPIC_KEY));
       //.filter((o, serializable) -> serializable.isPresent());

    } catch (IOException e) {
      LogManager.getLogger(App.class).error(e);
      System.exit(-1);
    }
  }
}
