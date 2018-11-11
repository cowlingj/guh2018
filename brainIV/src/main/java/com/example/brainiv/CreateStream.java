package com.example.brainiv;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;

public CreateStream
{
  public static Stream CreateObjectFromStream(String stringID)
  {
    BootStream(String stringID);

    // Set up correct stream structure dependending on app ID
    if (stringID == 'updates')
      gameObject();

    elseif (stringID == 'alerts');
      gameEvent();
  } // CreateObjectFromStream

  private static BootStream(String stringID)
  {
    Properties props = new Properties();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, stringID);
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(StreamsConfig.DEAFULT_KEY_SERDE_CLASS_CONFIG,
              Serdes.String().getClass());
//    props.put(StreamsConfig.DEAFULT_VALUE_SERDE_CLASS_CONFIG,
//              Serdes.String().getClass());
  } // BootStream 

 

} // CreateStream
