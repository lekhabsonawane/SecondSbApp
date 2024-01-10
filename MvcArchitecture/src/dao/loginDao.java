package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ResultBean;

public class loginDao {
	Connection con;

	public ResultBean getUser(String uname, String pass) {
		// db login
			System.out.println("dao");
			ResultBean rb = new ResultBean();
		
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
			final String USER = "root";
			final String PASS = "root";

			System.out.println(1);
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println(2);
			PreparedStatement pstmt = con.prepareStatement("select * from  patient2 where user_name=? and pword=?");
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			System.out.println("cred:"+uname+"-"+pass);
			ResultSet rs = pstmt.executeQuery();
			Object String;
			String username = "";
			
			
			
			if (rs.next()) {
				System.out.println("in if");
				username = rs.getString("user_name");
				rb.setUname(username);
				rb.setLoggedIn(true);
				System.out.println("in out if");

			} else {
				System.out.println("else if");
				rb.setLoggedIn(false);

			}
			return rb;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return rb;

	}

}