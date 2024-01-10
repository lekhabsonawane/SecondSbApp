package mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ResultBean;
import dao.regDao;
import service.loginService;
import service.regService;

@WebServlet("/reg")
public class regcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;


       Connection con;
  
    public regcontroller() {
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
			System.out.println("j");
			
		String uname=request.getParameter("uname");
		 
		
				String city=request.getParameter("city");
				 

		String state=request.getParameter("state");
		
		String Country=request.getParameter("Country");

		String pword=request.getParameter("pword");
String filename=request.getParameter("filename");

		System.out.println(6);
		ResultBean rb=new ResultBean();
		rb.setUname(uname);
		rb.setCity(city);
		rb.setState(state);
		
		rb.setCountry(Country);
		rb.setPword(pword);
		rb.setFilename(filename);
		regService regService1=new regService();
		
		ResultBean userInserted=regService1.registerUser(rb);
		System.out.println("res====" + userInserted.isRegistered());
		if (userInserted.isRegistered()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("homepage1.jsp"); //create homepage 
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.html");
			dispatcher.forward(request, response);
		}
			
		
	}catch(Exception e) {
		System.err.print(e);
	}

}}



