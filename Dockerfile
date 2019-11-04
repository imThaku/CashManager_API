FROM frolvlad/alpine-oraclejre8:slim
VOLUME /tmp
RUN sh -c 'touch /app.jar'
EXPOSE 8080
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar --spring.profiles.active=dev"]

ADD target/*.jar app.jar

CMD mkdir -p /opt/cashManager-Api/logs
