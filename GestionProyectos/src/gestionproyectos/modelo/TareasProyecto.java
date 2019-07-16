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
@Table(name = "TareasProyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareasProyecto.findAll", query = "SELECT t FROM TareasProyecto t")
    , @NamedQuery(name = "TareasProyecto.findByIdTareasProyecto", query = "SELECT t FROM TareasProyecto t WHERE t.idTareasProyecto = :idTareasProyecto")
    , @NamedQuery(name = "TareasProyecto.findByIdTarea", query = "SELECT t FROM TareasProyecto t WHERE t.idTarea = :idTarea")
    , @NamedQuery(name = "TareasProyecto.findByIdProyecto", query = "SELECT t FROM TareasProyecto t WHERE t.idProyecto = :idProyecto")})
public class TareasProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTareasProyecto")
    private Integer idTareasProyecto;
    @Column(name = "idTarea")
    private Integer idTarea;
    @Column(name = "idProyecto")
    private Integer idProyecto;

    public TareasProyecto() {
    }

    public TareasProyecto(Integer idTareasProyecto) {
        this.idTareasProyecto = idTareasProyecto;
    }

    public Integer getIdTareasProyecto() {
        return idTareasProyecto;
    }

    public void setIdTareasProyecto(Integer idTareasProyecto) {
        this.idTareasProyecto = idTareasProyecto;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTareasProyecto != null ? idTareasProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareasProyecto)) {
            return false;
        }
        TareasProyecto other = (TareasProyecto) object;
        if ((this.idTareasProyecto == null && other.idTareasProyecto != null) || (this.idTareasProyecto != null && !this.idTareasProyecto.equals(other.idTareasProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionproyectos.modelo.TareasProyecto[ idTareasProyecto=" + idTareasProyecto + " ]";
    }
    
}
