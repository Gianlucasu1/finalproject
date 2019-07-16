/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gianlucasorem
 */
@Entity
@Table(name = "Tareas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tareas.findAll", query = "SELECT t FROM Tareas t")
    , @NamedQuery(name = "Tareas.findByIdTarea", query = "SELECT t FROM Tareas t WHERE t.idTarea = :idTarea")
    , @NamedQuery(name = "Tareas.findByNombreTarea", query = "SELECT t FROM Tareas t WHERE t.nombreTarea = :nombreTarea")
    , @NamedQuery(name = "Tareas.findByDescripcionTarea", query = "SELECT t FROM Tareas t WHERE t.descripcionTarea = :descripcionTarea")
    , @NamedQuery(name = "Tareas.findByEstadoTarea", query = "SELECT t FROM Tareas t WHERE t.estadoTarea = :estadoTarea")})
public class Tareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTarea")
    private Integer idTarea;
    @Column(name = "nombre_tarea")
    private String nombreTarea;
    @Column(name = "descripcion_tarea")
    private String descripcionTarea;
    @Column(name = "estado_tarea")
    private Integer estadoTarea;

    public Tareas() {
    }

    public Tareas(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public Integer getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(Integer estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tareas)) {
            return false;
        }
        Tareas other = (Tareas) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionproyectos.modelo.Tareas[ idTarea=" + idTarea + " ]";
    }
    
}
