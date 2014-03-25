<%-- 
    Document   : associarProfessorturno
    Created on : Mar 1, 2014, 2:23:52 PM
    Author     : josechavarria
--%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<jsp:useBean id="divsbean" class="beans.HtmlCoder" scope="page"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if(actualsession.getUs()!=null){
    if(actualsession.getUs().getTipo().equals("admin")){ %>
<html>
    <head>

        <% out.print(divsbean.headindex(actualsession)); %>
         
    </head>
    <body>
<form id="novoTeste" method="post" onsubmit="processForm('novoTeste','inserirturno');return false;">
      
<fieldset>

<!-- Form Name -->
 
<legend>Novo Turno</legend>
<%
HashMap<Integer,String>professores= actualsession.getUs().ListaCarregarProfessores();
HashMap<Integer,String>ucCursos= actualsession.getUs().ListaUcCursos();


%>
<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="selectprofessor">Professor</label>
  <div class="controls">
    <select id="selectprofessor" name="selectprofessor" class="input-xlarge">
     <%

        Set<Integer> idsProfessores= professores.keySet();
        for(Integer idP : idsProfessores) {%>
        <option value="<% out.print(idP); %>"><% out.print(professores.get(idP)); %></option>
    <% }%>   
    </select>
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="descTurn">Descricao</label>
  <div class="controls">
    <input id="descTurn" name="descTurn" placeholder="Ex AlgaTp1EERC" class="input-xlarge" required="" type="text">
    
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="unidadec">Unidade Curricular</label>
  <div class="controls">
    <select id="unidadec" name="unidadec" class="input-xlarge">
      <%

        Set<Integer> idsuccursos= ucCursos.keySet();
        for(Integer iducc : idsuccursos) {%>
        <option value="<% out.print(iducc); %>"><% out.print(ucCursos.get(iducc)); %></option>
    <% }%>  
    </select>
  </div>
</div>



<!-- Button -->
<div class="control-group">
  <label class="control-label" for="saveprofessorTurno"></label>
  <div class="controls">
    <button  type="submit" class="btn btn-primary">Save</button>
  </div>
</div>
</fieldset>
    </form>  

    </body>
</html>
<% }else{
    response.sendRedirect(request.getContextPath());
        
        
        
        }
    }else{
    response.sendRedirect(request.getContextPath());
        
        
        
        }%>