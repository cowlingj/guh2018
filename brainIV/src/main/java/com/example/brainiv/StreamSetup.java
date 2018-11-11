package com.example.brainiv;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;

public class StreamSetup 
{
  private static props prepareStream(String streamID) 
  {
    Properties props = new Properties();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, streamID);
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(StreamsConfig.DEAFULT_KEY_SERDE_CLASS_CONFIG,
              Serdes.String.getClass());
    props.put(StreamsConfig.DEAFULT_VALUE_SERDE_CLASS_CONFIG,
              Serdes.String.getClass());


    StreamsConfig config = new StreamsConfig(props);
  } // prepareStream

 

} // StreamSetup 
