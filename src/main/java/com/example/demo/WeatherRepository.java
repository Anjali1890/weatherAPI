package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, String>{
	
	//@Query(value ="SELECT * FROM weather where sensor = (:sensor)", nativeQuery = true)
	//public List<Weather> getmetricesbySensor(String sensor);
	@Query(value ="SELECT id, max(temp), max(humidity), max(wind), sensor, datetime FROM weather where sensor = (:sensor)", nativeQuery = true)
	public Object getmaxsbySensor(String sensor);
	
	@Query(value ="SELECT id, min(temp), min(humidity), min(wind), sensor, datetime FROM weather where sensor = (:sensor)", nativeQuery = true)
	public Object getminsbySensor(String sensor);
	
	@Query(value ="SELECT avg(temp), avg(humidity), avg(wind), sensor FROM weather where sensor = (:sensor)", nativeQuery = true)
	public Object getavgsbySensor(String sensor);
	
	@Query(value = "SELECT max(datetime), avg(temp),avg(humidity), avg(wind) FROM weather group by datetime limit 1;", nativeQuery = true)
	public Object getlatestdatetime();
}
