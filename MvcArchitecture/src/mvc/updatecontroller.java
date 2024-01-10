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
import service.updateService;


@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 Connection con;
	  
    public updatecontroller() {
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
		System.out.println("update");
		
		
		 
		
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
		updateService regService1=new updateService();
		
		ResultBean userUpdated=regService1. updateUser(rb);
		System.out.println("res====" + userUpdated.isUpdated());
		if (userUpdated.isUpdated()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp"); 
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.forward(request, response);
		}
			
		
	}catch(Exception e) {
		System.err.print(e);
	}

}}

