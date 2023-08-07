FROM eclipse-temurin:8u372-b07-jre-centos7

ADD ./target/application-0.0.1.jar /app/application-0.0.1.jar

ADD runboot.sh /app/

WORKDIR /app

RUN chmod a+x runboot.sh

CMD sh -c /app/runboot.sh

EXPOSE 8080