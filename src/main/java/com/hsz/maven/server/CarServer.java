package com.hsz.maven.server;

import java.util.ArrayList;

import com.hsz.maven.model.Car;

public interface CarServer {

	public  void addCar(Car car);
	
	public ArrayList<Car> showCar();
	
	public void deleteCarById(int id);
	
	void updateCar(Car car,int id);// 抽象方法
	
	public  Car findCarByCarNumber(String carnumber);

	ArrayList<Car> selectCar(String type, String word);
}