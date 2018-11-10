#!/usr/bin/env bash
# Copy kafka-1.3.5.tar.gz to the lib/Py directory
set -e
PY_DIR='lib/Py'
INSTALL_DIR='install'

if [ ! -d "$INSTALL_DIR" ]; then
  mkdir -p "$INSTALL_DIR" 
fi

if [ ! -f "$INSTALL_DIR"/kafka_Py.tar.gz ]; then
  echo "Could not find the Kafka client tar file"
  echo "--downloading:"
  curl -o "$INSTALL_DIR"/kafka_Py.tar.gz https://files.pythonhosted.org/packages/3b/1b/44605e699e0970a2be3d7135d185f95e8605399aa0f2a9d64de342eae4b7/kafka-1.3.5.tar.gz 
fi

if [ ! -d "$PY_DIR" ]; then
  mkdir -p "$PY_DIR" 
fi

tar -xvzf "${INSTALL_DIR}/kafka_Py.tar.gz" -C "$PY_DIR"

unset -v PY_DIR INSTALL_DIR
