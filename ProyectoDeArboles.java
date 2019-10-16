/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodearboles;

/**
 *
 * @author EESPINOSRU
 */
public class ProyectoDeArboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        ArbolAVL ar = new ArbolAVL();
        NodoAVL nod = new NodoAVL(13);
        ar.setRaiz(nod);
        ar.add(3);
        ar.add(55);
        ar.add(10);
//        ar.add(23);
//        ar.add(25);
//        ar.add(56);
//        ar.add(77);
//        ar.add(30);
//        ar.add(37);
        
       // nod = ar.busca(10);
        ar.impr();
        ar.remove(3);
        ar.impr();
        

        
    }
    
}
