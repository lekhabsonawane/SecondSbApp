/*package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ValidateDao {
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
		PreparedStatement pstmt = con.prepareStatement("select * from  patient2 where user_name=?");
		String uname;
		pstmt.setString(1, uname);
	
}catch(Exception e) {
	System.out.println(3+"msgggg="+e.getMessage());
	

	e.printStackTrace();
}
	
}
}

*/