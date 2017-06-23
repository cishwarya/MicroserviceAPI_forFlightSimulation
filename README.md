This is a spring boot application with GET and POST method.  
Which should run in docker container.  

**Prerequisite:**  
Java 8  
Docker engine


Follow the following Steps to run the complete system.  
In case any error or question. Contact us on    
ishwarya.chandrasekaran@stud.uni-hannover.de  
tt14@tu-clausthal.de  

**Step 1:**  
You need a running mongodb docker container.  
Run the following command to get a running mongodb container in your local system.  
$ ```docker run -it --name mongo -d mongo```

**Step 2:**  
Get the IPAddress of the mongodb container. Which you had run on the last step.  
$ ```docker inspect <container-id>```  
Hint: You will get IPAddress by run the above command.  

Edit the mongodb container IPAddress in the following java file.  
*io.flightlog.dao.DAO.java*  

**Step 3:**  
Build the jar file. This is a maven project. Hence, run the following command to build.  
$ ```mvn package```  

**Step 4:**  
Build the Docker-images  
$ ```docker build -t flightlog:1.0 .```  

**Step 5:**  
Run the flightlog container.  
$ ```docker run -it -p 8080:8080 --name flightlog -d flightlog:1.0```  

**Step 6:**  
Run the following command to check the API.  
POST:  
$ ```curl -H "Content-Type: application/json" -X POST -d '{"sNo":"0.03", "pm_iAddrModeS":"2", "pm_dLatitude":"52.308928", "pm_dLongitude":"10.373013", "pm_dAltitudeMSL":"500.000000","pm_dRoll": "0.001500", "pm_dPitch":"0.180390", "pm_dHeading":"1.396260", "pm_dGroundTrack":"1.444650", "pm_dAirSpeed":"66.902228", "pm_dGroundSpeed":"92.341750", "pm_dVerticalSpeed":"0.005334"}' http://localhost:8080/post```    
hint : you will get "Saved" response  
GET:  
$ ```curl -X GET http://localhost:8080/get/0.03/```  
hint: you will get json response.  

**Step 7:**  
Extract the "runnable.zip". Which is shiped with this project.    
Which has two jar files.  
producer.jar  
consumer.jar  

Run the following command to send data to rest-api  
$ ```java -jar producer.jar TraficServerLog.txt```    

Run the following command to consume the data from rest-api    
$ ```java -jar consumer.jar```    