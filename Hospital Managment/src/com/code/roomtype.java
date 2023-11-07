package com.code;

public enum roomtype {

	
	
	GENERAL(2000),SPECIAL(5000),SEMISPECIAL(3000),ICU(7000);
	
	private int cost;

	private roomtype(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	
	
	
	private boolean equal(Object obj) {
		if(obj instanceof roomtype) {
			roomtype r1=(roomtype)obj;
			return this.cost==r1.cost;
		}
return false;
	}
	
	
}
