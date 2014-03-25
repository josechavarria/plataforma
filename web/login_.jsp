<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
import="beans.*"
import="java.sql.ResultSet"


<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<%

String username="",password="";

if(request.getParameter("username")!=null){
   username=request.getParameter("username");
}
if(request.getParameter("password")!=null){
    password=request.getParameter("password");
}

%>


<%
if(actualsession.login(username,password)){  
response.sendRedirect(request.getContextPath());}
else{
 
    response.sendRedirect("index.jsp?error=1");
}

%>


