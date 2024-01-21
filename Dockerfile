FROM maven:3.9.6-amazoncorretto-17 AS build

WORKDIR /

COPY core/pom.xml core/pom.xml
COPY application/pom.xml application/pom.xml
COPY adapter/pom.xml adapter/pom.xml
COPY adapter/entry-point/pom.xml adapter/entry-point/pom.xml

COPY pom.xml .
RUN mvn dependency:go-offline


COPY core/src core/src
COPY application/src application/src
COPY adapter/entry-point/src adapter/entry-point/src

RUN mvn package

FROM amazoncorretto:17-alpine

RUN mkdir /app

COPY --from=build /application/target/*.jar /app/app.jar

WORKDIR /app

#EXPOSE 8090
RUN ls -la

#CMD java -jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]