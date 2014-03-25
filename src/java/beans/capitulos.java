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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * armaxena daddos relativos a um capitulo
 * @author josechavarria
 */
public class capitulos extends Item {

    public capitulos(int id) {
        super(id, "");
    }
    
    public capitulos(int id, String descr) {
        super(id, descr);
        objetManipulation carregar= new objetManipulation();
        try {
            this.ListaCursos= carregar.carregarListacursos(id);
            this.ListaUcsAssociada=carregar.carregarListaUc(id);
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(capitulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    ArrayList<uc> ListaUcsAssociada= new ArrayList();
    ArrayList<curso> ListaCursos= new ArrayList();

    public ArrayList<uc> getListaUcsAssociada() {
        return ListaUcsAssociada;
    }

    public void setListaUcsAssociada(ArrayList<uc> ListaUcsAssociada) {
        this.ListaUcsAssociada = ListaUcsAssociada;
    }

    public ArrayList<curso> getListaCursos() {
        return ListaCursos;
    }

    public void setListaCursos(ArrayList<curso> ListaCursos) {
        this.ListaCursos = ListaCursos;
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
