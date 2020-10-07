# Email Validator System

### Environment
In order to compile and run this project correctly, below environments are required:

* [Java JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/install.html)
* A Web Browser

 ### Install(Under the project directory)
 #### - Run the below command to compile and setup:
 * _`mvn install`_
  * or _`mvn install -Dmaven.test.skip=true`_ if the test fails during the building.
 #### - Run the below command to run the tests:
 * _`mvn test`_
 
 ### Run the service(Under the project directory)
 #### - Run the below command to run the service:
 * _`mvn spring-boot:run`_
 #### - Then use the swagger link below to test the API:
 * http://localhost:8080/swagger-ui.html#!/emails_api/getUniqueEmailNumsUsingGET

 
 ### Project Explanation
 This project is simulating REST API for services about email, the current API is defined as below:
  * For the giving email list, return the value of the numbers of unique email.
  * Enter the emails into the field showing on the swagger UI, enter one email per line. Then click the "Try it out" button. The result will show in the "Response Body" field.
  * All the input emails must contain "@", email address doesn't contain "@" will be ignored and not counted in the result 


