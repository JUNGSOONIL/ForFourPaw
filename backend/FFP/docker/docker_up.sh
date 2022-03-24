#!/usr/bin/env bash
export PJT_DIR_NAME=docker

if [ ! "$( docker container inspect -f '{{.State.Running}}' hadoop )" == "true" ]; then
    docker run -d -v d:/ssafy/Project/Second_Project/S06P22E105/backend/FFP/docker \
    -p 9870:9870 -p 8088:8088 -p 16010:16010 -p 10002:10002 -p 14040:4040 -p 9995:9995 \
    --name hadoop hibuz/zeppelin-dev yarn,hbase,hive
    sleep 2
    docker start hadoop 
    
fi

if [[ "$OSTYPE" =~ ^msys  || "$OSTYPE" =~ ^cygwin ]]; then
    winpty docker exec -it hadoop sh -c "cd ~/docker&& sh spark_start.sh && /bin/bash" 
    
    
else
    docker exec -it hadoop sh -c "cd ~/docker && /bin/bash"
    
fi
