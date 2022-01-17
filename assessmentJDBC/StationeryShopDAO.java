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
		finally {
			try {
				prepstat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
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
		  try(PreparedStatement prestat=con.prepareStatement(select); ResultSet res=prestat.executeQuery();)
		  {
			String name=res.getString("name");
			String type=res.getString("type");
			Double price=res.getDouble("price");
			String brandname=res.getString("brandanme");
			int qu=res.getInt("quantity");
			int sr=res.getInt("serno");
			System.out.println("Name :"+name+"  Brand:"+brandname+"  "
					+ "Price :"+price+"  type :"+type+"  quantity:"+qu+"  serno:"+sr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  void deleteBySerialNumber(int serno) throws deleteException {
		  String Delete="delete from StationaryShop where serno =? ";
		  PreparedStatement prestat = null;
		  if(serno<10) {
			  try {
				  prestat=con.prepareStatement(Delete);
				  prestat.setInt(1,serno);
				  prestat.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  finally {
				  try {
					prestat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }  
		  }
		  else {
			  throw new deleteException("not in range");
		  }
		  

	  }
	  
	  void updatePriceByBrandName(Double price,String brandname) {
		  final String update = "update StationaryShop set price=? where brandanme=?";
		  try(PreparedStatement prestat=con.prepareStatement(update);) {
			prestat.setDouble(1, price);
			prestat.setString(2, brandname);
			prestat.execute();
			
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
