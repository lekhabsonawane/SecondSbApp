<%@page import="service.Utils"%>
<%
String data1 = request.getParameter("userName");
String res = Utils.appendPrefix(data1);
out.print(res);
%>
