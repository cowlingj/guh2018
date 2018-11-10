#!/usr/bin/env bash

LOG=/home/bitnami/install.log

[ ! -f "$LOG" ] && touch "$LOG"

echo "postinstall" >> "$LOG"