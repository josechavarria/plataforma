/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import beans.capitulos;
import beans.session;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "setIndexProva", urlPatterns = {"/setIndexProva"})
public class setIndexProva extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         boolean mode=Boolean.parseBoolean(request.getParameter("mode"));
        HttpSession sess = request.getSession();
       session ses= (session) sess.getAttribute("actualsession");
        if(ses!=null){
               
            
             if(ses.getUs().getTipo().equals("aluno")){
                  if(mode&&ses.getUs().getTesteExecutar().getIndexAtual()<ses.getUs().getTesteExecutar().getNumeroQuestoes()){
                      
                      ses.getUs().getTesteExecutar().setIndexAtual(ses.getUs().getTesteExecutar().getIndexAtual()+1);
                      
                  }else if((!mode)&&ses.getUs().getTesteExecutar().getIndexAtual()>0){
                    ses.getUs().getTesteExecutar().setIndexAtual(ses.getUs().getTesteExecutar().getIndexAtual()-1);
                  
                  }
             }
                
            try (PrintWriter out = response.getWriter()) {
                     /* TODO output your page here. You may use following sample code. */
                     out.print(mode);
                 }
          
           }else{
                  response.sendRedirect(request.getContextPath());
              
           } 
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
