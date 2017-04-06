# springboot-eureka-zuul

This is the source code for the blog post

This example covers the following :

1. Setup Edge server(Zuul)
2. Setup Eureka server
3. Service Registering: Eureka Clients
4. Service Discovery: Eureka Clients
3. Inter service communication  


#gateway-boot
#eureka-boot
#std-boot(Eureka client)
#school-boot(Eureka client)

#Test URLs (direct):
1. Eureka server : http://localhost:8761/
2. student service : http://localhost:8082/rest/student/
3. school service : http://localhost:8081/rest/school/student/<student_id>

#Test URLs(Via Proxy(Zuul))

1. student service : http://localhost:8080/student-service/rest/student/
2. school service : http://localhost:8080/school-service/rest/school/student/<student_id>
