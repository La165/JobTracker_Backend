FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 9003

CMD ["java", "-jar", "target/jobtracker-0.0.1-SNAPSHOT.jar"]