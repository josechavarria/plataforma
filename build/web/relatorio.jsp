<%-- 
    Document   : relatorio
    Created on : Feb 12, 2014, 6:14:06 PM
    Author     : josechavarria
--%>

<%@page import="beans.StrinUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.pergunta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<!DOCTYPE html>


 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio de atividade da sess&atilde;o</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="css/normalize.css" rel="stylesheet">
    <!-- Le styles -->

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/jumbotron.css" rel="stylesheet">
  
     </head>
     
    <body>
 
     <% 
        ArrayList <pergunta> perguntas= actualsession.getCaderno().getEnunciado();
         for(pergunta p: perguntas) {%>
              
   <div class="panel panel-primary" style=" page-break-after: always; ">
       <div class="panel-heading"> <h3><% out.print("Aluno: "+actualsession.getUs().getNome()+" "+actualsession.getUs().getApelido()+" N&uacute;mero: "+actualsession.getUs().getnALuno()+" Curso: "+actualsession.getUs().getCursoAluno().getdescr());  %>  
           </h3></div>
  <div class="panel-body">
        
            <div><img alt="pergunta" src="DispImage?latex=<% out.print(StrinUtils.encode(p.getLatexCode())); %>"></div>
            <%
          int i=0;
          for(i=0;i<4;i++){
          %>
            <div <% if(p.getRespostaDada()==i) {
                             if( p.getListaRespostas().get(p.getIndexRespostas()[i]).isCorreta()){
                             %> style="background-color : #00FF00; "<%
                                }else{
                                    %> style="background-color : red;" <%
                                } 
                    
          }
          %>   
          id="div<%out.print(i);%>"> <img  alt="resposta" src="DispImage?latex= <% out.print(StrinUtils.encode(p.getListaRespostas().get(p.getIndexRespostas()[i]).getLatexCode())); %>">       
        
       </div> <% }%>
        
         
     <% }%>
  </div>
</div>

        
    
        </body>
</html>


     
     
     
 
 
    
