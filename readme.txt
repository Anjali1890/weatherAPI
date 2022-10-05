Tools required:
STS. Java, MYSQL, myssql workbench

URLS:: use postman to test the service

post:: post method used to add newrecords so i have added 8 records in my database.

http://localhost:8080/weathers
body -> Raw -> below data

{
        "id": "8",
        "temp": "15",
        "humidity": "30",
        "wind": "125",
        "sensor": "2",
        "datetime": "24/09/2022"
    }

get:: fetch the matrices 

 http://localhost:8080/weathers/sensoravg?sensor=1
 http://localhost:8080/weathers/sensormin?sensor=1
 http://localhost:8080/weathers/sensormax?sensor=1
 http://localhost:8080/weathers/1
 http://localhost:8080/weathers/avg/temp
 http://localhost:8080/weathers/avg/humidity
  http://localhost:8080/weathers/avg/wind
 
 
 
 http://localhost:8080/weathers/latest 
 
 install MYSQL and MYSQL workbench 
 
 database details are mentioned in properties file.