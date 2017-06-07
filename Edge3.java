package com.xiongqi.huawei;

public class Edge3 {
	
	private int ID;
	private int v;
	private int w;   //v->w
	private int bandWidthSize;
	private int rentPrice;
  
	public Edge3(int ID,int v,int w, int bandWidthSize, int rentPrice) {
		super();
		this.ID=ID;
		this.v=v;
		this.w = w;  //v->w
		this.bandWidthSize = bandWidthSize;
		this.rentPrice = rentPrice;
	}
	
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getBandWidthSize() {
		return bandWidthSize;
	}
	public void setBandWidthSize(int bandWidthSize) {
		this.bandWidthSize = bandWidthSize;
	}
	public int getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	

	

}
