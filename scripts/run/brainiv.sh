#!/usr/bin/env bash

VERSION="0.1.0"
cd brainiv
mvn clean package
java -jar brainIV/target/brainiv-${VERSION}.jar