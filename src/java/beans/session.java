
package beans;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.*;
public class session  {
    user us;
    int indexPergunta=0;
    int contador=0;
    
    //variaveis que armaxenam arraylist para o menu de edicao
    ArrayList<pergunta> listaPerguntasEditar;
    ArrayList<uc> listaUcsEditar;
    ArrayList<capitulos> listaCapitulosEditar;
    ArrayList<curso> listaCursosEditar;
    capitulos capitulo;
    ArrayList<turno> turnos;
    //variaveis que armazenam arraylist para a realizacao de testes 
    //e exercicios de pratica
    ArrayList<pergunta> listaPerguntas;
    ArrayList<uc> listaUcs;
    ArrayList<capitulos> listaCapitulos;
    
    pergunta perguntaAlvo;
    Date lastInserted;
    user utilizadorInserir;
    
    teste test;
    cadernoExercicios caderno;

   
    ArrayList<curso> listaCursos;   

//valida uma sessão
    public boolean isvalid(){
  
        if(this.getUs()==null){
            return false;
        }else{
          return (this.getUs().getId()!=0) && (!this.getUs().username.isEmpty()) && (!this.getUs().nome.isEmpty()) && (!this.getUs().Apelido.isEmpty());
        }

  }
    
    //cria um novo utilizado em caso de login
    //se occorer com sucesso devolve true (isvalid)
    public boolean login(String user, String pass){
        try {
            ResultSet  rs;
            MySQLConnector con=new MySQLConnector();
            String sqlgetLogin="SELECT utilizador.id, utilizador.nome, utilizador.apelido, utilizador.username, utilizador.password, tipoUtilizador.descr FROM utilizador, tipoUtilizador WHERE utilizador.tipoUtilizador_id=tipoUtilizador.id and username='"+user+"' and password='"+pass+"'";
            con.createConnection();
            rs=con.executeQuery(sqlgetLogin);
            if(rs.next()){
                us= new user(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                       
                        
                }
               
            } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(session.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            }
  
         return isvalid();
  }
  
    
    //carregar todas as ucs em que o aluno esta inscrito
    public void carregarUcsInscrito() throws IOException, SQLException, ClassNotFoundException{
   String getUcs="SELECT uc.id, uc.descr FROM uc where uc.id in (select uc from ucALuno where aluno=(SELECT Aluno.nAluno FROM Aluno WHERE Aluno.utilizador_id = '"+this.getUs().getId()+"') and anoletivo_id=(select current_ano_letivo()))";  
   this.listaUcsEditar.clear();
   MySQLConnector con=new MySQLConnector();
   con.createConnection();
        ResultSet rs= con.executeQuery(getUcs);
        while(rs.next()){
            
           this.getListaUcs().add(new uc(rs.getInt(1),rs.getString(2)));
        }
        con.closeConnection();
   }
   
    //careggar todas as UCs existentes
    public ArrayList<uc> carregarLUcsTotal() throws IOException, SQLException, ClassNotFoundException{
   ArrayList<uc> u= new ArrayList<>();
       String getUcs="SELECT * FROM uc";
   MySQLConnector con=new MySQLConnector();
   con.createConnection();
        ResultSet rs= con.executeQuery(getUcs);
        while(rs.next()){
            
           u.add(new uc(rs.getInt(1),rs.getString(2)));
        }
        con.closeConnection();
        return u;
   }
   
    
    
    
    //carregar todos os capitulos existentes no sistema
    public void carregarListaCapituloscompleta() throws IOException, SQLException, ClassNotFoundException{
    // if(this.isvalid()){
           this.listaCapitulosEditar=new ArrayList<>();
        String getCapitulos="SELECT * FROM capitulo";
        ResultSet rs= (new MySQLConnector()).executeQuery(getCapitulos);
        while(rs.next()){
            this.getListaCapitulosEditar().add(new capitulos(rs.getInt(1),rs.getString(2)));
        
     //   }
       }
  }
    
    
    
    
    
     /*  boolean validatorDate() throws  IOException, SQLException, ClassNotFoundException{
   
   return updateDate().compareTo(lastInserted)/1000>20;
   
   }*/

    
    
    
    
    ////Esta seccao de codigo refere-se a utilizacao de metodos para a insersao de perguntas no siste
    ///foi colocada aqui porque só vão ser utilizados em ambito de sessão
    

    //devolve uma pergunta atraves de um conjunto de strings que sao recebidos nos webservices
    public pergunta stringPosttoObjet(String pergunta, String[] respostas, int correta, String ucs, String cursos, int capitulo) {
        pergunta p = new pergunta();
        p.novaPerguntaVazia();
        p.setLatexCode(pergunta);
        p.setListaRespostas(new ArrayList<resposta>());
        p.setC(this.getListaCapitulosEditar().get(capitulo));
        inserirRelacoesPergunta(ucs, cursos, p);
        for (int i = 0; i < respostas.length; i++) {
            p.listaRespostas.add(new resposta());
            if (!respostas[i].isEmpty()) {
                if ((i + 1) == correta) {
                    p.listaRespostas.set(i, new resposta(respostas[i], true));
                } else {
                    p.listaRespostas.set(i, new resposta(respostas[i], false));
                }
            }
        }
        return p;
    }
        //verifica se a pergunta tem todas as condicoes para ser inserida
    public String verificarPerguntaInserir(String pergunta, String[] respostas, int correta, int capitulo, String ucs, String cursos) {
        String message = "";
        renderLatex r = new renderLatex();
        if (r.renderLatex(pergunta) == null) {
            message += "Pergunta com sintaxe inv\u00e1lida\n";
        }
        for (int i = 0; i < 7; i++) {
            if (r.renderLatex(respostas[i]) == null) {
                message += "resposta" + (i + 1) + " com sintaxe inv\u00e1lida\n";
            }
            if (correta == (i + 1) && (respostas[i].isEmpty())) {
                message += "A resposta selecionada n\u00e3o pode ser definida como correta\n";
            }
        }
        if (capitulo >= this.listaCapitulosEditar.size()) {
            message += "Capitulo Inexistente";
        }
        if (message.isEmpty()) {
            if (this.perguntaAlvo.getId() != 0) {
                stringPosttoObjetUpdate(this.perguntaAlvo, pergunta, respostas, correta, ucs, cursos, capitulo);
            } else {
                this.perguntaAlvo = stringPosttoObjet(pergunta, respostas, correta, ucs, cursos, capitulo);
            }
            int contador = 0;
            for (resposta re : this.perguntaAlvo.getListaRespostas()) {
                if (!(re.getLatexCode().isEmpty() || re.getLatexCode().equals("\\\\") || re.getLatexCode().equals("\\:"))) {
                    contador++;
                }
            }
            if (contador < 4) {
                message += "Numero de respostas insuficiente";
            }
            if (message.isEmpty()) {
                if (this.perguntaAlvo.inserirPergunta()) {
                    message += "Sucesso";
                } else {
                    message += "Erro SQL";
                }
            }
        }
        return message;
    }
    //Apaga as  relacoes da pergunta com usc e disicplinas exsitentes e insere as novas
    public void inserirRelacoesPergunta(String ucs, String cursos, pergunta p) {
        if (ucs.equals("all")) {
            p.setlUc(p.getC().getListaUcsAssociada());
        } else {
            String[] unicur = ucs.split(",");
            p.setlUc(new ArrayList<uc>());
            for (String c : unicur) {
                for (uc u : p.getC().getListaUcsAssociada()) {
                    if (u.getId() == Integer.parseInt(c)) {
                        p.getlUc().add(u);
                    }
                }
            }
        }
        if (cursos.equals("all")) {
            p.listaCursos = p.getC().getListaCursos();
        } else {
            p.setListaCursos(new ArrayList<curso>());
            String[] cur = cursos.split(",");
            for (String c : cur) {
                for (curso curs : p.getC().getListaCursos()) {
                    if (curs.getId() == Integer.parseInt(c)) {
                        p.getListaCursos().add(curs);
                    }
                }
            }
        }
    }
    //quando o objeto nao e nulo, atualiza com novos parametro a pergunta
    public void stringPosttoObjetUpdate(pergunta p, String pergunta, String[] respostas, int correta, String ucs, String cursos, int capitulo) {
        p.setLatexCode(pergunta);
        p.setC(this.getListaCapitulosEditar().get(capitulo));
        inserirRelacoesPergunta(ucs, cursos, p);
        int i;
        for (i = 0; i < respostas.length; i++) {
            if (!respostas[i].isEmpty()) {
                if ((i + 1) == correta) {
                    p.getListaRespostas().set(i, new resposta(p.getListaRespostas().get(i).getId(), respostas[i], true));
                } else {
                    p.getListaRespostas().set(i, new resposta(p.getListaRespostas().get(i).getId(), respostas[i], false));
                }
            }
        }
    }
  

    
    //getters setters e construtores
    
    
    public ArrayList<turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<turno> turnos) {
        this.turnos = turnos;
    }
    
    
    public capitulos getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(capitulos capitulo) {
        this.capitulo = capitulo;
    }
    
    
    public teste getTest() {
        return test;
    }

