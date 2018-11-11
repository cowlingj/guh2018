import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.gaurav.kafka.constants.InterfaceKafkaConstants;

public class ConsumerCreator 
{
  public static Consumer<Long, String> createConsumer() 
  {
    Properties props = new Properties();

    // The Kafka broker's address
    // If Kafka is running on a cluster we can comma separate addresses
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
              InterfaceKafkaConstants.KAFKA_BROKERS);

    // ID of the Producer so the broker can determine the request source
    props.put(ConsumerConfig.GROUP_ID_CONFIG, 
              InterfaceKafkaConstants.GROUP_ID_CONFIG);

    // Serialises the key object
    // The example key is a 'long', so we can use the LongSerializer
    // IF we want to use some other object as the key,
    // create our own serializer (check example)
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
              LongDeserializer.class.getName());

    // Serialises the value object
    // The example value is 'String', so we use the StringSerializer
    // We can can create a custom serializer here too
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
              StringDeserializer.class.getName());

    // The max count of records that the consumer will fetch
    // in one iteration
    props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 
              InterfaceKafkaConstants.MAX_POLL_RECORDS);

    // When the consumer from a group receives a message
    // it must commit the offset of that record
    //    If true: offsets will be commited periodically
    //    false: offsets are commited manually
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

    // For each consumer group, the last commited offset is stored
    //    If earliest: consumer will fetch records from beginning of
    //                 offset, i.e. from 0
    //    If latest:   consumer will fetch records from new records.
    //                 By new records mean those created after the
    //                 consumer group became active
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, 
              InterfaceKafkaConstants.OFFSET_RESET_EARLIER);

    Consumer<Long, String> consumer = new KafkaConsumer<>(props);

    consumer.subscribe(Collections.singletonList(
                         InterfaceKafkaConstants.TOPIC_NAME)
                      );

    return consumer;

  }

}
