#!/usr/bin/env bash

ROOT=".."
CONFIG_DIR="${ROOT}/kafka-server/config"
KAFKA_DIR="${ROOT}/bin/kafka_2.11-2.0.0"
cd "$KAFKA_DIR"

bin/zookeeper-server-start.sh "${CONFIG_DIR}/zookeeper.properties" &
sleep 2
bin/kafka-server-start.sh -daemon "${CONFIG_DIR}/actions.properties"
bin/kafka-server-start.sh -daemon "${CONFIG_DIR}/alerts.properties"
bin/kafka-server-start.sh -daemon "${CONFIG_DIR}/updates.properties"
sleep 2

unset KAFKA_DIR
