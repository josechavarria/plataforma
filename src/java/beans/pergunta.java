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
import java.util.Collections;
import java.util.Iterator;

/**
 * Esta classe agrega dados relativoa á pergunta 
 * @author josechavarria
 */
public class pergunta {

    int id=0;
    String latexCode;
    String dica;
    ArrayList<resposta> listaRespostas;
    ArrayList<curso> listaCursos;
   
    int[] indexRespostas;
    int tentativas = 0;//usado para contar as tentativas
    capitulos c;
    ArrayList<uc> lUc;
    int respostaDada=5;

    public void setRespostaDada(int respostaDada) {
        this.respostaDada = respostaDada;
    }

    public int getRespostaDada() {
        return respostaDada;
    }

    public ArrayList<curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public void setLatexCode(String latexCode) {
        this.latexCode = latexCode;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public void setListaRespostas(ArrayList<resposta> listaRespostas) {
        this.listaRespostas = listaRespostas;
    }

    public void setIndexRespostas(int[] indexRespostas) {
        this.indexRespostas = indexRespostas;
    }

    
    ArrayList<resposta> novoAlRVazio() {
        ArrayList<resposta> r = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            r.add(new resposta());
        }
        return r;
    }
    public capitulos getC() {
        return c;
    }

    public void setC(capitulos c) {
        this.c = c;
    }

    public ArrayList<uc> getlUc() {
        return lUc;
    }

    public void setlUc(ArrayList<uc> lUc) {
        this.lUc = lUc;
    }

    /**
     *Inicia uma nova pergunta vazia
     */
    public void novaPerguntaVazia() {
        this.latexCode = "";
        this.dica = "";
        this.listaRespostas = novoAlRVazio();
    }

    /**
     * carrega todos os dados para a instancia de uma pergunta recebendo a chave primária correspondete na base de dados
     * @param idPergunta
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean Iniciarpergunta(int idPergunta) throws IOException, SQLException, ClassNotFoundException {
        this.id = idPergunta;
        this.carregarPergunta();
        this.carregarRespostas(idPergunta);
//        this.indexRespostas = this.CarregarIndexRespostas();
        return true;
    }

    /**
     * inicia os dados de uma pergunta existente para a editar
     * @param idPergunta
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean IniciarperguntaEditar(int idPergunta) throws IOException, SQLException, ClassNotFoundException {
        this.id = idPergunta;
        this.carregarPergunta();
        this.carregarRespostas(idPergunta);
          return true;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public int[] getIndexRespostas() {
        return indexRespostas;
    }

    public String getLatexCode() {
        return latexCode;
    }

    public String getDica() {
        return dica;
    }
    
    
    
    
    
    
    

    public ArrayList<resposta> getListaRespostas() {
        return listaRespostas;
    }

    /**
     * carregar para a instancia todos os dados relativos á tabla pergunta
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void carregarPergunta() throws IOException, SQLException, ClassNotFoundException {
        String latex = null;
        try{
        MySQLConnector con = new MySQLConnector();
        con.createConnection();
        String queryGetPergunta = "SELECT latex, Dica, capitulo_id FROM pergunta WHERE id='" + this.id + "'";
        ResultSet rs = con.executeQuery(queryGetPergunta);
        if (rs.next()) {
            this.latexCode = rs.getString(1);
;
            this.dica = rs.getString(2);
            this.c=this.carregarCapitulo(rs.getInt(3));
                }
        con.closeConnection();
        }catch(IOException | SQLException | ClassNotFoundException ex){
        }

    }

    /**
     * retorna um arraylist de respostas ou seja registos da tabela resposta correpondentes a uma pergunta
     * @param idPergunta
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void carregarRespostas(int idPergunta) throws IOException, SQLException, ClassNotFoundException {
       
        try{
            this.listaRespostas=new ArrayList<>();
        
        ResultSet rs;
        MySQLConnector con = new MySQLConnector();
        String queryGetRespostaCorreta = "SELECT id, latex FROM 	resposta WHERE pergunta_id='" + this.id + "' and correta='1' Group By id";
        rs = con.executeQuery(queryGetRespostaCorreta);
        if (rs.next()) {
            this.listaRespostas.add(new resposta(rs.getInt(1), rs.getString(2), true));
            
        }
        String queryGetRespostaserradas = "SELECT id, latex  FROM 	resposta WHERE pergunta_id='" + this.id + "' and correta='0' Group By id order by RAND()";
        rs = con.executeQuery(queryGetRespostaserradas);
            System.out.println(queryGetRespostaserradas);
        while (this.listaRespostas.size()<4&&rs.next()) {
            //resposta(int id, String latexCode, boolean correta)
         
            
            this.listaRespostas.add(new resposta(rs.getInt(1), rs.getString(2), false));
           
        }
        con.closeConnection();
        }catch(Exception Ex){
            
        }
        Collections.shuffle(this.listaRespostas);
    }

    /**
     *verifica se uma pergunta é apresentável ou seja todos os dados estão corretos
     * @return
     */
    public boolean verifcarPergunta() {
        boolean result = true;
        Iterator i = this.listaRespostas.iterator();
        if (latexCode == null) {
            result = false;
        } else if ((new renderLatex()).renderLatex(latexCode) == null) {
            result = false;
        }
        for (resposta r : this.listaRespostas) {
            if (!r.verificarResposta()) {
                result = false;
            }
        }

        return result;

    }

