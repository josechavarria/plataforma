/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import beans.objetManipulation;
import beans.session;
import beans.uc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josechavarria
 */
@WebServlet(name = "getucscapitulo", urlPatterns = {"/getucscapitulo"})
public class getucscapitulo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
            HttpSession sess = request.getSession();
       session ses= (session) sess.getAttribute("actualsession");
       StringBuilder html= new StringBuilder();
         int capitulo=Integer.parseInt(request.getParameter("capitulo"));
      if(ses==null){
          response.sendRedirect(request.getContextPath());
      }else{
           if(ses.isvalid()){
             ses.setListaUcsEditar((new objetManipulation()).carregarListaUc(ses.getListaCapitulosEditar().get(capitulo).getId()));
    
       if(ses.getPerguntaAlvo().getId()!=0){
           ses.getPerguntaAlvo().setlUc((new objetManipulation()).carregarListaUc(ses.getPerguntaAlvo().getC().getId()));
        }
         for (uc u : ses.getListaCapitulosEditar().get(capitulo).getListaUcsAssociada()){
            html.append("<label>");
            html.append(u.getdescr());
            html.append(" </label> <input class=\"ucscheck\" type=\"checkbox\" value=\"");
            html.append(u.getId());
             html.append("\"");
            html.append(" >");
            
         
        }  
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           out.print(html);
        }
           }else{
                response.sendRedirect(request.getContextPath());
   
           } 
    }
    }

    // <editor-fold defaultstate="collapsed" descr="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(getucscapitulo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getucscapitulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(getucscapitulo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getucscapitulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short descrription of the servlet.
     *
     * @return a String containing servlet descrription
     */
    @Override
    public String getServletInfo() {
        return "Short descrription";
    }// </editor-fold>

}