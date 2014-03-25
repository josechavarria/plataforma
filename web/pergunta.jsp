<%-- 
    Document   : pergunta
    Created on : Jan 20, 2014, 12:17:50 AM
    Author     : josechavarria
--%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"
        import="beans.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<jsp:useBean id="divsbean" class="beans.HtmlCoder" scope="page"/>
<jsp:useBean id="pergunta" class="beans.pergunta" scope="page"/>
 <% 
if(!actualsession.isvalid() && !actualsession.getUs().getTipo().equals("aluno")){
   response.sendRedirect(request.getContextPath());
} else { 
 %>

<!DOCTYPE html>
<html lang="en">
  <head>
   
    <% out.print(divsbean.headindex(actualsession)); %>
    
  
     </head>
     
    <% pergunta=actualsession.getCaderno().getPerguntaAtual(); %>  
 
     <body >


    <div class="container">
        <div><img src="DispImage?latex=<% out.print(StrinUtils.encode(pergunta.getLatexCode())); %>"></div>
            <%
          int i=0;
          for(i=0;i<4;i++){
          %>
        <div id="div<%out.print(i);%>"> <img  src="DispImage?latex= <% out.write(StrinUtils.encode(pergunta.getListaRespostas().get(i).getLatexCode())); %>">      
              <input  name="resposta<% out.print(i); %>" type="radio"  id="cresposta<%out.print(i);%>"  <% if(pergunta.getTentativas()>=2 ){%> disabled="true" <% }%> style="float: right"></div>
          <%
          }
          %> 
          <span id="dica" style="display: none " ><% out.print(pergunta.getDica()); %></span>
           <p><a style= " float: left" id="bFinalizar" class="btn btn-primary btn-lg" role="button"  >Finalizar</a>
               <a style=" <% if( pergunta.getTentativas()>=2 ){%> display : block; <% }else{%> display: none; <% }%>float: right" id="bSeguinte" class="btn btn-primary btn-lg" role="button"  >Seguinte</a>
            </p>
            
       
          <p>&nbsp;</p>
               

    </div> <!-- /container -->

</body>
</html>


<%

        
}%>
