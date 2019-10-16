
package proyectodearboles;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author EESPINOSRU
 */
public interface BinaryTreeADT <T extends Comparable<T>> {
   
    public boolean isEmpty();
    public void setRaiz(NodoAVL<T> a);
    public void add(T ele);
    public void arreglaFE(NodoAVL<T> nuevo);
    public int altura(NodoAVL<T> n);
    public NodoAVL<T> busca(T elem);
    public T remove(T elem);
    public void eliminaFE(NodoAVL<T> nuevo);
    public ArrayList<NodoAVL>  inordenA();
    public Iterator<NodoAVL> inorden();
    public int largo();
    public NodoAVL findMax(NodoAVL act);
    public int distARaiz(NodoAVL act);
    public void impr();

      
     
   
}