/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.IOException;
import java.sql.SQLException;

/**
 * classe que armazena od dados de uma determinada classe
 * @author josechavarria
 */
public class resposta {
    int id;
    String latexCode;
    boolean correta;
    int tentativa=0;
    public resposta (){
        this.latexCode="";
        this.correta=false;
    }

    public resposta(int id, String latexCode, boolean correta) {
        this.id = id;
        this.latexCode = latexCode;
        this.correta = correta;
    }

    public resposta(String latexCode, boolean correta) {
        this.latexCode = latexCode;
        this.correta = correta;
    }

    public resposta(boolean correta) {
        this.correta = correta;
    }
    

    public int getTentativa() {
        return tentativa;
    }

    public void setTentativa(int tentativa) {
        
        this.tentativa=tentativa;
        
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatexCode() {
        return latexCode;
    }
    
    public boolean verificarResposta(){
    boolean result=true;
        if(latexCode==null){
        result=false;
    }
    else if((new renderLatex()).renderLatex(latexCode)==null){
    
    result=false;
    
    }
    return result;
    }
    public void setLatexCode(String latexCode) {
        this.latexCode = latexCode;
    }

    /**
     * Insere uma instancia deste oobjeto e retorna true em caso de sucesso
     * @param idPergunta
     * @return
     */
    public boolean inserirResposta(int idPergunta){
    try{
         String latex=this.latexCode.replace("\\", "\\\\"); 
         MySQLConnector con= new MySQLConnector();
         con.createConnection();
        if(this.id==0){
        
        String insertResposta="INSERT INTO `PlataformaMatematica`.`resposta` (`id`, `latex`, `correta`, `pergunta_id`) VALUES (NULL, '"+latex+"', '"+(new randUtils()).boolean2TinyInt(this.correta)+"', '"+idPergunta+"')";
                        this.id=con.executeSQLReturnAI(insertResposta);
         
        }else{
            //cod update
            String updateResposta="UPDATE resposta SET  latex='"+latex+"', correta='"+(new randUtils()).boolean2TinyInt(this.correta)+"' WHERE resposta.id ='"+this.id+"'";
          
            con.executeSQL(updateResposta);
      }
           con.closeConnection();
    return true;
    
    }catch(IOException | ClassNotFoundException | SQLException ex){
    return false;
    }
    
    }
    
}
