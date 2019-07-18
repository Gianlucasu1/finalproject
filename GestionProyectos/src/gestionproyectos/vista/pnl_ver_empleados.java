/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.vista;

import PatronesDiseño.PrincipalVisitador;
import gestionproyectos.controlador.EmpleadosJpaController;
import gestionproyectos.controlador.PersonasJpaController;
import gestionproyectos.controlador.PrincipalController;
import gestionproyectos.modelo.Empleados;
import gestionproyectos.modelo.Personas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gianlucasorem
 */
public class pnl_ver_empleados extends javax.swing.JPanel implements PrincipalVisitador{

    
    /**
     * Creates new form pnl_ver_empleados
     */
    public pnl_ver_empleados() {
        initComponents();
        CrearModelo2();
        cargarInformacion();
    }
    public void setVisitador(PrincipalVisitador visitador) {
    this.visitador=visitador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    visitador.CambiarTarjetaB("PanelVacio");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    private PrincipalVisitador visitador;
    
    DefaultTableModel modelo2;

    private void CrearModelo2() {
        try {
            modelo2 = (new DefaultTableModel(
                    null, new String[]{
                        "ID", "Nombre",
                        "Documento"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                   
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modelo2) ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }
    
    
    public void cargarInformacion(){
    
        try {
            
            Object O[]=null;
            List<Empleados> listP = PrincipalController.getInstance().cargarEmpleados();
            
            for (int i = 0; i < listP.size(); i++) {
                modelo2.addRow(O);
                
                modelo2.setValueAt(listP.get(i).getId(),i, 0);
                modelo2.setValueAt(listP.get(i).getNombre(), i, 1);
                modelo2.setValueAt(listP.get(i).getDocumento(), i, 2);
              
                
            }
            
        } catch (Exception e) {
        }
    }

    @Override
    public void cambiarTarjeta(String tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CambiarTarjetaB(String tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarInformacion2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarInformacion3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarInformacion4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarInformacion5() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
