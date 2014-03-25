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
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author josechavarria
 */
public class objetManipulation {

    /**
     * carregar lista de uc mediante uma chave pimária de m capitulo
     * @param c
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public  ArrayList<uc> carregarListaUc(int c) throws IOException, SQLException, ClassNotFoundException{
     ArrayList<uc> u= new ArrayList<>();
     try{
     MySQLConnector con = new MySQLConnector();  
     con.createConnection();
 
    String getUcCApitulos="SELECT uc.id, uc.descr FROM uc where uc.id in (select uc from ucCapitulo where capitulo='"+c+"')"; 
    //System.out.print(getUcCApitulos);
    ResultSet rs=con.executeQuery(getUcCApitulos);
    while(rs.next()){
        u.add(new uc(rs.getInt(1), rs.getString(2)));
    
    }
    con.closeConnection();
     }catch(IOException | SQLException | ClassNotFoundException Ex){
        System.out.print(Ex);
    
    }
    return u;
    }
public  ArrayList<curso> carregarListacursos(int c) throws IOException, SQLException, ClassNotFoundException{
     ArrayList<curso> cur= new ArrayList<>();
     try{
     MySQLConnector con = new MySQLConnector();  
     con.createConnection();
 
   String getCursosCapitulo="select curso.id, curso.descr from curso where curso.id in(select curso_id from ucCurso where uc_id in (SELECT id FROM uc where uc.id in (select uc from ucCapitulo where capitulo='"+c+"')))";
      ResultSet rs=con.executeQuery(getCursosCapitulo);
    while(rs.next()){
        cur.add(new curso(rs.getInt(1), rs.getString(2)));
    
    }
    con.closeConnection();
     }catch(IOException | SQLException | ClassNotFoundException Ex){
         System.out.print(Ex);
    
    }
    return cur;
    }
public  HashMap<Integer,String> AlunosTurno(int turno) throws IOException, SQLException, ClassNotFoundException{
    HashMap<Integer,String> alunos=new HashMap<>(); 
    try{
     MySQLConnector con = new MySQLConnector();  
     con.createConnection();
     String getAlunosTurno="select aluno.nAluno, utilizador.nome, utilizador.apelido from utilizador, turno, aluno, ucAluno\n" +
"where utilizador.id=aluno.utilizador_id and ucALuno.aluno=aluno.nAluno and  ucAluno.turno=turno.id and turno.id='"+turno+"'";
     ResultSet rs=con.executeQuery(getAlunosTurno);
    while(rs.next()){
       alunos.put(rs.getInt(1),rs.getString(2)+" "+rs.getString(3));
    
    }
    con.closeConnection();
     }catch(IOException | SQLException | ClassNotFoundException Ex){
         System.out.print(Ex);
    
    }
    return alunos;
    }
public  HashMap<Integer,String> CapitulosTurno(int turno) throws IOException, SQLException, ClassNotFoundException{
    HashMap<Integer,String> capitulos=new HashMap<>(); 
    try{
     MySQLConnector con = new MySQLConnector();  
     con.createConnection();
     String getAlunosTurno="SELECT capitulo.id, capitulo.descr from capitulo, turno, uc, ucCapitulo, ucCurso\n" +
"where ucCurso.id=turno.ucCurso and turno.id='"+turno+"' and ucCurso.uc_id=ucCapitulo.uc and ucCapitulo.capitulo=capitulo.id group by capitulo.id   ";
             ResultSet rs=con.executeQuery(getAlunosTurno);
    while(rs.next()){
       capitulos.put(rs.getInt(1),rs.getString(2));
    
    }
    con.closeConnection();
     }catch(IOException | SQLException | ClassNotFoundException Ex){
         System.out.print(Ex);
    
    }
    return capitulos;
    }
 public Date updateDate() throws IOException, SQLException, ClassNotFoundException{
   Date d=null;
  
   String getCapitulos="SELECT now()";
        ResultSet rs= (new MySQLConnector()).executeQuery(getCapitulos);
        while(rs.next()){
            
           d=rs.getDate(1);
        }
   
    return d;
   }
public boolean mudarEstadoTeste(int teste, int estado){

 String AlterarTeste="UPDATE `PlataformaMatematica`.`testes` SET `visivel` = '"+estado+"' WHERE `testes`.`id` =6;    ";
  try{
      MySQLConnector con= new MySQLConnector();
                            
         con.createConnection();
                con.executeSQL(AlterarTeste);
                con.closeConnection();
                
               //name aleready exists se 0; se !=0
                //inseiru se maior que 0
              return true;
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return false;//sql error
            }



}
}
