# gatewayservice
gatewayservice acts as an edge service for all other microservice

* An API Gateway is a server that is the single entry point into the system. It is similar to the Facade pattern from object‑oriented design. The API Gateway encapsulates the internal system architecture and provides an API that is tailored to each client. It might have other responsibilities such as authentication, monitoring, load balancing, caching, request shaping and management, and static response handling.
* When it comes to choosing an API gateway for your microservices, there are a variety of options: Zuul from netflix, Kong, Nginx, HAProxy, Traefik, cloud vendor's solutions such as Amazon API Gateway or Google Cloud Endpoints and (the new) Spring Cloud gateway from Pivotal.

* Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs. When it receives request, Spring Cloud Gateway forwards it to a Gateway Handler Mapping, which determines what should be done with requests matching a specific route.

* In this Example we will use spring cloud gateway as a gateway provider, Netflix Eureka as a discovery server with circuit breaker pattern using Netflix Hystrix.
 
* In this implementation, we will have 2 different spring boot based microservices as course-service and student-service. These services will register themselves to the discovery server. Spring cloud gateway will use Netflix client API to discover the service and route the request to load balanced downstream services.

EndPoints for consumer

STUDENT-SERVICE
---------------
  http://localhost:8085/api/student/remove?studentID=1  
  http://localhost:8085/api/student/add?courseID=2
  http://localhost:8085/api/student/get?courseID=2

COURSE-SERVICE
--------------
  http://localhost:8085/api/course/get
  http://localhost:8085/api/course/remove?courseID=4
  http://localhost:8085/api/course/add/ 
