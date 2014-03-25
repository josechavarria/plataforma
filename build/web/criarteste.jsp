<%-- 
    Document   : criarteste
    Created on : Mar 1, 2014, 9:29:01 PM
    Author     : josechavarria
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="divsbean" class="beans.HtmlCoder" scope="page"/>
<!DOCTYPE html>
<%
    if(actualsession.getUs()!=null){
    if(actualsession.getUs().getTipo().equals("professor")){ %>
<html>
    <head>
        <% out.print(divsbean.headindex(actualsession)); %>
         
   
    </head>
    <body>
        <%
HashMap<Integer,String> turnos= actualsession.getUs().ListaTurnosProfessor();
//HashMap<Integer,String>ucCursos= actualsession.getUs().ListaUcCursos();


%>
       <form id="novoTeste" method="post" onsubmit="processFormInserirTeste('novoTeste','inserirTestes');return false;">
<fieldset>

<!-- Form Name -->
<legend>Inserir Teste</legend>
<div class="control-group">
  <label class="control-label" for="descricao">Descricao</label>
  <div class="controls">
    <input id="descricao" type="text" name="descricao" placeholder=" Teste_1_alga_eerc_TP1" class="input-xlarge" required="" >
    
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="numeroQuestoes">Numero de Questões</label>
  <div class="controls">
    <input id="numeroQuestoes" type="number" name="numeroQuestoes" placeholder="" class="input-xlarge" value="20" required="" >
    
  </div>
</div>


<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="cotacao">Cotação</label>
  <div class="controls">
    <input id="cotacao" type="number" name="cotacao" placeholder="" value="1" class="input-small" >
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="desconto">Desconto</label>
  <div class="controls">
      <input id="desconto" type="number" name="desconto" placeholder="" class="input-small" required="" value="0.25" >
    
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="turnoalvo">Turno</label>
  <div class="controls">
    <select id="turnoalvo" required="" name="turnoalvo" class="input-xxlarge">
     <option></option>
        <%
   
        Set<Integer> idsProfessores= turnos.keySet();
        for(Integer idTurnos : idsProfessores) {%>
        <option value="<% out.print(idTurnos); %>"><% out.print(turnos.get(idTurnos)); %></option>
    <% }%>   
    </select>
  </div>
</div>

<!-- Multiple Checkboxes (inline) -->

<div id="capitulosArea" class="control-group">
  
 
</div>
<!-- Button -->
<div class="control-group">
  <label class="control-label" for="submitTeste"></label>
  <div class="controls">
    <button id="submitTeste" type="submit" value="Submit" name="submitTeste"  class="btn btn-primary">Criar</button>
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