<%@page import="service.Utils1"%>
<%
String data1 = request.getParameter("msg");
String res = Utils1.validateUserName(data1);
out.print(res);
%>
