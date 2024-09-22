FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/proyect_tienda-0.0.1.jar
COPY ${JAR_FILE} app_ventas.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_ventas.jar"]