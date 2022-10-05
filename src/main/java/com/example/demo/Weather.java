package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name="weather")
@Table(name="weather")
public class Weather {

@Id
@Column(name="id")
String id;
@Column(name="temp")
String temp;
@Column(name="humidity")
String humidity;
@Column(name="wind")
String wind;
@Column(name="sensor")
String sensor;
@Column(name="datetime")
String datetime;

public Weather(String id, String temp, String humidity,String wind, String sensor,String datetime) {
	this.id = id;
	this.temp = temp;
	this.humidity = humidity;
	this.wind = wind;
	this.sensor = sensor;
	this.datetime = datetime;
}
public Weather() {
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTemp() {
	return temp;
}
public void setTemp(String temp) {
	this.temp = temp;
}
public String getHumidity() {
	return humidity;
}
public void setHumidity(String humidity) {
	this.humidity = humidity;
}
public String getWind() {
	return wind;
}
public void setWind(String wind) {
	this.wind = wind;
}
public String getSensor() {
	return sensor;
}
public void setSensor(String sensor) {
	this.sensor = sensor;
}
public String getDatetime() {
	return datetime;
}
public void setDatetime(String datetime) {
	this.datetime = datetime;
}

}
