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
        NodoAVL nod = new NodoAVL(100);
        ar.setRaiz(nod);
        ar.add(300);
        ar.add(400);
        ar.add(350);
        ar.add(375);
        ar.add(50);
        ar.add(200);
        ar.add(360);
        ar.add(380);
        ar.add(500);
        ar.add(390);
        
       // nod = ar.busca(10);
        ar.impr();
        ar.remove(375);
                ar.impr();
        ar.remove(50);
                ar.impr();
        ar.remove(400);
                ar.impr();
        ar.remove(380);
        ar.impr();
        

        
    }
    
}
