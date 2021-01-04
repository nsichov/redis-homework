FROM openjdk:8

RUN apt-get update && apt-get install -y maven
COPY . /project
RUN  cd /project && mvn package

ENTRYPOINT ["java","-Dspring.redis.host=redis", "-jar","/project/target/redis-homework-0.0.1-SNAPSHOT.jar"]
