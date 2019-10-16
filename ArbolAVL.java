
package proyectodearboles;
import java.util.ArrayList;
import java.util.Iterator;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author EESPINOSRU
 */
public class ArbolAVL <T extends Comparable<T>> {
    protected NodoAVL raiz = new NodoAVL(null);
   
    public boolean isEmpty() {
        if(raiz == null)
            return true;
        else
            return false;
    }
   
    public void setRaiz(NodoAVL<T> a){
        raiz = a;
    }
   

    public void add(T ele) {
        if(raiz != null){
            NodoAVL<T> elem = new NodoAVL<T>(ele);
            add(raiz, elem);
        }    
        else
            raiz = new NodoAVL(ele);
       
    }
   
    private void add(NodoAVL actual, NodoAVL elem){
       
        if(actual.getElement().compareTo(elem.getElement()) > 0){
            if( actual.getIzq() != null)
                add(actual.getIzq(), elem);
            else{
                actual.setIzq(elem);
                actual.getIzq().setPapa(actual);

                arreglaFE(actual.getIzq());
            }
        }
        else{
            if(actual.getDer() != null)
                add(actual.getDer(), elem);
            else{
                actual.setDer(elem);
                actual.getDer().setPapa(actual);
  
                arreglaFE(actual.getDer());
            }
       }
       
    }
   
    public void arreglaFE(NodoAVL<T> nuevo) {
        NodoAVL<T> actual = nuevo;
        boolean termine = false;
        while (!termine && actual != null && actual.getPapa() != null) {
            if (actual.equals(actual.getPapa().getIzq())) {
               
                actual.getPapa().fe -= 1;
            } else {
                
                actual.getPapa().fe += 1;
            }
           
            if (Math.abs(actual.getPapa().fe) == 2) {
                actual = rotacion(actual.getPapa());
            }
            if (actual.getPapa() != null && actual.getPapa().fe == 0) {
                termine = true;
            }
           
            actual = actual.getPapa();


        }
    }
   
   
     public int altura(NodoAVL<T> n){
         
         if(n != null){
             return altura(n.getDer(), n.getIzq());
         
         }else
             return 0;
     }
   
