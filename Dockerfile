FROM frolvlad/alpine-oraclejre8:slim
VOLUME /tmp
RUN sh -c 'touch /app.jar'
EXPOSE 8087
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar --spring.profiles.active=prod"]

ADD target/*.jar app.jar

CMD mkdir -p /opt/cashManager-Api/logs
