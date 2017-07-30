
package clases;

import clases.Lista;
import clases.Producto;
import javax.swing.JOptionPane;

public class Bebida {

    private Lista lista;
    
    public Bebida() {
        lista = new Lista();
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public void Agregar(String Nombre, String precio, String Id){
        try {
            Producto producto = new Producto(Nombre, Integer.parseInt(precio), Id);
            this.getLista().add(producto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar");
        }
    }
    
    public int Tamano(){
        int tamano;
        tamano = this.getLista().size();
        return tamano;
    }
    
    public Producto obtener(int i){
        Producto producto = this.getLista().get(i);
        return producto;
    }
    
    public int PrecioTotal(){
        int precio = this.getLista().PrecioTotal();
        return precio;
    }
    
    public void Eliminar(String Nombre, String precio, String Id){
        try {
            Producto producto = new Producto(Nombre, Integer.parseInt(precio), Id);
            this.getLista().Eliminar(producto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
    }
    
    public boolean Existe(String Nombre, String precio, String Id){
        boolean existe = false;
        try {
            Producto producto = new Producto(Nombre, Integer.parseInt(precio), Id);
            existe = this.getLista().Existe(producto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo buscar");
        }
        return existe;
    }
    
}
