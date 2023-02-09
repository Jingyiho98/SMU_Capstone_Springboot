FROM openjdk:12
COPY entrypoint/target/entrypoint-0.0.1-SNAPSHOT.jar entrypoint-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","entrypoint-0.0.1-SNAPSHOT.jar"]

