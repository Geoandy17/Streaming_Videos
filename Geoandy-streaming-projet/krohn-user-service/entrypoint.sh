#!/bin/bash

while :
do
  status_code=$(curl --write-out %{http_code} --silent --output /dev/null http://krohn-service-discovery:8010)
  status_code_config=$(curl --write-out %{http_code} --silent --output /dev/null http://krohn-config-service:8012/MicroservicesConfigServer/native)
  
  echo "Eureka service response: $status_code\n"
  echo "Config service response: $status_code_config"
  
  if [ $status_code -eq 401 ] && [ $status_code_config -eq 200 ]
  then
  
	set -eu
	 
	echo "Checking DB connection ..."
	 
	i=0
	until [ $i -ge 10 ]
	do
	  nc -z postgresql 5432 && break
	 
	  i=$(( i + 1 ))
	 
	  echo "$i: Waiting for DB 1 second ..."
	  sleep 1
	done
	 
	if [ $i -eq 10 ]
	then
	  echo "DB connection refused, terminating ..."
	  exit 1
	fi
	 
	echo "DB is up ..."
    java -jar user-service.jar
    break
  fi
  
  sleep 3
done