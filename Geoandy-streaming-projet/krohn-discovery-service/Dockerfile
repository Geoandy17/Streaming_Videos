FROM openjdk:8-jre
COPY target/krohn-discovery-discovery-1.0.0.jar discovery-service.jar
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]