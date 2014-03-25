
<%@page import="beans.cadernoExercicios"%>
<%@page import="beans.HtmlCoder"%>
<%@page import="beans.tabs"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.capitulos"%>
<%@page import="beans.uc"%>
<%@page import="beans.pergunta"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="actualsession" class="beans.session" scope="session"/>
<jsp:useBean id="divsbean" class="beans.HtmlCoder" scope="page"/>
<!DOCTYPE html>

<html lang="en">
<head>
    <% out.print(divsbean.headindex(actualsession)); %>
         
     
</head>
<body>
    <% if(actualsession.isvalid()){ 
            ArrayList<tabs> t= new ArrayList<tabs>();
            tabs tab;
                
            if(actualsession.getUs().getTipo().equals("professor")){
                  if(actualsession.getPerguntaAlvo()==null){
                actualsession.setPerguntaAlvo(new pergunta());
                actualsession.getPerguntaAlvo().novaPerguntaVazia();
                }
                 tab= new tabs(divsbean.MenuEditor(actualsession),"Inserir",0,"Inserir Formulas");
                t.add(tab);
                tab= new tabs(divsbean.divInserirTeste(),"InserirT",0,"Inserir Testes");
                t.add(tab);
                tab= new tabs(divsbean.estadoteste(actualsession),"controlarT",0,"Alterar Visibilidade de testes");
                t.add(tab);
                 tab= new tabs(divsbean.relatorioAtividade(actualsession),"relatorioa",0,"Relatório por Turno");
                t.add(tab);
                tab= new tabs(divsbean.relatorioTeste(actualsession),"pautaA",0,"Pautas de Avaliação");
                t.add(tab);
             
                //tabs(String content, String name, int id, String desc)
            }else if(actualsession.getUs().getTipo().equals("admin")){
                
                tab= new tabs(divsbean.divInserirTurno(),"Turnos",0,"Turnos");
                t.add(tab);
                 tab= new tabs(divsbean.divInserirALuno(),"InserirA",0,"Inserir Alunos");
                t.add(tab);
                tab= new tabs(divsbean.divInserirProfessor(),"InserirP",0,"Inserir Professores");
                t.add(tab);
                
            }else if(actualsession.getUs().getTipo().equals("aluno")){
                
                tab= new tabs(divsbean.divResponderPerguntasCaderno(actualsession),"Caderno",0,"Caderno de Exercicios");
                actualsession.setCaderno(new cadernoExercicios());
                t.add(tab);
                tab= new tabs(divsbean.provaAvaliacao(),"provaA",0,"Provas de Avaliação");
                actualsession.setCaderno(new cadernoExercicios());
                t.add(tab);
                
                 
            }
            tab= new tabs(divsbean.mudarPassword(),"AlterarPassword",0,"Mudar Password");
                t.add(tab);
            out.print(divsbean.tabNavigator(t)); 
    }else { 
       %> 
    
       <script>
          function hashPass(){
               
               $('#password').val(
                       function(){
                           return $().crypt({method:"sha1",source:$('#password').val()});
                           
        
        });
               
           };
           
           
           
       </script>
    <%
    out.print(divsbean.loginform());
    if(request.getParameter("error")!=null){
    %><div class="alert alert-warning">Login Incorreto</div> <%
    }
   }
                                 %>
                                 <footer style=" bottom: 0px;"> <h3> Jos&eacute; Chavarria e Carlos PiresCET-TPSI ESTG-IPVC 2013/2014</h3>
                                     
                                     
                                 </footer>
     
</body>
    





                                </html> 