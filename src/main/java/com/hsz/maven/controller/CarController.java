package com.hsz.maven.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsz.maven.model.Car;
import com.hsz.maven.server.CarServer;
import com.hsz.maven.utils.Pager;

@Controller
@RequestMapping("car")
public class CarController {
	
	private int mCurrentPager = 1; //当前页
	
	@Autowired
	private CarServer carServer;
	
	
	@RequestMapping("/add")
	public String login(Model model){
		return "/car/add_car";
	}
	
	@RequestMapping("/add_two")
	public String addCar(Car car,Model model) {
		if(carServer.findCarByCarNumber(car.getCarnumber()) == null){
			carServer.addCar(car);
		return "redirect:/car/show.do";
		}else{
			model.addAttribute("message", "添加的车辆信息已存在！");
			return "redirect:/car/add.do";
		}
	}
	
	@RequestMapping("/show")
	public String getAllCar(Integer page,Map<String, Object> map) {
//		ArrayList<Car> carLists = carServer.showCar();
//		model.addAttribute("carLists", carLists);
//		return "/list_car";
		
		if(page != null && page > 0){
			mCurrentPager = page;
		}
		
		Pager pager = new Pager(carServer.getTotalCount(),mCurrentPager);
		pager.setUrl("http://localhost:8080/CarManagerMaven/car/show.do");
		
		map.put("url", pager.getPageStr());
		
		List<Car> carLists = carServer.getPageCarLists(pager);
		map.put("carLists", carLists);

		return "/car/list_car";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		carServer.deleteCarById(id);
		return "redirect:/car/show.do";
	}
	
	@RequestMapping("/update")
	public String update(Car car,Integer id,Model model) {
	
		carServer.updateCar(car, id);
		return "redirect:/car/show.do";
		
	}
	
	@RequestMapping("/find")
	public String find(String type,String word,String number,Model model){
		
		// 判断为空进入修改否则进入列表
		if(type == null && word==null){
			Car car = null;
			type = "carnumber";
			word = number;
			ArrayList<Car> carLists = carServer.selectCar(type,word);
			
			if(carLists != null && carLists.size()>0){
				car = carLists.get(0); // 得到唯一值
			}
			model.addAttribute("car",car);
			return "/car/update_car";
			
		}else{
			
			ArrayList<Car> carLists = carServer.selectCar(type,word);
			for(Car car :carLists)
			car = carLists.get(0);
			model.addAttribute("carLists", carLists);
			return "/car/list_car";
		}
	
	}
}
