package com.example.brainiv;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerCreator {

  public static Producer<Long, String> createProducer() {

    Properties props = new Properties();

    // The Kafka broker's address
    // If Kafka is running on a cluster we can comma separate addresses
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
              InterfaceKafkaConstants.KAFKA_BROKERS);

    // ID of the Producer so the broker can determine the request source
    props.put(ProducerConfig.CLIENT_ID_CONFIG,
              InterfaceKafkaConstants.CLIENT_ID);

    // Serialises the key object
    // The example key is a 'long', so we can use the LongSerializer
    // IF we want to use some other object as the key,
    // create our own serializer (check example)
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
              LongSerializer.class.getName());

    // Serialises the value object
    // The example value is 'String', so we use the StringSerializer
    // We can can create a custom serializer here too
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              StringSerializer.class.getName());

    // Determines the partition in which the record will go 
    // The demo topic has only one partition, so its commented out
    //props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, 
    //          CustomPartitioner.class.getName());

    return new KafkaProducer<>(props);

  }

}
