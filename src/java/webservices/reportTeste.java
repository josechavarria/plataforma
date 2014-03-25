/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import beans.ExcelFiles;
import beans.estatisticaturno;
import beans.linha;
import beans.objetManipulation;
import beans.session;
import beans.teste;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
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
@WebServlet(name = "reportTeste", urlPatterns = {"/reportTeste"})
public class reportTeste extends HttpServlet {

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
         HttpSession sess = request.getSession();
       session se= (session) sess.getAttribute("actualsession");  
        if(se==null){
       response.sendRedirect(request.getContextPath());
       
       } else if(se.getUs().getTipo().equals("professor")) {
            int t=Integer.parseInt(request.getParameter("Teste"));
        
        if(t>0){
            try {
                response.setContentType("text/html;charset=UTF-8");
                teste te= new teste(t, false);
               
                
                byte [] outArray= (new ExcelFiles()).ficheiroExcell(te.criarLinhas(), te.getDescr());
                objetManipulation obM= new objetManipulation();        
                Date d= obM.updateDate();
                response.setContentType("application/ms-excel");
                response.setContentLength(outArray.length);
                response.setHeader("Expires:", "0"); // eliminates browser caching
                response.setHeader("Content-Disposition", "attachment; filename="+d+"_"+te.getDescr()+".xls");
                OutputStream outStream = response.getOutputStream();
                outStream.write(outArray);
                outStream.flush();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(reportTurno.class.getName()).log(Level.SEVERE, null, ex);
            }

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
