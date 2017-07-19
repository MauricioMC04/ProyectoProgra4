/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class Lista {

    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public int size() {
        int size = 0;
        Nodo Aux = this.getCabeza();
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

    public void add(Producto data) {
        if (this.isEmpty()) {
            Nodo nuevo = new Nodo(data);
            cabeza = nuevo;
        } else {
            Nodo nuevo = new Nodo(data);
            Nodo Aux = this.getCabeza();
            while(Aux.getSiguiente() != null){
                Aux = Aux.getSiguiente();
            }
            Aux.setSiguiente(nuevo);
        }
    }
    
    public Producto get(int index) {
        if(!this.isEmpty()){
            if(index > this.size() || index < 0){
                throw new IndexOutOfBoundsException();
            }else{
                Nodo Aux = this.getCabeza();
                int cont = 0;
                while(cont != index && Aux.getSiguiente() != null){
                    cont ++;
                    Aux = Aux.getSiguiente();
                }
                return Aux.getProducto();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Vacia");
            return null;
        }    
    }
    
    public int PrecioTotal(){
        int precio = 0;
        Nodo Aux = this.getCabeza();
        while(Aux != null){
            precio = precio + Aux.getProducto().getPrecio();
            Aux = Aux.getSiguiente();
        }
        return precio;
    }
    
    public void Eliminar(Producto producto){
        if(!this.isEmpty()){
            Nodo Aux = this.getCabeza();
            Nodo Borrar = null;
            if (Aux.getProducto().getNombre().equals(producto.getNombre()) && Aux.getProducto().getPrecio() == producto.getPrecio()) {
		Borrar = Aux;
		this.setCabeza(Borrar.getSiguiente());
            }else{
		while (Aux.getSiguiente() != null && (!Aux.getSiguiente().getProducto().getNombre().equals(producto.getNombre())) && Aux.getSiguiente().getProducto().getPrecio() != producto.getPrecio()) {
                    Aux = Aux.getSiguiente();
		}
		if (Aux.getSiguiente() != null) {
                    Borrar = Aux.getSiguiente();
		}
		if (Borrar != null) {
                    Aux.setSiguiente(Borrar.getSiguiente());
		}
            }
        }
    }
    
    public boolean Existe(Producto producto){
        boolean existe = false;
        if(!this.isEmpty()){
            Nodo Aux = this.getCabeza();
            while(Aux != null && existe == false){
                if(Aux.getProducto().getNombre().equals(producto.getNombre()) && Aux.getProducto().getPrecio() == producto.getPrecio()){
                   existe = true;
                }
                Aux = Aux.getSiguiente();
            }   
        }
        return existe;
    }
    
}
