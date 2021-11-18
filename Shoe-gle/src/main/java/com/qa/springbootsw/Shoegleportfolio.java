package com.qa.springbootsw;

public class Shoegleportfolio {

	private long shoeid;
	private String brand;
	private String sillouhette;
	private String colourway;
	private int size;
	private boolean collab;
	private double retailPrice;
	private double aftermarketPrice;
	
	
	public Shoegleportfolio(long shoeid, String brand, String sillouhette, String colourway, int size,boolean collab, double retailPrice, double aftermarketPrice) {
		super();
		this.shoeid = shoeid;
		this.brand = brand;
		this.sillouhette = sillouhette;
		this.colourway = colourway;
		this.size = size;
		this.collab = collab;
		this.retailPrice = retailPrice;
		this.aftermarketPrice = aftermarketPrice;
		// TODO Auto-generated constructor stub
	}
	
	public Shoegleportfolio(String brand, String sillouhette, String colourway, int size,boolean collab, double retailPrice, double aftermarketPrice) {
		super();
		this.brand = brand;
		this.sillouhette = sillouhette;
		this.colourway = colourway;
		this.size = size;
		this.collab = collab;
		this.retailPrice = retailPrice;
		this.aftermarketPrice = aftermarketPrice;
		// TODO Auto-generated constructor stub
	}

	public long getShoeid() {
		return shoeid;
	}

	public void setShoeid(long shoeid) {
		this.shoeid = shoeid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSillouhette() {
		return sillouhette;
	}

	public void setSillouhette(String sillouhette) {
		this.sillouhette = sillouhette;
	}

	public String getColourway() {
		return colourway;
	}

	public void setColourway(String colourway) {
		this.colourway = colourway;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isCollab() {
		return collab;
	}

	public void setCollab(boolean collab) {
		this.collab = collab;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getAftermarketPrice() {
		return aftermarketPrice;
	}

	public void setAftermarketPrice(double aftermarketPrice) {
		this.aftermarketPrice = aftermarketPrice;
	}
	
	
}
