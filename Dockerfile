FROM java:8
COPY demo-0.0.1-SNAPSHOT.jar /home/demo-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/flightlog-0.0.1-SNAPSHOT.jar"]
