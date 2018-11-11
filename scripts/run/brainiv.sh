#!/usr/bin/env bash

VERSION="0.1.0"

mvn clean package
java -jar brainIV/target/brainiv-${VERSION}.jar