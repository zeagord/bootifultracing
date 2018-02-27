#!/bin/sh
cd ~/Documents/code/bootifultracing/discoveryserver
nohup ./gradlew bootRun  > stdoutfile 2> stderrfile &
cd ~/Documents/code/bootifultracing/gatewayserver
nohup ./gradlew bootRun  > stdoutfile 2> stderrfile &
cd ~/Documents/code/bootifultracing/bookservice
nohup ./gradlew bootRun  > stdoutfile 2> stderrfile &
