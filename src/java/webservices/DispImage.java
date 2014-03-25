/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;




import beans.StrinUtils;
import beans.renderLatex;
import beans.session;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.URLDecoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.codec.binary.Base64;


/**
 *
 * @author josechavarria
 */
@WebServlet(name = "DispImage", urlPatterns = {"/DispImage"})
public class DispImage extends  HttpServlet{

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
      }else{
          if(se.isvalid()){
          String ini="Not\\:Defined";
      
        //String latex=request.getParameter("latex");
         //String latex=URLDecoder.decode(request.getParameter("latex"), "iso-8859-1");;
       
     //   String latex=new String(request.getParameter("latex").getBytes("iso-8859-1"), "UTF-8");
        // String latex=" \\left( \\begin{array}{ccc}\\:1\\:&\\:1\\:&\\:1\\:&\\:1\\:&\\:1\\:&\\:1\\\\1\\:&\\:11\\:&\\:1\\:&\\:11\\:&\\:1111\\:&\\:11\\\\0\\:&\\:0\\:&\\:0\\:&\\:0\\:&\\:0\\:&\\:0\\\\2\\:&\\:2\\:&\\:2\\:&\\:2\\:&\\:2\\:&\\:2\\\\\\:\\end{array} \\right) ";    
        //latex=latex.replace("%", "\\%");
     String latex=StrinUtils.decode(request.getParameter("latex"));
    
        if(latex.isEmpty()){
                latex=ini;
                }
                renderLatex render= new renderLatex();
    
         BufferedImage image= render.renderLatex(latex);
            
   response.setContentType("image/png");
       
    ServletOutputStream out= response.getOutputStream();
    ImageIO.write(image, "png", out);
   out.close();
      
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
   

    @SuppressWarnings("empty-statement")
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
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
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short descrription of the servlet.
     *
     * @return a String containing servlet descrription
     */
        public String getServletInfo() {
        return "Short descrription";
    }// </editor-fold>

}
