# Stage 1: Cached docker build
FROM library/openjdk:8u212-jdk-alpine3.9 as builder
WORKDIR /app

COPY ./mvnw .
COPY ./.mvn .mvn
COPY ./pom.xml .
RUN ./mvnw dependency:go-offline -B

COPY ./src ./src
RUN ./mvnw package -DskipTests

RUN mkdir -p ./target/dependency \
 && cd ./target/dependency \
 && jar -xf ../*.jar

# Stage 2: A minimal docker image with command to run the app
FROM library/openjdk:8u212-jre-alpine3.9
ENTRYPOINT ["/bin/ash","-c"]
CMD ["java -cp .:lib/* com.example.polls.PollsApplication"]
WORKDIR /app

COPY --from=builder /app/target/dependency/BOOT-INF/lib      ./lib
COPY --from=builder /app/target/dependency/META-INF          ./META-INF
COPY --from=builder /app/target/dependency/BOOT-INF/classes  .
