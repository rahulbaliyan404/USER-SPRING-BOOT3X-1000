FROM openjdk:17

COPY target/user-spring-boot3x-1000.jar .

EXPOSE 1000

ENTRYPOINT ["java","-jar","user-spring-boot3x-1000.jar"]