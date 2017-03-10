package com.hsz.maven.dao;

import java.util.ArrayList;

import com.hsz.maven.model.Car;

public interface CarDao {

	public  void addCar(Car car);
	
	public  ArrayList<Car> showCar();
	
	public void deleteCarById(int id);
	
	public  void updateCar(Car car, int id);// 抽象方法
	
	public  Car findCarByCarNumber(String carnumber);

	public  ArrayList<Car> selectCar(String type, String word);
	
}
