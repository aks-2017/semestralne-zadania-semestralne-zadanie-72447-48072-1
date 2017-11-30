#!/bin/bash
cd
sudo apt-get update -y
sudo apt-get install software-properties-common -y
sudo apt-get update -y
sudo apt-get install build-essential openjdk-7-jdk ant maven python-dev eclipse -y

git clone git://github.com/floodlight/floodlight.git -b v1.1
cd floodlight
git submodule init
git submodule update
ant
 
sudo mkdir /var/lib/floodlight
sudo chmod 777 /var/lib/floodlight
