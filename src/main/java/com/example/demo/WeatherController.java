package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class WeatherController {
	@Autowired
	WeatherRepository repo;
	@Autowired
	public WeatherService service;
	
	
	@RequestMapping("/weathers")
	public List<Weather> getAllWeathers() {
		System.out.println("in get method");
		return service.getAllWeather();
	}
	@RequestMapping("/weathers/avg/temp")
	public double getAvgWeathers() {
		System.out.println("in get avg method");
		return service.getAvgWeather();
	}
	@RequestMapping("/weathers/avg/hum")
	public double getAvghumWeather() {
		System.out.println("in get avg method");
		return service.getAvghumWeather();
	}
	@RequestMapping("/weathers/avg/wind")
	public double getAvgwindWeather() {
		System.out.println("in get avg method");
		return service.getAvgwindWeather();
	}
	@RequestMapping("/weathers/sensormax")
	public Object getmaxsbySensor(@RequestParam("sensor") String sensor) {
		System.out.println("in get max method");
		return service.getmaxsbySensor(sensor);
	}
	@RequestMapping("/weathers/sensormin")
	public Object getminsbySensor(@RequestParam("sensor") String sensor) {
		System.out.println("in get min method");
		return service.getminsbySensor(sensor);
	}
	@RequestMapping("/weathers/sensoravg")
	public Object getavgbySensor(@RequestParam("sensor") String sensor) {
		System.out.println("in get avg method");
		return service.getavgbySensor(sensor);
	}
	
	@RequestMapping("/weathers/latest")
	public Object getlatestdatetime(){
		System.out.println("in get avg method");
		return service.getlatestdatetime();
	}
	
	//@RequestMapping("/weathers/sensor/")
	//public List<Weather> getmetbySensor() {
	//	return service.getmaxbySensor();
	//}
	@RequestMapping("/weathers/{id}")
	public Optional<Weather> getWeather(@RequestParam String id) {
				
		return service.getWeather(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/weathers")
	public void addTopic(@RequestBody Weather weather) {
		service.addWeather(weather);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/weathers/{id}")
	public void updateTopic(@RequestBody Weather weather,@PathVariable String id) {
		service.updateWeather(weather,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/weathers/{id}")
	public void deleteTopic(@PathVariable String id) {
		service.deleteWeather(id);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintValidationException(ConstraintViolationException ex){
		return new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
