<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<form action="deleteController">
<%
String uname = request.getParameter("uname");
out.print("Hello"+" "+uname+" "+"welcome");
String driver ="com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/sakila";

String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>

<html>
<body bgcolor=aquamarine text=black>

<h1>deleted Users data</h1>

<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="Select * from patient2 where user_name= 'ankita'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
City:<td border="1"><%=resultSet.getString("city") %></td><br>


State:<td><%=resultSet.getString("state") %></td><br>


Country:<td><%=resultSet.getString("country") %></td><br>

Pword:<td><%=resultSet.getString("pword") %></td><br>
<table>
<tr><td>City:</td><td><input type="text" name="city" value="<%=resultSet.getString("city")%>"></td></tr><br>
<tr><td>State:</td><td><input type="text" name="state" value="<%=resultSet.getString("state")%>"></td></tr><br>
<tr><td>Country:</td><td><input type="text" name="country" value="<%=resultSet.getString("country")%>"></td></tr><br>
<tr><td>Pword:</td><td><input type="text" name="pword" value="<%=resultSet.getString("pword")%>"></td></tr><br>
</table>

<input type=submit value=delete><br>

</tr>

<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 
</form>
</body>
</html>




