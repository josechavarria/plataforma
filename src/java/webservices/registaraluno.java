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
 * @author josechavarria
 */
@WebServlet(name = "registaraluno", urlPatterns = {"/registaraluno"})
public class registaraluno extends HttpServlet {

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
           //username=testeA1&nome=testeA&apelido=testeA
           //&n_aluno=6758&password=68db750f9d45ac8a0dbc39ae184847c1c19352b0&
           //password2=7c4a8d09ca3762af61e59520943dc26494f8941b&
           //cc=13744312+1+ZZ1&curso=%5B4%2C+5%2C+6%2C+7%5D
            String nome=request.getParameter("nome");
            String apelido=request.getParameter("apelido");
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String password2=request.getParameter("password2");
               String CC=request.getParameter("cc");
               int curso=Integer.parseInt(request.getParameter("curso"));
            int numeroaluno=Integer.parseInt(request.getParameter("n_aluno"));
            se.setUtilizadorInserir(new user(0,nome,apelido,username,password,"aluno",CC));
           int resposta=0;
                if(password.equals(password2)){
                        resposta=se.getUtilizadorInserir().verificarnALuno(numeroaluno);
                           if(resposta==0){ 
                                 if(se.getUtilizadorInserir().inserirUtilizador()==0){
                                     resposta=-2;
                                 }
                             
                               if(resposta==0){
                                   se.getUtilizadorInserir().associarUtilizadorAluno(numeroaluno,se.getUtilizadorInserir().getId(),curso);

                               }
                           }else if(resposta>0){
                               resposta=-4; // numero de aluno atribuidp
                           }else{
                               resposta=-1;
                           }
                }else{
                    resposta=-3;
                }
            try (PrintWriter out = response.getWriter()) {
             
               if(resposta==-4){
             
             out.print("Número de aluno registado");
                  
             
             } else if(resposta==-2){
             
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
        return "Short descrription";
    }// </editor-fold>

}
