# springboot-eureka-zuul

In this project we will start to look at how we can implement the model using Spring Cloud and Netflix OSS. From the operations model we will cover the core parts: service discovery, dynamic routing, load balancing and to some extend an edge server.

To support the business services we use the following infrastructure services and components (blue boxes):
1. Service Discovery Server (Netflix Eureka)#gateway-boot
2. Dynamic Routing and Load Balancer (Netflix Ribbon)
3. Edge Server (Netflix Zuul)#eureka-boot

# Build instruction 
1. Maven 

#Test URLs (direct):
1. Eureka server : http://localhost:8761/
2. student service : http://localhost:8082/rest/student/
3. school service : http://localhost:8081/rest/school/student/<student_id>

#Test URLs(Via Proxy(Zuul))

1. student service : http://localhost:8080/student-service/rest/student/
2. school service : http://localhost:8080/school-service/rest/school/student/<student_id>
