
### DockerFile
# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
FROM openjdk:8-jre-slim
COPY --from=build /home/app/target/koc.finans.service-registry.jar /usr/local/lib/koc.finans.service-registry.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/usr/local/lib/koc.finans.service-registry.jar"]


### Docker file run command
docker build -f Dockerfile -t koc.finans.service-registry .

#
#### Maven plugin
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <executions>
        <execution>
            <configuration>
                <artifactItems>
                    <artifactItem>
                        <groupId>${project.groupId}</groupId>
                        <artifactId>${project.artifactId}</artifactId>
                        <version>${project.version}</version>
                    </artifactItem>
                </artifactItems>
            </configuration>
        </execution>
    </executions>
</plugin>


