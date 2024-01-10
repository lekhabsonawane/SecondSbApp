package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ResultBean;
import service.deleteService;


@WebServlet("/deleteController")
public class deleteController extends HttpServlet {
	 Connection con;
	  
	    public deleteController() {
	        super();
	       
	    }

		
		public void init(ServletConfig config) throws ServletException {
		}

		
		public void destroy() {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();

			}
			
		}

		
		

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			System.out.println("delete");
			
			
					String city=request.getParameter("city");
					 

			String state=request.getParameter("state");
			
			String country=request.getParameter("Country");

			String pword=request.getParameter("pword");
		
			System.out.println(6);
			ResultBean rb=new ResultBean();
			//rb.setUname(uname);
			rb.setCity(city);
			rb.setState(state);
			
			rb.setCountry(country);
			rb.setPword(pword);
			deleteService regService1=new deleteService();
			
			ResultBean userDeletedted=regService1.deleteUser(rb);
			System.out.println("res====" + userDeletedted.isDeleated());
			if (userDeletedted.isDeleated()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("homepage1.jsp"); 
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.forward(request, response);
			}
				
			
		}catch(Exception e) {
			System.err.print(e);
		}

	}}

