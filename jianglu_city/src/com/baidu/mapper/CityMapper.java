package com.baidu.mapper;

import java.util.List;
import java.util.Map;

import com.baidu.entity.City;
import com.baidu.entity.CityType;
import com.baidu.entity.User;

public interface CityMapper {

	List<City> findCity(Map<String, Object> map);

	List<CityType> findCityType();

	void addCity(City city);

	City findCityByName(City city);

	City findCityById(City city);

	void updateCity(City city);

	void deleteCityById(City city);

	Integer findCount(Map<String, Object> map);

	List<City> findCityByIds(Integer[] ids);

	void addUser(User u);

}
