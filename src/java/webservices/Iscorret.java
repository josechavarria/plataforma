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
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josechavarria
 */
@WebServlet(name = "iscorret", urlPatterns = {"/iscorret"})
public class Iscorret extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * 
     * 
     * verifica se uma pergunta está correta e insere a pergunta correspondente
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      boolean result = false;
        HttpSession sess = request.getSession();
       session se= (session) sess.getAttribute("actualsession");
       response.setContentType("text");
       if(se==null){
          response.sendRedirect(request.getContextPath());
 
       }else{
                if(se.isvalid()){

                 int id=Integer.parseInt(request.getParameter("id"));
                   if(se.getCaderno().getPerguntaAtual().getTentativas()<2){
                           

               if(se.getCaderno().getPerguntaAtual().iscorret(id)){
                result=true;
                        se.getCaderno().getPerguntaAtual().setRespostaDada(id);

                 }else{
                   se.getCaderno().getPerguntaAtual().setRespostaDada(id);
                  result=false;
                 }
                }
                   if(se.getCaderno().getPerguntaAtual().getTentativas()==2||result){
                   
                        se.getCaderno().getPerguntaAtual().registarRespostacaderno(id,se.getUs().getnALuno());

                   }
                }
                 try (PrintWriter out = response.getWriter()) {
                     /* TODO output your page here. You may use following sample code. */
                     out.print(result);

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
