package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import java.util.HashMap;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      beans.session actualsession = null;
      synchronized (session) {
        actualsession = (beans.session) _jspx_page_context.getAttribute("actualsession", PageContext.SESSION_SCOPE);
        if (actualsession == null){
          actualsession = new beans.session();
          _jspx_page_context.setAttribute("actualsession", actualsession, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form class=\"form-horizontal\">\n");
      out.write("<fieldset>\n");
      out.write("\n");
      out.write("<!-- Form Name -->\n");
      out.write("<legend>Form Name</legend>\n");
      out.write("\n");
      out.write("<!-- Password input-->\n");
      out.write("<div class=\"control-group\">\n");
      out.write("  <label class=\"control-label\" for=\"oldpassword\">Password antiga</label>\n");
      out.write("  <div class=\"controls\">\n");
      out.write("    <input id=\"oldpassword\" name=\"oldpassword\" placeholder=\"Password antiga\" class=\"input-xlarge\" type=\"password\">\n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Password input-->\n");
      out.write("<div class=\"control-group\">\n");
      out.write("  <label class=\"control-label\" for=\"password1\">Password</label>\n");
      out.write("  <div class=\"controls\">\n");
      out.write("    <input id=\"password1\" name=\"password1\" placeholder=\"Password\" class=\"input-xlarge\" required=\"\" type=\"password\">\n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Password input-->\n");
      out.write("<div class=\"control-group\">\n");
      out.write("  <label class=\"control-label\" for=\"password2\">Repita a password</label>\n");
      out.write("  <div class=\"controls\">\n");
      out.write("    <input id=\"password2\" name=\"password2\" placeholder=\"Password\" class=\"input-xlarge\" required=\"\" type=\"password\">\n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Button -->\n");
      out.write("<div class=\"control-group\">\n");
      out.write("  <label class=\"control-label\" for=\"enviarpassword\"></label>\n");
      out.write("  <div class=\"controls\">\n");
      out.write("    <button id=\"enviarpassword\" name=\"enviarpassword\" class=\"btn btn-primary\">Enviar</button>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</fieldset>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
