Tools required:
Spring tool suits. Java, MYSQL, myssql workbench

 install MYSQL and MYSQL workbench 
 
 database details are mentioned in properties file.

URLS:: use postman to test the service

post:: below post rest api used to add newrecords hence added 8 records in my database.

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

min , max, and avg of temp, humidity, wind is fetched based on sensor
 http://localhost:8080/weathers/sensoravg?sensor=1
 http://localhost:8080/weathers/sensormin?sensor=1
 http://localhost:8080/weathers/sensormax?sensor=1
 
 fetch records based on id
 http://localhost:8080/weathers/1
 
 fetach avg of tempearature
 http://localhost:8080/weathers/avg/temp
  fetach avg of humidity
 http://localhost:8080/weathers/avg/humidity
 
 fetach avg of wind
  http://localhost:8080/weathers/avg/wind
 
 
 fetach latest date avg temp, avg wind and avg humidity
 http://localhost:8080/weathers/latest 
 
