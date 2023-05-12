# Container Base

FROM eclipse-temurin:17-jdk-alpine

# Definition of Metadata

LABEL version="1.0"
LABEL name="Spring Boot - WS_FirmaEC"

# Ports to Export

EXPOSE 8090
EXPOSE 5432

#Change timezone to server

ENV TZ=America/Guayaquil
USER root
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Copy files to deploy

ADD ./spring-docker-firmaec.jar spring-docker-firmaec.jar

# execute run to deploy

CMD ["java","-jar","/spring-docker-firmaec.jar"]