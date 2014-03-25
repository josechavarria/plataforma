/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 * class que armazena os dados relatios a uma tab
 * @author josechavarria
 */
public class tabs extends Item{
    String content;
    String name;
    
    public String getContent() {
        return content;
    }

    public void setContent(String name) {
        this.content = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public tabs(String content, String name, int id, String descr) {
        super(id, descr);
        this.content = content;
        this.name = name;
    }
    
   
    
}
