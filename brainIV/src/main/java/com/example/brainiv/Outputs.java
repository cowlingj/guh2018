public class Outputs
{
  public static KStreams createOutputsKafkaStreams
  {
    Properties propertiesForOutputs = new Properties prepareStream
                                        (
                                         "streams-output"
                                        );

    final StreamsBuilder builder = new Streamsbuilder;

    builder.stream("streams-plaintext-input").to("streams-outputs-output");

    final Topology topology = builder.build();

    return final KStream outputsStreams = new KafkaStreams(topology, 
                      propertiesForOutputs);
  } // createOutput
  


} // Outputs
