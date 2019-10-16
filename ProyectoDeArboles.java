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
        NodoAVL nod = new NodoAVL(10);
        ar.setRaiz(nod);
        ar.add(5);
        ar.add(110);
        ar.add(100);
//        ar.add(50);
//        ar.add(115);
//        ar.add(300);
//        ar.add(37);
//        ar.add(302);
//        ar.add(47);
        
       // nod = ar.busca(10);
        ar.impr();
        //System.out.println ("hijo der de nod " + nod.getDer().getElement());
//        System.out.println( "Max : " + ar.findMax());

      //  ar.ponDatos1();
       System.out.print(ar.preordenA());
//        System.out.println( "Altura: " + ar.altura(ar.getRaiz()));
//        System.out.println( "Altura de 115: " + ar.altura(nod));
//        ar.remove(300);
//        ar.remove(115);
//        ar.remove(50);
//        System.out.println( "Altura: " + ar.altura(ar.getRaiz()));

       // System.out.print(ar.getRaiz().getIzq());
//       System.out.println( "Fact Eq 10: " + nod.getFe());
//       ar.remove(110);
//        System.out.println( "Lista inOrden: " + ar.inOrden());
//        System.out.println( "Fact Eq 10: " + nod.getFe());
        
    }
    
}
