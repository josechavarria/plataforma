/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;


import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Set;
/**
 * aramezena todas as strings para as várias HtmlCoder na interface de utilização
 * @author josechavarria
 */
public  class  HtmlCoder extends ItemDivs {
public  String mudarPassword(){
StringBuilder html= new StringBuilder();
    html.append("       <form id=\"mudarpassword\" method=\"post\" onsubmit=\"processForm('mudarpassword','changepassword');return false;\"");
     html.append("<fieldset>\n");
      html.append("\n");
      html.append("<!-- Form Name -->\n");
      html.append("<legend>Form Name</legend>\n");
      html.append("\n");
      html.append("<!-- Password input-->\n");
      html.append("<div class=\"control-group\">\n");
      html.append("  <label class=\"control-label\" for=\"oldpassword\">Password antiga</label>\n");
      html.append("  <div class=\"controls\">\n");
      html.append("    <input id=\"oldpassword\" name=\"oldpassword\" placeholder=\"Password antiga\" class=\"input-xlarge\" type=\"password\">\n");
      html.append("    \n");
      html.append("  </div>\n");
      html.append("</div>\n");
      html.append("\n");
      html.append("<!-- Password input-->\n");
      html.append("<div class=\"control-group\">\n");
      html.append("  <label class=\"control-label\" for=\"password1\">Password</label>\n");
      html.append("  <div class=\"controls\">\n");
      html.append("    <input id=\"password1\" name=\"password1\" placeholder=\"Password\" class=\"input-xlarge\" required=\"\" type=\"password\">\n");
      html.append("    \n");
      html.append("  </div>\n");
      html.append("</div>\n");
      html.append("\n");
      html.append("<!-- Password input-->\n");
      html.append("<div class=\"control-group\">\n");
      html.append("  <label class=\"control-label\" for=\"password2\">Repita a password</label>\n");
      html.append("  <div class=\"controls\">\n");
      html.append("    <input id=\"password2\" name=\"password2\" placeholder=\"Password\" class=\"input-xlarge\" required=\"\" type=\"password\">\n");
      html.append("    \n");
      html.append("  </div>\n");
      html.append("</div>\n");
      html.append("\n");
      html.append("<!-- Button -->\n");
      html.append("<div class=\"control-group\">\n");
      html.append("  <label class=\"control-label\" for=\"enviarpassword\"></label>\n");
      html.append("  <div class=\"controls\">\n");
      html.append("    <button id=\"enviarpassword\" name=\"enviarpassword\" class=\"btn btn-primary\">Enviar</button>\n");
      html.append("  </div>\n");
      html.append("</div>\n");
      html.append("\n");
      html.append("</fieldset>\n");
      html.append("</form>\n");

return html.toString();

}   
public  String relatorioTeste(session se){
       
        StringBuilder html= new StringBuilder();
        
      html.append("       <form id=\"relatorioTeste\" action=\"reportTeste\" method=\"post\" target=\"_BLANK\"");
      html.append("<fieldset>\n");
      html.append("\n");
      html.append("<!-- Mudar Password-->\n");
      html.append("<legend>Relat&oacute;rio do Teste</legend>\n");
      html.append("\n");
      html.append("<!-- Select Basic -->\n");
      html.append("<div class=\"control-group\">\n");
      html.append("  <label class=\"control-label\" for=\"teste\"></label>\n");
      html.append("  <div class=\"controls\">\n");
      html.append("    <select id=\"teste\" name=\"Teste\" class=\"input-xlarge\">\n");
      html.append("        <option></option>\n");
      html.append("        ");
      
      HashMap<Integer,String> testes= se.getUs().ListaTestesProfessor(); 
        Set<Integer> keystestes=testes.keySet();
        for(Integer i:keystestes){
            
      html.append(" \n");
      html.append("        \n");
      html.append("            <option value=\"");
      html.append(i); 
      html.append('"');
      html.append('>');
      html.append(testes.get(i)); 
      html.append("</option>\n");
      html.append("        \n");
      html.append("        ");

        
        }
      
          html.append("\n");
      html.append("        \n");
      html.append("    </select>\n");
      html.append("  </div>\n");
      html.append("</div>\n");
      html.append("\n");
      html.append("<!-- Button -->\n");

      html.append("   <div class=\"controls\">\n");
      html.append("    <button id=\"envteste\"  class=\"btn btn-inverse\">Pauta</button>\n");
     
      html.append("</div>\n");
      html.append("\n");
      html.append("</fieldset>\n");
      html.append("</form>\n");
      html.append("\n");
         return html.toString();
   }
public  String divResponderPerguntasCaderno(session ses) throws IOException, SQLException, ClassNotFoundException{
     HashMap<Integer,String> ucs= ses.getUs().ListaUcsALunoInscrito();

    StringBuilder html = new StringBuilder();
    html.append("             <div class=\" dl-horizontal inline\" style=\" background-color:#CCC; position:\" >\n");
  html.append("               <label for=\"selectUC\">Unidade Curricular </label> \n");
  html.append("                     <select id=\"selectUC\" class=\t\"selectpicker \">\n");
  html.append("                                            <option value=\"0\">  </option>\n");
  html.append("                                              ");

    Set<Integer> idsUcs= ucs.keySet();
    for(Integer id : idsUcs) {
  html.append("\n");
  html.append("        <option value=\"");
html.append(id); 
  html.append('"');
  html.append('>');
html.append(ucs.get(id)); 
  html.append("</option>\n");
  html.append("    ");
}
  html.append(" \n");
  html.append("                </select>  \n ");
  html.append("                <label for=\"selectCapitulo\">Capitulo </label> \n");
  html.append("                    <select  id=\"selectCapitulo\" class=\"selectpicker\" > <option value=\"0\">  </option>\n");
  html.append("                    </select>  \n ");
  html.append("       <button id=\"terminarTeste\" href=\"relatoriocaderno\" target=\"_blank\" type=\"button\" class=\"btn btn-default\" >Terminar Teste</button>  </div>                                              \n");
  html.append("                                                    <iframe  id =\"iframeCaderno\" src=\"inicio_teste.jsp\" width=100% > \n");
  html.append("          </iframe>\n");

    return html.toString();

}
public  String divMenuEditor() throws IOException, SQLException, ClassNotFoundException{
    return " <iframe  id =\"ifr\" src=\"menuEditor.jsp\" ></iframe>";
}
public  String MenuEditor(session ses) throws IOException, SQLException, ClassNotFoundException{
StringBuilder html = new StringBuilder();
  html.append(" <section id=\"editor\"");
  html.append("  <header>\n");
  html.append("               \n");
  html.append("            <div class=\" dl-horizontal\" style=\" background-color:#999\">        <label>Capitulo </label> \n");
  html.append("                                                      \n");
  html.append("           \n");

 ses.carregarListaCapituloscompleta(); 
  html.append("\n");
  html.append("               <select id=\"capitulos\" name=\"capitulo\">\n");
  html.append("                   ");

  if(ses.getPerguntaAlvo().getId()==0){
        html.append("<option></option>");
  int j=0;
    for (capitulos c : ses.getListaCapitulosEditar()) {

        html.append("\n");
        html.append("                   \n");
        html.append("                    <option  value=\"");
        html.append(j);
        html.append('"');
        html.append('>');
        html.append(c.getdescr());
        html.append("</option>\n");
        html.append("                   ");
    j++;
    }  
  }else{
      int j=0;
      for(capitulos c : ses.getListaCapitulosEditar()){
          if(c.getId()==ses.getPerguntaAlvo().getC().getId()){

                html.append("\n");
                html.append("                   \n");
                html.append("                    <option  value=\"");
                html.append(j);
                html.append('"');
                html.append('>');
                html.append(c.getdescr());
                html.append("</option>\n");
                html.append("                   ");
            j++;
          }
      }
    for (capitulos c : ses.getListaCapitulosEditar()) {

       if(c.getId()!=ses.getPerguntaAlvo().getC().getId()){

                html.append("\n");
                html.append("                   \n");
                html.append("                    <option  value=\"");
                html.append(j);
                html.append('"');
                html.append('>');
                html.append(c.getdescr());
                html.append("</option>\n");
                html.append("                   ");
            j++;
          }
    }  





  }

  html.append("\n");
  html.append("               </select>\n");
  html.append("   <div class=\"btn-group\" >\n");  
  html.append("               <button id=\"btndispdrag\" class=\"btn\">Editor Formulas</button>\n");  
    html.append("               <button id=\"clearM\" class=\"btn\">Apagar Mensagens</button>\n");  
   html.append("               <button id=\"novaP\" class=\"btn\">NovaP</button>\n");  

    html.append("   </div>");


  html.append("               </div>  <div  id=\"divucs\" class=\" dl-horizontal\" style=\" background-color:#999\"> \n");



  html.append("               </div>  <div  id=\"divcursos\" class=\" dl-horizontal\" style=\" background-color:#999\"> \n");




  html.append("              </div>\n");
  html.append("   <section class=\"dl-horizontal\" style=\" background-color: #999\"> \n");
  html.append("   <div class=\"btn-group\" >\n");
  html.append("    <button id=\"btnPergunta\" class=\"btn\">Pergunta</button>\n");
  html.append("    <button id=\"btn1\" class=\"btn\">1</button>\n");
  html.append("    <button id=\"btn2\" class=\"btn\">2</button>\n");
  html.append("    <button id=\"btn3\" class=\"btn\">3</button>\n");
  html.append("    <button id=\"btn4\" class=\"btn\">4</button>\n");
  html.append("    <button id=\"btn5\" class=\"btn\">5</button>\n");
  html.append("    <button id=\"btn6\" class=\"btn\">6</button>\n");
  html.append("    <button id=\"btn7\" class=\"btn\">7</button>\n");
  html.append("    <button id=\"btnDica\" class=\"btn\">Dica</button>\n");
  html.append("    </div>  \n");
  html.append("     </section> \n");
  html.append("    <section id=\"copybar\" class=\"dl-horizontal\" style=\" display: none; background-color: #999\">\n");
  html.append("     <div class=\"   btn-group  \">\n");
  html.append("    <label   class=\"label label-primary\">Copiar</label> \n");
  html.append("    <button id=\"copy0\" class=\"btn\">Pergunta</button>\n");
  html.append("    <button id=\"copy1\" class=\"btn\">1</button>\n");
  html.append("    <button id=\"copy2\" class=\"btn\">2</button>\n");
  html.append("    <button id=\"copy3\" class=\"btn\">3</button>\n");
  html.append("    <button id=\"copy4\" class=\"btn\">4</button>\n");
  html.append("    <button id=\"copy5\" class=\"btn\">5</button>\n");
  html.append("    <button id=\"copy6\" class=\"btn\">6</button>\n");
  html.append("    <button id=\"copy7\" class=\"btn\">7</button>\n");
  html.append("\n");
  html.append("    </div> ");
          html.append("</section> \n");
  html.append("</header>\n");
  html.append(" <section style=\" float:left;\">\n");
  html.append("    \n");
  html.append("               <div id=\"div0\" style=\"height:333px;\" >\n");
  html.append("                 <label   class=\"label label-primary\">Pergunta</label> \n");
    html.append("               <button id=\"bespaco0\" class=\"btn\">Espaco</button>\n"); 
      html.append("               <button id=\"benter0\" class=\"btn\">Enter</button>\n");  


     html.append("                           <textarea class=\"latexin\" name=\"latex0\" style=\" width: 400px\" id=\"textArea0\" \n");

    html.append(" >");
    html.append(ses.getPerguntaAlvo().getLatexCode());

           html.append("</textarea>\n");
  html.append("             <div id=\"imgarea0\"> <br><img id=\"image0\" alt=\"image\" src=\"DispImage?latex=\"/></div> \n");
  html.append("     </div>");
 ;
  while(ses.getPerguntaAlvo().getListaRespostas().size()<7){
      ses.getPerguntaAlvo().getListaRespostas().add(new resposta());
  }
for(int k=1;k<8;k++){ 
  html.append("     \n");
  html.append("          <div id=\"div");
html.append(k); 
  html.append("\" style=\" height:333px; display:none\">\n");
  html.append("             <label   class=\"label label-primary\">Resposta ");
html.append(k); 
  html.append(" </label>\n");
   html.append("               <button id=\"bespaco").append(k).append("\" class=\"btn\">Espaco</button>\n"); 
      html.append("               <button id=\"benter").append(k).append("\" class=\"btn\">Enter</button>\n");  

  html.append("             <textarea  class=\"latexin\" name=\"latex1\" id=\"textArea");
html.append(k); 

  html.append("\"             style=\" width: 400px\"");
    html.append(" >");
    html.append(ses.getPerguntaAlvo().getListaRespostas().get(k-1).getLatexCode());
  html.append("</textarea>\n");
  html.append("               <input class=\"rcorreta\" type=\"radio\" name=\"correta\"\n");if(ses.getPerguntaAlvo().getListaRespostas().get(k-1).isCorreta()){
  html.append("checked ");
  }
  html.append("                id=\"respo");
html.append(k); 
  html.append("\" value=\"");
html.append((k)); 
  html.append("\"> \n");
  html.append("         <div id=\"imgarea").append(k).append("\">  <br><img alt=\"resposta");
html.append(k); 
  html.append("\" src=\"DispImage?latex=\" id=\"image");
html.append(k); 
  html.append("\"/></div></div>\n");

}

  html.append("            <div id=\"div8\" style=\" height:333px; display:none\" >\n");
  html.append("                 <label   class=\"label label-primary\">Dica</label> \n");
  html.append("                 \n");
  html.append("                           <textarea name=\"dica\" style=\" width: 500px\" id=\"dica\" \n");
  html.append("                value=").append(ses.getPerguntaAlvo().getDica()).append("></textarea>\n");
  html.append("                \n");
  html.append("            </div>\n");

  html.append("          <button id=\"submitq\" class=\"btn btn-primary\"  type=\"submit\" style=\"float:left\">Submeter Resposta</button>\n");
  html.append("<section id=\"messages\" style=\"position:fixed; bottom:0;\" \" ></section>");

  html.append(" </section>\n");
  html.append("</section>");
    html.append("<aside id=\"asideapplet\" style=\"width:540px; height:333px; float:right;\">\n" +
" </aside>                  \n" +
"       ");

  return html.toString();

}
public  String asideapplet(){

return " <aside id=\"asideapplet\"style=\"width:540px; height:333px; float:right;\"> </aside>";

}
public  String loginform(){
  StringBuilder html = new StringBuilder();
  html.append("\n");
  html.append("\n");
  html.append("                                       <div class=\"container\">\n");
   html.append("        <h2 class=\"page-header\">Login</h2>\n");

  html.append("      <form class=\"form-signin\" id=\"loginform\" method=\"post\" onsubmit=\"hashPass();\" action=\"login_.jsp\">");
   html.append("        <input required=\"\"  type=\"text\" class=\"input-block-level\" name=\"username\" placeholder=\"Username\">\n");
  html.append("        <input required=\"\" id=\"password\" type=\"password\" class=\"input-block-level\" name=\"password\" placeholder=\"Password\">\n");
  html.append("        <label class=\"checkbox\">\n");
  html.append("            ");            
  html.append("\n");
  html.append(" \n");
  html.append("        <button class=\"btn btn-large btn-primary\" type=\"submit\">Sign in</button>\n");
  html.append("      </form>\n");
  html.append("\n");
  html.append("    </div>\n");
  html.append("                            ");

return html.toString();

}
public  String headindex(session ses){
    StringBuilder html = new StringBuilder();

  html.append("        <meta charset=\"UTF-8\">\n");
  html.append("        <title>Plataforma de Apoio a Matemática</title>\n");
  html.append("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
  html.append("        <meta name=\"description\" content=\"\">\n");
  html.append("        <meta name=\"author\" content=\"\">\n");
  html.append("        <!-- Le styles -->\n");
  html.append("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
  html.append("        <link href=\"css/normalize.css\" rel=\"stylesheet\">\n");
  html.append("        <link href=\"css/bootstrap-responsive.css\" rel=\"stylesheet\">\n");
  html.append("        <link href=\"css/simple-sidebar.css\" rel=\"stylesheet\">\n");
  html.append("        <link href=\"fonts/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
  html.append("        <script src=\"js/bootstrap-select.js\" type=\"text/javascript\"></script>\n");
  html.append("        <script src=\"js/bootstrap-select.min.js\" type=\"text/javascript\"></script>\n");
  html.append("        <link href=\"css/bootstrap-select.css\" type=\"text/css\" rel=\"stylesheet\">\n");
  html.append("        <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script> \n");
  html.append("        <script type=\"text/javascript\" src=\"js/tab.js\"></script>\n");
  html.append("        <script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n");
    html.append("        <script type=\"text/javascript\" src=\"js/crypt.js\"></script>\n");
  html.append("        <script type=\"text/javascript\" src=\"js/localjs.js\"></script>\n");



  int indexPergunta = 0;
if (ses.isvalid()) {
  html.append("         \n");
  html.append("               ");
if (ses.getUs().getTipo().equals("aluno")) { 
  html.append("\n");
  html.append("                 <script type=\"text/javascript\" src=\"js/teste.js\"></script>\n");
  html.append("                 <script type=\"text/javascript\" src=\"js/aluno.js\"></script>\n");
  html.append("                ");
}else if (ses.getUs().getTipo().equals("professor")){
 html.append("                 <script type=\"text/javascript\" src=\"js/jquery.base64.js\"></script>\n");
  html.append("                 <script type=\"text/javascript\" src=\"js/editor.js\"></script>\n");

  html.append("                 <script type=\"text/javascript\" src=\"js/professor.js\"></script>\n");
  } else if (ses.getUs().getTipo().equals("admin")){
 html.append("                 <script type=\"text/javascript\" src=\"js/jquery.base64.js\"></script>\n");
  html.append("                 <script type=\"text/javascript\" src=\"js/admin.js\"></script>\n");

   } 


}
  return html.toString();
}
public  String tabNavigator( ArrayList<tabs> t){
    StringBuilder tabs=new StringBuilder();
    StringBuilder content=new StringBuilder();
    StringBuilder html=new StringBuilder();
    for(tabs tabaux:t){
        tabs.append(this.addtab(tabaux));
        content.append(this.addtabContent(tabaux));
    }

  html.append("    <ul id=\"myTab\" class=\"nav nav-tabs\" >\n");
  html.append("       <li style=\"float : right\"><a id=\"logout\" href=\"logout\" >Logout</a></li>\n");
  html.append("     \n");
  html.append("      <li class=\"active\"><a href=\"#Home\" data-toggle=\"tab\">Plataforma de Matem&aacute;tica</a></li>\n");
  html.append("      <li class=\"\"><a href=\"#About\" data-toggle=\"tab\">Sobre o Projeto</a></li>\n");
  html.append(tabs);
  html.append("    </ul>\n");
  html.append("    <div id=\"myTabContent\" class=\"tab-content\">\n");
  html.append("      <div class=\"tab-pane fade active in\" id=\"Home\">\n");
  html.append("        <div class=\"hero-unit\">\n" +
"            <h1> Bem vindo </h1>\n" +
"            <p>Bem vindo &agrave; plataforma de Matem&aacute;tica Por favor selecione a opcao que pretende.</p>\n" +
"            \n" +
"          </div>");
  html.append("      </div>\n");
  html.append("        <div class=\"tab-pane fade \" id=\"About\">\n");
  html.append("<div class=\"hero-unit\">\n" +
"            <h1> Sobre </h1>\n" +
"            <p>Esta plataforma visa fomentar o trabalho aut&oacute;nomo dos alunos na &aacute;rea de matem&aacute;tica, atrav&eacute;s de exerc&iacute;cios que aplicam a matem&aacute;tica &agrave; sua &aacute;rea de estudos.</p>\n" +
"            \n" +
"          </div>");
  html.append("      </div>\n");
  html.append(content);
  html.append("    </div>\n");


    return html.toString();
}
public  static String javascriptMenuEditor(){
StringBuilder html= new StringBuilder();
  html.append("<script type=\"text/javascript\" src=\"js/teste.js\">");
  html.append("</script>\n");


return html.toString();
}
public  static String associarTurnoProfessor(session se){
StringBuilder html= new StringBuilder();    
          html.append("<fieldset>\n");
  html.append("\n");
  html.append("<!-- Form Name -->\n");
  html.append("<legend>Novo Turno</legend>\n");

HashMap<Integer,String>professores= se.getUs().ListaCarregarProfessores();
HashMap<Integer,String>ucCursos= se.getUs().ListaUcCursos();



  html.append("\n");
  html.append("<!-- Select Basic -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"selectprofessor\">Professor</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <select id=\"selectprofessor\" name=\"selectprofessor\" class=\"input-xlarge\">\n");
  html.append("     ");


    Set<Integer> idsProfessores= professores.keySet();
    for(Integer idP : idsProfessores) {
  html.append("\n");
  html.append("        <option value=\"");
html.append(idP); 
  html.append('"');
  html.append('>');
html.append(professores.get(idP)); 
  html.append("</option>\n");
  html.append("    ");
}
  html.append("   \n");
  html.append("    </select>\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("<!-- Text input-->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"descrTurn\">descrricao</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <input id=\"descTurn\" name=\"descTurn\" placeholder=\"Ex AlgaTp1EERC\" class=\"input-xlarge\" required=\"\" type=\"text\">\n");
  html.append("    \n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("<!-- Select Basic -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"unidadec\">Unidade Curricular</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <select id=\"unidadec\" name=\"unidadec\" class=\"input-xlarge\">\n");
  html.append("      ");


    Set<Integer> idsuccursos= ucCursos.keySet();
    for(Integer iducc : idsuccursos) {
  html.append("\n");
  html.append("        <option value=\"");
html.append(iducc); 
  html.append('"');
  html.append('>');
html.append(ucCursos.get(iducc)); 
  html.append("</option>\n");
  html.append("    ");
}
  html.append("  \n");
  html.append("    </select>\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("\n");
  html.append("\n");
  html.append("<!-- Button -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"saveprofessorTurno\"></label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <button id=\"saveprofessorTurno\" name=\"saveprofessorTurno\" class=\"btn btn-primary\">Save</button>\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("</fieldset>\n");

return html.toString();
}
public  String divInserirTeste(){
      return " <iframe  class =\"ifr\" src=\"criarteste.jsp\" ></iframe>";

 }
public  String divInserirTurno(){
      return " <iframe  class =\"ifr\" src=\"inserirNovoTurno.jsp\" ></iframe>";

 }
public  String divInserirALuno(){

  return " <iframe  class =\"ifr\" src=\"inseriraluno.jsp\" ></iframe>";


}
public  String provaAvaliacao(){

  return " <iframe  class =\"ifr\" src=\"responderTeste.jsp\" ></iframe>";


}
public  String divInserirProfessor(){

  return " <iframe  class =\"ifr\" src=\"inserirProfessor.jsp\" ></iframe>";


}
public  String InserirTeste(session se){
HashMap<Integer,String> turnos= se.getUs().ListaTurnosProfessor();
    StringBuilder html= new StringBuilder();
    html.append("       <form id=\"mudarEstadoTeste\" method=\"post\" onsubmit=\"processForm('mudarEstadoteste','estadoteste');return false;\"");
  html.append("<fieldset>\n");
  html.append("\n");
  html.append("<!-- Form Name -->\n");
  html.append("<legend>Form Name</legend>\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"descricao\">Descricao</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <input id=\"descricao\" type=\"text\" name=\"descricao\" placeholder=\" Teste_1_alga_eerc_TP1\" class=\"input-xlarge\" required=\"\" >\n");
  html.append("    \n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("<!-- Text input-->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"numeroQuestoes\">Numero de Questões</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <input id=\"numeroQuestoes\" type=\"number\" name=\"numeroQuestoes\" placeholder=\"\" class=\"input-xlarge\" value=\"20\" required=\"\" >\n");
  html.append("    \n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("\n");
  html.append("<!-- Text input-->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"cotacao\">Cotação</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <input id=\"cotacao\" type=\"number\" name=\"cotacao\" placeholder=\"\" value=\"1\" class=\"input-small\" >\n");
  html.append("    \n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("<!-- Text input-->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"desconto\">Desconto</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("      <input id=\"desconto\" type=\"number\" name=\"desconto\" placeholder=\"\" class=\"input-small\" required=\"\" value=\"0.25\" >\n");
  html.append("    \n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("<!-- Select Basic -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"turnoalvo\">Turno</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <select id=\"turnoalvo\" name=\"turnoalvo\" class=\"input-xxlarge\">\n");
  html.append("    ");


    Set<Integer> idsProfessores= turnos.keySet();
    for(Integer idTurnos : idsProfessores) {
  html.append("\n");
  html.append("        <option value=\"");
html.append(idTurnos); 
  html.append('"');
  html.append('>');
html.append(turnos.get(idTurnos)); 
  html.append("</option>\n");
  html.append("    ");
}
  html.append("   \n");
  html.append("    </select>\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("<!-- Multiple Checkboxes (inline) -->\n");
  html.append("\n");
  html.append("<div id=\"capitulosArea\" class=\"control-group\">\n");
  html.append("  \n");
  html.append(" \n");
  html.append("</div>\n");
  html.append("<!-- Button -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"submitTeste\"></label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <button id=\"submitTeste\" name=\"submitTeste\" type=\"submit\" class=\"btn btn-primary\">Criar</button>\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("\n");
  html.append("</fieldset>\n");
  html.append("</form>\n");


    return html.toString();
}
public  String relatorio(session se, ArrayList<pergunta> perguntas){
   StringBuilder html=new StringBuilder();
html.append("<!DOCTYPE html>\n");
  html.append("\n");
  html.append("\n");
  html.append(" \n");
  html.append("<html>\n");
  html.append("    <head>\n");
  html.append("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
  html.append("        <title>Relatorio de atividade da sess&atilde;o</title>\n");
  html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
  html.append("    <meta name=\"description\" content=\"\">\n");
  html.append("    <meta name=\"author\" content=\"\">\n");
  html.append("<link href=\"css/normalize.css\" rel=\"stylesheet\">\n");
  html.append("    <!-- Le styles -->\n");
  html.append("\n");
  html.append("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
  html.append("    <link href=\"css/bootstrap-responsive.css\" rel=\"stylesheet\">\n");
  html.append("    <link href=\"css/jumbotron.css\" rel=\"stylesheet\">\n");
  html.append("  \n");
  html.append("     </head>\n");
  html.append("     \n");
  html.append("    <body>\n");
  html.append(" \n");
  html.append("     ");


     for(pergunta p: perguntas) {
  html.append("\n");
  html.append("              \n");
  html.append("   <div class=\"panel panel-primary\" style=\" page-break-after: always; \">\n");
  html.append("       <div class=\"panel-heading\"> <h3>");
html.append("Aluno: "+se.getUs().getNome()+" "+se.getUs().getApelido()+" N&uacute;mero: "+se.getUs().getnALuno()+" Curso: "+se.getUs().getCursoAluno().getdescr());  
  html.append("  \n");
  html.append("           </h3></div>\n");
  html.append("  <div class=\"panel-body\">\n");
  html.append("        \n");
  html.append("            <div><img alt=\"pergunta\" src=\"DispImage?latex=");
html.append(StrinUtils.encode(p.getLatexCode())); 
  html.append("\"></div>\n");
  html.append("            ");

      int i=0;
      for(i=0;i<4;i++){

  html.append("\n");
  html.append("            <div ");
if(p.getRespostaDada()==i) {
                         if( p.getListaRespostas().get(i).isCorreta()){

  html.append(" style=\"background-color : #00FF00; \"");

                            }else{

  html.append(" style=\"background-color : red;\" ");

                            } 

      }

  html.append("   \n");
  html.append("          id=\"div");
html.append(i);
  html.append("\"> <img  alt=\"resposta\" src=\"DispImage?latex= ");
html.append(StrinUtils.encode(p.getListaRespostas().get(i).getLatexCode())); 
  html.append("\">       \n");
  html.append("        \n");
  html.append("       </div> ");
}
  html.append("\n");
  html.append("        \n");
  html.append("         \n");
  html.append("     ");
}
  html.append("\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("        \n");
  html.append("    \n");
  html.append("        </body>\n");
  html.append("</html>\n");



return html.toString();
}
public  String relatorioAtividade(session se){  
   StringBuilder html= new StringBuilder();
   HashMap<Integer,String> turnos= se.getUs().ListaTurnosProfessor();

         html.append("        <form id=\"novoRelatorio\"class=\"form-horizontal\" target=\"_BLANK\" method=\"post\" action=\"reportTurno\">");
  html.append("<fieldset>\n");
  html.append("\n");
  html.append("<!-- Form Name -->\n");
  html.append("<legend>Relatórios Turno</legend>\n");
  html.append("\n");
  html.append("<!-- Select Basic -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"turnolecionarrelatorio\">Turno</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <select id=\"turnolecionarrelatorio\" name=\"turnolecionarrelatorio\" class=\"input-xlarge\">\n");
 Set<Integer> idsProfessores= turnos.keySet();
    for(Integer idTurnos : idsProfessores) {
  html.append("\n");
  html.append("        <option value=\"");
html.append(idTurnos); 
  html.append('"');
  html.append('>');
html.append(turnos.get(idTurnos)); 
  html.append("</option>\n");
  html.append("    ");
}

  html.append("    </select>\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("<!-- Button -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"requererrelatorio\"></label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <button id=\"requererrelatorio\" name=\"requererrelatorio\" class=\"btn btn-inverse\">Relatório</button>\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("</fieldset>\n");
  html.append("</form>\n");

   return html.toString();

}
public  String estadoteste(session se){
StringBuilder html= new StringBuilder();
    html.append("       <form id=\"mudarEstadoTeste\" method=\"post\" onsubmit=\"processForm('mudarEstadoTeste','estadoteste');return false;\"");
 html.append("<fieldset>\n");
  html.append("\n");
  html.append("<!-- Form Name -->\n");
  html.append("<legend>Ativar testes</legend>\n");
  html.append("\n");
  html.append("<!-- Select Basic -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"testeativar\">Turno</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <select id=\"testeativar\" name=\"testeativar\" class=\"input-xlarge\">\n");
  html.append("        <option></option>\n");
  html.append("        ");
HashMap<Integer,String> testes= se.getUs().ListaTestesProfessor(); 
    Set<Integer> keystestes=testes.keySet();
    for(Integer i:keystestes){

  html.append(" \n");
  html.append("        \n");
  html.append("            <option value=\"");
html.append(i); 
  html.append('"');
  html.append('>');
html.append(testes.get(i)); 
  html.append("</option>\n");
  html.append("        \n");
  html.append("        ");


    }

  html.append("\n");
  html.append("        \n");
  html.append("    </select>\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("<!-- Button -->\n");

  html.append("   <div class=\"controls\">\n");
  html.append("    <input type=\"radio\" value=\"1\" name=\"estado\" class=\"btn btn-inverse\">Ativar</button>\n");

  html.append("    <input type=\"radio\" id=\"desativarteste\" name=\"estado\" value=\"0\" class=\"btn btn-inverse\">Desactivar</button>\n");
  html.append(" \n");
 html.append("    <button id=\"desativarteste\"  class=\"btn btn-inverse\">Enviar</button>\n");

  html.append("</div>\n");
  html.append("\n");
  html.append("</fieldset>\n");
  html.append("</form>\n");
  html.append("\n");



return html.toString();
}
public  String escolherteste(session se){
StringBuilder html= new StringBuilder();
html.append("<form>\n");

html.append("<fieldset>\n");
  html.append("\n");
  html.append("<!-- Form Name -->\n");
  html.append("<legend>Realizar Testes</legend>\n");
  html.append("\n");
  html.append("<!-- Select Basic -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("  <label class=\"control-label\" for=\"testeiniciar\">Teste</label>\n");
  html.append("  <div class=\"controls\">\n");
  html.append("    <select id=\"testeiniciar\" name=\"testeiniciar\" class=\"input-xlarge\">\n");
  html.append("        <option></option>\n");
  html.append("        ");
HashMap<Integer,String> testes= se.getUs().ListaTestesAluno(); 
    Set<Integer> keystestes=testes.keySet();
    for(Integer i:keystestes){

  html.append(" \n");
  html.append("        \n");
  html.append("            <option value=\"");
html.append(i); 
  html.append('"');
  html.append('>');
html.append(testes.get(i)); 
  html.append("</option>\n");
  html.append("        \n");
  html.append("        ");


    }

  html.append("\n");
  html.append("        \n");
  html.append("    </select>\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("<!-- Button -->\n");
  html.append("<div class=\"control-group\">\n");
  html.append("   <div class=\"controls\">\n");
 html.append("    <button id=\"iniciarProva\"  class=\"btn btn-inverse\">Iniciar</button>\n");

  html.append("</div>\n");
  html.append("\n");
  html.append("</fieldset>\n");
  html.append("</form>");
    html.append("\n");



return html.toString();
}
public  String relatorioProva(session se, ArrayList<pergunta> perguntas){
   StringBuilder html=new StringBuilder();

  html.append("<html>\n");
  html.append("    <head>\n");
  html.append("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
  html.append("        <title>Relatorio de atividade da sess&atilde;o</title>\n");
  html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
  html.append("    <meta name=\"description\" content=\"\">\n");
  html.append("    <meta name=\"author\" content=\"\">\n");
  html.append("<link href=\"css/normalize.css\" rel=\"stylesheet\">\n");
  html.append("    <!-- Le styles -->\n");
  html.append("\n");
  html.append("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
  html.append("    <link href=\"css/bootstrap-responsive.css\" rel=\"stylesheet\">\n");
  html.append("    <link href=\"css/jumbotron.css\" rel=\"stylesheet\">\n");
  html.append("  \n");
  html.append("     </head>\n");
  html.append("     \n");
  html.append("    <body>\n");
  html.append(" \n");
  html.append("     ");


     for(pergunta p: perguntas) {
  html.append("\n");
  html.append("              \n");
  html.append("   <div class=\"panel panel-primary\" style=\" page-break-after: always; \">\n");
  html.append("       <div class=\"panel-heading\"> <h3>");
html.append("Aluno: "+se.getUs().getNome()+" "+se.getUs().getApelido()+" N&uacute;mero: "+se.getUs().getnALuno()+" Curso: "+se.getUs().getCursoAluno().getdescr());  
  html.append("  \n");
  html.append("           </h3></div>\n");
  html.append("  <div class=\"panel-body\">\n");
  html.append("        \n");
  html.append("            <div><img alt=\"pergunta\" src=\"DispImage?latex=");
html.append(StrinUtils.encode(p.getLatexCode())); 
  html.append("\"></div>\n");
  html.append("            ");

      int i=0;
      for(i=0;i<4;i++){

  html.append("\n");
  html.append("            <div ");
if(p.getRespostaDada()==i) {
                            html.append(" style=\"background-color : #00FF00; \"");




      }

  html.append("   \n");
  html.append("          id=\"div");
html.append(i);
  html.append("\"> <img  alt=\"resposta\" src=\"DispImage?latex= ");
html.append(StrinUtils.encode(p.getListaRespostas().get(i).getLatexCode())); 
  html.append("\">       \n");
  html.append("        \n");
  html.append("       </div> ");
}
  html.append("\n");
  html.append("        \n");
  html.append("         \n");
  html.append("     ");
}
  html.append("\n");
  html.append("  </div>\n");
  html.append("</div>\n");
  html.append("\n");
  html.append("        \n");
  html.append("    \n");
  html.append("        </body>\n");
  html.append("</html>\n");



return html.toString();
}

}
