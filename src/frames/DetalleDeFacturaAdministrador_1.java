/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import frames.*;
import clases.Bebida;
import clases.conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dannycolumna
 */
public class DetalleDeFacturaAdministrador_1 extends javax.swing.JFrame {

    /**
     * Creates new form ventanaDetalleDeFactura
     */
     private Bebida bebida;

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida proceso) {
        this.bebida = proceso;
    }
    
    public DetalleDeFacturaAdministrador_1() {
        initComponents();
        
        // Llamamos al contenedor del Frame
        // La funion de ser opaco va a estar desabilitada
        ((JPanel) getContentPane()).setOpaque(false);
        
        // Definimos uno de ImageIcon
        // En el getResource vamos a poner la ubicacion exacta de la imagen que queramos utilizar
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/imagenes/FondoDetalleDeFactura.JPG"));
        
        // Definimos fondo de JLabel
        // En el JLabel es donde vamos agregar la imagen como fondo
        JLabel fondo = new JLabel();
        
        // Habilitamos la opcion de Icon
        fondo.setIcon(uno);
        
        // Aqui habilitamos el getLayeredPanel
        // Es para poder agregar el fondo que nosotros queramos poner
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        
        // Esta funcion es para poner el tamano de los bordes ya sea el ancho o el largo
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        
        // Para localizarlo en el centro de la pantalla de la computadora
        setLocationRelativeTo(this);
        
        // Desabilitar el maximizado del frame
        this.setResizable(false);
        
        // Habilitamos el titulo encima del frama
        this.setTitle("Detalle de Factura");
          
        this.setBebida(clases.main.V.getVA().getBebida());
        
        this.MostrarProductos();
    }

    private void MostrarProductos(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");
        if(bebida != null){
            String[] datos = new String[2];
            for(int i = 0; i < bebida.Tamano(); i++){
                datos[0] = bebida.obtener(i).getNombre();
                datos[1] = Integer.toString(bebida.obtener(i).getPrecio());
                modelo.addRow(datos);
            }  
        }  
        jTable1.setModel(modelo);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDetalleDeFactura = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDetalleDeFactura.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lblDetalleDeFactura.setText("DETALLE DE FACTURA");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnEliminarProducto.setText("ELIMINAR PRODUCTO");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDetalleDeFactura)
                        .addGap(234, 234, 234))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblDetalleDeFactura)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int fila = jTable1.getSelectedRow();
        try {
            String Nombre = jTable1.getValueAt(fila, 0).toString();
            String Precio = jTable1.getValueAt(fila, 1).toString();
            
            conectar cc = new conectar();
            Connection cn = cc.conexion();
            String sql = "";
        
            if(clases.main.V.getVA().getTabla().equals("cafe")){
                sql = "SELECT * FROM cafe WHERE (precio='" + Precio + "'  AND nombre='" + Nombre + "')";
            }else{
                if(clases.main.V.getVA().getTabla().equals("batidos")){
                    sql = "SELECT * FROM batidos WHERE (precio='" + Precio + "'  AND nombre='" + Nombre + "')";
                }
            }
        
            String[] datos = new String[3];
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                }
               
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }
            
            bebida.Eliminar(Nombre, Precio, datos[2]);
            clases.main.V.getVA().setBebida(bebida);
            this.MostrarProductos();
            clases.main.V.getVA().mostrarPrecio();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro o no ha seleccionado");
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetalleDeFacturaAdministrador_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleDeFacturaAdministrador_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleDeFacturaAdministrador_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleDeFacturaAdministrador_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleDeFacturaAdministrador_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDetalleDeFactura;
    // End of variables declaration//GEN-END:variables
}