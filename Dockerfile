FROM adoptopenjdk/openjdk8-openj9:alpine-jre

ADD target/aa-serverless-function.jar /app/
RUN /bin/sh -c 'java -Xshareclasses:cacheDir=/app/cache -Xscmx128m -jar app/aa-serverless-function.jar &' ; sleep 20

EXPOSE 8080

WORKDIR /app
ENTRYPOINT ["java", "-jar", "-Xquickstart", "-noverify", "-Xshareclasses:cacheDir=/app/cache,readOnly", "aa-serverless-function.jar" ]