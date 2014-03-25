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
    <script src="js/provaavaliacao.js"></script>
  
     </head>
     
    <% 
    if(request.getParameter("testeiniciar")!=null){
           actualsession.getUs().setTesteExecutar(new teste(Integer.parseInt(request.getParameter("testeiniciar"))));
       }
    
    
    if(actualsession.getUs().getTesteExecutar()==null){
        %><body> <%
         out.print(divsbean.escolherteste(actualsession));
         %></body> <%
    }else{
    
    %>
     
    <% pergunta=actualsession.getUs().getTesteExecutar().getEnunciado().get(actualsession.getUs().getTesteExecutar().getIndexAtual()); %>  
 
     <body >
       

    <div class="container">
        <div><img src="DispImage?latex=<% out.print(StrinUtils.encode(pergunta.getLatexCode())); %>"></div>
            <%
          int i=0;
          for(i=0;i<4;i++){
          %>
        <div id="div<%out.print(i);%>"> <img  src="DispImage?latex= <% out.write(StrinUtils.encode(pergunta.getListaRespostas().get(i).getLatexCode())); %>">      
              <input  name="resposta" id="respostaT<% out.print(i); %>" <%if(pergunta.getRespostaDada()==i){%> checked="true" <%}%>type="radio"  style="float: right"></div>
          <%
          }
          %> <div class="row-fluid show-grid">
                   <div class="span4"> <a style=" <% if( actualsession.getUs().getTesteExecutar().getIndexAtual()>0){%> display : block; <% }else{%> display: none; <% }%>float: left" id="bPanterior" class="btn btn-primary btn-lg" role="button"  >Anterior</a>
             </div><div style=" text-align: center;" class="span4"><a  id="bFinalizarProva" class="btn btn-primary btn-lg" role="button"  >Finalizar</a>
               </div>
           
              <div class="span4">  <a style=" <% if( actualsession.getUs().getTesteExecutar().getIndexAtual()<(actualsession.getUs().getTesteExecutar().getNumeroQuestoes()-1) ){%> display : block; <% }else{%> display: none; <% }%>float: right" id="bPseguinte" class="btn btn-primary btn-lg" role="button"  >Seguinte</a>
           </div>
           
            </div>
        
        <div id="messages"></div>
          <p>&nbsp;</p>
               

    </div> <!-- /container -->
<% }%>
</body>
</html>


<%

        
}%>
