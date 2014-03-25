/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;



/**
 * um item correpondete a uma div
 * @author josechavarria
 */
public  abstract class ItemDivs {


    
     String addtab(tabs tab){ 
    return   "<li class=\"\"><a href=\"#"+tab.getName()+"\" data-toggle=\"tab\">"+tab.getdescr()+"</a></li>\n";
    }
    String addtabContent(tabs tab){
   
    StringBuilder html = new StringBuilder();
      html.append("      <div class=\"tab-pane fade\" id=\"").append(tab.getName()).append("\">\n");
      html.append(tab.getContent());
      html.append("      </div>\n");

    return html.toString();
    }
    
    
}
