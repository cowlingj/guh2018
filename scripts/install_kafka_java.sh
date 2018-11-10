#!/usr/bin/env bash
# Copy kafka-clients-2.0.0.jar to the lib/java directory
set -e
JAVA_DIR='lib/java'
if [ ! -d "$JAVA_DIR" ]; then
  mkdir -p "$JAVA_DIR" 
fi
curl -o "$JAVA_DIR"/kafka_java.jar http://central.maven.org/maven2/org/apache/kafka/kafka-clients/2.0.0/kafka-clients-2.0.0.jar
unset -v JAVA_DIR
