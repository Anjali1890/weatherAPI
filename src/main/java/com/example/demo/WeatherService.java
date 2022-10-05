package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	@PersistenceContext
	  private EntityManager em;

	@Autowired
	private WeatherRepository repo;
	
	
	@Autowired
	public WeatherService(WeatherRepository repo) {
		super();
		this.repo = repo;
	}
	public List<Weather> getAllWeather() {
		List<Weather> weathers = new ArrayList<>();
		repo.findAll().forEach(weathers::add);
		return weathers;
	}
	public double getAvgWeather() {
		Query query = em.createQuery(
			      "SELECT avg(temp) FROM weather", Double.class);
			  double countryCount = (double)query.getSingleResult();
		return countryCount;
	}
	public double getAvghumWeather() {
		Query query = em.createQuery(
			      "SELECT avg(humidity) FROM weather", Double.class);
			  double humid = (double)query.getSingleResult();
		return humid;
	}
	public double getAvgwindWeather() {
		Query query = em.createQuery(
			      "SELECT avg(wind) FROM weather", Double.class);
			  double wind = (double)query.getSingleResult();
		return wind;
	}
	//public List<Weather> getmetricesbySensor(String sensor) {
		//List<Weather> weathermeat = repo.getmetricesbySensor(sensor);
		//return weathermeat;
		
	//}
	public Object getmaxsbySensor(String sensor) {
		Object[] weathermeat = (Object[]) repo.getmaxsbySensor(sensor);
		return weathermeat;
		
	}
	
	public Object getminsbySensor(String sensor) {
		Object[] weathermin = (Object[]) repo.getminsbySensor(sensor);
		return weathermin;
		
	}
	
	public Object getavgbySensor(String sensor) {
		Object[] weatheravg = (Object[]) repo.getavgsbySensor(sensor);
		return weatheravg;
		
	}
	
	public Object getlatestdatetime() {
		Object[] weatherlatavg = (Object[]) repo.getlatestdatetime();
		return weatherlatavg;
		
	}


	/*
	 * public String getmaxWeather() { Query query = em.createQuery(
	 * "SELECT max(temp) FROM weather", String.class); String maxtemp =
	 * (String)query.getSingleResult(); return maxtemp; }
	 */
	public Optional<Weather> getWeather(String id) {
		return repo.findById(id);
	}
	public void addWeather(Weather weather) {
		repo.save(weather);
	}
	public void updateWeather(Weather weather,String id) {		
		repo.save(weather);				
	}
	public void deleteWeather(String id) {
		repo.deleteById(id);
	}
	

}
