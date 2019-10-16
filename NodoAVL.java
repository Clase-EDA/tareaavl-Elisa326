
package proyectodearboles;
public class NodoAVL <T extends Comparable <T>> {
    T element;
    NodoAVL<T> izq, der,papa;
    int fe;

    NodoAVL(T elem) {
        element = elem;
        izq = null;
        der = null;
        papa = null;
        fe = 0;
    }
    
    public T getElement() {
        return element;
    }
    
//    public String toString() {
//        return element.toString() + "\n[" + izq.toString() + "---" + der.toString() + "]";
//    }

    public NodoAVL<T> getDer() {
        return der;
    }

    public NodoAVL<T> getIzq() {
        return izq;
    }

    public void  setElement(T element) {
        this.element = element;
    }
    

    public void setIzq(NodoAVL<T> elem) {
        izq = elem ;
    }

    public void setDer(NodoAVL<T> elem) {
        der = elem;
    }
    
    public NodoAVL<T> getPapa() {
        return papa;
    }
    public void setPapa(NodoAVL<T> pap) {
        papa = pap;
    }
    
     
    public void cuelga (NodoAVL<T> nodo){
        if(nodo == null)
            return;
        if(nodo.element.compareTo(element) < 0)
            izq = nodo;
        else
            der = nodo;
        nodo.setPapa(this);
    
    }    

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }
}
