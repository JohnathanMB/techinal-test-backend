FROM amazoncorretto:17-alpine
VOLUME /tmp
COPY application/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]