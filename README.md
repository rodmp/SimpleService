# Java EE Microservice
_Uses Microprofile and Payara Micro_

Connects to an H2 database and retrieves the suggested names.

Deploy to Payara Micro using the following after building and compiling:

`java -jar payara-micro-4.1.2.174.jar --deploy SimpleService.war`

Go to 
```
localhost:8080/SimpleService/rest/suggestedNameService
localhost:8080/SimpleService/rest/suggestedNameService/{id}
```

### Minor To-Do
- [ ] Remove Jackson
- [ ] Add GenericEntity List for findAll Response
- [ ] Update Microprofile to 1.2
- [ ] Dockerize
- [ ] Add uberjar plugin
