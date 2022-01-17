package com.thoughtfocus.assessment4;

public class Tester {

	public static void main(String[] args) {
	StationeryShopDTO stationeryshopdto=new StationeryShopDTO();
	stationeryshopdto.setBrandname("Station");
	stationeryshopdto.setName("manoj_shop");
	stationeryshopdto.setPrice(15000.99);
	stationeryshopdto.setQuantity(1);
	stationeryshopdto.setSerno(1);
	stationeryshopdto.setType("any");
	
	StationeryShopDAO stationeryshopdao=new StationeryShopDAO();
	//System.out.println(stationeryshopdao.add(stationeryshopdto));
	stationeryshopdao.getall();
	}

}
