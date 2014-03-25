/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Carlos
 */
public class linha {
 
ArrayList<celula> celulas; 

    public linha(ArrayList<celula> celulas) {
        this.celulas = celulas;
    }

   
    public ArrayList<celula> getCelulas() {
        return celulas;
    }

    public void setCelulas(ArrayList<celula> celulas) {
        this.celulas = celulas;
    }

    




}
