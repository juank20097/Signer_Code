# Contenedor Base

FROM quay.io/wildfly/wildfly:26.1.3.Final-jdk11

# Definición de Metadatos

LABEL version="1.0"
LABEL name="wildfly - FirmaEC - Mintel"

#Definición de puertos a exponer

EXPOSE 9990
EXPOSE 8080

#Change timezone to server

ENV TZ=America/Guayaquil
USER root
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#Ejecución de comandos de configuración de Contenedor

    #Creación de usuario para Wildfly

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

    #Copia del Driver de BDD

RUN cd /opt/jboss/wildfly/modules/system/layers/base/org
USER root
RUN mkdir postgresql
RUN cd postgresql
RUN mkdir main
RUN cd main
ADD ./module.xml /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/
ADD ./postgresql-42.5.1.jar /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/

    #Reemplazo del archivo standalone.xml con la conexión del DataSource

RUN rm /opt/jboss/wildfly/standalone/configuration/standalone.xml
ADD ./standalone.xml /opt/jboss/wildfly/standalone/configuration/

    #Adición de wars de FirmaEC

ADD ./api.war /opt/jboss/wildfly/standalone/deployments/
ADD ./servicio.war /opt/jboss/wildfly/standalone/deployments/

#Comando de lanzamiento del Contenedor

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]