    public void setTest(teste test) {
        this.test = test;
    }

    public cadernoExercicios getCaderno() {
        return caderno;
    }

    public void setCaderno(cadernoExercicios caderno) {
        this.caderno = caderno;
    }
    
    
    public user getUtilizadorInserir() {
        return utilizadorInserir;
    }

    public void setUtilizadorInserir(user utilizadorInserir) {
        this.utilizadorInserir = utilizadorInserir;
    }
    
    public user getUs() {
        return this.us;
    }

    public void setUs(user us) {
        this.us = us;
    }

    public int getIndexPergunta() {
        return indexPergunta;
    }

    public void setIndexPergunta(int indexPergunta) {
        this.indexPergunta = indexPergunta;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public ArrayList<pergunta> getListaPerguntasEditar() {
        return listaPerguntasEditar;
    }

    public void setListaPerguntasEditar(ArrayList<pergunta> listaPerguntasEditar) {
        this.listaPerguntasEditar = listaPerguntasEditar;
    }

    public ArrayList<uc> getListaUcsEditar() {
        return listaUcsEditar;
    }

    public void setListaUcsEditar(ArrayList<uc> listaUcsEditar) {
        this.listaUcsEditar = listaUcsEditar;
    }

    public ArrayList<capitulos> getListaCapitulosEditar() {
        return listaCapitulosEditar;
    }

    public void setListaCapitulosEditar(ArrayList<capitulos> listaCapitulosEditar) {
        this.listaCapitulosEditar = listaCapitulosEditar;
    }

    public ArrayList<curso> getListaCursosEditar() {
        return listaCursosEditar;
    }

    public void setListaCursosEditar(ArrayList<curso> listaCursosEditar) {
        this.listaCursosEditar = listaCursosEditar;
    }

    public ArrayList<pergunta> getListaPerguntas() {
        return this.listaPerguntas;
    }

    public void setListaPerguntas(ArrayList<pergunta> listaPerguntas) {
        this.listaPerguntas = listaPerguntas;
    }

    public ArrayList<uc> getListaUcs() {
        return listaUcs;
    }

    public void setListaUcs(ArrayList<uc> listaUcs) {
        this.listaUcs = listaUcs;
    }

    public ArrayList<capitulos> getListaCapitulos() {
        return listaCapitulos;
    }

    public void setListaCapitulos(ArrayList<capitulos> listaCapitulos) {
        this.listaCapitulos = listaCapitulos;
    }

    public ArrayList<curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public pergunta getPerguntaAlvo() {
        return perguntaAlvo;
    }

    public void setPerguntaAlvo(pergunta perguntaAlvo) {
        this.perguntaAlvo = perguntaAlvo;
    }

 

    public Date getLastInserted() {
        return lastInserted;
    }

    public void setLastInserted(Date lastInserted) {
        this.lastInserted = lastInserted;
    }  
    
    
}