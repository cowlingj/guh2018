package com.example.interpreter;

import com.example.common.Deserializer;
import com.example.common.Serializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.log4j.LogManager;
import java.io.IOException;
import java.util.Properties;

public class App {

  public static final String ACTION_CONFIG = "actions.properties";
  public static final String ALERT_CONFIG = "alerts.properties";
  public static final String UPDATE_CONFIG = "update.properties";

  public static void main(String[] args) {
    try {
      Properties actionPropertiesFile = new Properties();
      actionPropertiesFile.load(ClassLoader.getSystemResourceAsStream(ACTION_CONFIG));
      Properties actionStreamProperties = new Properties();
      actionStreamProperties.put(StreamsConfig.APPLICATION_ID_CONFIG,
              App.class.getCanonicalName());
      actionStreamProperties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
              actionPropertiesFile.getProperty("listeners"));
      actionStreamProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              Serializer.class.getCanonicalName());
      actionStreamProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
              Serializer.class.getCanonicalName());
      actionStreamProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
              Deserializer.class.getCanonicalName());
      actionStreamProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
              Deserializer.class.getCanonicalName());


      Properties alertProperties = new Properties();
      alertProperties.load(ClassLoader.getSystemResourceAsStream(ALERT_CONFIG));

      Properties updatePropertiesFile =  new Properties();
      updatePropertiesFile.load(ClassLoader.getSystemResourceAsStream(UPDATE_CONFIG));

      new StreamsBuilder().stream("").to("");
    } catch (IOException e) {
      LogManager.getLogger(App.class).error(e);
      System.exit(-1);
    }
  }
}
