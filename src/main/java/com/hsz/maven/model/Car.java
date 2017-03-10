package com.hsz.maven.model;

public class Car {

	private int id;
	private String carnumber; // 车牌号码
	private String carname; // 车辆类型
	private String owner; // 车主姓名
	private String phone; // 联系电话
	
	public Car() {
		
	}

	public Car(String carnumber, String carname, String owner, String phone) {
		
		this.carnumber = carnumber;
		this.carname = carname;
		this.owner = owner;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carnumber=" + carnumber + ", carname=" + carname + ", owner=" + owner + ", phone="
				+ phone + "]";
	}
	
}
