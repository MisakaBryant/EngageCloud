FROM eclipse-temurin:8u372-b07-jre-centos7

ADD ./target/application.jar /app/application.jar

ADD runboot.sh /app/

WORKDIR /app

RUN chmod a+x runboot.sh

CMD sh -c /app/runboot.sh