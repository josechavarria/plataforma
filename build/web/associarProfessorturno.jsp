<%-- 
    Document   : associarProfessorturno
    Created on : Mar 1, 2014, 2:23:52 PM
    Author     : josechavarria
--%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <meta charset="UTF-8">
        <title>Plataforma de Apoio a Matemática</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Le styles -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/normalize.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <script src="js/bootstrap-select.js" type="text/javascript"></script>
        <script src="js/bootstrap-select.min.js" type="text/javascript"></script>
        <link href="css/bootstrap-select.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery.min.js"></script> 
        <script type="text/javascript" src="js/tab.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.base64.js"></script>
        <script type="text/javascript" src="js/editor.js"></script>
        <script type="text/javascript" src="js/professor.js"></script>

        <script>
          
            
            
  
        </script>
         
    </head>
    <body>
       
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
    <button id="saveprofessorTurno" name="saveprofessorTurno" class="btn btn-primary">Save</button>
  </div>
</div>

</fieldset>


    </body>
</html>
