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
@WebServlet(name = "changepassword", urlPatterns = {"/changepassword"})
public class changepassword extends HttpServlet {

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
       session se= (session) sess.getAttribute("actualsession");        
         if(se==null){
       response.sendRedirect(request.getContextPath());
       
       } else{
             // oldpassword=1&password1=1&password2=1
             String oldpassword=request.getParameter("oldpassword");
             String password1=request.getParameter("password1");
             String password2=request.getParameter("password2");
             int resposta=0;
             
             if(oldpassword.equals(se.getUs().getPassword())){
             
                 if(se.getUs().alterarPalavraPasse(password1, password2)){
                 resposta=1;
                 
                 }
             }
             if(resposta==1){
               
                         
                         if(se.getUs().MudarRegistoPalavraPasse(password2)){
                             resposta=1;
                         }else{
                             resposta=-2;
                         }
             
             }
             try (PrintWriter out = response.getWriter()) {
                switch(resposta){
                    case 0:
                        out.print("As palavras passe não correspondem");
                        break; 
                    case 1:
                             out.print("sucesso");
                        break; 
                    case -2:
                             out.print("Não foi possivel mudar o registo\n Tente mais tarde");
                        break;
                
                }
             }
             
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
