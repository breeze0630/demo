package xt.lb.dto;

import java.util.ArrayList;

import xt.lb.entity.UserCar;

public class GoodsList {

	private String carName;
	private ArrayList<UserCar> list;

	public ArrayList<UserCar> getList() {
		return list;
	}

	public void setList(ArrayList<UserCar> list) {
		this.list = list;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	
}
