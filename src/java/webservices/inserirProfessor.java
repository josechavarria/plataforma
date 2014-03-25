/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import beans.session;
import beans.user;
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
 * @author Carlos
 */

@WebServlet(name = "inserirProfessor", urlPatterns = {"/inserirProfessor"})
public class inserirProfessor extends HttpServlet {
    
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
        ///////// este webservice insere um utilizador do tipo aluno 
        ///apenas é permitido caso o  tipo de utilizador seja professor
        HttpSession sess = request.getSession();
       session se= (session) sess.getAttribute("actualsession");
        if(se==null){
       response.sendRedirect(request.getContextPath());
       
       } else if(se.getUs().getTipo().equals("admin")) {
           
           
            String nome=request.getParameter("nome");
            String apelido=request.getParameter("apelido");
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String password2=request.getParameter("password2");
            String CC=request.getParameter("cc");
            
            se.setUtilizadorInserir(new user(0,nome,apelido,username,password,"professor",CC));
            
           int resposta=0;
           
                if(password.equals(password2)){
                    
                           if(resposta==0){ 
                               
                                if(se.getUtilizadorInserir().inserirUtilizador()==0){
                                    resposta=-2;
                                 }
                                 
                           }
                           else{
                               resposta=-1;
                           }
                }else{
                    resposta=-3;
                }
            try (PrintWriter out = response.getWriter()) {
             
              if(resposta==-2){
             
             out.print("username ou cartão cidadão registado");
                  
             
             }else if(resposta==-1){
             
             out.print("Não é possivel ligar à base de dados");
                  
             
             }else if(resposta==-3){
             
             out.print("As passwords não coincidem");
                  
             
             }else{
             
             out.print("Sucesso");
                  
             
             }
             
         
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
        return "Short description";
    }// </editor-fold>

}
