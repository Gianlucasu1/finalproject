/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.vista;

import PatronesDiseño.PrincipalVisitador;
import gestionproyectos.controlador.PrincipalController;
import gestionproyectos.modelo.Empleados;
import gestionproyectos.modelo.Proyectos;
import gestionproyectos.modelo.Tareas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gianlucasorem
 */
public class panel_ingresar_id extends javax.swing.JPanel implements PrincipalVisitador {
    panel_ver_proyectos proyecto;
    private String nombre1;
    private List<Proyectos> proy;
    private List<Tareas> tar;

    /**
     * Creates new form panel_ingresar_nombre
     */
    public panel_ingresar_id() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        txt_identificacion = new javax.swing.JTextField();

        jLabel1.setText("Ingrese su número de identificación:");

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_identificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_identificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jButton1)))
                .addGap(0, 135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txt_identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_identificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_identificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_identificacionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        int x=0;        
        List<Empleados> empleados = PrincipalController.getInstance().cargarEmpleados();
        
        String prueba = txt_identificacion.getText();
        
        for (int i = 0; i < empleados.size(); i++) {

            if (prueba.equals(empleados.get(i).getDocumento())) {
                
                this.nombre1 = empleados.get(i).getNombre();
                
                System.out.println("El id que mando es"+empleados.get(i).getId()); 
                
                this.proy=PrincipalController.getInstance().cargarProyectosEmpleado(empleados.get(i).getId());
    
                System.out.println(proy.size());
                PrincipalController.getInstance().setProyectosSolic(this.proy);
                
                x= x+1;

            } else {
                x=x;
            }

        }
        
        if (x >= 1) {
            JOptionPane.showMessageDialog(null, "Bienvenido a la aplicación señor(a) "+ nombre1);
            visitador.cambiarTarjeta("BotonesEmpleado");
            visitador.CambiarTarjetaB("PanelVacio");
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de documento registrado");
        }

    }//GEN-LAST:event_jButton1ActionPerformed
 
    
    public void setVisitador(PrincipalVisitador visitador) {
    this.visitador=visitador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_identificacion;
    // End of variables declaration//GEN-END:variables
   private PrincipalVisitador visitador;
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
}