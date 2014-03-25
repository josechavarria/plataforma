/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;

/**
 *
 * @author josechavarria
 */
public class uc extends Item {
    curso c;
    int semestre;
    int anocurricular;
    public uc(int id, String descr) {
        super(id, descr);
    }

    public uc(curso c, int semestre, int anocurricular, int id, String descr) {
        super(id, descr);
        this.c = c;
        this.semestre = semestre;
        this.anocurricular = anocurricular;
    }
    
    
    
    ArrayList<capitulos> lCapitulos = new ArrayList<capitulos>();

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

    public ArrayList<capitulos> getlCapitulos() {
        return lCapitulos;
    }

    public void setlCapitulos(ArrayList<capitulos> lCapitulos) {
        this.lCapitulos = lCapitulos;
    }

  


}

   
