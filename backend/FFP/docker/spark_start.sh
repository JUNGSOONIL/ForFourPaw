#!/bin/bash

# 도커 하둡 컨테이너 HDFS에 data input 디렉토리 생성
hdfs dfs -mkdir -p /user/hadoop/data/input

# hdfs에 데이터 옮김
hdfs dfs -put dataset.csv data/input/dataset.csv

spark-shell

