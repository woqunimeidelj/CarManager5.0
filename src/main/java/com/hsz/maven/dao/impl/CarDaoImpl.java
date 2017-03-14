package com.hsz.maven.dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.hsz.maven.dao.CarDao;
import com.hsz.maven.model.Car;
import com.hsz.maven.utils.Pager;

@Repository(value ="carDao")
// 单例模式
@Scope("singleton")
public class CarDaoImpl implements CarDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCar(Car car) {
		Session session = sessionFactory.getCurrentSession(); 
		session.beginTransaction(); // 开启事物
		session.save(car);
		session.getTransaction().commit(); // 提交事物

	}

	@Override
	public ArrayList<Car> showCar() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Car");
		ArrayList<Car> carLists = (ArrayList<Car>) query.list();
		session.getTransaction().commit();
		return carLists;
	}

	@Override
	public void deleteCarById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Car car = (Car) session.get(Car.class, id);
		session.delete(car);
		session.getTransaction().commit();

	}

	@Override
	public void updateCar(Car car,int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(car);
		session.getTransaction().commit();

	}

	@Override
	public Car findCarByCarNumber(String carnumber) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Car WHERE carnumber =:carnumber");
		query.setParameter("carnumber",carnumber);
		Car car = (Car) query.uniqueResult();
		session.getTransaction().commit();
		return car;
	}
	
	@Override
	public ArrayList<Car> selectCar(String type,String word) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		ArrayList<Car> carLists;
		String hql = null;
		
		//
		if(type.equals("carnumber")){
			hql = "from Car where carnumber=:word";
		}else if(type.equals("phone")){
			hql = "from Car where phone=:word";
		}else{
			hql = "from Car where owner=:word";
		}
		Query query = session.createQuery(hql);
		query.setParameter("word", word);
		carLists = (ArrayList<Car>) query.list();
		
		session.getTransaction().commit();
		return carLists;
	}

	@Override
	public int getTotalCount() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		long count =  (long) session.createQuery("SELECT count(*) from Car").uniqueResult();
		session.getTransaction().commit();
		
		return (int) count;
		
	}
	
	@Override
	public List<Car> getPageCarLists(Pager pager) {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("FROM Car").setFirstResult(pager.getIStart()).setMaxResults(pager.getIStep());;
		List<Car> carLists = (List<Car>) query.list();
		session.getTransaction().commit();
		
		return carLists;

	}
}
