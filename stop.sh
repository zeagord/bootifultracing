#!/bin/sh
curl -X POST localhost:8761/shutdown
curl -X POST localhost:8765/shutdown
curl -X POST localhost:9000/shutdown
