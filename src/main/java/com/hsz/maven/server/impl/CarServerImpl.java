package com.hsz.maven.server.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hsz.maven.dao.CarDao;
import com.hsz.maven.model.Car;
import com.hsz.maven.server.CarServer;
import com.hsz.maven.utils.Pager;
@Service(value ="carServer")
// 单例模式
@Scope("singleton")
public class CarServerImpl implements CarServer {
	@Autowired
	private CarDao carDao;
	
	@Override
	public void addCar(Car car) {
		carDao.addCar(car);

	}

	@Override
	public ArrayList<Car> showCar() {
		ArrayList<Car> carLists = carDao.showCar();
		return carLists;
	
	}

	@Override
	public void deleteCarById(int id) {
		 carDao.deleteCarById(id);
	}

	

	@Override
	public Car findCarByCarNumber(String carnumber) {
		return carDao.findCarByCarNumber(carnumber);
	}
	
	@Override
	public void updateCar(Car car,int id) {
		carDao.updateCar(car,id);
	}
	
	@Override
	public ArrayList<Car> selectCar(String type,String word) {
		ArrayList<Car> carLists = carDao.selectCar(type,word);
		return carLists;
	}

	@Override
	public int getTotalCount() {
		return carDao.getTotalCount();
	}
	
	@Override
	public List<Car> getPageCarLists(Pager pager) {
		return carDao.getPageCarLists(pager);
	}
}
