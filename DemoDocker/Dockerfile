FROM openjdk:22

ARG FILE_JAR=target/*jar

ADD ${FILE_JAR} demo-docker-v1.jar

ENTRYPOINT ["java", "-java", "demo-docker-v1.jar"]

EXPOSE 8080