// Packages that help set up the stream
import java.utils.Properties;
import org.apache.kafka.common.serialization.Serdes;

// Packages that help build a KStream
import org.apache.kafka.streams.Streamsbuilder;
import org.apache.kafka.streams.kstreams.KStream;

// Packages to build the KafkaStreams 
import org.apache.kafka.streams.Topology;
import org.apache.kafka.stream.KafkaStreams;

public class Stream
{
  // Instance variables incoming
  public KStream incomingStream;
  // Valid intakes are: 'actions', 'updates', 'alerts'
  public String topic;
  

  // Variables that are important for all parts of the program
  public Properties props;

  public Streamsbuilder builder;


  public Stream(KStream incomingStream, String topic)
  {
    runSetup();
  } // Stream

  private static void runSetup() 
  {
    final Properties props = new Properties();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, streamID);
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(StreamsConfig.DEAFULT_KEY_SERDE_CLASS_CONFIG,
              Serdes.String.getClass());
    props.put(StreamsConfig.DEAFULT_VALUE_SERDE_CLASS_CONFIG,
              Serdes.String.getClass());

    final StreamsBuilder builder = new Streamsbuilder;
  } // runSetup 
} // Stream
