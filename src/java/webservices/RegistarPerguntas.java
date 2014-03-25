/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import beans.StrinUtils;
import beans.session;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
@WebServlet(name = "registarperguntas", urlPatterns = {"/registarperguntas"})
public class RegistarPerguntas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected  void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        HttpSession sess = request.getSession();
       session se= (session) sess.getAttribute("actualsession");
      String message;
      
       
       //cor=2&per=&r1=&r2=&r3=fas&r4=&r5=&r6=&r7=&dica=&ucs=all
                
            
    // do what you have to do here
    // In your case, an other loop.

       
       
      
        if(se==null){
       response.sendRedirect(request.getContextPath());
       
       } else {
             String pergunta = StrinUtils.decode(request.getParameter("per"));
 
             
       int correta=Integer.parseInt(request.getParameter("cor"));
 
       String [] respostas= new String[7]; 
       for(int i=1;i<8;i++){
           respostas[i-1]=StrinUtils.decode(request.getParameter("r"+i));
 
             
       }
       String ucs=request.getParameter("ucs");
 
             
        String cursos=request.getParameter("cur");
 
             
       int capitulo=Integer.parseInt(request.getParameter("capi"));
 
          
        if(se.getUs().getTipo().equals("professor") && se.isvalid() ) {
       message=se.verificarPerguntaInserir(pergunta, respostas, correta, capitulo, ucs,cursos);
       try (PrintWriter out = response.getWriter()) {
           out.printf(message);
           
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
            Logger.getLogger(RegistarPerguntas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistarPerguntas.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegistarPerguntas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistarPerguntas.class.getName()).log(Level.SEVERE, null, ex);
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
