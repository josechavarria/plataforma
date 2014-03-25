<%-- 
    Document   : inicio_teste
    Created on : Jan 30, 2014, 1:29:52 AM
    Author     : josechavarria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="divsbean" class="beans.HtmlCoder" scope="page"/>
<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<!DOCTYPE html>

<html lang="en">
<head>
    <% out.print(divsbean.headindex(actualsession)); %>
         

 
    </head>
    <body>
        
<div class="jumbotron">
<div class="container" >
        <h1>Bem-vindo ao teste</h1>
        <p> iPara iniciar o teste por favor carregue no bot&atilde;o</p>
        <p><a  id="bSeguinte" class="btn btn-primary btn-lg" role="button"  >Iniciar »</a></p>
      </div>

</div>
    </body>
   
    
</html>
