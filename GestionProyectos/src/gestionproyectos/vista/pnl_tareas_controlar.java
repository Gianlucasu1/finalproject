/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.vista;

import PatronesDiseño.PrincipalVisitador;
import gestionproyectos.controlador.PrincipalController;
import gestionproyectos.modelo.Proyectos;
import gestionproyectos.modelo.Tareas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gianlucasorem
 */
public class pnl_tareas_controlar extends javax.swing.JPanel {

    /**
     * Creates new form pnl_tareas_controlar
     */
    public pnl_tareas_controlar() {
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

        jLabel1 = new javax.swing.JLabel();
        nombre_proyecto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcion_proyecto = new javax.swing.JTextArea();

        jLabel1.setText("Nombre del proyecto:");

        nombre_proyecto.setText("jLabel2");

        jLabel3.setText("Descripcion del proyecto:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Seleccionar tarea");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        descripcion_proyecto.setColumns(20);
        descripcion_proyecto.setRows(5);
        jScrollPane2.setViewportView(descripcion_proyecto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(nombre_proyecto)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre_proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int num = tabla.getSelectedRow();
        PrincipalController.getInstance().setTareaCon(num);
        PrincipalController.getInstance().getTareasDescrip();
        
        visitador.cargarInformacion5();
        visitador.CambiarTarjetaB("TareaControlada");
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descripcion_proyecto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombre_proyecto;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
   private PrincipalVisitador visitador;

    DefaultTableModel modelo2;

    private void CrearModelo2() {
        try {
            modelo2 = (new DefaultTableModel(
                    null, new String[]{
                        "Nombre Tarea", "ID"
                        }) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class
                   
                };
                boolean[] canEdit = new boolean[]{
                    false, false
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
    public void setVisitador(PrincipalVisitador visitador) {
        this.visitador = visitador;
    }
    
    public void cargarInformacion1(){
    
        try {
            Object O[]=null;
            List<Tareas> listP = PrincipalController.getInstance().cargarTareasControlar();
            
            
            
            for (int i = 0; i < listP.size(); i++) {
                
                modelo2.addRow(O);
                
                
                modelo2.setValueAt(listP.get(i).getNombreTarea(), i, 0);
                modelo2.setValueAt(listP.get(i).getIdTarea(),i, 1);
              
                
            }
            
            nombre_proyecto.setText(PrincipalController.getInstance().obtenerNombreProyecto());
            descripcion_proyecto.setText(PrincipalController.getInstance().obtenerDescripcionProyecto());
            
        } catch (Exception e) {
        }
    }
    
}
