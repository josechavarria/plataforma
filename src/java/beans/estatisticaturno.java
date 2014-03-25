/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josechavarria
 */
public class estatisticaturno {
     turno t;
    HashMap<Integer,String> capitulos;
    HashMap<Integer,String> Alunos;
    HashMap<Integer,linha> linhas;

    public estatisticaturno(int turno) {
        try {
            this.t=new turno(turno);
            
            objetManipulation obM= new objetManipulation();
            Alunos=  obM.AlunosTurno(turno);
            capitulos=obM.CapitulosTurno(turno);
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(estatisticaturno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public byte[] excellFille(){
        try {
            /*  for(int i=0; i<10; i++){
    
            celulas.add(new celula(i,"asada"+i));
        }
        HashMap<Integer,linha> linhas=new HashMap<>();
         for(int i=0; i<10; i++){
             l= new linha(celulas);
            linhas.put(new Integer(i) , l);
        }*/
         linhas=new HashMap<>();
            linhas.put(0,this.criarLinhaCapitulos());
            System.out.println(linhas);
            linhas.put(1,this.criarLinhaIntermedia());
            Set<Integer> nAlunos= Alunos.keySet();
              int i=1;
            for(Integer n: nAlunos){
                i++;
                   linhas.put(i, this.linhaAluno(n));
                      }
            Date d=new objetManipulation().updateDate();
            System.out.println(d);
            ExcelFiles excel=(new ExcelFiles());
             return  excel.ficheiroExcell(linhas,this.t.getdescr()+""+d+"");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(estatisticaturno.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    }
  
    
    int totaRespostasAlunoCaderno(int aluno, int capitulo ){
      int n=0;
        try{
          
          String totalRespostas="select Count(Alunoresposta.id) from resposta, alunoResposta, pergunta where resposta.pergunta_id=pergunta.id and alunoResposta.resposta=resposta.id\n" +
            "and pergunta.capitulo_id='"+capitulo+"'  and alunoResposta.aluno='"+aluno+"' group by alunoResposta.id";
          MySQLConnector con= new MySQLConnector();
       ResultSet rs=con.executeQuery(totalRespostas);
    if(rs.next()){
        n=rs.getInt(1);
    }
    con.closeConnection();
     }catch(IOException | SQLException | ClassNotFoundException Ex){
         System.out.print(Ex);
         return 0;
    
    }
    
    return n;
    
    }
    
    int totalRespostasCorretasAlunoCaderno(int aluno, int capitulo){
      int n=0;
        try{
          
          String totalRespostasCorretas="select Count(Alunoresposta.id) from resposta, alunoResposta, pergunta where resposta.pergunta_id=pergunta.id and alunoResposta.resposta=resposta.id\n" +
            "and pergunta.capitulo_id='"+capitulo+"'  and alunoResposta.aluno='"+aluno+"' and resposta.correta='1' group by alunoResposta.id";
        
          MySQLConnector con= new MySQLConnector();
       ResultSet rs=con.executeQuery(totalRespostasCorretas);
    if(rs.next()){
        n=rs.getInt(1);
    }
    con.closeConnection();
     }catch(IOException | SQLException | ClassNotFoundException Ex){
         System.out.print(Ex);
         return 0;
    
    }
    
    return n;
    }
 
           public linha criarLinhaIntermedia(){
             ArrayList<celula> celulasIntermedias=new ArrayList<>();
              celulasIntermedias.add(new celula(0,"Numero"));
              
             celulasIntermedias.add(new celula(1,"Nome"));
             
              for(int i=2;i<((capitulos.size())*2)+2;i=i+2){
                 celulasIntermedias.add(new celula(i,"Total"));
                 celulasIntermedias.add(new celula(i+1,"Corretas"));

             }

            linha linhaIntermedia=new linha(celulasIntermedias); 
             return linhaIntermedia;
    }
            public linha criarLinhaCapitulos(){
             ArrayList<celula> celulasCapitulos=new ArrayList<>();
               celulasCapitulos.add(new celula(0,""));
            celulasCapitulos.add(new celula(1,""));
          
              Set<Integer> idsCapitulos= capitulos.keySet();
             int i=1;
            for(Integer id : idsCapitulos) {
                i++;
                celulasCapitulos.add(new celula(i,capitulos.get(id)));
                i++;
                celulasCapitulos.add(new celula(i,""));
            }
            
             linha l=new linha(celulasCapitulos);
             return l;
    }
            public linha linhaAluno(int id){
                ArrayList<celula> celulasAluno=new ArrayList<>();
                 celulasAluno.add(new celula(0,""+id));
               
               celulasAluno.add(new celula(1,Alunos.get(id)));
                      
                 int i=1;
                  Set<Integer> idsCapitulos= capitulos.keySet();
          
                for(Integer idCapitulos : idsCapitulos) {
                        i++;
                        celulasAluno.add(new celula(i,""+totaRespostasAlunoCaderno(id,idCapitulos)));
                        i++;
                        celulasAluno.add(new celula(i,""+totalRespostasCorretasAlunoCaderno(id,idCapitulos)));
                    }
                linha l=new linha(celulasAluno);
                return l;
                }

    public turno getT() {
        return t;
    }

    public void setT(turno t) {
        this.t = t;
    }

    public HashMap<Integer, String> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(HashMap<Integer, String> capitulos) {
        this.capitulos = capitulos;
    }

    public HashMap<Integer, String> getAlunos() {
        return Alunos;
    }

    public void setAlunos(HashMap<Integer, String> Alunos) {
        this.Alunos = Alunos;
    }

    public HashMap<Integer, linha> getLinhas() {
        return linhas;
    }

    public void setLinhas(HashMap<Integer, linha> linhas) {
        this.linhas = linhas;
    }
    
    
    
    }
   
    
    
    
    
    
    
    
    
       
    

