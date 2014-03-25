/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import beans.session;
import beans.uc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;
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
@WebServlet(name = "getCapitulosUc", urlPatterns = {"/getCapitulosUc"})
public class getCapitulosUc extends HttpServlet {

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
        response.setContentType("text;charset=UTF-8");
        HttpSession sess = request.getSession();
       session se= (session) sess.getAttribute("actualsession");
      if(se==null){
          response.sendRedirect(request.getContextPath());
      }else{
           if(se.isvalid()&&se.getUs().getTipo().equals("aluno")){
       StringBuilder html=new StringBuilder("<option ></option>");
      
       int Uc=Integer.parseInt(request.getParameter("Uc"));
       HashMap<Integer,String> capitulos= se.getUs().ListaCapitulosUc(Uc);
       uc u=new uc(Uc,"");
       se.getCaderno().setUcAtual(u);
       
     //  se.setListaCapitulosEditar(se.carregarLCapitulos(Uc));
        Set<Integer> idsCapitulos= capitulos.keySet();
        for(Integer id : idsCapitulos) {
      html.append("\n");
      html.append("        <option value=\"");
 html.append(id); 
      html.append('"');
      html.append('>');
 html.append(capitulos.get(id)); 
      html.append("</option>\n");
      html.append("    ");
 }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           out.print(html);
        }
           }else{
                response.sendRedirect(request.getContextPath());
   
           } 
    }}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
              Logger.getLogger(getCapitulosUc.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(getCapitulosUc.class.getName()).log(Level.SEVERE, null, ex);
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
              Logger.getLogger(getCapitulosUc.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(getCapitulosUc.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
