FROM openjdk:18-jdk-oraclelinux8
FROM maven:3.8.6
#WORKDIR ./
#COPY ./BankAccService.jar BankAccService.jar
#ENTRYPOINT ["java","-jar","/BankAccService.jar"]
COPY . .

RUN mvn clean install -DskipTests

CMD mvn spring-boot:run
