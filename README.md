# CustomerPreferences
Spring boot Rest API Examples

What we’ll build We will build Customer Preferences RESTFul APIs for a Simple Customer Preferences Management System using Spring Boot 2 JPA and MySQL. Following are three REST APIs (Controller handler methods) are created for Customer.

1.1 POST http://localhost:8080/customer/v1/customer-preferences

1.2 PUT http://localhost:8080/customer/v1/get-customer-preferences/{ID}

**2. Tools and Technologies Used **
Spring Boot - 2.0.5.RELEASE JDK - 11 Spring Framework - 5.0.8 RELEASE Hibernate - 5.2.17.Final JPA Maven - 3.2+ IDE - Eclipse or Spring Tool Suite (STS)

3. Creating and Importing a Project  
   There are many ways to create a Spring Boot application. The simplest way is to use Spring Initializr at http://start.spring.io/, which is an online Spring Boot application  generator. image

Look at the above diagram, we have specified the following details: Generate: Maven Project Java Version: 11 Spring Boot:2.0.5 Group: customer.preferences Artifact: customerPreferences Name: customerPreferences Description: Rest API for a Customer Preferences management Package Name : com.sample.microservice.get.customer.preferences Packaging: jar (This is the default value) Dependencies: Web, JPA, MySQL, DevTools Once, all the details are entered, click on Generate Project button will generate a spring boot project and downloads it. Next, Unzip the downloaded zip file and import it into your favorite IDE.

4. Running Application This spring boot application has an entry point Java class called SpringBootCrudRestApplication.java with the public static void main(String[] args) method, which you can run to start the application. import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication public class Application {

public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
}
} @SpringBootApplication is a convenience annotation that adds all of the following: @Configuration tags the class as a source of bean definitions for the application context. @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet. @ComponentScan tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers. The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.

5. Testing REST APIs via Postman Client

 1. create customer preferences and created resource will be returned in response header location param.

  ![image](https://user-images.githubusercontent.com/89606757/131080574-da5f2aae-5fae-4874-895f-612405596d64.png)

  ![image](https://user-images.githubusercontent.com/89606757/131080650-7f844cf9-9e00-4d2b-b6a5-e0572a93c20a.png)



2. Update customer preferences using id
  
  ![image](https://user-images.githubusercontent.com/89606757/131080791-fd03403e-7a32-4593-9461-ba811207a3d7.png)

