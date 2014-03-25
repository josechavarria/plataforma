<%-- 
    Document   : pergunta
    Created on : Jan 20, 2014, 12:17:50 AM
    Author     : josechavarria
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.uc"%>
<%@page import="beans.capitulos"%>
<%@page import="java.util.Iterator"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<!DOCTYPE html>
<% if(!actualsession.isvalid()){
response.sendRedirect("index.jsp");

}else{ %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Sign in &middot; Twitter Bootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="js/professor.js"></script>
             
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    </head>


    <body> 
        <div style="float : left">
            <%       actualsession.setListaUcs(new ArrayList<uc>());
                    actualsession.getLUcs(); 
               for(Iterator iterator = actualsession.getListaUcs().iterator(); iterator.hasNext(); ) {  
                    uc u= (uc) iterator.next(); 
                   %>
                   <label for="check<% out.print(u.getId());%>"> <% out.print(u.getDesc());%> </label> <input type="checkbox" value="<% out.print(u.getId());%>" id="check<% out.print(u.getId());%>"> 
                    <br>  
                   <%
                   
                }  %>
                <% actualsession.getLCapitulos(); 
    %>
               <select name="capitulos">
                   <%    for(Iterator iterator = actualsession.getListaCapitulos().iterator(); iterator.hasNext(); ) {  
                    capitulos c= (capitulos) iterator.next(); 
                   %>
                   
                    <option value="<% out.print(c.getId()); %>"><% out.print(c.getDesc()); %></option>
                   <%
                }  %>
               
                </select> 
              
             <applet name="DragMath" codebase="applet" code="Display.MainApplet.class" archive="DragMath.jar" width=540 height=333>
                                                            <param name=language value="en">
                                                                <param name=outputFormat value="Latex">
             </applet >

        </div>
 <div style="float: right">
      <form class="form" action="inserirPerguntasWS" target="_blank" method="POST">
          <div>
              <% actualsession.getLCapitulos(); 
    %>
               <select name="capitulos">
                   <%    for(Iterator iterator = actualsession.getListaCapitulos().iterator(); iterator.hasNext(); ) {  
                    capitulos c= (capitulos) iterator.next(); 
                   %>
                   
                    <option value="<% out.print(c.getId()); %>"><% out.print(c.getDesc()); %></option>
                   <%
                }  %>
               
                </select> 
                 
              
          </div>
               <div id="div0">
                   <h1> <span class="label label-default">   Pergunta: </span><h1>
               <textarea name="latex0" id="textArea0" onchange="refreshIt('0');">
                 </textarea>
               <img id="image0" src=""/></div> 
          <%
          int i=0;
          for(i=1;i<8;i++){
          %>
          <div id="div<% out.print(i); %>">
              <h1> <span class="label label-primary">Resposta <%out.print(i);%>:</span></h1>
              <textarea name="latex<%out.print(i);%>" id="textArea<%out.print(i);%>" 
               value="" ></textarea>
               <input type="radio" name="correta<% out.print(i); %>"
                id="respo<% out.print(i); %>" > 
               <br><img id="image<% out.print(i); %>"/></div>
          <%}
        
          %> 
          <div id="div9">
                   <h1> <span class="label label-default">   Dica: </span><h1>
               <textarea name="dica" id="textArea9"></textarea>
            </div> 
          <button class="btn btn-large btn-primary" align="right" type="submit">Submeter Resposta</button>
      </form>

          </div>
  </body>
</html>
<%}%>