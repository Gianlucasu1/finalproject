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
@Table(name = "Proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")
    , @NamedQuery(name = "Proyectos.findByIdProyectos", query = "SELECT p FROM Proyectos p WHERE p.idProyectos = :idProyectos")
    , @NamedQuery(name = "Proyectos.findByNombreProyecto", query = "SELECT p FROM Proyectos p WHERE p.nombreProyecto = :nombreProyecto")
    , @NamedQuery(name = "Proyectos.findByDescripcionProyecto", query = "SELECT p FROM Proyectos p WHERE p.descripcionProyecto = :descripcionProyecto")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProyectos")
    private Integer idProyectos;
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Column(name = "descripcion_proyecto")
    private String descripcionProyecto;

    public Proyectos() {
    }

    public Proyectos(Integer idProyectos) {
        this.idProyectos = idProyectos;
    }

    public Integer getIdProyectos() {
        return idProyectos;
    }

    public void setIdProyectos(Integer idProyectos) {
        this.idProyectos = idProyectos;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyectos != null ? idProyectos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.idProyectos == null && other.idProyectos != null) || (this.idProyectos != null && !this.idProyectos.equals(other.idProyectos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionproyectos.modelo.Proyectos[ idProyectos=" + idProyectos + " ]";
    }
    
}
