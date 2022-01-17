package com.thoughtfocus.assessment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StationeryShopDAO {
	Connection con =getconn();
	PreparedStatement prepstat;
	  boolean add(StationeryShopDTO dto) {
		try {
			prepstat=con.prepareStatement("insert into StationaryShop values(?,?,?,?,?,?)");
			prepstat.setString(3,dto.getBrandname());
			prepstat.setString(2, dto.getType());
			prepstat.setString(1, dto.getName());
			prepstat.setDouble(4, dto.getPrice());
			prepstat.setInt(5, dto.getQuantity());
			prepstat.setInt(6, dto.getSerno());
			prepstat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(prepstat!=null) {
		return true;
		}
		else {
		return false;
		}
	 }
	  
	  void getall() {
		  final String select = "select * from StationaryShop";
		  ResultSet res;
		  try(PreparedStatement prestat=con.prepareStatement(select);)
		  {
			  res=prestat.executeQuery();
			String name=res.getString("name");
			String type=res.getString("type");
			Double price=res.getDouble("price");
			String brandname=res.getString("brandname");
			int qu=res.getInt("quantity");
			int sr=res.getInt("serno");
			System.out.println("Name :"+name+"  Brand:"+brandname+"  "
					+ "Price :"+price+"  type :"+type+"  quantity:"+qu+"  serno:"+sr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
		
	static Connection getconn() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assess4", "Mithun", "Mit@1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
