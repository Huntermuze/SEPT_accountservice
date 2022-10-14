FROM maven:3.8.6-jdk-18-slim
#WORKDIR ./
#COPY ./BankAccService.jar BankAccService.jar
#ENTRYPOINT ["java","-jar","/BankAccService.jar"]
COPY . .

RUN mvn clean install -DskipTests

CMD mvn spring-boot:run
