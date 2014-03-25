/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 * classe abstracta generica
 * @author josechavarria
 */
public abstract class Item {
   int id;
   String desc;
   boolean valida;
    public Item(int id, String descr) {
        this.id = id;
        this.desc = descr;
    }
     public Item(int id, String descr, boolean valida) {
        this.id = id;
        this.desc = descr;
        this.valida=valida;
    }
   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdescr() {
        return desc;
    }

    public void setdescr(String descr) {
        this.desc = descr;
    }
   
   
   
}
