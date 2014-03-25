/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author josechavarria
 */
public final   class user {
      int id;
    String username;
    String nome;
    String Apelido;
    String password;
    String tipo;
    int nALuno=0;
    String cc;
    curso cursoAluno;
    teste testeExecutar;
    public user(int id, String nome,  String Apelido,String username, String password, String tipo, String cc) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.Apelido = Apelido;
        this.password = password;
        this.tipo = tipo;
        this.cc=cc;
    }
      public user(int id, String nome,  String Apelido,String username, String password, String tipo) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.Apelido = Apelido;
        this.password = password;
        this.tipo = tipo;
        if(this.tipo.equals("aluno")){
        this.cursoAluno=cursoUtilizador();
        this.nALuno=nAluno();
        }
      
    }

    public teste getTesteExecutar() {
        return testeExecutar;
    }

    public void setTesteExecutar(teste testeExexutar) {
        this.testeExecutar = testeExexutar;
    }

    public curso getCursoAluno() {
        return cursoAluno;
    }

    public int getnALuno() {
        return nALuno;
    }

    public void setnALuno(int nALuno) {
        this.nALuno = nALuno;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String Apelido) {
        this.Apelido = Apelido;
    }

    public String getPassword() {
        return password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
     /**
     * Insere a intancia do objeto na base de dados como um novo utilizador
     * @param professor
     * @param ucCurso
     * @param descr
     * @return
     */
    public int inserirUtilizador(){
        if(this.id==0){
            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                String inserirUtilizador ="INSERT INTO `PlataformaMatematica`.`utilizador` (`id`, `nome`, `apelido`, `username`, `password`, `tipoUtilizador_id`, `CC`) VALUES (NULL, '"+this.nome+"', '"+this.Apelido+"', '"+this.username+"', '"+this.password+"',(select id from tipoUtilizador where tipoUtilizador.descr='"+this.tipo+"'),'"+this.cc+"')"; 
                System.out.println(inserirUtilizador);
                this.id =con.executeSQLReturnAI(inserirUtilizador);
                con.closeConnection();
                
                return this.id; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
              
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            }
        }else{
            return -1;
        }
  
    }

    /**
     * insere um tulizador como anluno na base de dados
     * @param nAluno
     * @param id
     * @param curso
     * @return
     */
    public boolean associarUtilizadorAluno(int nAluno, int id, int curso){
    try{
            MySQLConnector con= new MySQLConnector();
            con.createConnection();
           String associar="INSERT INTO `PlataformaMatematica`.`Aluno` (`nAluno`, `utilizador_id`, curso, anoletivo) VALUES ('"+nAluno+"', '"+id+"','"+curso+"',(select current_ano_letivo()))";
            con.executeSQL(associar);
            System.out.println(associar);
            con.closeConnection();
            return true; 
            }catch(IOException | SQLException | ClassNotFoundException Ex){
            return false;//sql error
        }
   
   }
    /**
     * Mudar a plavra passe do utilizador
     * @param p1
     * @param p2
     * @return
     */
    public boolean MudarRegistoPalavraPasse(String p){
            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                String mudarPalavraPasse ="UPDATE `PlataformaMatematica`.`utilizador` SET `password` ='"+p+"' WHERE `utilizador`.`id` ="+this.id+"";
               con.executeSQL(mudarPalavraPasse);
                con.closeConnection();
                return true; 
                }catch(IOException | SQLException | ClassNotFoundException Ex){
                return false;//sql error
            }
         }
    
    /**
     * alterar a string palavra passe p1 e p2 devem ser iguais
     * @param p1
     * @param p2
     * @return
     */
   
    public boolean alterarPalavraPasse(String p1,String p2){
           

             return p1.equals(p2);

         }
    
    /**
     * obter o numero de aluno detse utilizador
     * @return
     */
    public int nAluno(){
             int id=0;
             try{ 
                String AlunoCurso="Select nAluno from Aluno where utilizador_id='"+this.id+"'";
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                ResultSet rs= con.executeQuery(AlunoCurso);
                if(rs.next()){
                   id=rs.getInt(1);
                }
                con.closeConnection();
                return id; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            }

         }

    /**
     *obter numero de aluno de um utilizador
     * @param idUtilizador
     * @return
     */
    public int nAluno(int idUtilizador){
             int id=0;
             try{ 
                String AlunoCurso="Select nAluno from Aluno where utilizador_id='"+idUtilizador+"'";
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                ResultSet rs= con.executeQuery(AlunoCurso);
                if(rs.next()){
                   id=rs.getInt(1);
                }
                con.closeConnection();
                return id; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return 0;//sql error
            }

         }

    
    

    /**
     * verfificar se numero de aluno já existe
     * @param nA
     * @return -1 se nao ligar a base de dados
     * 0 se não existir
     * >0 se existir
     */
    public int verificarnALuno(int nA){
       String verificarAluno="SELECT utilizador_id FROM Aluno WHERE nAluno='"+nA+"'";
       int id=0;
       try{ 
                  MySQLConnector con= new MySQLConnector();
                con.createConnection();
                ResultSet rs= con.executeQuery(verificarAluno);
                if(rs.next()){
                   id=rs.getInt(1);
                   
                   
                }
                
                return id; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return -1;//sql error
            }

   
   }  

    /**
     * retornar lista com todosd os professores
     * @return
     */
    public HashMap<Integer,String> ListaCarregarProfessores(){
       HashMap<Integer,String> professores= new HashMap<>();

            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                String getProfessores="SELECT id,nome,apelido FROM utilizador WHERE tipoUtilizador_id=(select id from tipoUtilizador where tipoUtilizador.descr='professor' )";
                ResultSet rs= con.executeQuery(getProfessores);
                while(rs.next()){
                
                    professores.put(rs.getInt(1), rs.getString(2)+" "+rs.getString(3));
                
                }
                con.closeConnection();
                    //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
               
            }
        
   
   return professores;
   
   
   
   
   }

    /**
     * retorn uma lista com as associaçoes de cada uc com cada curso
     * @return
     */
    public HashMap<Integer,String> ListaUcCursos(){
       HashMap<Integer,String> ucCurso= new HashMap<>();
   
            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                String getUcCurso="select ucCurso.id, curso.descr, uc.descr from uc, curso, uccurso where curso.id=ucCurso.curso_id and uc.id=ucCurso.uc_id";
     ResultSet rs= con.executeQuery(getUcCurso);
                while(rs.next()){
                
                    ucCurso.put(rs.getInt(1), rs.getString(2)+" "+rs.getString(3));
                
                }
                con.closeConnection();
                    //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
               
            }
     
   
   return ucCurso;
    }

    /**
     * retorna lista de todos os cursos
     * @return
     */
    public HashMap<Integer,String> ListaCursos(){
       HashMap<Integer,String> Curso= new HashMap<>();
   
            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                String getUcCurso="select * from  curso";
                ResultSet rs= con.executeQuery(getUcCurso);
                while(rs.next()){
                
                    Curso.put(rs.getInt(1), rs.getString(2));
                
                }
                con.closeConnection();
                    //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
               
            }
     
   
   return Curso;
    }
   //INSERT INTO `PlataformaMatematica`.`turno` (`id`, `descr`, `anoletivo_id`, `professor`, `capitulos`) VALUES (NULL, 'tp1_alga_eerc', '1314', '1', '1');

    /**
     * //inserir novo turno
     * @param professor
     * @param ucCurso
     * @param descr
     * @return
     */
    public int novoturno(int professor, int ucCurso, String descr){
            String inserir="INSERT INTO `PlataformaMatematica`.`turno` (`id`, `descr`, `anoletivo_id`, `professor`, `ucCurso`) VALUES (NULL, '"+descr+"', (select current_ano_letivo()), '"+professor+"', '"+ucCurso+"')";

            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                 int i= con.executeSQLReturnAI(inserir);
                 con.closeConnection();
               return i;
            }catch(IOException | SQLException | ClassNotFoundException Ex){
              return -1; 
            }
     
   

   
     
   }
    /* uhsjbvsakBXKSAbjas*/
    //Inserir teste

    /**
     *inserir um novo teste
     * @param professor
     * @param ucCurso
     * @param descr
     * @return
     */
          public boolean inserirTestes(int professor, int ucCurso, String descr){
            String inserir="INSERT INTO `PlataformaMatematica`.`turno` (`id`, `descr`, `anoletivo_id`, `professor`, `ucCurso`) VALUES (NULL, '"+descr+"', (select current_ano_letivo()), '"+professor+"', '"+ucCurso+"')";

            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                  con.executeSQL(inserir);
              
                con.closeConnection();
               return true;
            }catch(IOException | SQLException | ClassNotFoundException Ex){
              return false; 
            }
     
   

   
   
   }
    
    /**
     *listar todos os turno lecionados por um professor correpondetente a uma instancia deste objeto
     * @return
     */
    public HashMap<Integer,String> ListaTurnosProfessor(){
       HashMap<Integer,String> ucCurso= new HashMap<>();
       
            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                String getTurnos="SELECT turno.id, turno.descr from turno where professor='"+this.id+"'";
                        ResultSet rs= con.executeQuery(getTurnos);
                while(rs.next()){
                
                    ucCurso.put(rs.getInt(1), rs.getString(2));
                
                }
                con.closeConnection();
                    //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
               
            }
     
   
   return ucCurso;
    }

    /**
     * Listar capitulos correpondentes a um determinado turno (relacionar unidade curricular com curso e capitulo)
     * @param turno
     * @return
     */
    public HashMap<Integer,String> ListaCapitulosTurno(int turno){
       HashMap<Integer,String> capitulos= new HashMap<>( );
       
            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                String getCapitulos="select * from capitulo where id in (select capitulo from ucCapitulo where uc=(select uc.id from uc where id=(select uc_id from ucCurso where id=(select ucCurso from turno where id='"+turno+"'))))"; 

                ResultSet rs= con.executeQuery(getCapitulos);
                while(rs.next()){
                
                    capitulos.put(rs.getInt(1), rs.getString(2));
                
                }
                con.closeConnection();
                    //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
               
            }
     
   
   return capitulos;
    }

    /**
     *retorna o curso correpondente ao proprio utilizador
     * @return
     */
    public curso cursoUtilizador(){
             curso c = null;
             try{ 
                String AlunoCurso="SELECT curso.id, curso.descr FROM curso WHERE curso.id=(select curso from aluno where utilizador_id='"+this.id+"' ) ";
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                ResultSet rs= con.executeQuery(AlunoCurso);
                if(rs.next()){
                   c=new curso(rs.getInt(1),rs.getString(2));
                }
                con.closeConnection();
                   return c; //name aleready exists se 0; se !=0
                //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
                return null;//sql error
            }

         }

    /**
     * retorna a lista de Unidades curriculares que uma instancia de utilizador se encontra inscrito
     * @return
     */
    public HashMap<Integer,String> ListaUcsALunoInscrito(){
       HashMap<Integer,String> ucCurso= new HashMap<>();
       
            try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                String getTurnos="select uc.id, uc.descr from uc, turno, ucCurso, aluno, ucAluno where aluno.nALuno='"+this.nALuno+"' and aluno.nAluno=uCALuno.aluno and ucAluno.turno=turno.id and turno.ucCurso=ucCurso.id and uc.id=UcCurso.uc_id";
                        ResultSet rs= con.executeQuery(getTurnos);
                while(rs.next()){
                
                    ucCurso.put(rs.getInt(1), rs.getString(2));
                
                }
                con.closeConnection();
                    //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
               
            }
     
   
   return ucCurso;
    }

    /** Lista todos os capitulos de uma determinada uc
     *
     * @param uc
     * @return
     */
    public HashMap<Integer, String> ListaCapitulosUc(int uc){
   HashMap<Integer,String> capitulos= new HashMap<>();
   String getCapitulos="select capitulo.id, capitulo.descr from capitulo, uc, ucCapitulo where ucCapitulo.capitulo=capitulo.id and ucCapitulo.uc='"+uc+"' group by capitulo.id";
   try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                        ResultSet rs= con.executeQuery(getCapitulos);
                while(rs.next()){
                
                    capitulos.put(rs.getInt(1), rs.getString(2));
                
                }
                con.closeConnection();
                    //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
               
            }
     
   
   
   return capitulos;
   
   }
  public HashMap<Integer, String> ListaTestesProfessor(){
   HashMap<Integer,String> TestesProfessor= new HashMap<>();
     String getTestes="select testes.id, testes.descr from testes, turno where testes.turno=turno.id and turno.professor='"+this.id+"'";

           try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                        ResultSet rs= con.executeQuery(getTestes);
                while(rs.next()){
                
                    TestesProfessor.put(rs.getInt(1), rs.getString(2));
                
                }
                con.closeConnection();
                    //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
               
            }
     
   
   
   return TestesProfessor;
   
   }
   public HashMap<Integer, String> ListaTestesAluno(){
   HashMap<Integer,String> TestesAluno= new HashMap<>();
     String getTestes="select testes.id, testes.descr from  testes, turno, ucAluno where testes.turno=turno.id and turno.id=ucAluno.turno and ucAluno.aluno='"+this.nALuno+"' and testes.id not in (select testeAluno.teste from testeAluno where testeAluno.aluno='"+this.nALuno+"' )";
           try{
                MySQLConnector con= new MySQLConnector();
                con.createConnection();
                        ResultSet rs= con.executeQuery(getTestes);
                while(rs.next()){
                
                    TestesAluno.put(rs.getInt(1), rs.getString(2));
                
                }
                con.closeConnection();
                    //inseiru se maior que 0
            }catch(IOException | SQLException | ClassNotFoundException Ex){
               
            }
     
   
   
   return TestesAluno;
   
   }
}
