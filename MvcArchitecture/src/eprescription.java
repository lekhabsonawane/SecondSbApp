import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @WebServlet("/eprescription")
 public class eprescription extends HttpServlet {
Connection con;       
  
    public eprescription() {
        super();
        // TODO Auto-generated constructor stub
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
			
			  final String DB_URL = "jdbc:mysql://localhost:3306/jpa7to8batch";
	    	  final String USER = "root";
	    	  final String PASS = "root";
			try {
				System.out.println(1);
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	//Class.forName("com.mysql.jdbc.Driver");
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
			con  = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println(2);
		}	catch(Exception e) {
			System.out.println(3+"msgggg="+e.getMessage());
			e.printStackTrace();
		}
			
			
			System.out.println(5);
		String uname=request.getParameter("PatientName");
		 
		
				String s2=request.getParameter("PatientAge");
				 

		String s3=request.getParameter("Email");
		
		String s4=request.getParameter("MobileNo");

		String s5=request.getParameter("AppointmentDate");
	

		System.out.println(6);
PreparedStatement pstmt=con.prepareStatement("insert into erx1 values(?,?,?,?,?)");
pstmt.setString(1, uname);
pstmt.setString(2,s2);
pstmt.setString(3, s3);
pstmt.setString(4, s4);
pstmt.setString(5,s5);


System.out.println(7);
pstmt.executeUpdate();
response.sendRedirect("eprescription.html");

		/*PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolor=greay text=black></body></html>");
		pw.println("hello"+" "+uname);*/
		
	}catch(Exception e) {
		System.err.print(e);
	}

}}
//pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
//title="Must contain at least one number and on
//e uppercase and lowercase letter and at least 8 or more characters"


