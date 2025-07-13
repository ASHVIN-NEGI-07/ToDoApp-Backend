FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copy everything and make mvnw executable
COPY . .
RUN chmod +x mvnw mvnw.cmd

# Now run the wrapper to build
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
