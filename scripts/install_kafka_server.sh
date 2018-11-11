#!/usr/bin/env bash
# install the Kafka Apache platform
set -e
INSTALL_DIR='install'
KAFKA_FILE='kafka.tgz'
BIN_DIR='bin'

if [ ! -d "$INSTALL_DIR" ]; then
  mkdir -p "$INSTALL_DIR"
fi

if [ ! -f "${INSTALL_DIR}/${KAFKA_FILE}" ]; then
  echo "Could not find the Kafka platform tgz file"
  echo "--downloading:"
  curl -o "${INSTALL_DIR}/${KAFKA_FILE}" http://www.mirrorservice.org/sites/ftp.apache.org/kafka/2.0.0/kafka_2.11-2.0.0.tgz 
fi

if [ ! -d "$BIN_DIR" ]; then
  mkdir -p "$BIN_DIR"
fi

tar -xvzf "${INSTALL_DIR}/${KAFKA_FILE}" -C "$BIN_DIR"

unset -v INSTALL_DIR KAFKA_FILE BIN_DIR
