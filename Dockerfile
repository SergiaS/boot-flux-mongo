# VARIANT 1
#FROM openjdk:11
#
## copy the packaged jar file into our docker image
## т.е. с локальной среды в docker
#COPY target/boot-flux-mongo-0.0.1-SNAPSHOT.jar /b-f-m.jar
#
## set the startup command to execute the jar
#CMD ["java", "-jar", "/b-f-m.jar"]


# VARIANT 2
## select parent image
#FROM maven:3.6.3-jdk-11
#
## copy the source tree and the pom.xml to our new container
#COPY ./ ./
#
## package our application code
#RUN mvn clean package
#
## set the startup command to execute the jar
#CMD ["java", "-jar", "target/boot-flux-mongo-0.0.1-SNAPSHOT.jar"]


# VARIANT 3
# the first stage of our build will use a maven 3.6.3 parent image
FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./

# package our application code
RUN mvn clean package

# the second stage of our build will use open jdk 11
FROM openjdk

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /target/boot-flux-mongo-0.0.1-SNAPSHOT.jar /demo.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/demo.jar"]
