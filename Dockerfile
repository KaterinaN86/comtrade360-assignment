FROM maven:3.8.6-jdk-11

#go to dir build
WORKDIR /build
#add the current source code to build
ADD . /build

#run in container. Builds a .jar file from the application to be run with spring boot
RUN mvn clean package spring-boot:repackage

#creates app dir
RUN mkdir /app

#cpoies .jar to app dir
RUN cp /build/target/assignment-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080
# runs the app
CMD ["java", "-jar", "/app/assignment-0.0.1-SNAPSHOT.jar" , "-Dspring.profile.active=default"]
