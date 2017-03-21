package com.baidu.service;

import java.util.List;
import java.util.Map;

import com.baidu.entity.City;
import com.baidu.entity.CityCustom;
import com.baidu.entity.CityType;
import com.baidu.entity.User;

public interface CityService {

	List<City> listCity(Map<String, Object> map);

	List<CityType> findCityType();

	void addCity(City city);

	City findCityByName(City city);

	City findCityById(City city);

	void updateCity(City city);

	void deleteCityById(City city);

	void deleteAll(String ids);

	Integer findCount(Map<String, Object> map);

	List<City> findCityByIds(Integer[] ids);

	void updateAllCity(CityCustom cityCustom);

	void addUser(User u);

}
