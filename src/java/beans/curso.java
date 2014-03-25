/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 * classe que armazena dados relativos a um curso
 * @author josechavarria
 */
public class curso extends Item{
    String tipoCurso;
    int numeroanos;

    public curso(String tipoCurso, int numeroanos, int id, String descr) {
        super(id, descr);
        this.tipoCurso = tipoCurso;
        this.numeroanos = numeroanos;
    }

    public curso(int id, String descr) {
        super(id, descr);
    }
    
   
    
}
