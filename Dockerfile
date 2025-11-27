# Use a slim JRE image for production (smaller, less attack surface)
FROM eclipse-temurin:21-jre-alpine

# Set application port (Spring Boot default)
EXPOSE 8080

# Define a volume for Tomcat's temporary files (good practice)
VOLUME /tmp

# Copy the generated JAR from the 'build' stage into the root of the final image
# Replace 'my-spring-boot-app-0.0.1-SNAPSHOT.jar' with your actual file name
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar

# Run the JAR file when the container starts
# The '-Djava.security.egd=file:/dev/./urandom' flag is common for Tomcat/web server performance
ENTRYPOINT ["java","-jar","app.jar"]