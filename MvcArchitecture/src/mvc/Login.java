package mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ResultBean;
import dao.loginDao;
import service.loginService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	Connection con;
	ResultSet rs = null;

	public Login() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login");
		try {
			System.out.println(5);
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pword");
			System.out.println(6);
			loginService loginService1 = new loginService();
			// service call
			ResultBean resultbean = loginService1.checkUser(uname, pass);
			System.out.println("res====" + resultbean.isLoggedIn());
			if (resultbean.isLoggedIn()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp"); //create homepage 
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
