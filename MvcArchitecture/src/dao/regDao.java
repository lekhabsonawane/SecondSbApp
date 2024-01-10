package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.ResultBean;

public class regDao {

	public ResultBean registerUser(ResultBean rb) {
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
			String uname=rb.getUname();
			String city=rb.getCity();
			String state=rb.getState();
			String Country=rb.getCountry();
			String pword=rb.getPword();
			String filename=rb.getFilename();
			PreparedStatement pstmt=con.prepareStatement("insert into students values(?,?,?,?,?,?)");
			pstmt.setString(1, uname);
			pstmt.setString(2,city);
			pstmt.setString(3, state);
			pstmt.setString(4, Country);
			pstmt.setString(5,pword);
			pstmt.setString(6,filename);



			System.out.println(7);
			int rs = pstmt.executeUpdate();
			Object String;
			String username = "";
			
			
			if (rs!=0) {
				System.out.println("in if");
				//username = rs.getString("user_name");
				rb.setUname(username);
				rb.setRegistered(true);
				System.out.println("in out if");

			} else {
				System.out.println("else if");
				rb.setRegistered(false);

			}
			return rb;
	/*if(i!=0) {
		System.out.println("Database inserted");
	}	*/
		}	catch(Exception e) {
		System.out.println(3+"msgggg="+e.getMessage());
		e.printStackTrace();
	}
		System.out.println(5);
		return rb;
		
		
}

	
}

