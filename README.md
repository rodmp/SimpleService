# Java EE Microservice
_Uses Microprofile and Payara Micro_

Connects to an H2 database and retrieves the suggested names.

## Deploy to Payara Micro

`java -jar payara-micro-4.1.2.174.jar --deploy SimpleService.war`

## Deploy Docker container

`docker run -d -p 8085:8080 --name simpleservice vasouv/simpleservice`

Go to 
```
localhost:8080/SimpleService/rest/suggestedNameService
localhost:8080/SimpleService/rest/suggestedNameService/{id}
```

### Minor To-Do
- [X] Remove Jackson
- [X] Add GenericEntity List for findAll Response
- [ ] Update Microprofile to 1.2
- [X] Dockerize