     /**
     *cada pergunta tem 7 respostas possiveis
     * este metodo é responsável por indicar quanis as perguntas que serão usadas
     * @return
     */
    /*int[] CarregarIndexRespostas() {

        int[] index = new int[4];
        System.out.println(listaRespostas.size());
        int[] aux = (new beans.randUtils()).getRandomNumbers(3, this.listaRespostas.size() , 1);
        System.out.println("1");
        int[] aux1 = new int[4];
        int[] aux2;
        aux1[0] = 0;
        for (int i = 1; i < 4; i++) {
            aux1[i] = aux[i - 1];
        }
        System.out.println("2");
        aux2 = (new beans.randUtils()).getRandomNumbers(4, 4, 0);
        for (int i = 0; i < 4; i++) {

            index[i] = aux1[aux2[i]];
        }

        return index;

    }*/

    /**
     * valaia se uma determina resposta é correta
     * @param index
     * @return
     */
    public boolean iscorret(int index) {
        this.setTentativas(this.getTentativas() + 1);
        return this.listaRespostas.get(index).isCorreta();
            
    }

    /**
     * regista uma resposta dada por um utilizador
     * @param index
     * @param idaluno
     */
    public boolean registarRespostacaderno(int index, int idaluno) {
        
        try {
            String inserirResposta="INSERT INTO `PlataformaMatematica`.`alunoResposta` (`aluno`, `resposta`, `data`) VALUES ('"+idaluno+"', '"+this.listaRespostas.get(index).getId()+"', ( now()))";
            
            MySQLConnector con = new MySQLConnector();
           con.executeSQL(inserirResposta);
            con.createConnection();
            
            con.closeConnection();
            return true;
            

        } catch (IOException | ClassNotFoundException | SQLException ex) {
            return false;
        }
        
        
      

    }
    
     

    /**
     * insere ou atualiza uma determinada pergunta na base de dados
     * @return
     */
    public boolean inserirPergunta() {
        try {
            String associarPerguntaUc;
            String associarPerguntaCurso;
            MySQLConnector con = new MySQLConnector();
             String latex=this.latexCode.replace("\\", "\\\\"); 
            con.createConnection();
            if (this.id == 0) {
               
                String insertPergunta ="INSERT INTO `PlataformaMatematica`.`pergunta` (`id`, `Dica`, `latex`, `capitulo_id`, `valida`) VALUES (NULL, '"+this.dica+"', '"+latex+"', '"+this.c.getId()+"', '1')"; 
                    //"INSERT INTO `PlataformaMatematica`.`perguntas` (`id`, `Dica`, `latex`, `capitulos_id`) VALUES (NULL, '" +this.dica + "', '" + this.latexCode + "', '" + this.c + "');";

                this.id = con.executeSQLReturnAI(insertPergunta);

            } else {
                //cod update
                String updatePergunta="UPDATE pergunta SET Dica ='"+this.dica+"', capitulo_id='"+this.getC().getId()+"',latex ='"+latex+"' WHERE pergunta.id ='"+this.id+"'";
                System.out.println(updatePergunta);
                con.executeSQL(updatePergunta);
            }
            for (resposta r : this.listaRespostas) {
                if(!r.getLatexCode().isEmpty()){
                    if(!r.inserirResposta(id)){
                    return false;
                    }
                }
               }
             con.executeSQL("DELETE FROM PerguntaUc WHERE pergunta_id='"+this.id+"'");
                
            for (uc u : this.lUc) {
                    associarPerguntaUc="INSERT INTO `PlataformaMatematica`.`PerguntaUc` (`pergunta_id`, `uc_id`) VALUES ('"+this.id+"', '"+u.getId()+"')";
                
                   con.executeSQL(associarPerguntaUc);
           }
              con.executeSQL("DELETE FROM PerguntaCurso WHERE pergunta_id='"+this.id+"'");
              
            for(curso curso: this.listaCursos){
               
                associarPerguntaCurso="INSERT INTO `PlataformaMatematica`.`PerguntaCurso` (`pergunta_id`, `curso_id`) VALUES ('"+this.id+"', '"+curso.getId()+"')";
                 con.executeSQL(associarPerguntaCurso);
            }

            con.closeConnection();
            return true;
            

        } catch (IOException | ClassNotFoundException | SQLException ex) {
            return false;
        }
        

    }

    /**
     *
     * @return
     */
   
   
       public capitulos carregarCapitulo( int id){
    
        try{
       
        MySQLConnector con = new MySQLConnector();
        con.createConnection();
        String queryGetPergunta = "SELECT * FROM capitulo where capitulo.id='"+id+"'";
        ResultSet rs = con.executeQuery(queryGetPergunta);
        if (rs.next()) {
            c= new capitulos(rs.getInt(1), rs.getString(2));
           
        }
        con.closeConnection();
       
        }catch(IOException | SQLException | ClassNotFoundException ex){
        }
        return c;
    }

}
