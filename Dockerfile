FROM openjdk:17-jdk AS build
WORKDIR /app

COPY backend/pom.xml .
COPY backend/src src
COPY backend/mvnw .
COPY backend/.mvn .mvn

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

FROM openjdk:19-jdk
VOLUME /tmp

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
