package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import beans.cadernoExercicios;
import beans.HtmlCoder;
import beans.tabs;
import java.util.ArrayList;
import beans.capitulos;
import beans.uc;
import beans.pergunta;
import java.util.Iterator;

public final class menuPErguntas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      beans.session actualsession = null;
      synchronized (session) {
        actualsession = (beans.session) _jspx_page_context.getAttribute("actualsession", PageContext.SESSION_SCOPE);
        if (actualsession == null){
          actualsession = new beans.session();
          _jspx_page_context.setAttribute("actualsession", actualsession, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      beans.HtmlCoder divsbean = null;
      synchronized (_jspx_page_context) {
        divsbean = (beans.HtmlCoder) _jspx_page_context.getAttribute("divsbean", PageContext.PAGE_SCOPE);
        if (divsbean == null){
          divsbean = new beans.HtmlCoder();
          _jspx_page_context.setAttribute("divsbean", divsbean, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    ");
 out.print(divsbean.headindex(actualsession)); 
      out.write("\n");
      out.write("         \n");
      out.write("     \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
 if(actualsession.isvalid()){ 
            ArrayList<tabs> t= new ArrayList<tabs>();
            
            if(actualsession.getUs().getTipo().equals("professor")){
                  if(actualsession.getPerguntaAlvo()==null){
                actualsession.setPerguntaAlvo(new pergunta());
                actualsession.getPerguntaAlvo().novaPerguntaVazia();
                }
                tabs tab= new tabs(divsbean.MenuEditor(actualsession),"Inserir",0,"Inserir Formulas");
                t.add(tab);
                tab= new tabs(divsbean.divInserirTeste(),"InserirT",0,"Inserir Testes");
                t.add(tab);
                
             
                //tabs(String content, String name, int id, String desc)
            }else if(actualsession.getUs().getTipo().equals("admin")){
                
                tabs tab= new tabs(divsbean.divInserirTurno(),"Turnos",0,"Turnos");
                t.add(tab);
                 tab= new tabs(divsbean.divInserirALuno(),"InserirA",0,"Inserir Alunos");
                t.add(tab);
            }else if(actualsession.getUs().getTipo().equals("aluno")){
                
                tabs tab= new tabs(divsbean.divResponderPerguntasCaderno(actualsession),"Caderno",0,"Caderno de Exercicios");
                actualsession.setCaderno(new cadernoExercicios());
                t.add(tab);
                 
            }
            out.print(divsbean.tabNavigator(t)); 
    }else { 
       
      out.write(" \n");
      out.write("    \n");
      out.write("       <script>\n");
      out.write("          function hashPass(){\n");
      out.write("               \n");
      out.write("               $('#password').val(\n");
      out.write("                       function(){\n");
      out.write("                           return $().crypt({method:\"sha1\",source:$('#password').val()});\n");
      out.write("                           \n");
      out.write("        \n");
      out.write("        });\n");
      out.write("               \n");
      out.write("           };\n");
      out.write("           \n");
      out.write("           \n");
      out.write("           \n");
      out.write("       </script>\n");
      out.write("    ");

    out.print(divsbean.loginform());
    if(request.getParameter("error")!=null){
    
      out.write("<div class=\"alert alert-warning\">Login Incorreto</div> ");

    }
   }
                                 
      out.write("\n");
      out.write("                                 <footer> <h3> Jos&eacute; Chavarria e Carlos PiresCET-TPSI ESTG-IPVC 2013/2014</h3>\n");
      out.write("                                     \n");
      out.write("                                     \n");
      out.write("                                 </footer>\n");
      out.write("     \n");
      out.write("</body>\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </html> ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
