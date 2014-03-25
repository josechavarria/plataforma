/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author Carlos
 */
public class celula {

 int id;
 String valor;
 boolean formula;

    public celula(int id, String valor) {
        this.formula = false;
        this.id = id;
        this.valor = valor;
    }

    public celula(int id, String valor, boolean formula) {
    
        this.id = id;
        this.valor = valor;
        this.formula = formula;
    }

    public boolean isFormula() {
        return formula;
    }

    public void setFormula(boolean formula) {
        this.formula = formula;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
 
}
