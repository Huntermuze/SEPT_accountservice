FROM maven:3.8.6-openjdk-18
#WORKDIR ./
#COPY ./BankAccService.jar BankAccService.jar
#ENTRYPOINT ["java","-jar","/BankAccService.jar"]
COPY . .

RUN mvn clean install -DskipTests

CMD mvn spring-boot:run
