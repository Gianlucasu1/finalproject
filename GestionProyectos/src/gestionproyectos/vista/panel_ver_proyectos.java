/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.vista;

import PatronesDiseño.PrincipalVisitador;
import gestionproyectos.controlador.PrincipalController;
import gestionproyectos.modelo.Empleados;
import gestionproyectos.modelo.PersonasProyecto;
import gestionproyectos.modelo.Proyectos;
import gestionproyectos.modelo.Tareas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gianlucasorem
 */
public class panel_ver_proyectos extends javax.swing.JPanel implements PrincipalVisitador {
    

    /**
     * Creates new form panel_ver_proyectos
     */
    public panel_ver_proyectos() {
        initComponents();
        CrearModelo2();
        
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

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Ingresar");
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
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButton1)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int sel=tabla.getSelectedRow();
        
        PrincipalController.getInstance().setNumProySol(sel);
        Proyectos proyecto = PrincipalController.getInstance().encontrarProySol();
        int g = proyecto.getIdProyectos();
        PrincipalController.getInstance().setIdproysol(g);
        List <Tareas> tareasSol = PrincipalController.getInstance().cargarTareasProy();
        PrincipalController.getInstance().setTareasSolic(tareasSol);
       
        
        visitador.CambiarTarjetaB("RealizarTareas");
        visitador.cargarInformacion2();
        JOptionPane.showMessageDialog(null, "No modifique las tareas completadas");

          
                
// TODO add your handling code here:
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
                        "ID", "Nombre Proy",
                        "Descripcion"}) {
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
    
    public void cargarInformacion1(){
    
        try {
            Object O[]=null;
            List<Proyectos> listP = PrincipalController.getInstance().getProyectosSolic();
            
            
            
            for (int i = 0; i < listP.size(); i++) {
                
                modelo2.addRow(O);
                
                modelo2.setValueAt(listP.get(i).getIdProyectos(),i, 0);
                modelo2.setValueAt(listP.get(i).getNombreProyecto(), i, 1);
                modelo2.setValueAt(listP.get(i).getDescripcionProyecto(), i, 2);
              
                
            }
            
        } catch (Exception e) {
        }
    }
    public void setVisitador(PrincipalVisitador visitador) {
    this.visitador=visitador;
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
    public void cargarInformacion() {
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
}
