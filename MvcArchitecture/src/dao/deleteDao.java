package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import DTO.ResultBean;

public class deleteDao {
	public ResultBean  deleteUser (ResultBean rb) {
		System.out.println("deletedao");
		
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
		
			String user_name="ankita";
			
			
			PreparedStatement 	ps = con.prepareStatement("delete from patient2 where user_name =?");
			 
		  ps.setString(1, user_name);
				int rs =  ps.executeUpdate();
				if (rs!=0) {
					System.out.println("in if");
					//username = rs.getString("user_name");
					rb.setUname(user_name);
					rb.setDeleated(true);
					System.out.println("in out if");

				} else {
					System.out.println("else if");
					rb.setDeleated(false);
					System.out.println("data deleted successfully");
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
