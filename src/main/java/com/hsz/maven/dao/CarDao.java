package com.hsz.maven.dao;

import java.util.ArrayList;
import java.util.List;

import com.hsz.maven.model.Car;
import com.hsz.maven.utils.Pager;

public interface CarDao {

	public  void addCar(Car car);
	
	public  ArrayList<Car> showCar();
	
	public List<Car> getPageCarLists(Pager pager); // 分页技术
	
	public void deleteCarById(int id);
	
	public  void updateCar(Car car, int id);// 抽象方法
	
	public  Car findCarByCarNumber(String carnumber);

	public  ArrayList<Car> selectCar(String type, String word);
	
	public int getTotalCount(); // 记录个数
}
