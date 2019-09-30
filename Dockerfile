FROM adoptopenjdk/openjdk11:jdk-11.0.2.7-alpine-slim
MAINTAINER github.com/rgalba
RUN apk --no-cache add curl
ADD build/libs/fibonacci-0.0.1-SNAPSHOT.jar fibonacci-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "fibonacci-0.0.1-SNAPSHOT.jar" ]