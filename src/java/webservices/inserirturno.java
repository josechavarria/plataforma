/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

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
@WebServlet(name = "inserirturno", urlPatterns = {"/inserirturno"})
public class inserirturno extends HttpServlet {

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
         HttpSession sess = request.getSession();
      //selectprofessor=1&descTurn=sdada&unidadec=1
        session ses= (session) sess.getAttribute("actualsession");
       StringBuilder html= new StringBuilder();
       if(ses!=null){
             if(!ses.getUs().getTipo().equals("admin")){
                 response.sendRedirect(request.getContextPath());
                 
                 //professor=1&uccurso=1&descr=1
             }else{
                  int professor=Integer.parseInt(request.getParameter("selectprofessor"));
                   
                  int uccurso=Integer.parseInt(request.getParameter("unidadec"));
                   String descr=request.getParameter("descTurn");
                   int inserir=ses.getUs().novoturno(professor, uccurso, descr);
                   if(inserir>0){
                   
                       try (PrintWriter out = response.getWriter()) {
                        
                        out.print("Turno Inserido");
                        }
             
                   }else if(inserir<0){
                        try (PrintWriter out = response.getWriter()) {
                        
                        out.print("Neste Momento não é possivel adicionar novos turnos");
                        }
             
                    }else{
                       try (PrintWriter out = response.getWriter()) {
                        
                        out.print("Coloque outro nome para o turno");
                        }
                   }
             } 
          
           }else{
                  response.sendRedirect(request.getContextPath());
              
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
     * Returns a short descrription of the servlet.
     *
     * @return a String containing servlet descrription
     */
    @Override
    public String getServletInfo() {
        return "Short descrription";
    }// </editor-fold>

}
