package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import DTO.ResultBean;

public class updateDao {

	public ResultBean  updateUser (ResultBean rb) {
		System.out.println("dao");
		
		try {
			Connection con;

			final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
			final String USER = "root";
			final String PASS = "root";

			System.out.println(1);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println(2);
			System.out.println(2);
			String uname=rb.getUname();
			String city=rb.getCity();
			String state=rb.getState();
			String country=rb.getCountry();
			String pword=rb.getPword();
			String user_name="ankita";

			
			PreparedStatement 	ps = con.prepareStatement("update patient2 set city = ?,state = ?,country = ?,pword= ? where user_name = ?");
			  ps.setString(1, uname);
			  ps.setString(1, city);
			  ps.setString(2, state);
			  ps.setString(3, country); 
			  ps.setString(4, pword);
			  ps.setString(5, user_name);
				int rs =  ps.executeUpdate();
			  

			
				
				if (rs!=0) {
					System.out.println("in if");
					//username = rs.getString("user_name");
					rb.setUname(user_name);
					rb.setUpdated(true);
					System.out.println("in out if");

				} else {
					System.out.println("else if");
					rb.setUpdated(false);

				}
				return rb;
		
			}	catch(Exception e) {
			System.out.println(3+"msgggg="+e.getMessage());
			e.printStackTrace();
		}
			System.out.println(5);
			return rb;
			
			
	}

		
	}

