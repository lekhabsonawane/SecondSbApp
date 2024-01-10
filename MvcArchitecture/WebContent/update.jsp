
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String uname = request.getParameter("uname");
String driver = "com.mysql.cj.jdbc.Driver";
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
<%
try{
	System.out.println("update");
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
System.out.println("update1");

String sql ="select * from patient2 where user_name=?";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	System.out.println("update4");

%>
<!DOCTYPE html>
<html>
<body>
<h1>Update data from database in jsp</h1>
<form method="post" action="updateprocess.jsp">
<input type="hidden" name="uname" value="<%=resultSet.getString("uname") %>">
<input type="text" name="uname" value="<%=resultSet.getString("uname") %>">

<br>
<table>
<tr><td>City:</td><td><input type="text" name="city" value="<%=resultSet.getString("city")%>"></td></tr><br>
<tr><td>State:</td><td><input type="text" name="state" value="<%=resultSet.getString("state")%>"></td></tr><br>
<tr><td>Country:</td><td><input type="text" name="country" value="<%=resultSet.getString("country")%>"></td></tr><br>
<tr><td>Pword:</td><td><input type="text" name="pword" value="<%=resultSet.getString("pword")%>"></td></tr><br>
</table>
<input type=submit value=update><br>
</tr>
</table>

</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>