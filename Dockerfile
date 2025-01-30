FROM eclipse-temurin:21
WORKDIR workspace
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} my-app.jar
ENTRYPOINT ["java", "-jar", "my-app.jar"]
