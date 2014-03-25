/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author josechavarria
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        
      /*  cadernoExercicios c= new cadernoExercicios();
        c.setUcAtual(new uc(10,""));
        c.setcAtual(new capitulos(12,""));
        session se= new session();
        String pergunta="pergunta";
        String resposta[] = new String[10];
        resposta[0]="correta";
       
       se.carregarListaCapituloscompleta();
        for(int i=1;i<resposta.length;i++){
            resposta[i]="err\\:ada\\\\"+i+"\\\\!\"\\# \\$ \\%";
       
        }
   for(int z=0;z<6;z++){     
       System.out.println("sadasdsdsds");
        for(int k=0;k<40;k++){
       //     se.verificarPerguntaInserir(pergunta, resposta, k, k, pergunta, pergunta)
         se.perguntaAlvo=new pergunta();
        se.verificarPerguntaInserir(((pergunta+k)+"\\\\capitulo"+(z+1)), resposta, 1, z,"all", "all");
        
        }
        
       
    
       
        
        
   }
        
        
        
     /*  c.setPerguntaAtual(c.novaPerguntaALteaoria(1, 4));
        System.out.println(c.getPerguntaAtual().getLatexCode());
        System.out.println(StrinUtils.encode(c.getPerguntaAtual().getLatexCode()));*/
        
   /*  user s= new user(0,"josefilipe", "FreitasChavarria","joseasdadssdaa","password","aluno");
       int id=s.inserirUtilizador();
        if(s.alterarPalavraPasse("ola", "ola")){
            System.out.println(s.MudarRegistoPalavraPasse());
            
        }
        if(s.associarUtilizadorAluno(66898, s.id)){ 
            System.out.println("defgwfefews");
      
            System.out.println(s.inscreverAlunoCurso(66898,5));
        
        
        }
        System.out.println("!\"#$%&/()=? ");
    
             }*/
      /*  capitulos c1= new capitulos(1,"aaaaaaa");
        System.out.println(c1.getdescr()); // prints 'foo'

       capitulos c2=c1;
        System.out.println(c2.getdescr()); // prints 'foo'

        c1.setdescr("cccccc");
        System.out.println(c2.getdescr()); // prints 'bar' but it should print 'foo'  */
   
     /*estatisticaturno esta= new estatisticaturno(2);
         esta.excellFille();
             esta= new estatisticaturno(3);
       esta.excellFille();
    
                 esta= new estatisticaturno(5);
        esta.excellFille();      
              linha l;
        ArrayList<celula> celulas= new ArrayList<>();
        for(int i=0; i<10; i++){
    
            celulas.add(new celula(i,"asada"+i));
        }
        HashMap<Integer,linha> linhas=new HashMap<>();
         for(int i=0; i<10; i++){
             l= new linha(celulas);
            linhas.put(new Integer(i) , l);
        }
        ExcelFiles exe= new ExcelFiles();
      //File file= exe.ficheiroExcell(esta.linhas, "teste.xls", "teste");
      
    */
     
        
    
    }      
}