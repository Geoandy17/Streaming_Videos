FROM openjdk:8-jre
COPY target/krohn-user-service-1.0.0.jar user-service.jar
RUN apt-get update 
RUN apt-get install -y netcat
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]