    private int altura(NodoAVL <T> der, NodoAVL <T> izq){
        int alt;
        if( der != null && izq != null){
            alt = Math.max(altura(der.getDer(),der.getIzq()), altura(izq.getDer(),izq.getIzq()));
        }
        else{
            if(der != null)
                alt = altura(der.getDer(),der.getIzq());
            else{
                if(izq != null)
                    alt = altura(izq.getDer(),izq.getIzq());
                else
                    alt = 0;
            }
               
        }
        alt = alt +1;
        return alt;
    }

   
    private NodoAVL<T> rotacion(NodoAVL<T> n) {
        NodoAVL<T> alfa = null;
        NodoAVL<T> beta = null;
        NodoAVL<T> gamma = null;
        NodoAVL<T> A = null;
        NodoAVL<T> B = null;
        NodoAVL<T> C = null;
        NodoAVL<T> D = null;
        NodoAVL<T> papa = null;
         
        if(n.getFe() == -2){
            if(n.getIzq() != null &&n.getIzq().getFe() == 1){
                alfa = n;
                papa = n.getPapa();
                beta = alfa.getIzq();
               
                gamma = beta.getDer();
                A = beta.getIzq();
                B = gamma.getIzq();
                C = gamma.getDer();
                D = alfa.getDer();

                gamma.cuelga(beta);
                gamma.cuelga(alfa);
                if(C != null)
                    alfa.cuelga(C);
                else
                    alfa.setIzq(null);
                alfa.cuelga(D);
                beta.cuelga(A);
                if(B != null)
                    beta.cuelga(B);
                else
                    beta.setDer(null);
                if (papa != null) {
                    papa.cuelga(gamma);
                } else {
                    gamma.setPapa(null);
                    raiz = gamma;
                }
                alfa.setFe(altura(D) - altura(C));          
                beta.setFe(altura(B) - altura(A));
                gamma.setFe(altura(alfa) - altura(beta));
                return gamma;
            }
            else{
                alfa = n;
                papa = n.getPapa();
                beta = alfa.getIzq();
                gamma = beta.getIzq();
                A = gamma.getIzq();
                B = gamma.getDer();
                C = beta.getDer();
                D = alfa.getDer();
                gamma.cuelga(A);
                gamma.cuelga(B);
                if(C != null)
                    alfa.cuelga(C);
                else
                    alfa.setIzq(null);
                alfa.cuelga(D);
                beta.cuelga(alfa);
                beta.cuelga(gamma);
                if (papa != null) {
                    papa.cuelga(beta);
                } else {
                    beta.setPapa(null);
                    raiz = beta;
                }
                alfa.setFe(altura(alfa.getDer()) - altura(alfa.getIzq()));
                beta.setFe(altura(gamma) - altura(alfa));
                return beta;
            }
        }
        else{

            if(n.getDer() != null && n.getDer().getFe() == -1){
                alfa = n;
                papa = n.getPapa();
                beta = alfa.getDer();
                gamma = beta.getIzq();
                A = alfa.getIzq();
                B = gamma.getIzq();
                C = gamma.getDer();
                D = beta.getDer();

                gamma.cuelga(beta);
                gamma.cuelga(alfa);
                alfa.cuelga(A);
                if(B != null)
                    alfa.cuelga(B);
               
                else
                    alfa.setDer(null);
                if(C != null)
                    beta.cuelga(C);
                else
                    beta.setIzq(null);
                beta.cuelga(D);
                if (papa != null) {
                    papa.cuelga(gamma);
                } else {
                    gamma.setPapa(null);
                    raiz = gamma;
                }
                alfa.setFe(altura(B) - altura(A));
                beta.setFe(altura(D) - altura(C));
                gamma.setFe(altura(beta) - altura(alfa));
                return gamma;
            }

            else{
                alfa = n;
                papa = n.getPapa();
                beta = alfa.getDer();
                gamma = beta.getDer();
                A = alfa.getIzq();
                B = beta.getIzq();
               
                C = gamma.getIzq();
               
                D = gamma.getDer();
                alfa.cuelga(A);
               
                if(B != null)
                    alfa.cuelga(B);
                else
                    alfa.setDer(null);
                gamma.cuelga(C);
                gamma.cuelga(D);
               
                beta.cuelga(alfa);
                beta.cuelga(gamma);
                if (papa != null) {
                    papa.cuelga(beta);
                } else {
                    beta.setPapa(null);
                    raiz = beta;
                }
                alfa.setFe(altura(alfa.getDer()) - altura(alfa.getIzq()));    
                beta.setFe(altura(gamma) - altura(alfa));
                return beta;
            }
        }
             
    }

   
   
    public NodoAVL<T> busca(T elem){
        return busca(raiz, elem);
    }
   
    private NodoAVL<T> busca(NodoAVL<T> N, T elem){
        boolean encontre= false;
        while(!encontre && N != null){
            if(elem.compareTo(N.getElement()) < 0)
                N = N.getIzq();
            else
                if (elem.compareTo(N.getElement()) > 0)
                    N = N.getDer();
                else
                    encontre =true;          
        }
        if(encontre)
            return N;
        return null;
    }

   public T remove(T elem) {
       System.out.println("Se va a eliminar " + elem);
        remove1(elem);
        return elem;
    }
   
    private boolean remove1(T elem){
        NodoAVL<T> bor = busca(raiz, elem);
        if (bor == null) {
            return false;
        } else {
            if (bor.getIzq() == null && bor.getDer() == null) {
                if(bor == raiz){
                    raiz = null;
                }else{
                    if (bor.getPapa().getElement().compareTo(elem) > 0) {
                        System.out.println("Hijo izquierdo");
                        NodoAVL<T> aux = bor.getPapa();
                        aux.setIzq(null);
                        aux.fe += 1;
                        if(Math.abs(aux.fe) != 1 )
                            eliminaFE(aux);    
                       
                       
                    } else {
                        System.out.println("Hijo Derecho");
                        eliminaFE(bor);
                        bor.getPapa().setDer(null);
                   
                    }
                }
            } else {
                if (bor.getIzq() == null) {
                    if(bor == raiz){;
                        raiz = bor.getDer();
                        raiz.setPapa(null);
                    }
                    else{
                        eliminaFE(bor);
                        bor.getPapa().cuelga(bor.getDer());
                    }
                }else if(bor.getDer() == null){
                    if(bor == raiz){
                        raiz = bor.getDer();
                        raiz.setPapa(null);
                    }
                    else{
                        eliminaFE(bor);
                        bor.getPapa().cuelga(bor.getIzq());
                    }
                   
                }
                else{
                    NodoAVL<T> suc = bor.getDer();
                    while(suc.getIzq() != null)
                        suc = suc.getIzq();
                    bor.setElement(suc.getElement());
                    if(suc == bor.getDer()){
                        eliminaFE(suc);
                        bor.setDer(suc.getDer());
                    }else{

                        eliminaFE(suc);
                        suc.getPapa().setIzq(suc.getDer());
                    }
                   
                }

            }
           
       
        }
         
        return true;
    }
   
