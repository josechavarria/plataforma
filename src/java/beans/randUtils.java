/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author josechavarria
 */
public class randUtils {
    // 
     /**
     *
     * @param min
     * @param tamanhoIntervalo
     * @return nesta classe encontram-se metodos responsáveis pelo retorno de:

     */
    
   
    /**
     *
     * @param min
     * @param tamanhoIntervalo
     * @return um numero aleatori no intervalo entre min do tamanhoIntervalo

     */
            public static int randomNumber(int min, int tamanhoIntervalo){
        
        return min+new Random().nextInt(tamanhoIntervalo);
        
        }
        
         /**
     *
     * @param min
     * @param tamanhoIntervalo
     * @return um array com nELementos, com valores compreendidos entre  o limiteInferiro e o modulo do tamanho
        

     */
       
        
       public  int[] getRandomNumbers(int nElementos, int moduloIntervalo,  int limiteInferior) {
        int[] arrayRetorno=new int[nElementos];
        int i = 0, k = 0, x;
        boolean state;

        Random gerador = new Random();

        for (i = 0; i < nElementos; i++) {

            arrayRetorno[i] = nElementos;
        }

        i = 0;
 
            while (i < nElementos) {
                state = false;
                k = 0;
                   
                x = limiteInferior + gerador.nextInt(moduloIntervalo);
                System.out.println(x+"cfbhjnkml,ç.");
                while (!state) {
                    if (arrayRetorno[k] == x) {
                        state = true;

                    } else if (k == nElementos - 1) {
                        arrayRetorno[i] = x;

                        state = true;
                        i++;

                    }
                    k++;
                }

            }

        
        return arrayRetorno;
    }

         public static int boolean2TinyInt( boolean b){
        if(b){
            return 1;
        }else{
            return 0;
        }
    }
    
 
    
}
