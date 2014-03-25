/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

/**
 * armazena dados relativos a um caderno de exercicios
 * @author josechavarria
 */
public class cadernoExercicios {
    
    ArrayList<pergunta> enunciado=new ArrayList<>();
    pergunta perguntaAtual;
    uc ucAtual;
    capitulos cAtual;

    /**
     * insere uma nova pergunta no objeto que vai ser respondida pelo aluno
     * @param indice
     * @param curso
     * @return
     */
    public pergunta novaPerguntaALteaoria( int curso){
    pergunta p=new pergunta();
    int contador=1;
    String getNumeroPerguntas="select pergunta.id from pergunta where pergunta.id in( select pergunta_id from PerguntaCurso where curso_id='"+curso+"') and pergunta.id in (select pergunta_id from PerguntaUc where uc_id='"+this.ucAtual.getId()+"' ) and pergunta.capitulo_id='"+this.cAtual.getId()+"' order by RAND()";
            try{ 
                 MySQLConnector con= new MySQLConnector();
                con.createConnection();
                ResultSet rs= con.executeQuery(getNumeroPerguntas);
                if(rs.next()){
                    
                    p.Iniciarpergunta(rs.getInt(1));
               
                   
                }
                
                con.closeConnection();
                //name aleready exists se 0; se !=0
                //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return null;//sql error
            }
   
    
    return p;
    }

    /**
     * retorna o numero de perguntas disponioveis para um determinado capitulo
     * @param c
     * @return
     */
    public int numeroPerguntasCapitulo(int c){
            int numeroPerguntas=0;
            System.out.println("nkgbh agsvhbjnmhbfgvcdxsjnkmj"+this.cAtual.getId());
            String getNumeroPerguntas="select count(*) from pergunta where pergunta.id in( select pergunta_id from PerguntaCurso where curso_id='"+c+"') and pergunta.id in (select pergunta_id from PerguntaUc where uc_id='"+this.ucAtual.getId()+"' ) and pergunta.capitulo_id='"+this.cAtual.getId()+"' ";
            System.out.println(getNumeroPerguntas);
               
            try{ 
                 MySQLConnector con= new MySQLConnector();
                con.createConnection();
                ResultSet rs= con.executeQuery(getNumeroPerguntas);
                if(rs.next()){
                  numeroPerguntas=rs.getInt(1);
                }
                con.closeConnection();
                 return numeroPerguntas; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return 0;//sql error
            }
   
            
    }
    

    
    

    public ArrayList<pergunta> getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(ArrayList<pergunta> enunciado) {
        this.enunciado = enunciado;
    }

    public uc getUcAtual() {
        return ucAtual;
    }

    public void setUcAtual(uc ucAtual) {
        this.ucAtual = ucAtual;
    }

    public pergunta getPerguntaAtual() {
        return perguntaAtual;
    }

    public void setPerguntaAtual(pergunta perguntaAtual) {
        this.perguntaAtual = perguntaAtual;
    }

    public capitulos getcAtual() {
        return cAtual;
    }

    public void setcAtual(capitulos cAtual) {
        this.cAtual = cAtual;
    }

   
    
}
