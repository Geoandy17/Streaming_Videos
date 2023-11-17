#!/bin/bash

while :
do
  status_code=$(curl --write-out %{http_code} --silent --output /dev/null http://krohn-config-service:8012/MicroservicesConfigServer/native)
  
  echo "Config service response: $status_code"
  
  if [ $status_code -eq 200 ]
  then
      java -jar discovery-service.jar
      break
  fi
  
  sleep 3
done

