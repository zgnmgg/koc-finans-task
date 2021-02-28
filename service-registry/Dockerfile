# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8-jre-slim
COPY --from=build /home/app/target/koc.finans.service-registry.jar /usr/local/lib/koc.finans.service-registry.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/koc.finans.service-registry.jar"]
