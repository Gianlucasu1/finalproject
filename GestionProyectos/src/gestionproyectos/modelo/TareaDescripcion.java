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
@Table(name = "tareaDescripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareaDescripcion.findAll", query = "SELECT t FROM TareaDescripcion t")
    , @NamedQuery(name = "TareaDescripcion.findById", query = "SELECT t FROM TareaDescripcion t WHERE t.id = :id")
    , @NamedQuery(name = "TareaDescripcion.findByIdTarea", query = "SELECT t FROM TareaDescripcion t WHERE t.idTarea = :idTarea")
    , @NamedQuery(name = "TareaDescripcion.findByDescripcionTrabajo", query = "SELECT t FROM TareaDescripcion t WHERE t.descripcionTrabajo = :descripcionTrabajo")})
public class TareaDescripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idTarea")
    private Integer idTarea;
    @Column(name = "descripcionTrabajo")
    private String descripcionTrabajo;

    public TareaDescripcion() {
    }

    public TareaDescripcion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }

    public void setDescripcionTrabajo(String descripcionTrabajo) {
        this.descripcionTrabajo = descripcionTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaDescripcion)) {
            return false;
        }
        TareaDescripcion other = (TareaDescripcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionproyectos.modelo.TareaDescripcion[ id=" + id + " ]";
    }
    
}
