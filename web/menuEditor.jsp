<%@page import="java.util.ArrayList"%>
<%@page import="beans.uc"%>
<%@page import="beans.divs"%>
<%@page import="beans.capitulos"%>
<%@page import="java.util.Iterator"%>
<%@page import="beans.pergunta"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<jsp:useBean id="pergunta" class="beans.pergunta" scope="request" />
<% if( actualsession.isvalid()  ){ %>
<html lang="en">
    <head>
    <% out.print((new divs( )).headindex(actualsession)); %>
     
</head>
  <body>
        
       
      <% 
  if(actualsession.getPerguntaAlvo()==null){
                actualsession.setPerguntaAlvo(new pergunta());
                actualsession.getPerguntaAlvo().novaPerguntaVazia();
                }
out.print((new divs()).MenuEditor(actualsession)); %>
        
    </body>
</html>
<%}else{

response.sendRedirect(request.getContextPath());

} %>