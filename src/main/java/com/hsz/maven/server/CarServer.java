package com.hsz.maven.server;

import java.util.ArrayList;
import java.util.List;

import com.hsz.maven.model.Car;
import com.hsz.maven.utils.Pager;

public interface CarServer {

	public  void addCar(Car car);
	
	public ArrayList<Car> showCar();
	
	public List<Car> getPageCarLists(Pager pager);
	
	public void deleteCarById(int id);
	
	void updateCar(Car car,int id);// 抽象方法
	
	public  Car findCarByCarNumber(String carnumber);

	ArrayList<Car> selectCar(String type, String word);
	
	public int getTotalCount();
}