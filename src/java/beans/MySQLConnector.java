package beans;

import java.io.*;
import java.sql.*;


public class MySQLConnector{
       private Connection conn;
       private int connId;
       private Statement stDal = null;
       String driver="com.mysql.jdbc.Driver";
      

       /**
        * Constructor da classe
        * O parametro vai dicidir qual a coneccao a executar, pode ser 1,2 ou 3.
        */
     String url= "jdbc:mysql://localhost:3306/PlataformaMatematica";
      String username="plataformaMatema";
      String password = "plataformamatematica";
   
         
    /*  String url= "jdbc:mysql://127.6.1.2:3306/PlataformaMatematica";
      
      String username="adminBw5sk6b";
      String password = "THJkRZ8Ep8U_";
      
      */
       /**
        * Cria a coneccao a base de dados
        * caso a variavel connId seja:
        * 1-> Coneccao de exemplo
        * 2-> Coneccao por ficheiro de configuracao externo
        * 3-> Coneccao a base de dados de Projecto
        */
       public void createConnection() throws IOException, SQLException, ClassNotFoundException
       {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, username, password);
             
       }

      

       public Statement createStatement() throws IOException, SQLException, ClassNotFoundException
       {
          if(this.conn==null)
              this.createConnection();
          try{
              if(this.stDal == null)
                this.stDal = this.conn.createStatement();
              }
          catch(Exception e){
              System.out.println(e.getMessage());
             }
          return this.stDal;
       }

      public Statement createStatement1() throws IOException, SQLException, ClassNotFoundException
       {
          Statement st=null;
          if(this.conn==null)
              this.createConnection();
          try{
              st = this.conn.createStatement();
              }
          catch(Exception e){
              System.out.println(e.getMessage());
             }
          return st;
       }

       public Connection returnConnection() throws IOException, SQLException, ClassNotFoundException
       {
           if(this.conn==null)
              this.createConnection();
           return this.conn;
       }

       public void executeSQL(String SqlComm) throws IOException, SQLException, ClassNotFoundException
       {
        Statement st = this.createStatement();
        try{
              st.execute(SqlComm);
              }
          catch(Exception e){
              System.out.println(e.getMessage());
             }

       }

    /**
     *
     * @param SqlComm
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int executeSQLReturnAI(String SqlComm) throws IOException, SQLException, ClassNotFoundException
       {
           int autoIncrementKey=0;
        Statement st = this.createStatement();
        ResultSet rs;
        try{
              st.execute(SqlComm, Statement.RETURN_GENERATED_KEYS);
              rs=st.getGeneratedKeys();
              if(rs.next())
              {
                  autoIncrementKey=rs.getInt(1);
              }
              }
          catch(Exception e){
              System.out.println(e.getMessage());
             }
           return autoIncrementKey;

       }

       public ResultSet executeQuery(String SqlComm) throws IOException, SQLException, ClassNotFoundException
       {
          Statement st = this.createStatement1();
          ResultSet rs=null;

          try{
              rs = st.executeQuery(SqlComm);
             }
          catch(Exception e){
              System.out.println(e.getMessage());
             }
          return rs;
       }

    public ResultSet executeQueryNavigate(String SqlComm)
       {
          Statement st = null;
          ResultSet rs=null;

          try{
              st = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                     ResultSet.CONCUR_READ_ONLY);
              rs = st.executeQuery(SqlComm);
             }
          catch(Exception e){
              System.out.println(e.getMessage());
             }
          return rs;
       }

       public void closeConnection()
       {
              if(this.conn!=null)
              {
                  try{
                   this.conn.close();
                   }
                   catch(Exception e){
                      System.out.println(e.getMessage());
                   }
              }
       }
}