FROM openjdk:17 AS GRADLE_BUILD

COPY ./ ./

RUN java --version
RUN ./gradlew clean build

FROM openjdk:17

#COPY build/libs/jdk17-0.0.1-SNAPSHOT.jar /app.jar
COPY --from=GRADLE_BUILD build/libs/jdk17-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080

CMD ["java", "--enable-preview", "-jar", "/app.jar"]
