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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * estao guradados todos os elementos de um teste
 * @author josechavarria
 */
public class teste {
    int id=0;
    ArrayList<pergunta> enunciado;
    float desconto;
    float cotacao;
    int [] indicesRespostas;
    turno t;
    ArrayList<capitulos> capitulosAssociados;
    String descr;
    int numeroQuestoes;
    int indexAtual=0;

    

    public teste(float desconto, float cotacao, turno t, ArrayList<capitulos> capitulosAssociados, String descr, int numeroQuestoes) {
       
        this.desconto = desconto;
        this.cotacao = cotacao;
        this.t = t;
        this.capitulosAssociados = capitulosAssociados;
        this.descr = descr;
        this.numeroQuestoes = numeroQuestoes;
    }
     public teste(int id){
      if(this.iniciarTeste(id)==1){
        this.iniciarEnunciado();
      }
      
     }
 public teste(int id, boolean func){
      this.iniciarTeste(id,func);
      
      
     }

    public ArrayList<pergunta> getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(ArrayList<pergunta> enunciado) {
        this.enunciado = enunciado;
    }

    public int getIndexAtual() {
        return indexAtual;
    }

    public void setIndexAtual(int indexAtual) {
        this.indexAtual = indexAtual;
    }
     
  

    public turno getT() {
        return t;
    }

