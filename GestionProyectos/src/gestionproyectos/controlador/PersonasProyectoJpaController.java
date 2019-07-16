/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.controlador;

import gestionproyectos.controlador.exceptions.NonexistentEntityException;
import gestionproyectos.modelo.PersonasProyecto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author gianlucasorem
 */
public class PersonasProyectoJpaController implements Serializable {

    public PersonasProyectoJpaController( ) {
        this.emf = Persistence.createEntityManagerFactory("GestionProyectosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PersonasProyecto personasProyecto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(personasProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PersonasProyecto personasProyecto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            personasProyecto = em.merge(personasProyecto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = personasProyecto.getId();
                if (findPersonasProyecto(id) == null) {
                    throw new NonexistentEntityException("The personasProyecto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PersonasProyecto personasProyecto;
            try {
                personasProyecto = em.getReference(PersonasProyecto.class, id);
                personasProyecto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personasProyecto with id " + id + " no longer exists.", enfe);
            }
            em.remove(personasProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PersonasProyecto> findPersonasProyectoEntities() {
        return findPersonasProyectoEntities(true, -1, -1);
    }

    public List<PersonasProyecto> findPersonasProyectoEntities(int maxResults, int firstResult) {
        return findPersonasProyectoEntities(false, maxResults, firstResult);
    }

    private List<PersonasProyecto> findPersonasProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PersonasProyecto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PersonasProyecto findPersonasProyecto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PersonasProyecto.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonasProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PersonasProyecto> rt = cq.from(PersonasProyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
