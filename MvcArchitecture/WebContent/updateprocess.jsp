<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.cj.jdbc.Driver";%>
<%!String connectionUrl = "jdbc:mysql://localhost:3306/sakila";%>
<%!String userid = "root";%>
<%!String password = "root";
%>
<%
String uname = request.getParameter("uname");
String city=request.getParameter("city");
String state=request.getParameter("state");
String country=request.getParameter("country");
String pword=request.getParameter("pword");
if(uname != null)
{
	System.out.println("update2");

Connection con = null;
PreparedStatement ps = null;
//String personID = Integer.parseInt(uname);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(connectionUrl,userid,password);
System.out.println("update3");

String sql="Update patient2 set user_name=? set city=?,state=?,country=?,pword=? where user_name=+uname";
ps = con.prepareStatement(sql);

ps.setString(1,uname);
ps.setString(2, city);
ps.setString(3, state);
ps.setString(4, country);
ps.setString(5, pword);

int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
} 
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>