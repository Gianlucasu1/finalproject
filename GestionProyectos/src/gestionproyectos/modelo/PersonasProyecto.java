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
@Table(name = "PersonasProyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonasProyecto.findAll", query = "SELECT p FROM PersonasProyecto p")
    , @NamedQuery(name = "PersonasProyecto.findById", query = "SELECT p FROM PersonasProyecto p WHERE p.id = :id")
    , @NamedQuery(name = "PersonasProyecto.findByIdProyecto", query = "SELECT p FROM PersonasProyecto p WHERE p.idProyecto = :idProyecto")
    , @NamedQuery(name = "PersonasProyecto.findByIdPersona", query = "SELECT p FROM PersonasProyecto p WHERE p.idPersona = :idPersona")})
public class PersonasProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idProyecto")
    private Integer idProyecto;
    @Column(name = "idPersona")
    private Integer idPersona;

    public PersonasProyecto() {
    }

    public PersonasProyecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
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
        if (!(object instanceof PersonasProyecto)) {
            return false;
        }
        PersonasProyecto other = (PersonasProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionproyectos.modelo.PersonasProyecto[ id=" + id + " ]";
    }
    
}
