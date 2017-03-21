package com.baidu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.entity.City;
import com.baidu.entity.CityCustom;
import com.baidu.entity.CityType;
import com.baidu.entity.User;
import com.baidu.mapper.CityMapper;

@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	@Override
	public List<City> listCity(Map<String, Object> map) {
		return cityMapper.findCity(map);
	}

	@Override
	public List<CityType> findCityType() {
		return cityMapper.findCityType();

	}

	@Override
	public void addCity(City city) {
		cityMapper.addCity(city);
	}

	@Override
	public City findCityByName(City city) {
		return cityMapper.findCityByName(city);
	}

	@Override
	public City findCityById(City city) {
		return cityMapper.findCityById(city);
	}

	@Override
	public void updateCity(City city) {
		cityMapper.updateCity(city);
	}

	@Override
	public void deleteCityById(City city) {
		cityMapper.deleteCityById(city);
	}

	@Override
	public void deleteAll(String ids) {
		String[] split = ids.split(",");
		for (String id : split) {
			City c = new City();
			c.setId(Integer.parseInt(id));
			cityMapper.deleteCityById(c);
		} 
		
	}

	@Override
	public Integer findCount(Map<String, Object> map) {
		return cityMapper.findCount(map);
	}

	@Override
	public List<City> findCityByIds(Integer[] ids) {
		
		return cityMapper.findCityByIds(ids);
	}

	@Override
	public void updateAllCity(CityCustom cityCustom) {
		
		List<City> cities = cityCustom.getCities();
		
		for (City city : cities) {
			
			cityMapper.updateCity(city);
			
		}
		
	}

	@Override
	public void addUser(User u) {
		cityMapper.addUser(u);
	}

}
