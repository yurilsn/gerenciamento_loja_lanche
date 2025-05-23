FROM maven:3.6.3-openjdk-17-slim AS build
WORKDIR /app
COPY . /app
#COPY src /app
EXPOSE 8080
#RUN echo ${PWD} && ls -lR
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/gerenciamento_loja-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java","-jar","./gerenciamento_loja-0.0.1-SNAPSHOT.jar"]