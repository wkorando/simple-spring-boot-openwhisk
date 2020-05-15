# Simple example of using OpenWhisk

* Implements POST /init
* Implements POST /run
* Uses standard Spring Boot semantics
* This is meant to be used in a docker container and not the OpenWhisl simpleJava8Action, as it starts a webserver opens port 8080

Build Java artifact:
`mvn clean package`

Build docker image: 
`docker build . -t [DockerHubRepo]/[image-name]:[tag]`

Push to DockerHub repo:
`docker push [DockerHubRepo]/[image-name]:[tag]`

Deploy function:
`ibmcloud fn action update [action-name] --docker [DockerHubRepo]/[image-name]:[tag] --web true`