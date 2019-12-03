FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY ./target/CashManager-1.0-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "CashManager-1.0-SNAPSHOT.jar"]