
package clases;

import javax.swing.JOptionPane;

public class Venta {
    
    private NodoVenta cabeza;

    public Venta() {
        this.cabeza = null;
    }

    public NodoVenta getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoVenta cabeza) {
        this.cabeza = cabeza;
    }

    public int size() {
        int size = 0;
        NodoVenta Aux = this.getCabeza();
        while(Aux != null){
            size++;
            Aux = Aux.getSiguiente();
        }
        return size;
    }
    
    public boolean isEmpty(){
        boolean vacio = true; 
        if(this.size() == 0){
            vacio = true;
        }else{
            vacio = false;
        }
        return vacio;
    } 

    public void add(Bebida data) {
        if (this.isEmpty()) {
            NodoVenta nuevo = new NodoVenta(data);
            cabeza = nuevo;
        } else {
            NodoVenta nuevo = new NodoVenta(data);
            NodoVenta Aux = this.getCabeza();
            while(Aux.getSiguiente() != null){
                Aux = Aux.getSiguiente();
            }
            Aux.setSiguiente(nuevo);
        }
    }
    
    public Bebida get(int index) {
        if(!this.isEmpty()){
            if(index > this.size() || index < 0){
                throw new IndexOutOfBoundsException();
            }else{
                NodoVenta Aux = this.getCabeza();
                int cont = 0;
                while(cont != index && Aux.getSiguiente() != null){
                    cont ++;
                    Aux = Aux.getSiguiente();
                }
                return Aux.getBebida();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Vacia");
            return null;
        }    
    } 
}
