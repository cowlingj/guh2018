#!/usr/bin/env bash
# install the Kafka Apache platform
set -e
INSTALL_DIR='install'
KAFKA_FILE='kafka.tgz'
EXEC_DIR='exec'

if [ ! -d "$INSTALL_DIR" ]; then
  mkdir -p "$INSTALL_DIR"
fi

if [ ! -f "${INSTALL_DIR}/${KAFKA_FILE}" ]; then
  echo "Could not find the Kafka platform tgz file"
  echo "--downloading:"
  curl -o "${INSTALL_DIR}/${KAFKA_FILE}" http://www.mirrorservice.org/sites/ftp.apache.org/kafka/2.0.0/kafka_2.11-2.0.0.tgz 
fi

if [ ! -d "$EXEC_DIR" ]; then
  mkdir -p "$EXEC_DIR"
fi

tar -xvzf "${INSTALL_DIR}/${KAFKA_FILE}" -C "$EXEC_DIR"

unset -v INSTALL_DIR KAFKA_FILE EXEC_DIR
