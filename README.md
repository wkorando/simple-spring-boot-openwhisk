# Super simple Spring Boot project to use with Apache OpenWhisk. 

* Implements POST /init
* Implements POST /run
* Uses standard Spring Boot semantics
* This is meant to be used in a docker container and not the OpenWhisl simpleJava8Action, as it starts a webserver opens port 8080

mvn install
java -jar target/demo-0.0.1-SNAPSHOT.jar


Test init:
curl -d '{"key1":"value1", "key2":"value2"}' -H "Content-Type: application/json" -X POST http://localhost:8080/init

Test run:
curl -d '{"name":"Pratik"}' -H "Content-Type: application/json" -X POST http://localhost:8080/run
