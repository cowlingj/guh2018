// Packages that help set up the stream
import java.utils.Properties;
import org.apache.kafka.common.serialization.Serdes;

// Packages that help build a KStream
import org.apache.kafka.streams.Streamsbuilder;
import org.apache.kafka.streams.kstreams.KStream;

// Packages to build the KafkaStreams 
import org.apache.kafka.streams.Topology;
import org.apache.kafka.stream.KafkaStreams;

public class KafkaCommunicator 
{
  private Properties props;
  private StreamsBuilder builder;

  public static KStreams createOutputs
  {
    runSetup();
    
    return KStream outputsStream = builder.stream("outputs");

  } // createKafkaOutput

  public static void finishOutputs
  {
    final KafkaStreams outputsStreams = new KafkaStreams(builder.build(), 
                                                         props);
  } // finishOutputs


  public static KStreams createAlerts
  {
    runSetup();

    return KStream alertsStream = builder.stream("alerts");
  } // createAlerts
  
  public static void finishAlerts
  {
    final KafkaStreams alertsStreams = new KafkaStreams(builder.build(),
                                                        props);
  
  private static void runSetup() 
  {
    Properties props = new Properties();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, streamID);
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(StreamsConfig.DEAFULT_KEY_SERDE_CLASS_CONFIG,
              Serdes.String.getClass());
    props.put(StreamsConfig.DEAFULT_VALUE_SERDE_CLASS_CONFIG,
              Serdes.String.getClass());

    final StreamsBuilder builder = new Streamsbuilder;
  } // runSetup 

} // Outputs
