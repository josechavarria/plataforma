/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import beans.*;
import beans.session;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "NewrndQ", urlPatterns = {"/NewrndQ"})
public class NewrndQ extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
      /* if(se==null){
       ArrayList<Integer> listaIdsPerguntas=new ArrayList<Integer>();
       String queryGetIdPerguntas="SELECT id FROM perguntas";
    
        MySQLConnector con=new MySQLConnector();
        pergunta perguntaAlvo=new pergunta();
        ResultSet rs=con.executeQuery(queryGetIdPerguntas);
        while(rs.next()){
        listaIdsPerguntas.add(rs.getInt(1));
        }
        con.closeConnection();
        
        int id=randUtils.randomNumber(1, listaIdsPerguntas.size()-1);
           try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
           out.print(id);
        }
        
        perguntaAlvo.Iniciarpergunta(listaIdsPerguntas.get(id));
        se.getListaPerguntas().add(perguntaAlvo);
      //  se.setIndexAtual(se.getListaPerguntas().size()-1);
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
           out.print("true");
        }}else{
       
       response.sendRedirect(request.getContextPath());
       }*/
         if(se==null){
       response.sendRedirect(request.getContextPath());
       
       } else {
                     
                  
                if(se.getUs().getTipo().equals("aluno") && se.isvalid() ) {
                    
                    if(se.getCaderno().getPerguntaAtual()!=null){
                        se.getCaderno().getEnunciado().add(se.getCaderno().getPerguntaAtual());
                    
                    }
                        
                     int numeroPerguntas=se.getCaderno().numeroPerguntasCapitulo(se.getUs().getCursoAluno().getId());
                
                      int id=0;
                     
                     if(numeroPerguntas>0){
                      
                     do{
                            
                       se.getCaderno().setPerguntaAtual(se.getCaderno().novaPerguntaALteaoria(se.getUs().getCursoAluno().getId()));
                   
                            
                           
                       
                    
                         
                     
                     }while(!se.getCaderno().getPerguntaAtual().verifcarPergunta());
                      try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                       out.print(1);
                     }
                     }else{
                     try (PrintWriter out = response.getWriter()) {
                            /* TODO output your page here. You may use following sample code. */
                            out.print(0);
                                         } 
                     
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewrndQ.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewrndQ.class.getName()).log(Level.SEVERE, null, ex);
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
