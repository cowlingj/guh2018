#!/usr/bin/env bash

BUCKET_NAME='aws-codedeploy-eu-west-1'

sudo apt update
sudo apt install awscli
sudo apt install -y ruby
cd ~
curl -O "https://${BUCKET_NAME}.s3.amazonaws.com/latest/install"
chmod +x ./install
sudo ./install auto

unset BUCKET_NAME