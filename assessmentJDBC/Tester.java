package com.thoughtfocus.assessment4;

public class Tester {

	public static void main(String[] args) {
	StationeryShopDTO stationerymanoj=new StationeryShopDTO();
	stationerymanoj.setBrandname("Station1");
	stationerymanoj.setName("manoj_shop");
	stationerymanoj.setPrice(15000.99);
	stationerymanoj.setQuantity(1);
	stationerymanoj.setSerno(1);
	stationerymanoj.setType("any");
	
	StationeryShopDTO stationerymithun=new StationeryShopDTO();
	stationerymithun.setBrandname("Station2");
	stationerymithun.setName("kiran_shop");
	stationerymithun.setPrice(15000.99);
	stationerymithun.setQuantity(1);
	stationerymithun.setSerno(2);
	stationerymithun.setType("any");
	
	StationeryShopDAO stationeryshopdao=new StationeryShopDAO();
	System.out.println(stationeryshopdao.add(stationerymanoj));
	//stationeryshopdao.getall();
	System.out.println(stationeryshopdao.add(stationerymithun));
	try{
		stationeryshopdao.deleteBySerialNumber(1);
	}
	catch (deleteException e) {
		e.getmessage();
	}
	stationeryshopdao.updatePriceByBrandName(2000.99, "Station1");
	
	}

}
