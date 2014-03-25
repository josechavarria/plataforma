/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josechavarria
 */
public final class turno {
    int id;
    uc u;
    String descr;

    public turno(int id) {
        this.id = id;
        this.descr=descrTurno();
    }

        String descrTurno(){
        try {
            String descri="";
            String getDescri="select turno.descr from turno where turno.id='"+this.id+"'";
          
            MySQLConnector con= new MySQLConnector();
            con.createConnection();
            
            ResultSet rs= con.executeQuery(getDescri);
            if(rs.next()){
                descri=rs.getString(1);
            }
              System.out.println(descri);
            con.closeConnection();
            return descri;
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            
            Logger.getLogger(turno.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        
        }
    public String getdescr() {
        return descr;
    }

    public void setdescr(String descr) {
        this.descr = descr;
    }
    public int getId() {
        return id;
    }

    public uc getU() {
        return u;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
