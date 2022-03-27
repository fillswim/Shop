FROM openjdk:11
COPY target/Shop-0.0.1-SNAPSHOT.jar /tmp
WORKDIR /tmp
CMD java -jar ./Shop-0.0.1-SNAPSHOT.jar