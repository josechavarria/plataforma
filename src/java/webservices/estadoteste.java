/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import beans.capitulos;
import beans.objetManipulation;
import beans.session;
import beans.teste;
import beans.turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "estadoteste", urlPatterns = {"/estadoteste"})
public class estadoteste extends HttpServlet {

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
       int resposta=0;
            
       if(se==null){
       response.sendRedirect(request.getContextPath());
       
       } else if(se.getUs().getTipo().equals("professor")) {
         //  descricao=teskljsfdfds&numeroQuestoes=20&cotacao=1&desconto=0.25&turnoalvo=3
              int teste=Integer.parseInt(request.getParameter("testeativar"));
             int estado=Integer.parseInt(request.getParameter("estado"));
             objetManipulation ob= new objetManipulation();
             if(estado>1||estado<0){
                 resposta=-3;
             
             }else
                if(se.getUs().ListaTestesProfessor().get(teste)!=null){
                    if(ob.mudarEstadoTeste(teste, estado)){
                        resposta=1;
                    }else{
                        resposta=-1;
                    }

                 }else{



                     resposta=-2;
                 }
       }
            //public teste(float desconto, float cotacao, 
            //int[] indicesRespostas, turno t, ArrayList<capitulos> capitulosAssociados, 
            //String descr, int numeroQuestoes) {
            
            try (PrintWriter out = response.getWriter()) {
             
              if(resposta>0){
             
             out.print("Sucesso");
                  
             
             }else if(resposta==-1){
             
             out.print("Não é possivel ligar à base de dados");
                  
             
             }else if(resposta==-2){
             
             out.print("O teste que pretede alterar não é válido");
                  
             
             }else if(resposta==-3){
             
             out.print("O valor para o estado não é válido");
                  
             
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
