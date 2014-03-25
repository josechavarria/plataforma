/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import beans.capitulos;
import beans.session;
import beans.teste;
import beans.turno;
import beans.user;
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
@WebServlet(name = "inserirTestes", urlPatterns = {"/inserirTestes"})
public class inserirTestes extends HttpServlet {

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
       
       } else if(se.getUs().getTipo().equals("professor")) {
         //  descricao=teskljsfdfds&numeroQuestoes=20&cotacao=1&desconto=0.25&turnoalvo=3
           
            String [] capitulos=request.getParameterValues("capitulosT");
            String descricao=request.getParameter("descricao");
            int numeroQuestoes=Integer.parseInt(request.getParameter("numeroQuestoes"));
            Float  cotacao=Float.parseFloat(request.getParameter("cotacao"));
            Float  desconto=Float.parseFloat(request.getParameter("desconto"));
            int turnoAlvo=Integer.parseInt(request.getParameter("turnoalvo"));
            //public teste(float desconto, float cotacao, 
            //int[] indicesRespostas, turno t, ArrayList<capitulos> capitulosAssociados, 
            //String descr, int numeroQuestoes) {
            ArrayList<capitulos> capitulosAl= new ArrayList<>();
            for(String c:capitulos){
            capitulosAl.add(new capitulos(Integer.parseInt(c)));
                
            }
            teste t= new teste(desconto,cotacao,new turno(turnoAlvo), capitulosAl,descricao,numeroQuestoes);
             
            int resposta=t.inserirTeste();
            if(resposta>0){
                for(capitulos c: t.getCapitulosAssociados()){
                    t.inserirCapituloTeste(c);
                }
            
            }
            try (PrintWriter out = response.getWriter()) {
             
              if(resposta>0){
             
             out.print("Sucesso");
                  
             
             }else if(resposta==-1){
             
             out.print("Não é possivel ligar à base de dados");
                  
             
             }else if(resposta==0){
             
             out.print("Por favor insira outra descricao para o teste");
                  
             
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
