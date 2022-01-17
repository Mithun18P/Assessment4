package com.thoughtfocus.assessment4;

public class StationeryShopDTO {
	private String name;
	private String type;
	private String brandname;
	private Double price;
	private int quantity;
	private int serno;
	
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getBrandname() {
		return brandname;
	}
	public Double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getSerno() {
		return serno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setSerno(int serno) {
		this.serno = serno;
	}
}
