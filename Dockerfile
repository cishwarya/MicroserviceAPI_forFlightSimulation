FROM java:8
COPY target/flightLog-api-0.0.1-SNAPSHOT.jar /home/flightLog-api-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/flightLog-api-0.0.1-SNAPSHOT.jar"]