    public void eliminaFE(NodoAVL<T> nuevo){
        NodoAVL<T> actual = nuevo;
        boolean termine = false;
        if(Math.abs(actual.fe) == 2){
               actual = rotacion (actual);
        }
        while(!termine && actual != null && actual.getPapa() != null){  
            if(actual == actual.getPapa().getIzq()){
                    actual.getPapa().fe += 1;
                   
            }
            else
                actual.getPapa().fe -= 1;
               
           
           if(Math.abs(actual.getPapa().fe) == 2){
               actual = rotacion (actual.getPapa());
           }
           if(Math.abs(actual.getPapa().fe) == 1)
               termine = true;
           actual = actual.getPapa();

        }
       
    }

    public ArrayList<NodoAVL>  inordenA() {
        ArrayList <NodoAVL> lista =new ArrayList<NodoAVL> ();
        inorden(raiz, lista);
        return lista;
       
    }
    public Iterator<NodoAVL> inorden() {
        return inordenA().iterator();
       
    }
    private void inorden(NodoAVL<T> actual, ArrayList <NodoAVL> lista){
        if (actual==null)
            return;
        inorden(actual.getIzq(),lista);
        lista.add(actual);
        inorden(actual.getDer(),lista);
       
    }  
     public int largo(){
        int alt = altura(raiz);
        int i = 0 ;
        int altCont = 0;
        int largo = 0;
        while( i < alt){
            largo = largo + (int) Math.pow(2, i);
            i++;
        }
        return largo;
    }
    public NodoAVL findMax(NodoAVL act){
        System.out.println("raiz " + act.getElement());
        while(act!= null){
            act = act.getDer();
        }
         System.out.println("max " + act.getElement());
        return act;
    }
        public ArrayList <NodoAVL> preordenA() {
        ArrayList <NodoAVL> lista =new ArrayList<NodoAVL>();
        preorden(raiz, lista);
        return lista; 
    }
    private void preorden(NodoAVL<T> actual, ArrayList<NodoAVL> lista){
        if (actual==null)
            return;
        lista.add(actual);
        preorden(actual.getIzq(),lista);
        preorden(actual.getDer(),lista);
    }
     public Iterator<NodoAVL> preorden() {
        ArrayList <NodoAVL>  lista =new ArrayList<NodoAVL> ();
        preorden(raiz, lista);
        return preordenA().iterator();
    }
     
    public int distARaiz(NodoAVL act){
       int i = 0;
//       System.out.print("    raiz: " + raiz.getElement());
//       System.out.print("    act: " + act.getElement());
       while (act.getElement()!= raiz.getElement()){
//           System.out.println ("entra "  );
           act = act.getPapa();
           i++;
         }
//       System.out.println(" dist: " + i);
       return i;
   }
    
     public void impr(){
         
         NodoAVL[] arr = new NodoAVL[inordenA().size()];
         for(int h = 0;h < inordenA().size(); h++ ){
             arr[h] = inordenA().remove(h);
         }
         int dist = 0;
         int distAR;
         //System.out.print(raiz.getElement() + " FE: " + raiz.getFe() + "-->");
         while(dist <= altura(raiz)){
             int j = 0;
             while( j < arr.length){
                 distAR =distARaiz(arr[j]);
                 if(distAR == dist){
//                       System.out.println("dist a R: " +distAR );
//                     System.out.println("dist de Niv: " +dist );
                     System.out.print(arr[j].getElement() + " ");
                     System.out.print("FE: " + arr[j].getFe() + "--> ");
                 }
                 j++;
             }
             dist++;
         }
     }

}