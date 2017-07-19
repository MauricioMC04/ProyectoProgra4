
package clases;

import javax.swing.JOptionPane;

public class Proceso {

    private Lista lista;
    
    public Proceso() {
        lista = new Lista();
    }

    private Lista getLista() {
        return lista;
    }

    private void setLista(Lista lista) {
        this.lista = lista;
    }

    public void Agregar(String Nombre, String precio){
        try {
            Producto producto = new Producto(Nombre, Integer.parseInt(precio));
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
    
    public void Eliminar(String Nombre, String precio){
        try {
            Producto producto = new Producto(Nombre, Integer.parseInt(precio));
            this.getLista().Eliminar(producto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
    }
    
    public boolean Existe(String Nombre, String precio){
        boolean existe = false;
        try {
            Producto producto = new Producto(Nombre, Integer.parseInt(precio));
            existe = this.getLista().Existe(producto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo buscar");
        }
        return existe;
    }
    
}