    public void setT(turno t) {
        this.t = t;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getNumeroQuestoes() {
        return numeroQuestoes;
    }

    public void setNumeroQuestoes(int numeroQuestoes) {
        this.numeroQuestoes = numeroQuestoes;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getCotacao() {
        return cotacao;
    }

    public void setCotacao(float cotacao) {
        this.cotacao = cotacao;
    }

    public int[] getIndicesRespostas() {
        return indicesRespostas;
    }

    public void setIndicesRespostas(int[] indicesRespostas) {
        this.indicesRespostas = indicesRespostas;
    }

    public ArrayList<capitulos> getCapitulosAssociados() {
        return capitulosAssociados;
    }

    public void setCapitulosAssociados(ArrayList<capitulos> capitulosAssociados) {
        this.capitulosAssociados = capitulosAssociados;
    }

    public int inserirTeste(){
        String inserirTeste="INSERT INTO `PlataformaMatematica`.`testes` (`id`, `turno`, `numeroquestoes`, `desconto`, `cotacao`, `visivel`, `descr`) VALUES (NULL, '"+this.t.getId()+"', '"+this.numeroQuestoes+"', '"+this.desconto+"', '"+this.cotacao+"', '0', '"+this.descr+"');";
  try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                this.id =con.executeSQLReturnAI(inserirTeste);
                con.closeConnection();
                
                return this.id; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
              
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            }
  
  
  

  }

    //INSERT INTO `PlataformaMatematica`.`testeCapitulo` (`teste`, `capitulo`) VALUES ('1', '9');
    
    public int inserirCapituloTeste(capitulos c){
        String inserirCapitulosTeste="INSERT INTO `PlataformaMatematica`.`testeCapitulo` (`teste`, `capitulo`) VALUES ('"+this.id+"', '"+c.getId()+"')";
        int idR;        
        try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                idR =con.executeSQLReturnAI(inserirCapitulosTeste);
                con.closeConnection();
                
                return idR; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
              
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            }
  
  
  

  }
    int iniciarTeste( int id){
         String Teste="SELECT numeroquestoes, desconto, cotacao\n" +
"FROM testes\n" +
"WHERE id = '"+id+"'";
         try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                ResultSet rs= con.executeQuery(Teste);
                 if(rs.next()){
                     
                     this.numeroQuestoes=rs.getInt(1);
                     this.cotacao=rs.getFloat(3);
                     this.desconto=rs.getFloat(2);
                 }
                con.closeConnection();
                if(this.numeroQuestoes>0){
                    this.id=id;
                return 1; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
                }else{
                    return 0;
                }
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            }
  
    
    }
     int iniciarTeste( int id ,boolean func){
         String Teste="SELECT numeroquestoes, desconto, cotacao, turno, descr\n" +
"FROM testes\n" +
"WHERE id = '"+id+"'";
         System.out.println(Teste);
         try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                ResultSet rs= con.executeQuery(Teste);
                 if(rs.next()){
                     
                     this.numeroQuestoes=rs.getInt(1);
                     this.cotacao=rs.getFloat(3);
                     this.desconto=rs.getFloat(2);
                     this.descr=rs.getString(5);
                     this.t=new turno(rs.getInt(4));
                 }
                con.closeConnection();
                if(this.numeroQuestoes>0){
                    this.id=id;
                return 1; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
                }else{
                    return 0;
                }
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            }
  
    
    }


    int iniciarEnunciado(){
    String getPerguntas="select pergunta.id from pergunta, testeCapitulo where pergunta.capitulo_id=testecapitulo.capitulo  and testeCapitulo.teste='"+this.id+"' group by pergunta.id order by rand()";
    String getNPerguntas="select count(pergunta.id) from pergunta, testeCapitulo where pergunta.capitulo_id=testecapitulo.capitulo  and testeCapitulo.teste='"+this.id+"' order by rand()";
        int numeroQuestoesDisponiveis=0;
        try{
                    System.out.println(getNPerguntas);  
   
            enunciado=new ArrayList<>();
            MySQLConnector con= new MySQLConnector();
                con.createConnection();
                ResultSet rs= con.executeQuery(getNPerguntas);
                if(rs.next()){
                    numeroQuestoesDisponiveis=rs.getInt(1);
                    
                    
                }
                if(numeroQuestoesDisponiveis>=this.numeroQuestoes){
                rs=con.executeQuery(getPerguntas);
                
                 while(rs.next()&&this.enunciado.size()<this.numeroQuestoes){
                     pergunta p= new pergunta();
                     p.Iniciarpergunta(rs.getInt(1));
                     this.enunciado.add(p);
                  
                            
                 }
                 
                 
                con.closeConnection();
                }else{
                    con.closeConnection();
                    return 0;
                    
                }
                System.out.println(this.enunciado.size());
                if(this.numeroQuestoes>0){
                return 1; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
                }else{
                    return 0;
                }
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            
    
    }



    }
 public int registarTeste(int aluno){
     String inserirTeste="INSERT INTO `PlataformaMatematica`.`testeAluno` (`aluno`, `teste`) VALUES ('"+aluno+"', '"+this.id+"')";
             try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                int idTeste =con.executeSQLReturnAI(inserirTeste);
                 System.out.println(inserirTeste+idTeste);
                con.closeConnection();
                return registarRespostas(idTeste);
                  //name aleready exists se 0; se !=0
                //inseiru se maior que 0
              
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            }
  
  
 
 
 }
 
 public int registarRespostas(int testeAluno){
 
     String inserirRespostas;
             try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                con.executeSQL("Delete from respostaTeste where respostaTeste.teste='"+testeAluno+"'");
                for(pergunta p:this.enunciado){
                    if(p.getRespostaDada()<5){
                        inserirRespostas="INSERT INTO `PlataformaMatematica`.`respostaTeste` (`resposta`, `teste`) VALUES ('"+p.getListaRespostas().get(p.getRespostaDada()).getId()+"', '"+testeAluno+"')";
                         System.out.println(inserirRespostas); 
                        con.executeSQL(inserirRespostas);
                        
                     }
                }
                con.closeConnection();
                
                return 1; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
              
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            }
  
  
 
 
 
 
 
 }
 
 
   public HashMap<Integer,linha> criarLinhas(){
        try {
            
            HashMap<Integer,linha> retorno = new HashMap<>();
            ArrayList<celula> celulasIntermedias=new ArrayList<>();
            celulasIntermedias.add(new celula(0,"NumeroRespostas"));
            celulasIntermedias.add(new celula(1,this.numeroQuestoes+""));
            retorno.put(0,new linha(celulasIntermedias));
             celulasIntermedias=new ArrayList<>();
            celulasIntermedias=new ArrayList<>();
            celulasIntermedias.add(new celula(0,"Cotacao"));
            celulasIntermedias.add(new celula(1,StrinUtils.pointTosmicolon(this.cotacao)));
            retorno.put(1,new linha(celulasIntermedias));
            celulasIntermedias=new ArrayList<>();
         
            celulasIntermedias.add(new celula(0,"Desconto"));
            celulasIntermedias.add(new celula(1,StrinUtils.pointTosmicolon(this.desconto)));
            retorno.put(2,new linha(celulasIntermedias));
            celulasIntermedias=new ArrayList<>();
            celulasIntermedias.add(new celula(0,"Numero"));
            celulasIntermedias.add(new celula(1,"Nome"));
            celulasIntermedias.add(new celula(2,"Total Respondidas"));
            celulasIntermedias.add(new celula(3,"Corretas"));
            celulasIntermedias.add(new celula(4,"Nota Final"));
            
            retorno.put(3,new linha(celulasIntermedias));
            objetManipulation ob= new objetManipulation();
            HashMap<Integer,String> alunos=ob.AlunosTurno(this.t.getId());
            ArrayList<celula> celulas=new ArrayList<>();
            Set<Integer> nAluno= alunos.keySet();
            int contador=4;
            HashMap<Integer,Integer> alunoTeste= AlunosTeste();
             for(Integer i:nAluno ){
                
               if(alunoTeste.get(i)!=null){
                    contador++;
                    celulas=new ArrayList<>();
                    celulas.add(new celula(0,i.toString()));
                    celulas.add(new celula(1,alunos.get(i)));
                    celulas.add(new celula(2,contarTotal(alunoTeste.get(i))+""));
                    celulas.add(new celula(3,contarcertas(alunoTeste.get(i))+""));
                    celulas.add(new celula(4,"D"+contador+"*B2-(C"+contador+"-D"+contador+")*B3\n",true));
                    retorno.put(contador-1, new linha(celulas));
               }
                
            }   
            return retorno;
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
   }
    
 
public int  contarTotal(int teste){
    
    
        int rcertas=0 ;

     try{
     MySQLConnector con = new MySQLConnector();  
     con.createConnection();
     String getAlunosTurno="SELECT count(`resposta`)'Respostas Certas' FROM `respostaTeste`  WHERE (`teste` ="+ teste +" )";
             ResultSet rs=con.executeQuery(getAlunosTurno);
    if(rs.next()){
       rcertas = rs.getInt(1);
    }
    con.closeConnection();
     }catch(IOException | SQLException | ClassNotFoundException Ex){
         System.out.print(Ex);
    
    }
     
    return rcertas;
}
   
public int  contarcertas(int teste){
    
    
        int rcertas=0 ;

     try{
     MySQLConnector con = new MySQLConnector();  
     con.createConnection();
     String getAlunosTurno="SELECT count(`resposta`)'Respostas Certas' FROM `respostaTeste` , `resposta` WHERE (`resposta` = `id` and `correta`=1 and `teste` ="+ teste +" )";
             ResultSet rs=con.executeQuery(getAlunosTurno);
    if(rs.next()){
       rcertas = rs.getInt(1);
    }
    con.closeConnection();
     }catch(IOException | SQLException | ClassNotFoundException Ex){
         System.out.print(Ex);
    
    }
     
    return rcertas;
}
 public  HashMap<Integer,Integer> AlunosTeste() throws IOException, SQLException, ClassNotFoundException{
    HashMap<Integer,Integer> testes =new HashMap<>(); 
    try{
     MySQLConnector con = new MySQLConnector();  
     con.createConnection();
     String getAlunosTeste="SELECT id, aluno FROM testeAluno WHERE teste = '"+this.id+"'";
     ResultSet rs=con.executeQuery(getAlunosTeste);
    while(rs.next()){
       testes.put(rs.getInt(2), rs.getInt(1));
    }
    con.closeConnection();
     }catch(IOException | SQLException | ClassNotFoundException Ex){
         System.out.print(Ex);
    
    }
    return testes;
    }
}
