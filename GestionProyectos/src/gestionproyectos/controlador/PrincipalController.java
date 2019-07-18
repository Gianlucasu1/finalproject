/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.controlador;

import gestionproyectos.modelo.Empleados;
import gestionproyectos.modelo.PersonasProyecto;
import gestionproyectos.modelo.Proyectos;
import gestionproyectos.modelo.TareaDescripcion;
import gestionproyectos.modelo.Tareas;
import gestionproyectos.modelo.TareasProyecto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gianlucasorem
 */
public class PrincipalController {
    
    TareasJpaController CTareas = new TareasJpaController();
    EmpleadosJpaController CEmpleados = new EmpleadosJpaController();
    ProyectosJpaController1 CProyectos = new ProyectosJpaController1();
    TareasProyectoJpaController1 CTareasProyectos = new TareasProyectoJpaController1();
    PersonasProyectoJpaController CPersonasProyectos = new PersonasProyectoJpaController();
    TareaDescripcionJpaController CTareaDescripcion = new TareaDescripcionJpaController();
    private static PrincipalController instance;
    private List <Empleados> empleados;
    private List <Proyectos> proyectos;
    private List <Tareas> tareas;
    private List <TareasProyecto> tareasproyecto;
    
    // este entero  es el id del proyecto en el cual empezare a subir tareas
    private int idProyecto;
    // este entero es el id de la tarea con al que asociaré el proyecto
    private int idTarea;
    //
    private int idPersona;
    // este entero representa el id de la ersona para buscar el proyecto en el que esta
    
    // este numero representa el indice de la lista de proyectos solicitados en la cual el usuario desea trabajar
    private int numproysol;
    // Este numero indica el id del proyecto en el cual el usuario desea trabajar
    private int idproysol;
    // Esta es la tarea la cual el usuario quiere modificar en el momento
    private Tareas tareaRealizar;
    // Este sera la asociacion entre la tarea a realizar y la descripcion de lo que se ha realizado en el momento
    private Proyectos proyControlar;
    
    // este es el id del proyecto que quiero controlar
    private int numproycontrolar;
    
    // esta lista de tareas spon las tareas que el admon desea controlar
    
    private List<Tareas> tareasControl;
    private Tareas tareaCon;
    private String descripciontarea;
    
    //
    private List<Proyectos> proyectosSolic;
    private List<Tareas> tareasSolic;
    
    
    
    private PrincipalController() {
    }

    public static PrincipalController getInstance() {
        if (instance == null) {
            instance = new PrincipalController();
        }
        return instance;
    }
    
    // este metodo carga los empleados de la base de datos para posteriormente mostrarlo en el panelmostrarempleados
    //
    
    public List<Empleados> cargarEmpleados(){
         try {
            
            List<Empleados> listP = CEmpleados.findEmpleadosEntities();
            this.empleados=listP;
            
            
        } catch (Exception e) {
        }
        return empleados;
    
    }
    
    // este metodo es usado para crear un empleado en la base de datos
    
