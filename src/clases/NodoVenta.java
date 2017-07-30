/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Josue
 */
public class NodoVenta {
    private Bebida bebida;
    private NodoVenta siguiente;

    public NodoVenta(Bebida bebida) {
        this.bebida = bebida;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public NodoVenta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVenta siguiente) {
        this.siguiente = siguiente;
    }
}
