FROM adoptopenjdk/openjdk8-openj9

ADD target/demo.jar /app/
ADD script.sh /app/
ADD start-spring.sh /app/
ADD openwhisk-web-action-http-proxy /app/

ENV PROXY_PORT 8081
ENV PROXY_ALIVE_DELAY 7000
ENV APP_SERVER_CMD /app/start-spring.sh
EXPOSE 8080

WORKDIR /app
CMD ./script.sh