    public void crearEmpleado(Empleados empleado){
        try {
            
             CEmpleados.create(empleado);
            JOptionPane.showMessageDialog(null, "Los datos han sido guardados con éxito.");

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    
    }
    
    // este meto
    
     public void crearProyecto(Proyectos proyectos){
        try {
            
            CProyectos.create(proyectos);
            JOptionPane.showMessageDialog(null, "Se ha guardado.");

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    
    }

    public void getIdProyecto(String nombreProyecto) {
    try {
            
            
            List<Proyectos> listP = CProyectos.findProyectosEntities();
            this.proyectos=listP;
            
            for (int i = 0; i < listP.size(); i++) {
                
           if(listP.get(i).getNombreProyecto() == nombreProyecto){
           
             this.idProyecto=listP.get(i).getIdProyectos();
               System.out.println("el id del proyecto es "+ idProyecto);
           }
               
        }
            
            
        } catch (Exception e) {
        }
    
    
    }
    
    
    public void crearTarea(Tareas tarea){
        try {
            
             CTareas.create(tarea);
            JOptionPane.showMessageDialog(null, "La tarea ha sido guardada con éxito, ingrese otra si desea");

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    
    }

    public void getIdTarea(String nombreTarea) {
        try {
            
            
            List<Tareas> listP = CTareas.findTareasEntities();
            this.tareas=listP;
            
            for (int i = 0; i < listP.size(); i++) {
                
           if(listP.get(i).getNombreTarea()== nombreTarea){
           
             this.idTarea=listP.get(i).getIdTarea();
             
           }
               
        }
            
            
        } catch (Exception e) {
        }
   
    }
    
    
    //--------------------------------------

    public void crearTareaProyecto() {

        TareasProyecto tp = new TareasProyecto();
        tp.setIdProyecto(idProyecto);
        tp.setIdTarea(idTarea);
        CTareasProyectos.create(tp);
        System.out.println("La asociacion se hizo correctamente");
    }
    
    
    public void getIdPersona(String nombrePersona) {
        try {
            
            
            List<Empleados> listP = CEmpleados.findEmpleadosEntities();
            
            
            for (int i = 0; i < listP.size(); i++) {
                
           if(listP.get(i).getNombre()== nombrePersona){
           
             this.idPersona=listP.get(i).getId();
             
           }
               
        }
            
            
        } catch (Exception e) {
        }
   
    }
    
    public void crearPersonaProyecto() {

        PersonasProyecto tp = new PersonasProyecto();
        tp.setIdProyecto(idProyecto);
        tp.setIdPersona(idPersona);
        CPersonasProyectos.create(tp);
        System.out.println("La asociacion se hizo correctamente yuju");
    }

    

    
    // Esta funcion retorna los proyectos a los cuales el empleado esta asignado
    public List<Proyectos> cargarProyectosEmpleado(int z) {
     
    List<PersonasProyecto> personasproyecto = CPersonasProyectos.findPersonasProyectoEntities();
    List<Proyectos> proyectos = CProyectos.findProyectosEntities();
    List<Proyectos> proyectosSolicitados= new ArrayList<Proyectos>();
    int num;
        
        for (int i = 0; i < personasproyecto.size(); i++) {
            
        // Aca comparo que en la posicion de la lista el id persona sea igual al de el empleado que ingreso a la app    
        if(personasproyecto.get(i).getIdPersona() == z){
            
        
        num=personasproyecto.get(i).getIdProyecto();
            
            for (int j = 0; j < proyectos.size(); j++) {
             
            if(num==proyectos.get(j).getIdProyectos()) {   
            proyectosSolicitados.add(proyectos.get(j));
            }
            
            
            }
        
        }
            
        }
        
        
    return proyectosSolicitados;
        
    }
    
    
    
    public List<Tareas>  cargarTareasProy() {
        List<TareasProyecto> tareasproyecto = CTareasProyectos.findTareasProyectoEntities();
        List<Tareas> tareas = CTareas.findTareasEntities();
        List<Tareas> tareasSolicitadas = new ArrayList<Tareas> ();
        int num;
        
        for (int i = 0; i < tareasproyecto.size(); i++) {
            
        if(tareasproyecto.get(i).getIdProyecto() == this.idproysol){
        
        num = tareasproyecto.get(i).getIdTarea();
        
        for (int j = 0; j < tareas.size(); j++) {
             
            if(num == tareas.get(j).getIdTarea()) {   
            tareasSolicitadas.add(tareas.get(j));
            }
            
            
            }
            
        }     
            
            
         }
        
        return tareasSolicitadas;
                        
    
    }
    

    public void setProyectosSolic(List<Proyectos> proyectosSolic) {
        this.proyectosSolic = proyectosSolic;
        System.out.println(this.proyectosSolic.size());
    }

    public List<Proyectos> getProyectosSolic() {
        return proyectosSolic;
    }

    public List<Tareas> getTareasSolic() {
    return this.tareasSolic;
    }

    public void setTareasSolic(List<Tareas> tareasSolic) {
        this.tareasSolic = tareasSolic;
    }

    public List<Tareas> cargarTareasEmpleado(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void setNumProySol(int sel) {

    this.numproysol=sel; 
        
    }

    public Proyectos encontrarProySol() {
    
    Proyectos proyecto_encontrado=this.proyectosSolic.get(numproysol);
    return proyecto_encontrado;
    

    }

    public void setIdproysol(int idproysol) {
        this.idproysol = idproysol;
    }

    public Tareas obtenerTareaRealizar(int sel) {

       Tareas tarea2 = tareasSolic.get(sel);

       return tarea2;
    }

    public void setTareaRealizar(Tareas tareaRealizar) {
        this.tareaRealizar = tareaRealizar;
    }

    public Tareas getTareaRealizar() {
        return tareaRealizar;
    }

    public void modificarTareaTrue() {
    
    this.tareaRealizar.getIdTarea();
    
    this.tareaRealizar.setEstadoTarea(1);
        try {
             CTareas.edit(tareaRealizar); 
             JOptionPane.showMessageDialog(null, "Fue cambiada con exito");

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() );
        }
 
    
    
   
    }

    public void asociarTareaDescripcion(String text) {
    
    int num = this.tareaRealizar.getIdTarea();
    TareaDescripcion tareaDescripcion= new TareaDescripcion();
    tareaDescripcion.setIdTarea(num);
    tareaDescripcion.setDescripcionTrabajo(text);
    CTareaDescripcion.create(tareaDescripcion);
    
    

    }

    public List<Proyectos> getProyectosTodos() {
    
    this.proyectos = CProyectos.findProyectosEntities();
    return proyectos;
    }

    public void encontrarProyControlar(int num) {
    
    this.proyControlar=proyectos.get(num);
    this.numproycontrolar=proyControlar.getIdProyectos();
        
    }
    
    public List<Tareas>  cargarTareasControlar() {
        List<TareasProyecto> tareasproyecto = CTareasProyectos.findTareasProyectoEntities();
        List<Tareas> tareas = CTareas.findTareasEntities();
        List<Tareas> tareasControlar = new ArrayList<Tareas> ();
        int num;
        
        for (int i = 0; i < tareasproyecto.size(); i++) {
            
        if(tareasproyecto.get(i).getIdProyecto() == this.numproycontrolar){
        
        num = tareasproyecto.get(i).getIdTarea();
        
        for (int j = 0; j < tareas.size(); j++) {
             
            if(num == tareas.get(j).getIdTarea()) {   
            tareasControlar.add(tareas.get(j));
            }
            
            
            }
            
        }     
            
            
         }
        this.tareasControl=tareasControlar;
        
        return tareasControlar;
                        
    
    }

    public String obtenerNombreProyecto() {
    String nom=this.proyControlar.getNombreProyecto();
    return nom;
    }

    public String obtenerDescripcionProyecto() {
    String desc = this.proyControlar.getDescripcionProyecto();
    return desc;
    }

    

    public void setTareaCon(int num) {
    
    this.tareaCon = this.tareasControl.get(num);
        
    }

    public void getTareasDescrip() {
   
    List <TareaDescripcion> tareadescripcion = CTareaDescripcion.findTareaDescripcionEntities();
    
    int num = tareaCon.getIdTarea();
    
        for (int i = 0; i < tareadescripcion.size(); i++) {
            
            if(num == tareadescripcion.get(i).getIdTarea()){
            this.descripciontarea = tareadescripcion.get(i).getDescripcionTrabajo();
            }
            
        }
    

    }

    public String obNomTarea() {
    String nom = tareaCon.getNombreTarea();
    return nom;
    }

    public String obDesTarea() {
    String des = tareaCon.getDescripcionTarea();
    return des;
    }

    public int obEstTarea() {
    int num = tareaCon.getEstadoTarea();
        System.out.println(descripciontarea);
        return num;
    }

    public String obDescTarComp() {
String desc = this.descripciontarea;
return desc;
        }

    

    
    
    
    

    
    
    
    
    
    
        
    }
    
    
    
    
   
    
    
    
    

