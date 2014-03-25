<%-- 
    Document   : inseriraluno
    Created on : Mar 2, 2014, 4:08:57 PM
    Author     : josechavarria
--%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.HtmlCoder"%>
<%@page import="beans.tabs"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.capitulos"%>
<%@page import="beans.uc"%>
<%@page import="beans.pergunta"%>
<%@page import="java.util.Iterator"%>

<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<jsp:useBean id="divsbean" class="beans.HtmlCoder" scope="page"/>
<%if(actualsession.getUs()!=null){
    if(actualsession.getUs().getTipo().equals("admin")){ %>
<!DOCTYPE html>
<html>
    <head>
     <% out.print(divsbean.headindex(actualsession)); %>
         
   
    </head>
    <body>
        <%  
     
        
        HashMap<Integer, String> cursos = actualsession.getUs().ListaCursos();%>
        <form class="form-horizontal" id="novoaluno" method="post" onsubmit="processForm('novoaluno','registaraluno');return false;"> 
            <fieldset> <!-- Form Name --> 
                <legend>Registar Utilizador</legend> <!-- Text input--> 
                <div class="control-group"> 
                    <label class="control-label" for="username">Username</label> 
                    <div class="controls">
                        <input id="username" name="username" placeholder="Username" class="input-xlarge" required="" type="text"> </div> 
                </div><div class="control-group"> 
                    <label class="control-label" for="nome">Nome</label> 
                    <div class="controls">
                        <input id="username" name="nome" placeholder="nome" class="input-xlarge" required="" type="text"> </div> 
                </div><div class="control-group"> 
                    <label class="control-label" for="apelido">Apelido</label> 
                    <div class="controls">
                        <input id="username" name="apelido" placeholder="apelido" class="input-xlarge" required="" type="text"> </div> 
                </div>
                
                
                
                <!-- Text input--> <div class="control-group">
                    <label class="control-label" for="n_aluno">Número do Aluno</label> 
                    <div class="controls"> <input type="number" id="n_aluno" name="n_aluno" placeholder="Número do Aluno" class="input-xlarge" required="" > </div> 
                </div> <!-- Password input-->
                <div class="control-group"> 
                    <label class="control-label" for="password">Password</label> 
                    <div class="controls"> <input id="password" name="password" placeholder="Password" class="input-xlarge" required="" type="password"> </div> 
                </div> <!-- Password input--> <div class="control-group"> 
                    <label class="control-label" for="password2">Password</label>
                    <div class="controls"> <input id="password2" name="password2" placeholder="Repita a Password" class="input-xlarge" required="" type="password"> </div> 
                </div> <!-- Text input--> <div class="control-group"> 
                    <label class="control-label" for="cc">Cartão de Cidadão</label>
                    <div class="controls"> <input id="cc" name="cc" placeholder="XXXXXXXXX X XXX" class="input-xlarge" required="" pattern="([0-9]{8}) ([0-9]) ([A-Z]{2}[0-9])" type="text"> </div>
                </div> <!-- Select Basic --> <div class="control-group"> 
                    <label class="control-label" for="curso">Curso</label>
                    <div class="controls">
                        <select id="curso" name="curso" class="input-xlarge"> 
                        <%

                            Set<Integer> idsCursos= cursos.keySet();
                            for(Integer idCursos : idsCursos) {%>
                            <option value="<%out.print(idCursos); %>"><% out.print(cursos.get(idCursos)); %></option>
                        <% }%> 
                        
                        </select> 
                    </div> </div> <!-- Button --> <div class="control-group"> <label class="control-label" for="send"></label> <div class="controls"> 
                                <button id="send" name="send" class="btn btn-primary">Registar</button> 
                            </div> </div> 
            </fieldset> 
        </form>
    </body>
</html>
<% }else{
    response.sendRedirect(request.getContextPath());
        
        
        
        }
    }else{
    response.sendRedirect(request.getContextPath());
        
        
    } %>
    